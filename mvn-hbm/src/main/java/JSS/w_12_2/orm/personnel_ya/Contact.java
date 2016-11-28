package JSS.w_12_2.orm.personnel_ya;

import javax.persistence.*;
import java.util.Collection;

@Entity
public class Contact {
    private int id;
    private int responsibleUser;
    private String position;
    private String email;
    private String skype;
    private String note;
    private String phone;
    private int phoneTypeId;
    private String surname;
    private String name;
    private Integer companyId;
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
    @Column(name = "responsible_user", nullable = false)
    public int getResponsibleUser() {
        return responsibleUser;
    }

    public void setResponsibleUser(int responsibleUser) {
        this.responsibleUser = responsibleUser;
    }

    @Basic
    @Column(name = "position", nullable = false, length = 255)
    public String getPosition() {
        return position;
    }

    public void setPosition(String position) {
        this.position = position;
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
    @Column(name = "skype", nullable = true, length = 255)
    public String getSkype() {
        return skype;
    }

    public void setSkype(String skype) {
        this.skype = skype;
    }

    @Basic
    @Column(name = "note", nullable = true, length = -1)
    public String getNote() {
        return note;
    }

    public void setNote(String note) {
        this.note = note;
    }

    @Basic
    @Column(name = "phone", nullable = true, length = 255)
    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    @Basic
    @Column(name = "phone_type_id", nullable = false)
    public int getPhoneTypeId() {
        return phoneTypeId;
    }

    public void setPhoneTypeId(int phoneTypeId) {
        this.phoneTypeId = phoneTypeId;
    }

    @Basic
    @Column(name = "surname", nullable = true, length = 255)
    public String getSurname() {
        return surname;
    }

    public void setSurname(String surname) {
        this.surname = surname;
    }

    @Basic
    @Column(name = "name", nullable = true, length = 255)
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Basic
    @Column(name = "company_id", nullable = true)
    public Integer getCompanyId() {
        return companyId;
    }

    public void setCompanyId(Integer companyId) {
        this.companyId = companyId;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Contact contact = (Contact) o;

        if (id != contact.id) return false;
        if (responsibleUser != contact.responsibleUser) return false;
        if (phoneTypeId != contact.phoneTypeId) return false;
        if (position != null ? !position.equals(contact.position) : contact.position != null) return false;
        if (email != null ? !email.equals(contact.email) : contact.email != null) return false;
        if (skype != null ? !skype.equals(contact.skype) : contact.skype != null) return false;
        if (note != null ? !note.equals(contact.note) : contact.note != null) return false;
        if (phone != null ? !phone.equals(contact.phone) : contact.phone != null) return false;
        if (surname != null ? !surname.equals(contact.surname) : contact.surname != null) return false;
        if (name != null ? !name.equals(contact.name) : contact.name != null) return false;
        if (companyId != null ? !companyId.equals(contact.companyId) : contact.companyId != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = id;
        result = 31 * result + responsibleUser;
        result = 31 * result + (position != null ? position.hashCode() : 0);
        result = 31 * result + (email != null ? email.hashCode() : 0);
        result = 31 * result + (skype != null ? skype.hashCode() : 0);
        result = 31 * result + (note != null ? note.hashCode() : 0);
        result = 31 * result + (phone != null ? phone.hashCode() : 0);
        result = 31 * result + phoneTypeId;
        result = 31 * result + (surname != null ? surname.hashCode() : 0);
        result = 31 * result + (name != null ? name.hashCode() : 0);
        result = 31 * result + (companyId != null ? companyId.hashCode() : 0);
        return result;
    }

    @OneToMany(mappedBy = "contactByContactId")
    public Collection<File> getFilesById() {
        return filesById;
    }

    public void setFilesById(Collection<File> filesById) {
        this.filesById = filesById;
    }

    @OneToMany(mappedBy = "contactByContactId")
    public Collection<Tag> getTagsById() {
        return tagsById;
    }

    public void setTagsById(Collection<Tag> tagsById) {
        this.tagsById = tagsById;
    }
}
