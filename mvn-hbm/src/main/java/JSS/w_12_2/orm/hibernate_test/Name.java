package JSS.w_12_2.orm.hibernate_test;

import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Embeddable;

@Embeddable
public class Name {

    @Basic
    @Column(name = "firstName")
    String first;

    @Basic
    @Column(name = "lastName")
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

    @Override
    public String toString() {
        return "Name{" +
                "first='" + first + '\'' +
                ", last='" + last + '\'' +
                '}';
    }

    public Name(String first, String last) {
        this.first = first;
        this.last = last;
    }
}
