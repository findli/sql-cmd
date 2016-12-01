package com.becomejavasenior.bean;

import java.io.Serializable;
import java.sql.Time;
import java.time.LocalDateTime;
import java.util.Date;
import java.util.Objects;

public class Task implements Serializable {

    private static final long serialVersionUID = 6293431459384559680L;

    private int id;
    private String title;
    private TaskType taskTypeId;
    private String description;
    private Date deadLine;
    private int periodInDaysTypeId;
    private int periodInMinutes;
    private User responsibleUserId;
    private boolean isFinished;
    private boolean isDeleted;

    public Task() {
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

    public TaskType getTaskTypeId() {
        return taskTypeId;
    }

    public void setTaskTypeId(TaskType taskTypeId) {
        this.taskTypeId = taskTypeId;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public Date getDeadLine() {
        return deadLine;
    }

    public void setDeadLine(Date deadLine) {
        this.deadLine = deadLine;
    }

    public int getPeriodInDaysTypeId() {
        return periodInDaysTypeId;
    }

    public void setPeriodInDaysTypeId(int periodInDaysTypeId) {
        this.periodInDaysTypeId = periodInDaysTypeId;
    }

    public int getPeriodInMinutes() {
        return periodInMinutes;
    }

    public void setPeriodInMinutes(int periodInMinutes) {
        this.periodInMinutes = periodInMinutes;
    }

    public User getResponsibleUserId() {
        return responsibleUserId;
    }

    public void setResponsibleUserId(User responsibleUserId) {
        this.responsibleUserId = responsibleUserId;
    }

    public boolean isFinished() {
        return isFinished;
    }

    public void setFinished(boolean finished) {
        isFinished = finished;
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
        if (!(o instanceof Task)) return false;
        Task task = (Task) o;
        return id == task.id &&
                taskTypeId == task.taskTypeId &&
                periodInDaysTypeId == task.periodInDaysTypeId &&
                periodInMinutes == task.periodInMinutes &&
                responsibleUserId == task.responsibleUserId &&
                isFinished == task.isFinished &&
                isDeleted == task.isDeleted &&
                Objects.equals(title, task.title) &&
                Objects.equals(description, task.description) &&
                Objects.equals(deadLine, task.deadLine);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, title, taskTypeId, description, deadLine, periodInDaysTypeId, periodInMinutes, responsibleUserId, isFinished, isDeleted);
    }

    @Override
    public String toString() {
        return "Task{" +
                "id=" + id +
                ", title='" + title + '\'' +
                ", taskTypeId=" + taskTypeId +
                ", description='" + description + '\'' +
                ", deadLine=" + deadLine +
                ", periodInDaysTypeId=" + periodInDaysTypeId +
                ", periodInMinutes=" + periodInMinutes +
                ", responsibleUserId=" + responsibleUserId +
                ", isFinished=" + isFinished +
                ", isDeleted=" + isDeleted +
                '}';
    }

}