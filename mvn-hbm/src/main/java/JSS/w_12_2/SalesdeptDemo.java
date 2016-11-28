package JSS.w_12_2;

import JSS.w_12_1.HibernateUtil;
import JSS.w_12_2.orm.hibernate_test.Name;
import JSS.w_12_2.orm.hibernate_test.User;
import org.hibernate.Session;

import static JSS.w_12_1.HibernateUtil.getSession;

public class SalesdeptDemo {
    public static void main(final String[] args) {
        final Session session = getSession();
        try {
            newEntityDemo(session);
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            session.close();
            HibernateUtil.close();
        }
    }

    public static void xmlMappingDemo(Session session) {
        /*final Query query = session.createQuery("from CustomerWithXmlMapping as C WHERE C.id > 0");
        System.out.println("executing: " + query.getQueryString());
        List<Object> result = query.list();
        for (Object o : result) {
            System.out.println(o.getClass().getName() + " : " + o);
        }*/
    }

    public static void newEntityDemo(Session session) {
        session.beginTransaction();
        User user = new User("First user", new Name("name 1", "surname"), "desc 1", new byte[]{1, 2, 3, 4, 5});
        session.save(user);
        session.getTransaction().commit();
    }

}
