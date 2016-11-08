package com.becomejavasenior.bean;

import java.io.Serializable;

public class Address implements Serializable {

    private int id;
    private String country;
    private String city;
    private String street;
    private String buildNum;
    private int zipcode;
    private String officeRoom;


    public Address() {
    }


    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getCountry() {
        return country;
    }

    public void setCountry(String country) {
        this.country = country;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public String getStreet() {
        return street;
    }

    public void setStreet(String street) {
        this.street = street;
    }

    public String getBuildNum() {
        return buildNum;
    }

    public void setBuildNum(String buildNum) {
        this.buildNum = buildNum;
    }

    public int getZipcode() {
        return zipcode;
    }

    public void setZipcode(int zipcode) {
        this.zipcode = zipcode;
    }

    public String getOfficeRoom() {
        return officeRoom;
    }

    public void setOfficeRoom(String officeRoom) {
        this.officeRoom = officeRoom;
    }


    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Address address = (Address) o;

        if (id != address.id) return false;
        if (zipcode != address.zipcode) return false;
        if (country != null ? !country.equals(address.country) : address.country != null) return false;
        if (city != null ? !city.equals(address.city) : address.city != null) return false;
        if (street != null ? !street.equals(address.street) : address.street != null) return false;
        if (buildNum != null ? !buildNum.equals(address.buildNum) : address.buildNum != null) return false;
        return officeRoom != null ? officeRoom.equals(address.officeRoom) : address.officeRoom == null;

    }

    @Override
    public int hashCode() {
        int result = id;
        result = 31 * result + (country != null ? country.hashCode() : 0);
        result = 31 * result + (city != null ? city.hashCode() : 0);
        result = 31 * result + (street != null ? street.hashCode() : 0);
        result = 31 * result + (buildNum != null ? buildNum.hashCode() : 0);
        result = 31 * result + zipcode;
        result = 31 * result + (officeRoom != null ? officeRoom.hashCode() : 0);
        return result;
    }


    @Override
    public String toString() {
        return "Address{" +
                "id=" + id +
                ", country='" + country + '\'' +
                ", city='" + city + '\'' +
                ", street='" + street + '\'' +
                ", buildNum='" + buildNum + '\'' +
                ", zipcode=" + zipcode +
                ", officeRoom='" + officeRoom + '\'' +
                '}';
    }
}
