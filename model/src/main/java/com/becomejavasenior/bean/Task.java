package com.becomejavasenior.bean;

import java.io.Serializable;
import java.util.Date;

public class Task implements Serializable {
    protected int id;
    protected String title;
    protected int taskTypeId;
    protected String description;
    protected Date deadlineDate;
    protected Date time;
    protected int periodInDaysTypeId;
    protected int periodInMinutes;
    protected int responsibleUserId;
    protected boolean isFinished;
    protected boolean isDeleted;

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
}
