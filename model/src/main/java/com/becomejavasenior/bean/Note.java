
package com.becomejavasenior.bean;


import java.io.Serializable;
import java.util.Date;
import java.util.List;

public class Note implements Serializable {

    private int id;
    private String noteText;
    private User createdUser;
    private Date dateCreate;
    private List<Deal> dealNote;
    private List<Contact> contactNote;
    private List<Company> companyNote;
    private boolean isDeleted;

    public Note() {
    }

    public boolean isDeleted() {
        return isDeleted;
    }

    public void setDeleted(boolean deleted) {
        isDeleted = deleted;
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

    public User getCreatedUser() {
        return createdUser;
    }

    public void setCreatedUser( User createdUser) {
        this.createdUser = createdUser;
    }

    public Date getDateCreate() {
        return dateCreate;
    }

    public void setDateCreate(Date dateCreate) {
        this.dateCreate = dateCreate;
    }

    public void setDealNote(List<Deal> dealNote) {
        this.dealNote = dealNote;
    }

    public void setContactNote(List<Contact> contactNote) {
        this.contactNote = contactNote;
    }

    public void setCompanyNote(List<Company> companyNote) {
        this.companyNote = companyNote;
    }

    public void setIsDeleted(boolean isDeleted) {
        this.isDeleted = isDeleted;
    }

    public List<Deal> getDealNote() {
        return dealNote;
    }

    public List<Contact> getContactNote() {
        return contactNote;
    }

    public List<Company> getCompanyNote() {
        return companyNote;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Note note = (Note) o;

        if (id != note.id) return false;
        if (noteText != null ? !noteText.equals(note.noteText) : note.noteText != null) return false;
        if (createdUser != null ? !createdUser.equals(note.createdUser) : note.createdUser != null)
            return false;
        return dateCreate != null ? dateCreate.equals(note.dateCreate) : note.dateCreate == null;

    }

    @Override
    public int hashCode() {
        int result = id;
        result = 31 * result + (noteText != null ? noteText.hashCode() : 0);
        result = 31 * result + (createdUser != null ? createdUser.hashCode() : 0);
        result = 31 * result + (dateCreate != null ? dateCreate.hashCode() : 0);
        return result;
    }

    @Override
    public String toString() {
        return "Note{" +
                "id=" + id +
                ", noteText='" + noteText + '\'' +
                ", createtByUserId=" + createdUser +
                ", dateCreate=" + dateCreate +
                '}';
    }
}
