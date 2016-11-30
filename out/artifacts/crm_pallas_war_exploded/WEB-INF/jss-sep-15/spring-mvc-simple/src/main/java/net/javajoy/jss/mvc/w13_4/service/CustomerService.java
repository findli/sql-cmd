package net.javajoy.jss.mvc.w13_4.service;

import net.javajoy.jss.mvc.w13_4.domain.Customer;

import java.util.List;

/**
 * @author Cyril Kadomsky
 */
public interface CustomerService {

    Customer get(Long id);
    List<Customer> getAll();
    void update(Customer customer);
    void delete(Long id);
    void add(Customer customer);

}
