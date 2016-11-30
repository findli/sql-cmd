package net.javajoy.jss.mvc.w13_4.service;

import net.javajoy.jss.mvc.w13_4.dao.DAO;
import net.javajoy.jss.mvc.w13_4.domain.Customer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

/**
 * @author Cyril Kadomsky
 */
@Service
@Transactional(
        // value="transactionManager",
        readOnly = true
)
public class CustomerServiceImpl implements CustomerService {

    @Autowired
    //@Qualifier("customerDAOJdbcImpl")
    //@Qualifier("customerDAOHibernateImpl")
    @Qualifier("customerDAOHibernateTemplateImpl")
    DAO<Customer> customerDAO;

    public CustomerServiceImpl() {
    }

    public void setCustomerDAO(DAO<Customer> customerDAO) {
        this.customerDAO = customerDAO;
    }

    @Override
    public Customer get(Long id) {
        return customerDAO.get(id);
    }

    @Override
    public List<Customer> getAll() {
        return customerDAO.getAll();
    }

    @Override
    @Transactional(readOnly = false, propagation = Propagation.REQUIRED)
    public void update(Customer customer) {
        customerDAO.update(customer);
    }

    @Override
    @Transactional(readOnly = false, propagation = Propagation.REQUIRED)
    public void delete(Long id) {
        customerDAO.delete(id);
    }

    @Override
    @Transactional(readOnly = false, propagation = Propagation.REQUIRED)
    public void add(Customer customer) {
        customerDAO.save(customer);
    }
}
