package JSS.w_12_1;

import JSS.w_12_1.orm.Customer;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.metadata.ClassMetadata;

import java.util.List;
import java.util.Map;

import static JSS.w_12_1.HibernateUtil.getSession;

public class HibernateDemo {
    public static void main(final String[] args) throws Exception {
        insertDemo();
    }

    public static void metaDataDemo() {
        final Session session = getSession();
        System.out.println("querying all the managed entities...");
        try {
            final Map metadataMap = session.getSessionFactory().getAllClassMetadata();
            for (Object key : metadataMap.keySet()) {
                final ClassMetadata classMetadata = (ClassMetadata) metadataMap.get(key);
                final String entityName = classMetadata.getEntityName();
                final Query query = session.createQuery("from " + entityName);
                System.out.println("executing: " + query.getQueryString());
                for (Object o : query.list()) {
                    System.out.println(" " + o);
                }
            }
        } finally {
            session.close();
            HibernateUtil.close();
        }
    }

    public static void queryDemo() {
        final Session session = getSession();
        try {
            final Query query = session.createQuery("from Customer as C WHERE C.id > 0");
            System.out.println("executing: " + query.getQueryString());
            List<Customer> results = query.list();
            for (Object o : results) {
                System.out.println(" " + o);
            }


            final Query query1 = session.createQuery("select avg (rating) from Customer as C WHERE C.id > 0");
            System.out.println("executing: " + query1.getQueryString());
            List<Customer> results1 = query1.list();
            for (Object o : results1) {
                System.out.println(" " + o + " " + o.getClass());
            }
        } finally {
            session.close();
            HibernateUtil.close();
        }
    }
    public static void insertDemo() {
        final Session session = getSession();
        try {
            session.beginTransaction();
            final Customer customer = new Customer("new customer", "1111-1111", null, 12);
            session.save(customer);
            session.getTransaction().commit();
        } finally {
            session.close();
            HibernateUtil.close();
        }
    }
}
