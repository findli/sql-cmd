package net.javajoy.jss.mvc.w13_3.service;

import net.javajoy.jss.mvc.w13_3.domain.Customer;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

/**
 * @author Cyril Kadomsky
 */
@Service
public class CustomerServiceSimpleImpl implements CustomerServiceSimple {

    List<Customer> data = new ArrayList<>(20);
    long newId = 1;

    public CustomerServiceSimpleImpl() {
        data.add( new Customer(1l,"Ann",123));
        data.add( new Customer(2l,"Bruce",345));
        data.add( new Customer(3l,"Clara",456));
        newId = 4;
    }

    @Override
    public Customer get(Long id) {
        Customer customer = null;
//        data.stream()
//                .filter(c -> c.getId().longValue() == id.longValue() )
//                .findFirst().ifPresent(c -> customer = c);
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
        if (c!=null) {
            int index = data.indexOf(c);
            data.set(index,customer);
        }
    }

    @Override
    public void delete(Long id) {
        Customer c = get(id);
        if (c!=null) {
            data.remove(c);
        }

    }

    @Override
    public void add(Customer customer) {
        customer.setId(newId);
        newId++;
        data.add(customer);
    }
}
