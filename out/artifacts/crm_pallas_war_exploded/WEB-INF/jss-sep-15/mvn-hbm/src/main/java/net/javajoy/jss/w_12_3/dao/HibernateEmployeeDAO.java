package net.javajoy.jss.w_12_3.dao;

import net.javajoy.jss.w_12_2.orm.personnel.Employee;
import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.criterion.*;

import java.math.BigDecimal;
import java.util.List;

/**
 * @author Cyril Kadomsky
 */
public class HibernateEmployeeDAO implements AbstractEmployeeDAO {

    Session session;

    public HibernateEmployeeDAO(Session session) {
        this.session = session;
    }

    @Override
    public Employee getById(long id) {
        return session.get(Employee.class,id);
    }

    public Employee loadById(long id) {
        return session.load(Employee.class, id);
    }

    public List<Employee> getAsList() {
        return session.createQuery("from Employee")
                .list();
    }

    public long add(Employee newEmployee) {
        session.beginTransaction();
        long id = (long) session.save(newEmployee);        // INSERT
        session.getTransaction().commit();
        return id;
    }

    public void naiveUpdate(Employee transientEmployee) {

        session.beginTransaction();

        Employee persistent = session.get( Employee.class, transientEmployee.getId() );

        if (persistent!=null) {
            persistent.setName(transientEmployee.getName());
        }

        session.getTransaction().commit();
    }

    public Employee mergeUpdate(Employee transientEmployee) {
        session.beginTransaction();
        Employee persistent = (Employee) session.merge(transientEmployee);
        session.getTransaction().commit();
        return persistent;
    }

    public List<Employee> getAsListFilterByValue(String name, int ageMin) {
        return (List<Employee>)
                session.createQuery("from Employee where name like :name and age > :age order by name")
                    .setParameter("name", "%" + name + "%")
                    .setParameter("age", ageMin)
                    .list();
    }

    public List<Employee> getAsListFilterByInstance(Employee detached) {

        detached.setName("%" + detached.getName() + "%");
        return (List<Employee>)
                session.createQuery("from Employee where name like :name and age > :age ")
                        .setProperties(detached)
                        .list();
    }

    public List getAsListWithCriteria() {

        Criteria criteria = session.createCriteria(Employee.class);

        Criterion nameCrit = Restrictions.ilike("name","%a%");
        Criterion ageCrit = Restrictions.ge("age",50);          // >=
        Criterion salryCrit = Restrictions.between("salary",new BigDecimal(3000),new BigDecimal(10000));

        LogicalExpression orExpr = Restrictions.or(nameCrit,ageCrit);
        LogicalExpression andExpr = Restrictions.and(orExpr, salryCrit);

        criteria.add(andExpr);

        criteria.addOrder(Order.asc("name"));

        // criteria.setProjection(Projections.countDistinct("name"));

        return criteria.list();
    }


}
