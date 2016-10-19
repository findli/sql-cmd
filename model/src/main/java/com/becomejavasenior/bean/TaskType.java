package com.becomejavasenior.bean;

import java.io.Serializable;

public class TaskType implements Serializable {
    protected int id;
    protected String title;

    public TaskType() {
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
}
