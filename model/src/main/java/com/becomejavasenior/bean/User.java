package com.becomejavasenior.bean;


import java.io.Serializable;
import java.util.Date;

public class User implements Serializable {

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

    public User() {
    }

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

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        User user = (User) o;

        if (isAdmin != user.isAdmin) return false;
        if (rights != user.rights) return false;
        if (isNotification != user.isNotification) return false;
        if (language != user.language) return false;
        if (fName != null ? !fName.equals(user.fName) : user.fName != null) return false;
        if (lName != null ? !lName.equals(user.lName) : user.lName != null) return false;
        if (password != null ? !password.equals(user.password) : user.password != null) return false;
        if (email != null ? !email.equals(user.email) : user.email != null) return false;
        if (photoPath != null ? !photoPath.equals(user.photoPath) : user.photoPath != null) return false;
        if (note != null ? !note.equals(user.note) : user.note != null) return false;
        return dateCreate != null ? dateCreate.equals(user.dateCreate) : user.dateCreate == null;

    }

    @Override
    public int hashCode() {
        int result = fName != null ? fName.hashCode() : 0;
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
        return result;
    }

    @Override
    public String toString() {
        return "User{" +
                "fName='" + fName + '\'' +
                ", lName='" + lName + '\'' +
                ", password='" + password + '\'' +
                ", email='" + email + '\'' +
                ", isAdmin=" + isAdmin +
                ", rights=" + rights +
                ", photoPath='" + photoPath + '\'' +
                ", isNotification=" + isNotification +
                ", note='" + note + '\'' +
                ", dateCreate=" + dateCreate +
                ", Language=" + language +
                '}';
    }
}
