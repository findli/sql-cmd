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
    private List<Task> dealTask;
    private List<Tag> dealTag;
    private List<Contact> dealContact;
    private List<Note> dealNote;
    private Contact primaryContact;
    private Date createDate;

    public Deal(){

    }

    public List<Contact> getDealContact() {
        return dealContact;
    }

    public void setDealContact(List<Contact> dealContact) {
        this.dealContact = dealContact;
    }

    public List<Note> getDealNote() {
        return dealNote;
    }

    public void setDealNote(List<Note> dealNote) {
        this.dealNote = dealNote;
    }

    public List<Tag> getDealTag() {
        return dealTag;
    }

    public void setDealTag(List<Tag> dealTag) {
        this.dealTag = dealTag;
    }

    public List<Task> getDealTask() {
        return dealTask;
    }

    public void setDealTask(List<Task> dealTask) {
        this.dealTask = dealTask;
    }

    public Date getCreateDate() {
        return createDate;
    }

    public void setCreateDate(Date createDate) {
        this.createDate = createDate;
    }

    public Contact getPrimaryContact() {
        return primaryContact;
    }

    public void setPrimaryContact(Contact primaryContact) {
        this.primaryContact = primaryContact;
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
                ", primary_contact_id=" + primaryContact +
                '}';
    }
}