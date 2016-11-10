package model.src.main.java.com.becomejavasenior.bean;

import java.io.Serializable;
import java.util.List;


public class Contact implements Serializable {

    private int id;
    private String fName;
    private String lName;
    private Company company;
    private String position;
    private String skype;
    private String email;
    private User responsibleUser;
    private boolean isDeleted;
    private List<Task> tasks;
    private List<EventHistory> events;
    private List<Phone> phoneNumbers;

    public Contact() {
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
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

    public Company getCompany() {
        return company;
    }

    public void setCompany(Company company) {
        this.company = company;
    }

    public String getPosition() {
        return position;
    }

    public void setPosition(String position) {
        this.position = position;
    }

    public String getSkype() {
        return skype;
    }

    public void setSkype(String skype) {
        this.skype = skype;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public User getResponsibleUser() {
        return responsibleUser;
    }

    public void setResponsibleUser(User responsibleUser) {
        this.responsibleUser = responsibleUser;
    }

    public boolean is_deleted() {
        return isDeleted;
    }

    public void setDeleted(boolean deleted) {
        this.isDeleted = deleted;
    }

    public List<Task> getTasks() {
        return tasks;
    }

    public void setTasks(List<Task> tasks) {
        this.tasks = tasks;
    }

    public List<EventHistory> getEvents() {
        return events;
    }

    public void setEvents(List<EventHistory> events) {
        this.events = events;
    }

    public List<Phone> getPhoneNumbers() {
        return phoneNumbers;
    }

    public void setPhoneNumbers(List<Phone> phoneNumbers) {
        this.phoneNumbers = phoneNumbers;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Contact contact = (Contact) o;

        if (id != contact.id) return false;
        if (fName != null ? !fName.equals(contact.fName) : contact.fName != null) return false;
        if (lName != null ? !lName.equals(contact.lName) : contact.lName != null) return false;
        if (position != null ? !position.equals(contact.position) : contact.position != null) return false;
        if (skype != null ? !skype.equals(contact.skype) : contact.skype != null) return false;
        return email != null ? email.equals(contact.email) : contact.email == null;

    }

    @Override
    public int hashCode() {
        int result = id;
        result = 31 * result + (fName != null ? fName.hashCode() : 0);
        result = 31 * result + (lName != null ? lName.hashCode() : 0);
        result = 31 * result + (position != null ? position.hashCode() : 0);
        result = 31 * result + (skype != null ? skype.hashCode() : 0);
        result = 31 * result + (email != null ? email.hashCode() : 0);
        return result;
    }

    @Override
    public String toString() {
        return "Contact{" +
                "id=" + id +
                ", name='" + fName + '\'' +
                ", Surname='" + lName + '\'' +
                ", responsibleUser=" + responsibleUser.getfName() + " " + responsibleUser.getlName() + '\'' +
                ", position='" + position + '\'' +
                ", skype='" + skype + '\'' +
                ", email='" + email + '\'' +
                ", company=" + company.getTitle() +
                '}';
    }
}
