package com.becomejavasenior.bean;


import java.io.Serializable;
import java.util.Date;

public class LoginHistory implements Serializable {

    private int id;
    private User user;
    private Date date;
    private String ipAdress;
    private String browser;


    public LoginHistory() {
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    public String getIpAdress() {
        return ipAdress;
    }

    public void setIpAdress(String ipAdress) {
        this.ipAdress = ipAdress;
    }

    public String getBrowser() {
        return browser;
    }

    public void setBrowser(String browser) {
        this.browser = browser;
    }


    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        LoginHistory that = (LoginHistory) o;

        if (id != that.id) return false;
        if (date != null ? !date.equals(that.date) : that.date != null) return false;
        if (ipAdress != null ? !ipAdress.equals(that.ipAdress) : that.ipAdress != null) return false;
        return browser != null ? browser.equals(that.browser) : that.browser == null;

    }

    @Override
    public int hashCode() {
        int result = id;
        result = 31 * result + (date != null ? date.hashCode() : 0);
        result = 31 * result + (ipAdress != null ? ipAdress.hashCode() : 0);
        result = 31 * result + (browser != null ? browser.hashCode() : 0);
        return result;
    }

    @Override
    public String toString() {
        return "LoginHistory{" +
                "id=" + id +
                ", user=" + user +
                ", date=" + date +
                ", ipAdress='" + ipAdress + '\'' +
                ", browser='" + browser + '\'' +
                '}';
    }
}
