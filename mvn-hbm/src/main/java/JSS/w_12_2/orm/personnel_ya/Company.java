package JSS.w_12_2.orm.personnel_ya;

import javax.persistence.*;
import java.util.Collection;

@Entity
public class Company {
    private int id;
    private String name;
    private int responsibleUser;
    private String phone;
    private String email;
    private String web;
    private String address;
    private String description;
    private Collection<File> filesById;
    private Collection<Tag> tagsById;

    @Id
    @Column(name = "id", nullable = false)
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    @Basic
    @Column(name = "name", nullable = false, length = 255)
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Basic
    @Column(name = "responsible_user", nullable = false)
    public int getResponsibleUser() {
        return responsibleUser;
    }

    public void setResponsibleUser(int responsibleUser) {
        this.responsibleUser = responsibleUser;
    }

    @Basic
    @Column(name = "phone", nullable = true, length = 11)
    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    @Basic
    @Column(name = "email", nullable = true, length = 255)
    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    @Basic
    @Column(name = "web", nullable = true, length = 255)
    public String getWeb() {
        return web;
    }

    public void setWeb(String web) {
        this.web = web;
    }

    @Basic
    @Column(name = "address", nullable = true, length = 255)
    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    @Basic
    @Column(name = "description", nullable = true, length = 255)
    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Company company = (Company) o;

        if (id != company.id) return false;
        if (responsibleUser != company.responsibleUser) return false;
        if (name != null ? !name.equals(company.name) : company.name != null) return false;
        if (phone != null ? !phone.equals(company.phone) : company.phone != null) return false;
        if (email != null ? !email.equals(company.email) : company.email != null) return false;
        if (web != null ? !web.equals(company.web) : company.web != null) return false;
        if (address != null ? !address.equals(company.address) : company.address != null) return false;
        if (description != null ? !description.equals(company.description) : company.description != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = id;
        result = 31 * result + (name != null ? name.hashCode() : 0);
        result = 31 * result + responsibleUser;
        result = 31 * result + (phone != null ? phone.hashCode() : 0);
        result = 31 * result + (email != null ? email.hashCode() : 0);
        result = 31 * result + (web != null ? web.hashCode() : 0);
        result = 31 * result + (address != null ? address.hashCode() : 0);
        result = 31 * result + (description != null ? description.hashCode() : 0);
        return result;
    }

    @OneToMany(mappedBy = "companyByCompanyId")
    public Collection<File> getFilesById() {
        return filesById;
    }

    public void setFilesById(Collection<File> filesById) {
        this.filesById = filesById;
    }

    @OneToMany(mappedBy = "companyByCompanyId")
    public Collection<Tag> getTagsById() {
        return tagsById;
    }

    public void setTagsById(Collection<Tag> tagsById) {
        this.tagsById = tagsById;
    }
}
