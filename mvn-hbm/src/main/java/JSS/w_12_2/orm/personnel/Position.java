package JSS.w_12_2.orm.personnel;

import javax.persistence.*;
import java.util.List;

@Entity
@Table(name = "positions", schema = "", catalog = "java_jss_personnel")
public class Position {
    private long id;
    private String name;
    private String comment;
    private List<Employee> employees;

    public Position() {
    }

    public Position(String name, String comment) {
        this.name = name;
        this.comment = comment;
    }

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

    @Override
    public String toString() {
        return "Position{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", comment='" + comment + '\'' +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Position position = (Position) o;

        if (id != position.id) return false;
        if (name != null ? !name.equals(position.name) : position.name != null) return false;
        if (comment != null ? !comment.equals(position.comment) : position.comment != null) return false;
        return employees != null ? employees.equals(position.employees) : position.employees == null;
    }

    @Override
    public int hashCode() {
        int result = (int) (id ^ (id >>> 32));
        result = 31 * result + (name != null ? name.hashCode() : 0);
        result = 31 * result + (comment != null ? comment.hashCode() : 0);
        result = 31 * result + (employees != null ? employees.hashCode() : 0);
        return result;
    }

    @Basic
    @Column(name = "comment")
    public String getComment() {
        return comment;
    }

    public void setComment(String comment) {
        this.comment = comment;
    }

    @OneToMany(mappedBy = "position")
    public List<Employee> getEmployees() {
        return employees;
    }

    public void setEmployees(List<Employee> employees) {
        this.employees = employees;
    }
}
