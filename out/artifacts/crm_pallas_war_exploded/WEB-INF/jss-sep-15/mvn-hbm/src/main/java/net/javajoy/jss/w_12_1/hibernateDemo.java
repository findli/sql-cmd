package net.javajoy.jss.w_12_1;

import net.javajoy.jss.w_12_1.orm.Customer;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.metadata.ClassMetadata;

import java.util.List;
import java.util.Map;

/**
 * @author Cyril Kadomsky
 */
public class hibernateDemo {

    public static void main(final String[] args) throws Exception {
        insertDemo();
    }


    public static void metaDataDemo() {
        final Session session = HibernateUtil.getSession();
        try {
            System.out.println("querying all the managed entities...");
            final Map metadataMap = session.getSessionFactory().getAllClassMetadata();
            for (Object key : metadataMap.keySet()) {
                final ClassMetadata classMetadata = (ClassMetadata) metadataMap.get(key);
                final String entityName = classMetadata.getEntityName();
                final Query query = session.createQuery("from " + entityName);   // HQL
                System.out.println("executing: " + query.getQueryString());
                for (Object o : query.list()) {
                    System.out.println("  " + o);
                }
            }
        } finally {
            session.close();
            HibernateUtil.close();
        }
    }

    public static void queryDemo() {
        final Session session = HibernateUtil.getSession();
        try {
            final Query query = session.createQuery("from Customer as C where C.id>15");   // HQL
            System.out.println("executing: " + query.getQueryString());
            List<Customer> results = query.list();
            for (Customer o : results) {
                System.out.println("  " + o);
            }

            final Query query1 = session.createQuery("select avg(rating) from Customer as C where C.id>15");   // HQL
            System.out.println("executing: " + query1.getQueryString());
            List<Double> results1 = query1.list();
            for (Double o : results1) {
                System.out.println("   " + o + " " + o.getClass());
            }



        } finally {
            session.close();
            HibernateUtil.close();
        }
    }

    public static void insertDemo() {
        final Session session = HibernateUtil.getSession();
        Transaction transaction = null;
        try {
            transaction = session.beginTransaction();
            Customer customer = new Customer("New customer","1111-1111",null,12);
            session.save(customer);
            transaction.commit();
        } finally {
            if (transaction!=null) {
                transaction.rollback();
            }
            session.close();
            HibernateUtil.close();
        }
    }

}
