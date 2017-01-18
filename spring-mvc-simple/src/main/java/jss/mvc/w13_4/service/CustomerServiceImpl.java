package jss.mvc.w13_4.service;

import jss.mvc.w13_4.dao.DAO;
import jss.mvc.w13_4.dao.jdbc.CustomerDAOJdbcImpl;
import jss.mvc.w13_4.domain.Customer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service // spring boot interpret this class as service class for some controller
@Transactional(
//        value = "transactionManager",
        readOnly = true
)
public class CustomerServiceImpl implements CustomerService {

    @Autowired
//    @Qualifier("customerDAOJdbcImpl")
//    @Qualifier("customerDAOHibernateImpl")
    @Qualifier("customerDAOHibernateTemplateImpl")
    DAO<Customer> customerDAO;

    public CustomerServiceImpl() {
        customerDAO = new CustomerDAOJdbcImpl();
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
    // для выполнения метода нужно создать транзакциюи завершить после выполнения метода
    @Transactional(readOnly = false, propagation = Propagation.REQUIRED)
    public void update(Customer customer) {
        customerDAO.update(customer);
    }

    @Override
    public void delete(Long id) {
        customerDAO.delete(id);
    }

    @Override
    @Transactional(readOnly = false, propagation = Propagation.REQUIRED)
    public void add(Customer customer) {
        customerDAO.save(customer);
    }
}
