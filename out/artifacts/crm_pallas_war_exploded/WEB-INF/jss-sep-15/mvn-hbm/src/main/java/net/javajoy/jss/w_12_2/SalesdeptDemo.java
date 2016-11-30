package net.javajoy.jss.w_12_2;

import net.javajoy.jss.w_12_1.HibernateUtil;
import net.javajoy.jss.w_12_2.orm.hibernate_test.Name;
import net.javajoy.jss.w_12_2.orm.hibernate_test.User;
import org.hibernate.Session;

/**
 * @author Cyril Kadomsky
 */
public class SalesdeptDemo {

    public static void main(final String[] args) throws Exception {
        final Session session = HibernateUtil.getSession();
        try {
            // xmlMappingDemo(session);

            newEntityDemo(session);

        } finally {
            session.close();
            HibernateUtil.close();
        }
    }


    public static void xmlMappingDemo(Session session) {

//        session.beginTransaction();
//        session.save(new CustomerWithXmlMApping("New new!!!","33333",null,12));
//        session.getTransaction().commit();
//
//        final Query query = session.createQuery("from CustomerWithXmlMApping as C where C.id>15");
//        List<Object> results = query.list();
//        for (Object o : results) {
//            System.out.println(o.getClass().getName() + " : " + o);
//        }
    }

    public static void newEntityDemo(Session session) {

        session.beginTransaction();
        session.save(new User("First user", new Name("Bob","Smith"), "hdjkdkfkfflfllflf", new byte[]{1, 2, 45, 67}));
        session.getTransaction().commit();
    }

}
