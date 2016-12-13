package com.becomejavasenior.bean;


import java.io.Serializable;

public class Language implements Serializable {
    private int id;
    private String title;
    private String shortTitle;

    public Language(){ }

    public void setId(int id) {
        this.id = id;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public void setShortTitle(String shortTitle) {
        this.shortTitle = shortTitle;
    }

    public int getId() {
        return id;
    }

    public String getTitle() {
        return title;
    }

    public String getShortTitle() {
        return shortTitle;
    }

    @Override
    public boolean equals(Object o){
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Language language = (Language)o;
        if(id != language.id) return false;
        if(title != null ? !title.equals(language.title) : language.title != null) return false;
        return shortTitle != null ? shortTitle.equals(language.shortTitle) : language.shortTitle == null;
    }

    @Override
    public int hashCode(){
        int result = id;
        result = 31 * result + (title != null ? title.hashCode() : 0);
        result = 31 * result + (shortTitle != null ? shortTitle.hashCode() : 0);
        return  result;
    }

    @Override
    public String toString(){
        return "Contact{" +
                "id=" + id +
                ", title='" + title + '\'' +
                ", shortTitle='" + shortTitle + '\'' +
                '}';
    }
}