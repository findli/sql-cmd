package JSS.w03_pract.model.om;

public class Customer {

    private long id = -1;           // -1 - new record
    private String name = "";
    private String phone = "";
    private String address = "";
    private int rating = 0;

    public Customer(String name, String phone, String address, int rating) {
        this.id = -1;
        this.name = name;
        this.phone = phone;
        this.address = address;
        this.rating = rating;
    }

    public Customer(long id, String name, String phone, String address, int rating) {
        this.id = id;
        this.name = name;
        this.phone = phone;
        this.address = address;
        this.rating = rating;
    }

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

    public int getRating() {
        return rating;
    }

    public void setRating(int rating) {
        this.rating = rating;
    }
}
