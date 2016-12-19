package jss.w13_2.aop;

import java.util.Arrays;
import java.util.List;

public class SimpleCustomerDAO implements CustomerDAO {
    private String tableName;
    private List<String> names = Arrays.asList(new String[]{"Ann", "Bob", "Clara", "David"});

    public SimpleCustomerDAO() {
    }

    public void setTableName(String tableName) {
        System.out.println("SimpleCustomerDAO.setTableName()");
        this.tableName = tableName;
    }

    @Override
    public Customer get(long id) {
        System.out.println("SimpleCustomerDAO.get() : reading customer from DB by id = " + id);
        Customer customer = new Customer();
        customer.setId(id);
        customer.setName(names.get((int) id - 1));
        return customer;
    }

    public int size() {
        return 5;
    }

    public Customer update(Customer customer) {
        Customer actual = get(customer.getId());
        customer.setName(actual.getName());

        return customer;
    }
}
