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

    public void setDeal(Deal dealNote) {
        this.deal = dealNote;
    }

    public void setContact(Contact contactNote) {
        this.contact = contactNote;
    }

    public void setCompany(Company companyNote) {
        this.company = companyNote;
    }

    public void setIsDeleted(boolean isDeleted) {
        this.isDeleted = isDeleted;
    }

    public Contact getContact() {
        return contact;
    }

    public Company getCompany() {
        return company;
    }

    public void setFiles(List<File> files) {
        this.files = files;
    }

    public List<File> getFiles() {
        return files;
    }

    public Deal getDeal() {
        return deal;
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
        if (deal != null ? !deal.equals(note.deal) : note.deal != null) return false;
        if (contact != null ? !contact.equals(note.contact) : note.contact != null) return false;
        if (company != null ? !company.equals(note.company) : note.company != null) return false;
        if (noteText != null ? !noteText.equals(note.noteText) : note.noteText != null) return false;
        if (isDeleted != note.isDeleted) return false;
        return dateCreate != null ? dateCreate.equals(note.dateCreate) : note.dateCreate == null;

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
        return result;
    }

    @Override
    public String toString() {
        return "Note{" +
                "id=" + id +
                ", noteText='" + noteText + '\'' +
                ", createtByUserId=" + createdUser +
                ", dateCreate=" + dateCreate +
                ", dateCreate=" + deal.getTitle() +
                ", dateCreate=" + contact.getfName() + '\'' + contact.getlName() +
                ", dateCreate=" + company.getTitle() +
                ", dateCreate=" + isDeleted +
                '}';
    }
}
