package net.javajoy.jss.w_12_2.orm.personnel;

import javax.persistence.*;
import java.util.List;

/**
 * @author Cyril Kadomsky
 */
@Entity
@Table(name = "positions", schema = "", catalog = "personnel")
public class Position {
    private long id;
    private String name;
    private String comment;
    private List<Employee> employees;

    @Id
    @Column(name = "id")
    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    @Basic
    @Column(name = "name")
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Basic
    @Column(name = "comment")
    public String getComment() {
        return comment;
    }

    public void setComment(String comment) {
        this.comment = comment;
    }

    public Position() {
    }

    public Position(String name, String comment) {
        this.name = name;
        this.comment = comment;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Position position = (Position) o;

        if (id != position.id) return false;
        if (name != null ? !name.equals(position.name) : position.name != null) return false;
        if (comment != null ? !comment.equals(position.comment) : position.comment != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        long result = id;
        result = 31 * result + (name != null ? name.hashCode() : 0);
        result = 31 * result + (comment != null ? comment.hashCode() : 0);
        return (int) result;
    }

    @OneToMany(mappedBy = "position")
    public List<Employee> getEmployees() {
        return employees;
    }

    public void setEmployees(List<Employee> employees) {
        this.employees = employees;
    }

    @Override
    public String toString() {
        return "Position{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", comment='" + comment + '\'' +
                '}';
    }
}
