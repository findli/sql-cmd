package net.javajoy.jss.w_12_3;

import net.javajoy.jss.w_12_1.HibernateUtil;
import net.javajoy.jss.w_12_2.orm.personnel.Employee;
import net.javajoy.jss.w_12_2.orm.personnel.Position;
import net.javajoy.jss.w_12_3.dao.AbstractDAOFactory;
import net.javajoy.jss.w_12_3.dao.HibernateDAOFactory;
import net.javajoy.jss.w_12_3.dao.HibernateEmployeeDAO;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.resource.transaction.spi.TransactionStatus;

/**
 * @author Cyril Kadomsky
 */
public class Demo {

    private Session session;
    private HibernateEmployeeDAO employeeDAO;


    public Demo(Session session) {
        this.session = session;
        AbstractDAOFactory factory = new HibernateDAOFactory(session);
        employeeDAO = (HibernateEmployeeDAO) factory.getEmployeeDAO();
    }


    public static void main(String[] args) {
        final Session session = HibernateUtil.getSession();

        try {
            Demo demo = new Demo(session);

            // demo.getEmployee();

            // demo.update();

            // demo.filter();

            System.out.println( demo.employeeDAO.getAsListWithCriteria() );


        } finally {
            if (session!=null) {
                Transaction transaction = session.getTransaction();
                if (transaction!=null && transaction.getStatus() == TransactionStatus.ACTIVE) {
                    System.out.println("Transaction not commited !!!!");
                    transaction.rollback();
                }
                session.close();
            }
            HibernateUtil.close();
        }
    }

    public void getEmployee() {
        Employee employee = employeeDAO.getById(5);   // persistent
        System.out.println(employee.getId());

        Employee employee1 = employeeDAO.loadById(6);
        System.out.println(employee1.getId());
        System.out.println(employee1.getName() );   // lazy fetching
    }

    public void add() {
        Employee e = new Employee("new emplooyee",12,null,new Position("Director",null) );  // transient
        employeeDAO.add(e);

    }

    public void update() {

        // Received from edit form :

        Position transientPosition = new Position("Manager1111", null);
        transientPosition.setId(3);

        Employee transientEmployee = new Employee("Dana2",30,null, transientPosition );
        transientEmployee.setId(5);

        Employee persistent = session.get(Employee.class, 5l);

        // employeeDAO.naiveUpdate(transientEmployee);
        employeeDAO.mergeUpdate(transientEmployee);

        System.out.println(transientEmployee.getName());
        System.out.println(persistent.getName());
    }

    void filter() {

        System.out.println(
                employeeDAO.getAsListFilterByValue("a", 20)
        );
        System.out.println();
        System.out.println(
                employeeDAO.getAsListFilterByInstance(
                        new Employee("a",20,null,null)
                ));

    }

}
