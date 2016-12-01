package com.becomejavasenior.bean;

import java.io.Serializable;
import java.util.Objects;

public class TaskType implements Serializable {

    private int id;
    private String title;

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

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof TaskType)) return false;
        TaskType taskType = (TaskType) o;
        return id == taskType.id &&
                Objects.equals(title, taskType.title);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, title);
    }

    @Override
    public String toString() {
        return "TaskType{" +
                "id=" + id +
                ", title='" + title + '\'' +
                '}';
    }
}
