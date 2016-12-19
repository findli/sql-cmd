package jss.mvc.service;

import jss.mvc.domain.Customer;

import java.util.List;

public interface CustomerService {
    Customer get(Long id);
    List<Customer> getAll();

    void update(Customer customer);
    void delete(Long id);

    void add(Customer customer);
}
