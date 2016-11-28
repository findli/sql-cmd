package JSS.w_12_2.orm.hibernate_test;

import org.hibernate.annotations.Type;

import javax.persistence.*;
import java.util.Arrays;

@Entity
@Table(name = "user", schema = "", catalog = "hibernate_test")
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    int id;

    String login;

    @Embedded
    Name name;

    @Basic
    @Type(type = "string")
    String descr;
    @Lob
    @Basic
    byte data[];

    public User() {
    }

    public String getLogin() {
        return login;
    }

    public void setLogin(String login) {
        this.login = login;
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

    // можно писать аннотации к геттерам и сеттерам
    public long getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getDesc() {
        return descr;
    }

    public void setDesc(String descr) {
        this.descr = descr;
    }

    public byte[] getData() {
        return data;
    }

    public void setData(byte[] data) {
        this.data = data;
    }
}
