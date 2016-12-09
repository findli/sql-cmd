package com.becomejavasenior.bean;


import java.io.Serializable;
import java.util.Date;
import java.util.List;

public class Note implements Serializable {

    private int id;
    private String noteText;
    private User createdUser;
    private Date dateCreate;
    private Deal deal;
    private Contact contact;
    private Company company;
    private boolean isDeleted;
    private List<File> files;

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

    public User getCreatedUser() {
        return createdUser;
    }

    public void setCreatedUser(User createdUser) {
        this.createdUser = createdUser;
    }

    public Date getDateCreate() {
        return dateCreate;
    }

    public void setDateCreate(Date dateCreate) {
        this.dateCreate = dateCreate;
    }

    public Deal getDeal() {
        return deal;
    }

    public void setDeal(Deal deal) {
        this.deal = deal;
    }

    public Contact getContact() {
        return contact;
    }

    public void setContact(Contact contact) {
        this.contact = contact;
    }

    public Company getCompany() {
        return company;
    }

    public void setCompany(Company company) {
        this.company = company;
    }

    public boolean isDeleted() {
        return isDeleted;
    }

    public void setDeleted(boolean deleted) {
        isDeleted = deleted;
    }

    public List<File> getFiles() {
        return files;
    }

    public void setFiles(List<File> files) {
        this.files = files;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Note note = (Note) o;

        if (id != note.id) return false;
        if (isDeleted != note.isDeleted) return false;
        if (noteText != null ? !noteText.equals(note.noteText) : note.noteText != null) return false;
        if (createdUser != null ? !createdUser.equals(note.createdUser) : note.createdUser != null) return false;
        if (dateCreate != null ? !dateCreate.equals(note.dateCreate) : note.dateCreate != null) return false;
        if (deal != null ? !deal.equals(note.deal) : note.deal != null) return false;
        if (contact != null ? !contact.equals(note.contact) : note.contact != null) return false;
        if (company != null ? !company.equals(note.company) : note.company != null) return false;
        return files != null ? files.equals(note.files) : note.files == null;
    }

    @Override
    public int hashCode() {
        int result = id;
        result = 31 * result + (noteText != null ? noteText.hashCode() : 0);
        result = 31 * result + (createdUser != null ? createdUser.hashCode() : 0);
        result = 31 * result + (dateCreate != null ? dateCreate.hashCode() : 0);
        result = 31 * result + (deal != null ? deal.hashCode() : 0);
        result = 31 * result + (contact != null ? contact.hashCode() : 0);
        result = 31 * result + (company != null ? company.hashCode() : 0);
        result = 31 * result + (isDeleted ? 1 : 0);
        result = 31 * result + (files != null ? files.hashCode() : 0);
        return result;
    }

    @Override
    public String toString() {
        return "Note{" +
                "id=" + id +
                ", noteText='" + noteText + '\'' +
                ", createdUser=" + createdUser +
                ", dateCreate=" + dateCreate +
                ", deal=" + deal +
                ", contact=" + contact +
                ", company=" + company +
                ", isDeleted=" + isDeleted +
                ", files=" + files +
                '}';
    }
}
