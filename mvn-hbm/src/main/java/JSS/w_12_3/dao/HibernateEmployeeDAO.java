package JSS.w_12_3.dao;

import JSS.w_12_2.orm.personnel.Employee;
import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.criterion.*;

import java.math.BigDecimal;
import java.util.List;

public class HibernateEmployeeDAO implements AbstractEmployeeDAO {

    private Session session;

    public HibernateEmployeeDAO(Session session) {

        this.session = session;
    }

    public List getAsListWithCriteria() {

        Criteria criteria = session.createCriteria(Employee.class);
        Criterion nameCriterion = Restrictions.like("name", "%a%");
        Criterion ageCriterion = Restrictions.ge("age", 1);
        Criterion salaryCriterion = Restrictions.between("salary", new BigDecimal(0), new BigDecimal(10000000));

        LogicalExpression orExpression = Restrictions.or(nameCriterion, ageCriterion);
        LogicalExpression andExpression = Restrictions.and(orExpression, salaryCriterion);

//        criteria.add(orExpression);
//        criteria.add(salaryCriterion);
        // or
        criteria.add(andExpression);

        criteria.addOrder(Order.asc("name"));

        criteria.setProjection(Projections.countDistinct("name"));

        return (List) criteria.list();
    }

    public List<Employee> getAsListFilteredByValue(String name, long notId) {
        return (List<Employee>) session.createQuery("from Employee where name LIKE :name and id != :notId ").setParameter("name", "%" + name + "%").setParameter("notId", notId).list();
    }

    public List<Employee> getAsListFilteredByInstance(Employee detached) {

        detached.setName("%" + detached.getName() + "%");

        return (List<Employee>) session.createQuery("from Employee where name LIKE :name and age = :age ").setProperties(detached).list();
    }

    public Employee mergeUpdate(Employee transientEmployee) {
        session.beginTransaction();
        Employee employee = (Employee) session.merge(transientEmployee);
        session.getTransaction().commit();

        return employee;
    }

    public void nativeUpdate(Employee transientEmployee) {
        session.beginTransaction();
        Employee persistent = session.get(Employee.class, transientEmployee.getId());

        if (persistent != null) {
            persistent.setName(transientEmployee.getName());
        }

        session.getTransaction().commit();
    }

    public long add(Employee newEmployee) {
        session.beginTransaction();
        long id = (long) session.save(newEmployee);
        session.getTransaction().commit();

        return id;
    }

    public List<Employee> getAsList() {
        return session.createQuery("from Employee ").list();
    }

    // @TODO impl
    public Employee getByName(String name) {
        return session.get(Employee.class, name);
    }

    @Override
    public Employee getById(long id) {
        /**
         * get - делает новый экземпляр
         * если в бд есть такой, то заполняет и возвращает
         * если нет то null
         */
        return session.get(Employee.class, id);
    }

    public Employee loadById(long id) {
        /**
         * load - создайтся прокси и пока не обратимся к полю - запроса не произойдет
         * возвращается ссылка на объект прокси
         */
        return session.load(Employee.class, id);
    }
}
