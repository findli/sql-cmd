package jss.mvc.w13_3.service;

import jss.mvc.w13_3.domain.Customer;

import java.util.List;

public interface CustomerServiceSimple {
    Customer get(Long id);
    List<Customer> getAll();

    void update(Customer customer);
    void delete(Long id);

    void add(Customer customer);
}
