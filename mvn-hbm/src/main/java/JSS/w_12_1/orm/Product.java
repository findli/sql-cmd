package JSS.w_12_1.orm;

import javax.persistence.*;
import java.util.Arrays;
import java.util.Collection;

@Entity
@Table(name = "Products", schema = "java_jss_salesdept", catalog = "")
public class Product {
    private int id;
    private String description;
    private int price;
    private String details;
    private byte[] manual;
    private Collection<Order> orders;

    @Id
    @Column(name = "id")
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    @Basic
    @Column(name = "description")
    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    @Basic
    @Column(name = "price")
    public int getPrice() {
        return price;
    }

    public void setPrice(int price) {
        this.price = price;
    }

    @Basic
    @Column(name = "details")
    public String getDetails() {
        return details;
    }

    public void setDetails(String details) {
        this.details = details;
    }

    @Basic
    @Column(name = "manual")
    public byte[] getManual() {
        return manual;
    }

    public void setManual(byte[] manual) {
        this.manual = manual;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Product product = (Product) o;

        if (id != product.id) return false;
        if (price != product.price) return false;
        if (description != null ? !description.equals(product.description) : product.description != null) return false;
        if (details != null ? !details.equals(product.details) : product.details != null) return false;
        if (!Arrays.equals(manual, product.manual)) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = id;
        result = 31 * result + (description != null ? description.hashCode() : 0);
        result = 31 * result + price;
        result = 31 * result + (details != null ? details.hashCode() : 0);
        result = 31 * result + Arrays.hashCode(manual);
        return result;
    }

    @OneToMany(mappedBy = "product")
    public Collection<Order> getOrders() {
        return orders;
    }

    public void setOrders(Collection<Order> orders) {
        this.orders = orders;
    }

    @Override
    public String toString() {
        return "Product{" +
                "id=" + id +
                ", description='" + description + '\'' +
                ", price=" + price +
                ", details='" + details + '\'' +
                ", orders=" + orders +
                '}';
    }
}
