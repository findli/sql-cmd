package jss.mvc.w13_4.dao.hibernate;

import jss.mvc.w13_4.dao.DAO;
import jss.mvc.w13_4.domain.Customer;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.orm.hibernate4.HibernateTemplate;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class CustomerDAOHibernateTemplateImpl implements DAO<Customer> {
    private HibernateTemplate hibernateTemplate;

    @Autowired
    public void setHibernateTemplate(HibernateTemplate hibernateTemplate) {
        this.hibernateTemplate = hibernateTemplate;
    }

    @Override
    public Customer get(long id) {
//        hibernateTemplate.getSessionFactory().getCurrentSession();
        return (Customer) hibernateTemplate.get(Customer.class, id);
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
    public Long update(Customer detached) {
        hibernateTemplate.update(detached);
        return detached.getId();
    }

    @Override
    public void delete(long id) {
        hibernateTemplate.delete(id);
    }
}
