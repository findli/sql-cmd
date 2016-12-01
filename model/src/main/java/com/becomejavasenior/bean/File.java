package com.becomejavasenior.bean;


import java.util.Date;

public class File {

    private int id;
    private String fileName;
    private String filePath;
    private int fileSize;
    private Date dateCreate;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getFileName() {
        return fileName;
    }

    public void setFileName(String fileName) {
        this.fileName = fileName;
    }

    public String getFilePath() {
        return filePath;
    }

    public void setFilePath(String filePath) {
        this.filePath = filePath;
    }

    public int getFileSize() {
        return fileSize;
    }

    public void setFileSize(byte fileSize) {
        this.fileSize = fileSize;
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

        File file = (File) o;

        if (id != file.id) return false;
        if (fileSize != file.fileSize) return false;
        if (fileName != null ? !fileName.equals(file.fileName) : file.fileName != null) return false;
        if (filePath != null ? !filePath.equals(file.filePath) : file.filePath != null) return false;
        return dateCreate != null ? dateCreate.equals(file.dateCreate) : file.dateCreate == null;

    }

    @Override
    public int hashCode() {
        int result = id;
        result = 31 * result + (fileName != null ? fileName.hashCode() : 0);
        result = 31 * result + (filePath != null ? filePath.hashCode() : 0);
        result = 31 * result + (int) fileSize;
        result = 31 * result + (dateCreate != null ? dateCreate.hashCode() : 0);
        return result;
    }


    @Override
    public String toString() {
        return "File{" +
                "id=" + id +
                ", fileName='" + fileName + '\'' +
                ", filePath='" + filePath + '\'' +
                ", fileSize=" + fileSize +
                ", dateCreate=" + dateCreate +
                '}';
    }
}