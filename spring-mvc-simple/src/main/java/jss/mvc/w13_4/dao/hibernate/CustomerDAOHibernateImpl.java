package jss.mvc.w13_4.dao.hibernate;

import jss.mvc.w13_4.dao.DAO;
import jss.mvc.w13_4.domain.Customer;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class CustomerDAOHibernateImpl implements DAO<Customer> {
    private SessionFactory sessionFactory;

    @Autowired
    public void setSessionFactory(SessionFactory sessionFactory) {
        this.sessionFactory = sessionFactory;
    }

    @Override
    public Customer get(long id) {
        Session session = sessionFactory.getCurrentSession();

        return (Customer) session.get(Customer.class, id);
    }

    @Override
    public List<Customer> getAll() {
        Session session = sessionFactory.getCurrentSession();

        return session.createQuery("FROM jss.mvc.w13_4.domain.Customer").list();
    }

    @Override
    public void save(Customer trans) {
        Session session = sessionFactory.getCurrentSession();
        session.save(trans);
    }

    @Override
    public Long update(Customer detached) {
        Session session = sessionFactory.getCurrentSession();
//        Session session = sessionFactory.openSession();
//        session.beginTransaction();
        session.update(detached);
//        session.getTransaction().commit();

        return detached.getId();
    }

    @Override
    public void delete(long id) {
        Session session = sessionFactory.getCurrentSession();
        session.delete(new Customer(id, null, null, null, null));
    }
}
