package jss.mvc.w13_4.service;

import jss.mvc.w13_4.domain.Customer;

import java.util.List;

public interface CustomerService {
    Customer get(Long id);
    List<Customer> getAll();

    void update(Customer customer);
    void delete(Long id);

    void add(Customer customer);
}
