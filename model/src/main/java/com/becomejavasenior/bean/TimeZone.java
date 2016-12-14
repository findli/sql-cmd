package com.becomejavasenior.bean;


import java.io.Serializable;
import java.util.List;

public class TimeZone implements Serializable{

    private int id;
    private String title;
    private int shiftInHours;
    private List<CrmSettings> settingses;

    public TimeZone(){}

    public void setId(int id) {
        this.id = id;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public void setShiftInHours(int shiftInHourse) {
        this.shiftInHours = shiftInHourse;
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

    public int getShiftInHours() {
        return shiftInHours;
    }

    public List<CrmSettings> getSettingses() {
        return settingses;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        TimeZone timeZone = (TimeZone) o;

        if (id != timeZone.id) return false;
        if (!title.equals(timeZone.title)) return false;
        return  shiftInHours != timeZone.shiftInHours;
    }

    @Override
    public int hashCode() {
        int result = id;
        result = 31 * result + title.hashCode();
        result = 31 * result + shiftInHours;
        return result;
    }

    @Override
    public String toString() {
        return "Stage{" +
                "id=" + id +
                ", title='" + title + '\'' +
                ", color='" + shiftInHours + '\'' +
                '}';
    }
}
