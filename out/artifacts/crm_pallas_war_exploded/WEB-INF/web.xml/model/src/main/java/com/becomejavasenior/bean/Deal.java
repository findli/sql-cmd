package com.becomejavasenior.bean;

import java.io.Serializable;
import java.util.List;

public class Deal implements Serializable {

    private int id;
    private String title;
    private Company company;
    private int budget;
    private Stage stage;
    private User responsibleUser;
    private boolean isDeleted;

    public Deal(){

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

    public void setIsDeleted(boolean deleted) {
        this.isDeleted = deleted;
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

