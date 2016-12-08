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

    public Deal(){

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
        if (!title.equals(deal.title)) return false;
        if (!company.equals(deal.company)) return false;
        if (!stage.equals(deal.stage)) return false;
        return responsibleUser.equals(deal.responsibleUser);

    }

    @Override
    public int hashCode() {
        int result = id;
        result = 31 * result + title.hashCode();
        result = 31 * result + company.hashCode();
        result = 31 * result + budget;
        result = 31 * result + stage.hashCode();
        result = 31 * result + responsibleUser.hashCode();
        result = 31 * result + (isDeleted ? 1 : 0);
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
                ", responsible_user=" + responsibleUser +
                ", isDeleted=" + isDeleted +
                '}';
    }
}