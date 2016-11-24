package com.becomejavasenior.bean;

import java.io.Serializable;
import java.util.List;


<<<<<<< HEAD
=======

>>>>>>> d80b510610f3099333cb46c2d4958fca80808ef8
public class Company implements Serializable {

    private int id;
    private String title;
    private String phoneNumber;
    private String email;
    private String website;
<<<<<<< HEAD
    private Adress adress;
    private User responsibleUser;
    private Boolean isDeleted;

=======
    private Address address;
    private User responsibleUser;
    private Boolean isDeleted;
    private List<Tag> tags;
    private List<Note> notes;
    private List<Task> tasks;
    private List<Contact> contacts;
    private List<Deal> deals;
>>>>>>> d80b510610f3099333cb46c2d4958fca80808ef8

    public Company() {
    }

<<<<<<< HEAD
=======

>>>>>>> d80b510610f3099333cb46c2d4958fca80808ef8
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

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getWebsite() {
        return website;
    }

    public void setWebsite(String website) {
        this.website = website;
    }

<<<<<<< HEAD
    public Adress getAdress() {
        return adress;
    }

    public void setAdress(Adress adress) {
        this.adress = adress;
=======
    public Address getAddress() {
        return address;
    }

    public void setAddress(Address address) {
        this.address = address;
    }

    public Boolean getDeleted() {
        return isDeleted;
>>>>>>> d80b510610f3099333cb46c2d4958fca80808ef8
    }

    public User getResponsibleUser() {
        return responsibleUser;
    }

    public void setResponsibleUser(User responsibleUser) {
        this.responsibleUser = responsibleUser;
    }

<<<<<<< HEAD
    public void setIsDeleted(Boolean isDeleted) {
        this.isDeleted = isDeleted;
    }

    public Boolean getIsDeleted() {
        return isDeleted;
=======
    public Boolean isDeleted() {
        return isDeleted;
    }

    public void setDeleted(Boolean deleted) {
        isDeleted = deleted;
    }

    public List<Tag> getTags() {
        return tags;
    }

    public void setTags(List<Tag> tags) {
        this.tags = tags;
    }

    public List<Note> getNotes() {
        return notes;
    }

    public void setNotes(List<Note> notes) {
        this.notes = notes;
    }

    public List<Task> getTasks() {
        return tasks;
    }

    public void setTasks(List<Task> tasks) {
        this.tasks = tasks;
    }

    public List<Contact> getContacts() {
        return contacts;
    }

    public void setContacts(List<Contact> contacts) {
        this.contacts = contacts;
>>>>>>> d80b510610f3099333cb46c2d4958fca80808ef8
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Company company = (Company) o;

        if (id != company.id) return false;
        if (title != null ? !title.equals(company.title) : company.title != null) return false;
        if (phoneNumber != null ? !phoneNumber.equals(company.phoneNumber) : company.phoneNumber != null) return false;
        if (email != null ? !email.equals(company.email) : company.email != null) return false;
        if (website != null ? !website.equals(company.website) : company.website != null) return false;
<<<<<<< HEAD
        return adress != null ? adress.equals(company.adress) : company.adress == null;
=======
        return address != null ? address.equals(company.address) : company.address == null;
>>>>>>> d80b510610f3099333cb46c2d4958fca80808ef8

    }

    @Override
    public int hashCode() {
        int result = id;
        result = 31 * result + (title != null ? title.hashCode() : 0);
        result = 31 * result + (phoneNumber != null ? phoneNumber.hashCode() : 0);
        result = 31 * result + (email != null ? email.hashCode() : 0);
        result = 31 * result + (website != null ? website.hashCode() : 0);
<<<<<<< HEAD
        result = 31 * result + (adress != null ? adress.hashCode() : 0);
=======
        result = 31 * result + (address != null ? address.hashCode() : 0);
>>>>>>> d80b510610f3099333cb46c2d4958fca80808ef8
        return result;
    }

    @Override
    public String toString() {
        return "Company{" +
                "id=" + id +
                ", title='" + title + '\'' +
                ", phoneNumber='" + phoneNumber + '\'' +
                ", email='" + email + '\'' +
                ", website='" + website + '\'' +
<<<<<<< HEAD
                ", adress=" + adress +
                ", responsibleUser=" + responsibleUser +
                ", isDeleted=" + isDeleted +
                '}';
    }
}
=======
                ", address=" + address +
                ", responsibleUser=" + responsibleUser +
                '}';
    }

    public List<Deal> getDeals() {
        return deals;
    }

    public void setDeals(List<Deal> deals) {
        this.deals = deals;
    }

}

>>>>>>> d80b510610f3099333cb46c2d4958fca80808ef8
