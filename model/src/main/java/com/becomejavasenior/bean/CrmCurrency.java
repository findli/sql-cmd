package com.becomejavasenior.bean;


import java.io.Serializable;
import java.util.List;

public class CrmCurrency implements Serializable{

    private int id;
    private String title;
    private String shortTitle;
    private List<CrmSettings> settingses;

    public CrmCurrency(){}

    public void setId(int id) {
        this.id = id;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public void setShortTitle(String shortTitle) {
        this.shortTitle = shortTitle;
    }

    public void setSettingses(List<CrmSettings> settingses) {
        this.settingses = settingses;
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

    public List<CrmSettings> getSettingses() {
        return settingses;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        CrmCurrency crmCurrency = (CrmCurrency) o;

        if (id != crmCurrency.id) return false;
        if (!title.equals(crmCurrency.title)) return false;
        return !shortTitle.equals(crmCurrency.shortTitle);
    }

    @Override
    public int hashCode() {
        int result = id;
        result = 31 * result + title.hashCode();
        result = 31 * result + shortTitle.hashCode();
        return result;
    }

    @Override
    public String toString() {
        return "Stage{" +
                "id=" + id +
                ", title='" + title + '\'' +
                ", shortTitle='" + shortTitle + '\'' +
                '}';
    }
}
