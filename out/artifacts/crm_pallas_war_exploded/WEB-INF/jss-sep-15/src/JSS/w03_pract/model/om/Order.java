package JSS.w03_pract.model.om;

import java.sql.Date;

public class Order {


    private long id = -1;
    private Customer customer = null;
    private Product product = null;

    private Date date = null;
    private int qty = 0;
    private float amount = 0;

    public Order(long id, Customer customer, Product product, Date data, int qty, float amount) {
        this.id = id;
        this.customer = customer;
        this.product = product;
        this.date = data;
        this.qty = qty;
        this.amount = amount;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public Customer getCustomer() {
        return customer;
    }

    public void setCustomer(Customer customer) {
        this.customer = customer;
    }

    public Product getProduct() {
        return product;
    }

    public void setProduct(Product product) {
        this.product = product;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    public int getQty() {
        return qty;
    }

    public void setQty(int qty) {
        this.qty = qty;
    }

    public float getAmount() {
        return amount;
    }

    public void setAmount(float amount) {
        this.amount = amount;
    }
}
