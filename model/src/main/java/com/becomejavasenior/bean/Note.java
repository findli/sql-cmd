package com.becomejavasenior.bean;


import java.io.Serializable;
import java.util.Date;
import java.util.List;

public class Note implements Serializable {

    private int id;
    private String noteText;
<<<<<<< HEAD
    private User createtByUserId;
    private Date dateCreate;
=======
    private User createdUser;
    private Date dateCreate;
    private List<File> files;
    private boolean isDeleted;
>>>>>>> d80b510610f3099333cb46c2d4958fca80808ef8

    public Note() {
    }

<<<<<<< HEAD
=======
    public boolean isDeleted() {
        return isDeleted;
    }

    public void setDeleted(boolean deleted) {
        isDeleted = deleted;
    }

>>>>>>> d80b510610f3099333cb46c2d4958fca80808ef8
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

<<<<<<< HEAD
    public User getCreatetByUserId() {
        return createtByUserId;
    }

    public void setCreatetByUserId(User createtByUserId) {
        this.createtByUserId = createtByUserId;
=======
    public User getCreatedUser() {
        return createdUser;
    }

    public void setCreatedUser(User createdUser) {
        this.createdUser = createdUser;
>>>>>>> d80b510610f3099333cb46c2d4958fca80808ef8
    }

    public Date getDateCreate() {
        return dateCreate;
    }

    public void setDateCreate(Date dateCreate) {
        this.dateCreate = dateCreate;
    }

<<<<<<< HEAD
=======
    public List<File> getFiles() {
        return files;
    }

    public void setFiles(List<File> files) {
        this.files = files;
    }
>>>>>>> d80b510610f3099333cb46c2d4958fca80808ef8

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Note note = (Note) o;

        if (id != note.id) return false;
        if (noteText != null ? !noteText.equals(note.noteText) : note.noteText != null) return false;
<<<<<<< HEAD
        if (createtByUserId != null ? !createtByUserId.equals(note.createtByUserId) : note.createtByUserId != null)
=======
        if (createdUser != null ? !createdUser.equals(note.createdUser) : note.createdUser != null)
>>>>>>> d80b510610f3099333cb46c2d4958fca80808ef8
            return false;
        return dateCreate != null ? dateCreate.equals(note.dateCreate) : note.dateCreate == null;

    }

    @Override
    public int hashCode() {
        int result = id;
        result = 31 * result + (noteText != null ? noteText.hashCode() : 0);
<<<<<<< HEAD
        result = 31 * result + (createtByUserId != null ? createtByUserId.hashCode() : 0);
=======
        result = 31 * result + (createdUser != null ? createdUser.hashCode() : 0);
>>>>>>> d80b510610f3099333cb46c2d4958fca80808ef8
        result = 31 * result + (dateCreate != null ? dateCreate.hashCode() : 0);
        return result;
    }

    @Override
    public String toString() {
        return "Note{" +
                "id=" + id +
                ", noteText='" + noteText + '\'' +
<<<<<<< HEAD
                ", createtByUserId=" + createtByUserId +
=======
                ", createtByUserId=" + createdUser +
>>>>>>> d80b510610f3099333cb46c2d4958fca80808ef8
                ", dateCreate=" + dateCreate +
                '}';
    }
}
