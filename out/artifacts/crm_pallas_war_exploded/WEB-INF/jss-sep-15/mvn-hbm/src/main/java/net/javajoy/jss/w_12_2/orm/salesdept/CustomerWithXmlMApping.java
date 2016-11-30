package net.javajoy.jss.w_12_2.orm.salesdept;

/**
 * @author Cyril Kadomsky
 */
public class CustomerWithXmlMApping {
    private long id;
    private String name;
    private String phone;
    private String address;
    private Integer rating;

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

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

        CustomerWithXmlMApping customers = (CustomerWithXmlMApping) o;

        if (id != customers.id) return false;
        if (name != null ? !name.equals(customers.name) : customers.name != null) return false;
        if (phone != null ? !phone.equals(customers.phone) : customers.phone != null) return false;
        if (address != null ? !address.equals(customers.address) : customers.address != null) return false;
        if (rating != null ? !rating.equals(customers.rating) : customers.rating != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = (int) (id ^ (id >>> 32));
        result = 31 * result + (name != null ? name.hashCode() : 0);
        result = 31 * result + (phone != null ? phone.hashCode() : 0);
        result = 31 * result + (address != null ? address.hashCode() : 0);
        result = 31 * result + (rating != null ? rating.hashCode() : 0);
        return result;
    }

    public CustomerWithXmlMApping() {
    }

    public CustomerWithXmlMApping(String name, String phone, String address, Integer rating) {
        this.name = name;
        this.phone = phone;
        this.address = address;
        this.rating = rating;
    }

    @Override
    public String toString() {
        return "CustomerWithXmlMApping{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", phone='" + phone + '\'' +
                ", address='" + address + '\'' +
                ", rating=" + rating +
                '}';
    }
}
