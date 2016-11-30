package com.becomejavasenior.bean;


import java.io.Serializable;
import java.util.Date;

public class EventHistory implements Serializable{

    private int id;
    private EventObject eventObject;
    private EventAction eventAction;
    private int objectId;
    private User promotedUser;
    private Date date;

    public EventHistory() {
    }


    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public EventObject getEventObject() {
        return eventObject;
    }

    public void setEventObject(EventObject eventObject) {
        this.eventObject = eventObject;
    }

    public EventAction getEventAction() {
        return eventAction;
    }

    public void setEventAction(EventAction eventAction) {
        this.eventAction = eventAction;
    }

    public int getObjectId() {
        return objectId;
    }

    public void setObjectId(int objectId) {
        this.objectId = objectId;
    }

    public User getPromotedUser() {
        return promotedUser;
    }

    public void setPromotedUser(User promotedUser) {
        this.promotedUser = promotedUser;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        EventHistory that = (EventHistory) o;

        if (id != that.id) return false;
        if (objectId != that.objectId) return false;
        if (eventObject != that.eventObject) return false;
        if (eventAction != that.eventAction) return false;
        return date != null ? date.equals(that.date) : that.date == null;

    }

    @Override
    public int hashCode() {
        int result = id;
        result = 31 * result + (eventObject != null ? eventObject.hashCode() : 0);
        result = 31 * result + (eventAction != null ? eventAction.hashCode() : 0);
        result = 31 * result + objectId;
        result = 31 * result + (date != null ? date.hashCode() : 0);
        return result;
    }


    @Override
    public String toString() {
        return "EventHistory{" +
                "id=" + id +
                ", eventObject=" + eventObject +
                ", eventAction=" + eventAction +
                ", objectId=" + objectId +
                ", promotedUser=" + promotedUser +
                ", date=" + date +
                '}';
    }
}
