package model.src.main.java.com.becomejavasenior.bean;


import java.io.Serializable;

public class Phone implements Serializable {

    private int id;
    private PhoneType phoneType;
    private String phoneNumber;

    public Phone() {
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public PhoneType getPhoneType() {
        return phoneType;
    }

    public void setPhoneType(PhoneType phoneType) {
        this.phoneType = phoneType;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Phone phone = (Phone) o;

        if (id != phone.id) return false;
        return phoneNumber != null ? phoneNumber.equals(phone.phoneNumber) : phone.phoneNumber == null;

    }

    @Override
    public int hashCode() {
        int result = id;
        result = 31 * result + (phoneNumber != null ? phoneNumber.hashCode() : 0);
        return result;
    }


    @Override
    public String toString() {
        return "Phone{" +
                "id=" + id +
                ", phoneType=" + phoneType +
                ", phoneNumber='" + phoneNumber + '\'' +
                '}';
    }
}
