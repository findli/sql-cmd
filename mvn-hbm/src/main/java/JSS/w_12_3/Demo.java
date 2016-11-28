package JSS.w_12_3;

import JSS.w_12_1.HibernateUtil;
import JSS.w_12_2.orm.personnel.Employee;
import JSS.w_12_2.orm.personnel.Position;
import JSS.w_12_3.dao.AbstractDAOFactory;
import JSS.w_12_3.dao.HibernateDAOFactory;
import JSS.w_12_3.dao.HibernateEmployeeDAO;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.resource.transaction.spi.TransactionStatus;

import java.util.List;

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
//            demo.getEmployee();
//            demo.update();
//            demo.updateMerge();
//            demo.filter();
//            demo.filter();

            System.out.println(demo.employeeDAO.getAsListWithCriteria());
        } finally {
            if (session != null) {
                Transaction transaction = session.getTransaction();
                if (transaction != null && transaction.getStatus() == TransactionStatus.ACTIVE) {
                    transaction.rollback();
                }
                session.close();
            }
            HibernateUtil.close();
        }
    }

    void filter(){
        System.out.println(employeeDAO.getAsListFilteredByValue("a", 1));
        System.out.println(employeeDAO.getAsListFilteredByInstance(
                new Employee(("a"), 1, null, null))
        );
    }
    public void getEmployee() {
//        Employee employeeName = employeeDAO.getByName("name1");
//        System.out.println(employeeName.getId());
//        System.out.println(employeeName.getName());


        Employee employee = employeeDAO.getById(1); // persistent object
        System.out.println(employee.getId());

        Employee employeeLoadProxyWithId = employeeDAO.loadById(1);
        System.out.println(employeeLoadProxyWithId.getId());
        System.out.println(employeeLoadProxyWithId.getName()); // lazy fetch
    }

    public void add() {
        Employee employee = new Employee("new employee", 12, null, new Position("Director", null)); // transient object: never persistent, not associated with any Session
        // then persisted object - associated with a unique Session
        // detached - previously persistent, not associated with any Session
        employeeDAO.add(employee);
    }

    public void update() {
        // recieved from edit form
        Position transientPosition = new Position("Manager", null);
        transientPosition.setId(2);
        Employee transientEmployee = new Employee("name 123", 30, null, transientPosition);
        transientEmployee.setId(3);

        Employee persistent = session.get(Employee.class, (long) 3);
        System.out.println(persistent.getName());
        // обновляется только name не age т.к. так только поле name прописано вручную на апдейт в nativeUpdate
        employeeDAO.nativeUpdate(transientEmployee);

        System.out.println(transientEmployee.getName());
        /**
         * в nativeUpdate session.get возвращает другую ссылку на persistent с id 3
         * Session следит за всеми объектами ссылающиеся на id 3 и автоматом их синхронизирует по commit()!
         */
        System.out.println(persistent.getName());

        Employee persistentAfterNativeUpdate = session.get(Employee.class, (long) 3);
        System.out.println(persistentAfterNativeUpdate.getName());
    }

    public void updateMerge() {
        // recieved from edit form
        Position transientPosition = new Position("Manager", null);
        transientPosition.setId(2);
        Employee transientEmployee = new Employee("name 123", 30, null, transientPosition);
        transientEmployee.setId(3);

        Employee persistent = session.get(Employee.class, (long) 3);
        System.out.println(persistent.getName());
        employeeDAO.mergeUpdate(transientEmployee);

        System.out.println(transientEmployee.getName());
        /**
         * в nativeUpdate session.get возвращает другую ссылку на persistent с id 3
         * Session следит за всеми объектами ссылающиеся на id 3 и автоматом их синхронизирует по commit()!
         */
        System.out.println(persistent.getName());

        Employee persistentAfterNativeUpdate = session.get(Employee.class, (long) 3);
        System.out.println(persistentAfterNativeUpdate.getName());
    }
}
