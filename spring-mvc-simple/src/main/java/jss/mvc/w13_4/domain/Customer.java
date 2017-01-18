package jss.mvc.w13_4.domain;

import org.springframework.core.annotation.Order;

import javax.persistence.*;
import java.util.Collection;

@Entity
@Table(name = "customers", schema = "java_jss_salesdept", catalog = "")
public class Customer {
    private Long id;
    private String address;
    private String name;
    private String phone;
    private Integer rating;
//    private Collection<Order> orders;

    public Customer() {
    }

    public Customer(Long id, String address, String name, String phone, Integer rating) {
        this.id = id;
        this.address = address;
        this.name = name;
        this.phone = phone;
        this.rating = rating;
    }

    public Customer(String address, String name, String phone, Integer rating) {
        this.address = address;
        this.name = name;
        this.phone = phone;
        this.rating = rating;
    }

    public Customer(Long id, String address, String name, String phone, Integer rating, Collection<Order> orders) {
        this.id = id;
        this.address = address;
        this.name = name;
        this.phone = phone;
        this.rating = rating;
//        this.orders = orders;
    }

    @Override
    public String toString() {
        return "Customer{" +
                "id=" + id +
                ", address='" + address + '\'' +
                ", name='" + name + '\'' +
                ", phone='" + phone + '\'' +
                ", rating=" + rating +
//                ", orders=" + orders +
                '}';
    }

    @Id
    @Column(name = "id")
    @GeneratedValue(strategy = GenerationType.IDENTITY) // use mysql autoincrement property
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    @Basic
    @Column(name = "address")
    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    @Basic
    @Column(name = "name")
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Basic
    @Column(name = "phone")
    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    @Basic
    @Column(name = "rating")
    public Integer getRating() {
        return rating;
    }

    public void setRating(Integer rating) {
        this.rating = rating;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Customer customer = (Customer) o;

        if (id != customer.id) return false;
        if (address != null ? !address.equals(customer.address) : customer.address != null) return false;
        if (name != null ? !name.equals(customer.name) : customer.name != null) return false;
        if (phone != null ? !phone.equals(customer.phone) : customer.phone != null) return false;
        if (rating != null ? !rating.equals(customer.rating) : customer.rating != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = id.intValue();
        result = 31 * result + (address != null ? address.hashCode() : 0);
        result = 31 * result + (name != null ? name.hashCode() : 0);
        result = 31 * result + (phone != null ? phone.hashCode() : 0);
        result = 31 * result + (rating != null ? rating.hashCode() : 0);
        return result;
    }

//    @OneToMany(mappedBy = "customer")
//    public Collection<Order> getOrders() {
//        return orders;
//    }

//    public void setOrders(Collection<Order> orders) {
//        this.orders = orders;
//    }
}
