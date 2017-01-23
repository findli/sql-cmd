package com.becomejavasenior.bean;


import java.io.Serializable;

public class PhoneType implements Serializable{


    private int id;
    private String title;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        PhoneType phoneType = (PhoneType) o;

        if (id != phoneType.id) return false;
        return title != null ? title.equals(phoneType.title) : phoneType.title == null;

    }

    @Override
    public int hashCode() {
        int result = id;
        result = 31 * result + (title != null ? title.hashCode() : 0);
        return result;
    }

    @Override
    public String toString() {
        return "PhoneType{" +
                "id=" + id +
                ", title='" + title + '\'' +
                '}';
    }
}
