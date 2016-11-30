package net.javajoy.jss.w_12_2;

import net.javajoy.jss.w_12_1.HibernateUtil;
import net.javajoy.jss.w_12_2.orm.personnel.Employee;
import org.hibernate.Session;

/**
 * @author Cyril Kadomsky
 */
public class PersonnelDBDemo {

    public static void main(final String[] args) throws Exception {
        final Session session = HibernateUtil.getSession();
        try {


            // joinDemo(session);
            //russianDemo(session);

            // Get entity instance by ID without Query
            //Employee e  = (Employee) session.get("net.javajoy.jss.w_12_2.orm.personnel.Employee",7);
            Employee e  = (Employee) session.get(Employee.class,7);
            System.out.println(e.getName());

        } finally {
            session.close();
            HibernateUtil.close();
        }
    }

    public static void russianDemo(Session session) {
        session.createQuery("select E.id from Employee E where E.name = 'Иван' ")
                .list()
                .forEach(id -> System.out.println(id) );
    }



        public static void joinDemo(Session session) {

        // 1. Implicit association join

//        String hql = "from Employee E where position.name = 'Director'";
//
//        List<Employee> employees =  session.createQuery(hql).list();
//
//        for (Employee employee : employees) {
//            Position pos = employee.getPosition();          // Lazy fetching !!!!
//            System.out.println(pos.getName());
//        }

        // 2. Explicit association join

//        session.createQuery("select distinct P.name from Position P join P.employees E where E.age > 30")
//                .list().forEach(p -> System.out.println(p));

        // 2 a) Eager fetch
//        session.createQuery("select distinct E from Employee E join fetch E.position P where P.name = 'Director' ")
//                .list()
//                .forEach(p -> System.out.println(((Employee) p).getName() + " - " + ((Employee) p).getPosition().getName()));

        // 3. Join without association
        session.createQuery("select distinct E from Employee E, Position P where E.name = P.comment ")
                .list()
                .forEach(p -> System.out.println(((Employee) p).getName() + " - " + ((Employee) p).getPosition().getName()));

    }


}
