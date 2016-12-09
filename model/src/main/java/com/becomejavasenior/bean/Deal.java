package com.becomejavasenior.bean;

import java.io.Serializable;
import java.util.Date;
import java.util.List;

public class Deal implements Serializable {

    private int id;
    private String title;
    private Company company;
    private int budget;
    private Stage stage;
    private User responsibleUser;
    private boolean isDeleted;
    private List<Task> tasks;
    private List<Tag> tags;
    private List<Contact> contacts;
    private List<Note> notes;
    private Date createDate;
    private Contact primaryContact;

    public Deal(){

    }

    public List<Task> getTasks() {
        return tasks;
    }

    public void setTasks(List<Task> tasks) {
        this.tasks = tasks;
    }

    public List<Tag> getTags() {
        return tags;
    }

    public void setTags(List<Tag> tags) {
        this.tags = tags;
    }

    public List<Contact> getContacts() {
        return contacts;
    }

    public void setContacts(List<Contact> contacts) {
        this.contacts = contacts;
    }

    public List<Note> getNotes() {
        return notes;
    }

    public void setNotes(List<Note> notes) {
        this.notes = notes;
    }

    public Contact getPrimaryContact() {
        return primaryContact;
    }

    public void setPrimaryContact(Contact primaryContact) {
        this.primaryContact = primaryContact;
    }

    public List<Contact> getDealContact() {
        return contacts;
    }

    public void setDealContacts(List<Contact> dealContact) {
        this.contacts = dealContact;
    }

    public void setDealNotes(List<Note> dealNotes){
        this.notes = dealNotes;
    }

    public List<Note> getDealNotes() {
        return notes;
    }

    public void setDealNote(List<Note> dealNote) {
        this.notes = dealNote;
    }

    public List<Tag> getDealTags() {
        return tags;
    }

    public void setDealTags(List<Tag> dealTag) {
        this.tags = dealTag;
    }

    public List<Task> getDealTasks() {
        return tasks;
    }

    public void setDealTasks(List<Task> dealTask) {
        this.tasks = dealTask;
    }

    public Date getCreateDate() {
        return createDate;
    }

    public void setCreateDate(Date createDate) {
        this.createDate = createDate;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public Company getCompany() {
        return company;
    }

    public void setCompany(Company company) {
        this.company = company;
    }

    public int getBudget() {
        return budget;
    }

    public void setBudget(int budget) {
        this.budget = budget;
    }

    public Stage getStage() {
        return stage;
    }

    public void setStage(Stage stage) {
        this.stage = stage;
    }

    public User getResponsibleUser() {
        return responsibleUser;
    }

    public void setResponsibleUser(User responsibleUser) {
        this.responsibleUser = responsibleUser;
    }

    public boolean isDeleted() {
        return isDeleted;
    }

    public void setDeleted(boolean deleted) {
        isDeleted = deleted;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Deal deal = (Deal) o;

        if (id != deal.id) return false;
        if (budget != deal.budget) return false;
        if (isDeleted != deal.isDeleted) return false;
        if (title != null ? !title.equals(deal.title) : deal.title != null) return false;
        if (company != null ? !company.equals(deal.company) : deal.company != null) return false;
        if (stage != null ? !stage.equals(deal.stage) : deal.stage != null) return false;
        if (responsibleUser != null ? !responsibleUser.equals(deal.responsibleUser) : deal.responsibleUser != null)
            return false;
        if (tasks != null ? !tasks.equals(deal.tasks) : deal.tasks != null) return false;
        if (tags != null ? !tags.equals(deal.tags) : deal.tags != null) return false;
        if (contacts != null ? !contacts.equals(deal.contacts) : deal.contacts != null) return false;
        if (notes != null ? !notes.equals(deal.notes) : deal.notes != null) return false;
        if (createDate != null ? !createDate.equals(deal.createDate) : deal.createDate != null) return false;
        return primaryContact != null ? primaryContact.equals(deal.primaryContact) : deal.primaryContact == null;
    }

    @Override
    public int hashCode() {
        int result = id;
        result = 31 * result + (title != null ? title.hashCode() : 0);
        result = 31 * result + (company != null ? company.hashCode() : 0);
        result = 31 * result + budget;
        result = 31 * result + (stage != null ? stage.hashCode() : 0);
        result = 31 * result + (responsibleUser != null ? responsibleUser.hashCode() : 0);
        result = 31 * result + (isDeleted ? 1 : 0);
        result = 31 * result + (tasks != null ? tasks.hashCode() : 0);
        result = 31 * result + (tags != null ? tags.hashCode() : 0);
        result = 31 * result + (contacts != null ? contacts.hashCode() : 0);
        result = 31 * result + (notes != null ? notes.hashCode() : 0);
        result = 31 * result + (createDate != null ? createDate.hashCode() : 0);
        result = 31 * result + (primaryContact != null ? primaryContact.hashCode() : 0);
        return result;
    }

    @Override
    public String toString() {
        return "Deal{" +
                "id=" + id +
                ", title='" + title + '\'' +
                ", company=" + company +
                ", budget=" + budget +
                ", stage=" + stage +
                ", responsibleUser=" + responsibleUser +
                ", isDeleted=" + isDeleted +
                ", createDate=" + createDate +
                ", primaryContact=" + primaryContact +
                '}';
    }
}

