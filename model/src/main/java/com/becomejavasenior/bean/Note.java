package com.becomejavasenior.bean;


import java.io.Serializable;
import java.util.Date;

public class Note implements Serializable {

    private int id;
    private String noteText;
    private User createdByUserId;
    private Date dateCreate;

    public Note() {
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getNoteText() {
        return noteText;
    }

    public void setNoteText(String noteText) {
        this.noteText = noteText;
    }

    public User getCreatedByUserId() {
        return createdByUserId;
    }

    public void setCreatedByUserId(User createdByUserId) {
        this.createdByUserId = createdByUserId;
    }

    public Date getDateCreate() {
        return dateCreate;
    }

    public void setDateCreate(Date dateCreate) {
        this.dateCreate = dateCreate;
    }


    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Note note = (Note) o;

        if (id != note.id) return false;
        if (noteText != null ? !noteText.equals(note.noteText) : note.noteText != null) return false;
        if (createdByUserId != null ? !createdByUserId.equals(note.createdByUserId) : note.createdByUserId != null)
            return false;
        return dateCreate != null ? dateCreate.equals(note.dateCreate) : note.dateCreate == null;

    }

    @Override
    public int hashCode() {
        int result = id;
        result = 31 * result + (noteText != null ? noteText.hashCode() : 0);
        result = 31 * result + (createdByUserId != null ? createdByUserId.hashCode() : 0);
        result = 31 * result + (dateCreate != null ? dateCreate.hashCode() : 0);
        return result;
    }

    @Override
    public String toString() {
        return "Note{" +
                "id=" + id +
                ", noteText='" + noteText + '\'' +
                ", createdByUserId=" + createdByUserId +
                ", dateCreate=" + dateCreate +
                '}';
    }
}
