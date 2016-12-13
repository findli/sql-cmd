package com.becomejavasenior.bean;


import java.io.Serializable;
import java.util.Date;
import java.util.List;

public class User implements Serializable {

    private int id;
    private String fName;
    private String lName;
    private String password;
    private String email;
    private boolean isAdmin;
    private int rights;
    private String photoPath;
    private boolean isNotification;
    private String note;
    private Date dateCreate;
    private Language language;
    private List<Deal> deals;
    private List<Task> tasks;
    private List<Company> companies;
    private List<LoginHistory> loginHistories;
    private List<Contact> contacts;
    private List<EventHistory> eventHistories;
    private List<Note> notes;
    private List<Phone> phones;

    public User() {
    }

    public int getId() { return id; }

    public void setId(int id) { this.id = id; }

    public boolean isAdmin() { return isAdmin; }

    public boolean isNotification() { return isNotification; }

    public String getfName() {
        return fName;
    }

    public void setfName(String fName) {
        this.fName = fName;
    }

    public String getlName() {
        return lName;
    }

    public void setlName(String lName) {
        this.lName = lName;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public boolean is_admin() {
        return isAdmin;
    }

    public void setAdmin(boolean admin) {
        this.isAdmin = admin;
    }

    public int getRights() {
        return rights;
    }

    public void setRights(int rights) {
        this.rights = rights;
    }

    public String getPhotoPath() {
        return photoPath;
    }

    public void setPhotoPath(String photoPath) {
        this.photoPath = photoPath;
    }

    public boolean is_notification() {
        return isNotification;
    }

    public void setNotification(boolean notification) {
        this.isNotification = notification;
    }

    public String getNote() {
        return note;
    }

    public void setNote(String note) {
        this.note = note;
    }

    public Date getDateCreate() {
        return dateCreate;
    }

    public void setDateCreate(Date dateCreate) {
        this.dateCreate = dateCreate;
    }

    public Language getLanguage() {
        return language;
    }

    public void setLanguage(Language language) {
        this.language = language;
    }

    public void setIsAdmin(boolean isAdmin) {
        this.isAdmin = isAdmin;
    }

    public void setIsNotification(boolean isNotification) {
        this.isNotification = isNotification;
    }

    public void setDeals(List<Deal> userDeals) {
        this.deals = userDeals;
    }

    public void setTasks(List<Task> userTasks) {
        this.tasks = userTasks;
    }

    public void setCompanies(List<Company> userCompanys) {
        this.companies = userCompanys;
    }

    public void setLoginHistories(List<LoginHistory> userLoginHistory) {
        this.loginHistories = userLoginHistory;
    }

    public void setContacts(List<Contact> userContacts) {
        this.contacts = userContacts;
    }

    public void setEventHistories(List<EventHistory> userEventHistory) {
        this.eventHistories = userEventHistory;
    }

    public void setNotes(List<Note> userNotes) {
        this.notes = userNotes;
    }

    public List<Deal> getDeals() {
        return deals;
    }

    public List<Task> getTasks() {
        return tasks;
    }

    public List<Company> getCompanies() {
        return companies;
    }

    public List<LoginHistory> getLoginHistories() {
        return loginHistories;
    }

    public List<Contact> getContacts() {
        return contacts;
    }

    public List<EventHistory> getEventHistories() {
        return eventHistories;
    }

    public List<Note> getNotes() {
        return notes;
    }

    public void setPhones(List<Phone> phones) {
        this.phones = phones;
    }

    public List<Phone> getPhones() {
        return phones;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        User user = (User) o;

        if (id != user.id) return false;
        if (isAdmin != user.isAdmin) return false;
        if (rights != user.rights) return false;
        if (isNotification != user.isNotification) return false;
        if (fName != null ? !fName.equals(user.fName) : user.fName != null) return false;
        if (lName != null ? !lName.equals(user.lName) : user.lName != null) return false;
        if (password != null ? !password.equals(user.password) : user.password != null) return false;
        if (email != null ? !email.equals(user.email) : user.email != null) return false;
        if (photoPath != null ? !photoPath.equals(user.photoPath) : user.photoPath != null) return false;
        if (note != null ? !note.equals(user.note) : user.note != null) return false;
        if (dateCreate != null ? !dateCreate.equals(user.dateCreate) : user.dateCreate != null) return false;
        if (language != null ? !language.equals(user.language) : user.language != null) return false;
        if (deals != null ? !deals.equals(user.deals) : user.deals != null) return false;
        if (tasks != null ? !tasks.equals(user.tasks) : user.tasks != null) return false;
        if (companies != null ? !companies.equals(user.companies) : user.companies != null) return false;
        if (loginHistories != null ? !loginHistories.equals(user.loginHistories) : user.loginHistories != null)
            return false;
        if (contacts != null ? !contacts.equals(user.contacts) : user.contacts != null) return false;
        if (eventHistories != null ? !eventHistories.equals(user.eventHistories) : user.eventHistories != null)
            return false;
        if (notes != null ? !notes.equals(user.notes) : user.notes != null) return false;
        return phones != null ? phones.equals(user.phones) : user.phones == null;
    }

    @Override
    public int hashCode() {
        int result = id;
        result = 31 * result + (fName != null ? fName.hashCode() : 0);
        result = 31 * result + (lName != null ? lName.hashCode() : 0);
        result = 31 * result + (password != null ? password.hashCode() : 0);
        result = 31 * result + (email != null ? email.hashCode() : 0);
        result = 31 * result + (isAdmin ? 1 : 0);
        result = 31 * result + rights;
        result = 31 * result + (photoPath != null ? photoPath.hashCode() : 0);
        result = 31 * result + (isNotification ? 1 : 0);
        result = 31 * result + (note != null ? note.hashCode() : 0);
        result = 31 * result + (dateCreate != null ? dateCreate.hashCode() : 0);
        result = 31 * result + (language != null ? language.hashCode() : 0);
        result = 31 * result + (deals != null ? deals.hashCode() : 0);
        result = 31 * result + (tasks != null ? tasks.hashCode() : 0);
        result = 31 * result + (companies != null ? companies.hashCode() : 0);
        result = 31 * result + (loginHistories != null ? loginHistories.hashCode() : 0);
        result = 31 * result + (contacts != null ? contacts.hashCode() : 0);
        result = 31 * result + (eventHistories != null ? eventHistories.hashCode() : 0);
        result = 31 * result + (notes != null ? notes.hashCode() : 0);
        result = 31 * result + (phones != null ? phones.hashCode() : 0);
        return result;
    }

    @Override
    public String toString() {
        return "User{" +
                "id=" + id +
                ", fName='" + fName + '\'' +
                ", lName='" + lName + '\'' +
                ", password='" + password + '\'' +
                ", email='" + email + '\'' +
                ", isAdmin=" + isAdmin +
                ", rights=" + rights +
                ", photoPath='" + photoPath + '\'' +
                ", isNotification=" + isNotification +
                ", note='" + note + '\'' +
                ", dateCreate=" + dateCreate +
                ", language=" + language +
                ", deals=" + deals +
                ", tasks=" + tasks +
                ", companies=" + companies +
                ", loginHistories=" + loginHistories +
                ", contacts=" + contacts +
                ", eventHistories=" + eventHistories +
                ", notes=" + notes +
                ", phones=" + phones +
                '}';
    }
}