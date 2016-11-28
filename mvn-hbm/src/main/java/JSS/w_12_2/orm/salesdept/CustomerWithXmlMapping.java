package JSS.w_12_2.orm.salesdept;

public class CustomerWithXmlMapping {
    private int id;
    private String address;
    private String name;
    private String phone;
    private Integer rating;

    public CustomerWithXmlMapping() {
    }

    public CustomerWithXmlMapping(String address, String name, String phone, Integer rating) {

        this.address = address;
        this.name = name;
        this.phone = phone;
        this.rating = rating;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
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

    public Integer getRating() {
        return rating;
    }

    public void setRating(Integer rating) {
        this.rating = rating;
    }

    @Override
    public String toString() {
        return "CustomerWithXmlMapping{" +
                "id=" + id +
                ", address='" + address + '\'' +
                ", name='" + name + '\'' +
                ", phone='" + phone + '\'' +
                ", rating=" + rating +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        CustomerWithXmlMapping customers = (CustomerWithXmlMapping) o;

        if (id != customers.id) return false;
        if (address != null ? !address.equals(customers.address) : customers.address != null) return false;
        if (name != null ? !name.equals(customers.name) : customers.name != null) return false;
        if (phone != null ? !phone.equals(customers.phone) : customers.phone != null) return false;
        if (rating != null ? !rating.equals(customers.rating) : customers.rating != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = id;
        result = 31 * result + (address != null ? address.hashCode() : 0);
        result = 31 * result + (name != null ? name.hashCode() : 0);
        result = 31 * result + (phone != null ? phone.hashCode() : 0);
        result = 31 * result + (rating != null ? rating.hashCode() : 0);
        return result;
    }
}
