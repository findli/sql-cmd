package JSS.w_12_2;

import JSS.w_12_1.HibernateUtil;
import JSS.w_12_2.orm.personnel_ya.Company;
import JSS.w_12_2.orm.personnel_ya.Tag;
import org.hibernate.Session;

import java.util.List;

import static JSS.w_12_1.HibernateUtil.getSession;

public class PersonnelDemo {
    public static void main(final String[] args) {
        final Session session = getSession();
        try {
            xmlMappingDemo(session);

            Company company = (Company) session.get("JSS.w_12_2.orm.personnel_ya.Company", 1);
//            System.out.println(company.getId());
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            session.close();
            HibernateUtil.close();
        }
    }

    public static void xmlMappingDemo(Session session) {
        // lazy loading
        final org.hibernate.query.Query query = session.createQuery("from Tag as T WHERE T.companyByCompanyId.id > 0");
        List<Tag> result = query.list();
        for (Tag tag : result) {
            System.out.println(tag.getClass().getName() + " : " + tag.getCompanyByCompanyId().getAddress());
        }
        // explicit join
        final org.hibernate.query.Query query2 = session.createQuery("select distinct T.name from Tag as T join T.companyByCompanyId C where C.id > 0");
        List<Tag> result2 = query2.list();
        for (Tag tag : result2) {
            System.out.println(tag.getClass().getName() + " : " + tag);
        }
        // explicit join another for:
//        query2.list().forEach(t -> System.out.println(t.toString()));

        // eager fetch
        session.createQuery("from Company C join fetch C.tagsById T where T.id > 0").list()
                .forEach(c -> System.out.println(((Company) c).getName()));

        // неестественное соединение без ON
        session.createQuery("select C.id from Company C, Tag T where C.id = T.id").list()
                .forEach(c -> System.out.println(((Company) c).getName() + " - " + ((Company) c).getAddress()));
    }


}
