package com.becomejavasenior.bean;

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
    private List<Note> contactNote;
    private List<Tag> contactTag;
    private List<Task> contactTask;
    private List<Deal> contactDeal;
    private List<EventHistory> contactEvent;
    private List<Phone> contactPhone;

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

    public void setContactNote(List<Note> contactNote) {
        this.contactNote = contactNote;
    }

    public List<Note> getContactNote() {
        return contactNote;
    }

    public boolean isDeleted() {
        return isDeleted;
    }

    public List<Tag> getContactTag() {
        return contactTag;
    }

    public void setContactTag(List<Tag> contactTag) {
        this.contactTag = contactTag;
    }

    public List<Task> getContactTask() {
        return contactTask;
    }

    public void setContactTask(List<Task> contactTask) {
        this.contactTask = contactTask;
    }

    public List<Deal> getContactDeal() {
        return contactDeal;
    }

    public void setContactDeal(List<Deal> contactDeal) {
        this.contactDeal = contactDeal;
    }

    public List<EventHistory> getContactEvent() {
        return contactEvent;
    }

    public void setContactEvent(List<EventHistory> contactEvent) {
        this.contactEvent = contactEvent;
    }

    public List<Phone> getContactPhone() {
        return contactPhone;
    }

    public void setContactPhone(List<Phone> contactPhone) {
        this.contactPhone = contactPhone;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Contact contact = (Contact) o;

        if (id != contact.id) return false;
        if (isDeleted != contact.isDeleted) return false;
        if (fName != null ? !fName.equals(contact.fName) : contact.fName != null) return false;
        if (lName != null ? !lName.equals(contact.lName) : contact.lName != null) return false;
        if (company != null ? !company.equals(contact.company) : contact.company != null) return false;
        if (position != null ? !position.equals(contact.position) : contact.position != null) return false;
        if (skype != null ? !skype.equals(contact.skype) : contact.skype != null) return false;
        if (email != null ? !email.equals(contact.email) : contact.email != null) return false;
        if (responsibleUser != null ? !responsibleUser.equals(contact.responsibleUser) : contact.responsibleUser != null)
            return false;
        if (!contactNote.equals(contact.contactNote)) return false;
        if (!contactTag.equals(contact.contactTag)) return false;
        if (!contactTask.equals(contact.contactTask)) return false;
        if (!contactDeal.equals(contact.contactDeal)) return false;
        if (!contactEvent.equals(contact.contactEvent)) return false;
        return contactPhone.equals(contact.contactPhone);
    }

    @Override
    public int hashCode() {
        int result = id;
        result = 31 * result + (fName != null ? fName.hashCode() : 0);
        result = 31 * result + (lName != null ? lName.hashCode() : 0);
        result = 31 * result + (company != null ? company.hashCode() : 0);
        result = 31 * result + (position != null ? position.hashCode() : 0);
        result = 31 * result + (skype != null ? skype.hashCode() : 0);
        result = 31 * result + (email != null ? email.hashCode() : 0);
        result = 31 * result + (responsibleUser != null ? responsibleUser.hashCode() : 0);
        result = 31 * result + (isDeleted ? 1 : 0);
        result = 31 * result + contactNote.hashCode();
        result = 31 * result + contactTag.hashCode();
        result = 31 * result + contactTask.hashCode();
        result = 31 * result + contactDeal.hashCode();
        result = 31 * result + contactEvent.hashCode();
        result = 31 * result + contactPhone.hashCode();
        return result;
    }

    @Override
    public String toString() {
        return "Contact{" +
                "id=" + id +
                ", fName='" + fName + '\'' +
                ", lName='" + lName + '\'' +
                ", company=" + company +
                ", position='" + position + '\'' +
                ", skype='" + skype + '\'' +
                ", email='" + email + '\'' +
                ", responsibleUser=" + responsibleUser +
                ", isDeleted=" + isDeleted +
                '}';
    }
}
