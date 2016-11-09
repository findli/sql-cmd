package com.becomejavasenior.bean;

import java.io.Serializable;
import java.time.LocalDateTime;
import java.util.Objects;

public class Task implements Serializable {

    private int id;
    private String title;
    private int taskTypeId;
    private String description;
    private LocalDateTime deadLine;
    private int periodInDaysTypeId;
    private int periodInMinutes;
    private int responsibleUserId;
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

    public int getTaskTypeId() {
        return taskTypeId;
    }

    public void setTaskTypeId(int taskTypeId) {
        this.taskTypeId = taskTypeId;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public LocalDateTime getDeadLine() {
        return deadLine;
    }

    public void setDeadLine(LocalDateTime deadLine) {
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

    public int getResponsibleUserId() {
        return responsibleUserId;
    }

    public void setResponsibleUserId(int responsibleUserId) {
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
