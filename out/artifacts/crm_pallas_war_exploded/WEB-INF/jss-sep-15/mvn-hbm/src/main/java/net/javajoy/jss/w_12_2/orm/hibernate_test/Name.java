package net.javajoy.jss.w_12_2.orm.hibernate_test;

import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Embeddable;

/**
 * @author Cyril Kadomsky
 */
@Embeddable
public class Name {

    @Basic
    @Column(name="firstName", length = 64, nullable = false)
    String first;

    @Basic
    @Column(name="lastName", length=64, nullable = true)
    String last;

    public String getFirst() {
        return first;
    }

    public void setFirst(String first) {
        this.first = first;
    }

    public String getLast() {
        return last;
    }

    public void setLast(String last) {
        this.last = last;
    }

    public Name() {
    }

    public Name(String first, String last) {
        this.first = first;
        this.last = last;
    }

    @Override
    public String toString() {
        return "Name{" +
                "first='" + first + '\'' +
                ", last='" + last + '\'' +
                '}';
    }
}
