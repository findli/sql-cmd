package net.javajoy.jss.w_12_2.orm.hibernate_test;

import org.hibernate.annotations.Type;

import javax.persistence.*;
import java.util.Arrays;

/**
 * @author Cyril Kadomsky
 */

@Entity
@Table(name = "user", schema = "", catalog = "hibernate_test")
public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)   // Use MySQL AutoIncrement property
    long id;

    String login;

    @Embedded
    Name name;

    @Type(type = "text")
    String descr;

    @Lob            // Store as BLOB
    @Basic
    byte data[];

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getLogin() {
        return login;
    }

    public void setLogin(String login) {
        this.login = login;
    }

    public Name getName() {
        return name;
    }

    public void setName(Name name) {
        this.name = name;
    }

    public String getDescr() {
        return descr;
    }

    public void setDescr(String descr) {
        this.descr = descr;
    }

    public byte[] getData() {
        return data;
    }

    public void setData(byte[] data) {
        this.data = data;
    }

    public User() {
    }

    public User(String login, Name name, String descr, byte[] data) {
        this.login = login;
        this.name = name;
        this.descr = descr;
        this.data = data;
    }

    @Override
    public String toString() {
        return "User{" +
                "id=" + id +
                ", login='" + login + '\'' +
                ", name=" + name +
                ", descr='" + descr + '\'' +
                ", data=" + Arrays.toString(data) +
                '}';
    }
}

