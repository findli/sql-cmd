package jss.mvc.w13_4.service;

import jss.mvc.w13_4.domain.Customer;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service // spring boot interpret this class as service class for some controller
public class CustomerServiceImpl implements CustomerService {
    List<Customer> data = new ArrayList<>(20);
    long newId = 1;

    public CustomerServiceImpl() {
        data.add(new Customer(1l, "Ann", 123));
        data.add(new Customer(2l, "Bruce", 345));
        data.add(new Customer(3l, "Clara", 456));
        newId = 4;
    }

    @Override
    public Customer get(Long id) {
        Customer customer = null;
//        data.stream().filter(c -> c.getId().longValue() == id.longValue()).findFirst().ifPresent(c-> customer);
        for (Customer c : data) {
            if (c.getId().longValue() == id.longValue()) {
                customer = c;
            }
        }
        return customer;
    }

    @Override
    public List<Customer> getAll() {
        return data;
    }

    @Override
    public void update(Customer customer) {
        Customer c = get(customer.getId());

        if (c != null) {
            int index = data.indexOf(c);
            data.set(index, customer);
        }
    }

    @Override
    public void delete(Long id) {
        Customer c = get(id);

        if (c != null) {
            data.remove(c);
        }
    }

    @Override
    public void add(Customer customer) {
        customer.setId(newId++);
        data.add(customer);
    }
}
