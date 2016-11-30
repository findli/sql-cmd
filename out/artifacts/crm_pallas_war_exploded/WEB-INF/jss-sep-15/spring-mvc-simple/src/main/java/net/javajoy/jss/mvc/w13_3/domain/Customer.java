package net.javajoy.jss.mvc.w13_3.domain;

/**
 * @author Cyril Kadomsky
 */
public class Customer {
    Long id;
    String name;
    Integer rating;

    public Customer() {
    }

    public Customer(Long id, String name, Integer rating) {
        this.id = id;
        this.name = name;
        this.rating = rating;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Integer getRating() {
        return rating;
    }

    public void setRating(Integer rating) {
        this.rating = rating;
    }
}
