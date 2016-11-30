package jss.w13_1.bean.dao;

public class CustomerView {
    CustomerDAO dao;

    public CustomerView(CustomerDAO dao) {
        this.dao = dao;
    }

    @Override
    public String toString() {
        return "CustomerView{" +
                "dao=" + dao +
                '}';
    }
}
