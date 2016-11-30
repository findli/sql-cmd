package net.javajoy.jss.mvc.w13_4.dao.hibernate;

import net.javajoy.jss.mvc.w13_4.dao.DAO;
import net.javajoy.jss.mvc.w13_4.domain.Customer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.orm.hibernate4.HibernateTemplate;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * @author Cyril Kadomsky
 */
@Repository
public class CustomerDAOHibernateTemplateImpl implements DAO<Customer> {

    private HibernateTemplate hibernateTemplate;

    @Autowired
    public void setHibernateTemplate(HibernateTemplate hibernateTemplate) {
        this.hibernateTemplate = hibernateTemplate;
    }

    @Override
    public Customer get(long id) {
        // hibernateTemplate.getSessionFactory().getCurrentSession()....
        return hibernateTemplate.get(Customer.class,id);
    }

    @Override
    public List<Customer> getAll() {
        return hibernateTemplate.loadAll(Customer.class);
    }

    @Override
    public void save(Customer trans) {
        hibernateTemplate.save(trans);
    }

    @Override
    public void update(Customer detached) {
        hibernateTemplate.update(detached);
    }

    @Override
    public void delete(long id) {
        hibernateTemplate.delete(id);
    }
}
