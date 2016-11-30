package net.javajoy.jss.w13_1.bean.dao;

/**
 * @author Cyril Kadomsky
 */
public class CustomerView {
    CustomerDAO dao;

    public CustomerView(CustomerDAO connection) {
        this.dao = connection;
    }

    @Override
    public String toString() {
        return "CustomerView{" +
                "dao=" + dao +
                '}';
    }
}
