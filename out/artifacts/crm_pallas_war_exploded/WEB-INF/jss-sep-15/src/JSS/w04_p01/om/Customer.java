package JSS.w04_p01.om;

public class Customer {

    private long id = -1;

    private String name = "";
    private String phone = "";
    private int rating = 0;


    public Customer(long id, String name, String phone, int rating) {
        this.id = id;
        this.name = name;
        this.phone = phone;
        this.rating = rating;
    }
    public Customer(String name, String phone, int rating) {
        this.id = -1;
        this.name = name;
        this.phone = phone;
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

    public int getRating() {
        return rating;
    }

    public void setRating(int rating) {
        this.rating = rating;
    }
}
