package net.javajoy.jss.w_12_1.orm;

import javax.persistence.*;
import java.math.BigDecimal;
import java.util.Arrays;

/**
 * @author Cyril Kadomsky
 */
@Entity
@Table(name = "products", schema = "", catalog = "salesdept")
public class Product {
    private long id;
    private String description;
    private String details;
    private BigDecimal price;
    private byte[] manual;

    @Id
    @Column(name = "id")
    public long getId() {
        return id;
    }

    public void setId(long id) {
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
    @Column(name = "details")
    public String getDetails() {
        return details;
    }

    public void setDetails(String details) {
        this.details = details;
    }

    @Basic
    @Column(name = "price")
    public BigDecimal getPrice() {
        return price;
    }

    public void setPrice(BigDecimal price) {
        this.price = price;
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
        if (description != null ? !description.equals(product.description) : product.description != null) return false;
        if (details != null ? !details.equals(product.details) : product.details != null) return false;
        if (price != null ? !price.equals(product.price) : product.price != null) return false;
        if (!Arrays.equals(manual, product.manual)) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = (int) (id ^ (id >>> 32));
        result = 31 * result + (description != null ? description.hashCode() : 0);
        result = 31 * result + (details != null ? details.hashCode() : 0);
        result = 31 * result + (price != null ? price.hashCode() : 0);
        result = 31 * result + (manual != null ? Arrays.hashCode(manual) : 0);
        return result;
    }

    @Override
    public String toString() {
        return "Product{" +
                "id=" + id +
                ", description='" + description + '\'' +
                ", details='" + details + '\'' +
                ", price=" + price +
                "}";
    }
}
