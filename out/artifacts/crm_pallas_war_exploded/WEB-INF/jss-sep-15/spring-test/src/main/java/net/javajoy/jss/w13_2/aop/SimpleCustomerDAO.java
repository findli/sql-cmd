package net.javajoy.jss.w13_2.aop;

import java.util.Arrays;
import java.util.List;

/**
 * @author Cyril Kadomsky
 */

public class SimpleCustomerDAO implements CustomerDAO {

    private String tableName;
    private List<String> names = Arrays.asList( new String[] {"Ann", "Bob", "Clara", "David"} );

    public SimpleCustomerDAO() {
    }

    public void setTableName(String tableName) {
        System.out.println("SimpleCustomerDAO.setTableName()");
        this.tableName = tableName;
    }

    public Customer get(long id) {
        System.out.println("SimpleCustomerDAO.get() : reading customer from DB by id = " + id);
        Customer cust = new Customer();
        cust.setId(id);
        cust.setName(names.get((int)id-1));
        return cust;
    }

    public int size() {
        return 4;
    }

    public Customer update(Customer cust) {
        Customer actual = get(cust.getId());
        cust.setName( actual.getName() );
        return cust;
    }

}
