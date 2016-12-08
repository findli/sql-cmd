package com.becomejavasenior.bean;

import java.io.Serializable;
import java.util.List;
import java.util.Objects;

public class TaskType implements Serializable {

    private int id;
    private String type;
    private List<Task> tasks;

    public TaskType() {
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public void setTasks(List<Task> tasks) {
        this.tasks = tasks;
    }

    public List<Task> getTasks() {
        return tasks;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof TaskType)) return false;
        TaskType taskType = (TaskType) o;
        return id == taskType.id &&
                Objects.equals(type, taskType.type);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, type);
    }

    @Override
    public String toString() {
        return "TaskType{" +
                "id=" + id +
                ", type='" + type + '\'' +
                '}';
    }
}
