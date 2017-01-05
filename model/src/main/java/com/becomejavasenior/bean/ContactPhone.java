package com.becomejavasenior.bean;

import java.io.Serializable;

public class ContactPhone implements Serializable {

    private int id;
    private String phoneNumber;
    private Contact contact;
    private PhoneType phoneType;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    public Contact getContact() {
        return contact;
    }

    public void setContact(Contact contact) {
        this.contact = contact;
    }

    public PhoneType getPhoneType() {
        return phoneType;
    }

    public void setPhoneType(PhoneType phoneType) {
        this.phoneType = phoneType;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        ContactPhone that = (ContactPhone) o;

        if (id != that.id) return false;
        if (phoneNumber != null ? !phoneNumber.equals(that.phoneNumber) : that.phoneNumber != null) return false;
        if (contact != null ? !contact.equals(that.contact) : that.contact != null) return false;
        return phoneType != null ? phoneType.equals(that.phoneType) : that.phoneType == null;

    }

    @Override
    public int hashCode() {
        int result = id;
        result = 31 * result + (phoneNumber != null ? phoneNumber.hashCode() : 0);
        result = 31 * result + (contact != null ? contact.hashCode() : 0);
        result = 31 * result + (phoneType != null ? phoneType.hashCode() : 0);
        return result;
    }

    @Override
    public String toString() {
        return "ContactPhone{" +
                "id=" + id +
                ", phoneNumber='" + phoneNumber + '\'' +
                ", contact=" + contact +
                ", phoneType=" + phoneType +
                '}';
    }
}
