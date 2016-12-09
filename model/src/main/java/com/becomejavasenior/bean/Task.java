package com.becomejavasenior.bean;

import java.io.Serializable;
import java.util.Date;

public class Task implements Serializable {

    private static final long serialVersionUID = 6293431459384559680L;

    private int id;
    private String title;
    private TaskType taskType;
    private String description;
    private Date deadlineDate;
    private PeriodInDaysType periodInDaysType;
    private int periodInMinutes;
    private User responsibleUser;
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

    public TaskType getTaskType() {
        return taskType;
    }

    public void setTaskType(TaskType taskType) {
        this.taskType = taskType;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public Date getDeadlineDate() {
        return deadlineDate;
    }

    public void setDeadlineDate(Date deadlineDate) {
        this.deadlineDate = deadlineDate;
    }

    public PeriodInDaysType getPeriodInDaysType() {
        return periodInDaysType;
    }

    public void setPeriodInDaysType(PeriodInDaysType periodInDaysType) {
        this.periodInDaysType = periodInDaysType;
    }

    public int getPeriodInMinutes() {
        return periodInMinutes;
    }

    public void setPeriodInMinutes(int periodInMinutes) {
        this.periodInMinutes = periodInMinutes;
    }

    public User getResponsibleUser() {
        return responsibleUser;
    }

    public void setResponsibleUser(User responsibleUser) {
        this.responsibleUser = responsibleUser;
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
        if (o == null || getClass() != o.getClass()) return false;

        Task task = (Task) o;

        if (id != task.id) return false;
        if (periodInMinutes != task.periodInMinutes) return false;
        if (isFinished != task.isFinished) return false;
        if (isDeleted != task.isDeleted) return false;
        if (title != null ? !title.equals(task.title) : task.title != null) return false;
        if (taskType != null ? !taskType.equals(task.taskType) : task.taskType != null) return false;
        if (description != null ? !description.equals(task.description) : task.description != null) return false;
        if (deadlineDate != null ? !deadlineDate.equals(task.deadlineDate) : task.deadlineDate != null) return false;
        if (periodInDaysType != null ? !periodInDaysType.equals(task.periodInDaysType) : task.periodInDaysType != null)
            return false;
        return responsibleUser != null ? responsibleUser.equals(task.responsibleUser) : task.responsibleUser == null;

    }

    @Override
    public int hashCode() {
        int result = id;
        result = 31 * result + (title != null ? title.hashCode() : 0);
        result = 31 * result + (taskType != null ? taskType.hashCode() : 0);
        result = 31 * result + (description != null ? description.hashCode() : 0);
        result = 31 * result + (deadlineDate != null ? deadlineDate.hashCode() : 0);
        result = 31 * result + (periodInDaysType != null ? periodInDaysType.hashCode() : 0);
        result = 31 * result + periodInMinutes;
        result = 31 * result + (responsibleUser != null ? responsibleUser.hashCode() : 0);
        result = 31 * result + (isFinished ? 1 : 0);
        result = 31 * result + (isDeleted ? 1 : 0);
        return result;
    }

    @Override
    public String toString() {
        return "Task{" +
                "id=" + id +
                ", title='" + title + '\'' +
                ", taskType=" + taskType +
                ", description='" + description + '\'' +
                ", deadlineDate=" + deadlineDate +
                ", periodInDaysType=" + periodInDaysType +
                ", periodInMinutes=" + periodInMinutes +
                ", responsibleUser=" + responsibleUser +
                ", isFinished=" + isFinished +
                ", isDeleted=" + isDeleted +
                '}';
    }
}
