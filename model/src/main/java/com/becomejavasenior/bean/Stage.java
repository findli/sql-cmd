package com.becomejavasenior.bean;

import java.io.Serializable;
import java.util.List;

public class Stage implements Serializable{

    private int id;
    private String title;
    private String color;
    private int priority;
    private boolean isDeletable;
    private List<Deal> deals;

    public Stage(){

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

    public String getColor() {
        return color;
    }

    public void setColor(String color) {
        this.color = color;
    }

    public int getPriority() {
        return priority;
    }

    public void setPriority(int priority) {
        this.priority = priority;
    }

    public boolean is_deletable() {
        return isDeletable;
    }

    public void setDeletable(boolean deletable) {
        this.isDeletable = deletable;
    }

    public void setIsDeletable(boolean isDeletable) {
        this.isDeletable = isDeletable;
    }

    public void setDeals(List<Deal> deals) {
        this.deals = deals;
    }

    public boolean isDeletable() {
        return isDeletable;
    }

    public List<Deal> getDeals() {
        return deals;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Stage stage = (Stage) o;

        if (id != stage.id) return false;
        if (isDeletable != stage.isDeletable) return false;
        if (!title.equals(stage.title)) return false;
        if (priority != stage.priority) return false;
        return color.equals(stage.color);

    }

    @Override
    public int hashCode() {
        int result = id;
        result = 31 * result + title.hashCode();
        result = 31 * result + color.hashCode();
        result = 31 * result + (isDeletable ? 1 : 0);
        return result;
    }

    @Override
    public String toString() {
        return "Stage{" +
                "id=" + id +
                ", title='" + title + '\'' +
                ", color='" + color + '\'' +
                ", priority=" + priority +
                ", isDeletable=" + isDeletable +
                '}';
    }

}
