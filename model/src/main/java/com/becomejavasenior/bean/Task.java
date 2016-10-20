package com.becomejavasenior.bean;

import java.io.Serializable;
import java.util.Date;

public class Task implements Serializable {
    private int id;
    private String title;
    private TaskType taskTypeId;
    private String description;
    private Date deadlineDate;
    private Date time;
    private PeriodInDaysType periodInDaysTypeId;
    private int periodInMinutes;
    private int responsibleUserId;
    private boolean isFinished;
    private boolean isDeleted;

    public Task() {
    }

    @Override
    public String toString() {
        return "Task{" +
                "id=" + id +
                ", title='" + title + '\'' +
                ", taskTypeId=" + taskTypeId +
                ", description='" + description + '\'' +
                ", deadlineDate=" + deadlineDate +
                ", time=" + time +
                ", periodInDaysTypeId=" + periodInDaysTypeId +
                ", periodInMinutes=" + periodInMinutes +
                ", responsibleUserId=" + responsibleUserId +
                ", isFinished=" + isFinished +
                ", isDeleted=" + isDeleted +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Task task = (Task) o;

        if (id != task.id) return false;
        if (periodInMinutes != task.periodInMinutes) return false;
        if (responsibleUserId != task.responsibleUserId) return false;
        if (isFinished != task.isFinished) return false;
        if (isDeleted != task.isDeleted) return false;
        if (title != null ? !title.equals(task.title) : task.title != null) return false;
        if (taskTypeId != null ? !taskTypeId.equals(task.taskTypeId) : task.taskTypeId != null) return false;
        if (description != null ? !description.equals(task.description) : task.description != null) return false;
        if (deadlineDate != null ? !deadlineDate.equals(task.deadlineDate) : task.deadlineDate != null) return false;
        if (time != null ? !time.equals(task.time) : task.time != null) return false;
        return periodInDaysTypeId != null ? periodInDaysTypeId.equals(task.periodInDaysTypeId) : task.periodInDaysTypeId == null;

    }

    @Override
    public int hashCode() {
        int result = id;
        result = 31 * result + (title != null ? title.hashCode() : 0);
        result = 31 * result + (taskTypeId != null ? taskTypeId.hashCode() : 0);
        result = 31 * result + (description != null ? description.hashCode() : 0);
        result = 31 * result + (deadlineDate != null ? deadlineDate.hashCode() : 0);
        result = 31 * result + (time != null ? time.hashCode() : 0);
        result = 31 * result + (periodInDaysTypeId != null ? periodInDaysTypeId.hashCode() : 0);
        result = 31 * result + periodInMinutes;
        result = 31 * result + responsibleUserId;
        result = 31 * result + (isFinished ? 1 : 0);
        result = 31 * result + (isDeleted ? 1 : 0);
        return result;
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

    public Date getDeadlineDate() {
        return deadlineDate;
    }

    public void setDeadlineDate(Date deadlineDate) {
        this.deadlineDate = deadlineDate;
    }

    public Date getTime() {
        return time;
    }

    public void setTime(Date time) {
        this.time = time;
    }

    public PeriodInDaysType getPeriodInDaysTypeId() {
        return periodInDaysTypeId;
    }

    public void setPeriodInDaysTypeId(PeriodInDaysType periodInDaysTypeId) {
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
}
