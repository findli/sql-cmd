package com.becomejavasenior.bean;

import java.io.Serializable;

public class PeriodInDaysType implements Serializable {
    private int id;
    private String title;
    private int daysInPeriod;

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        PeriodInDaysType that = (PeriodInDaysType) o;

        if (id != that.id) return false;
        if (daysInPeriod != that.daysInPeriod) return false;
        return title != null ? title.equals(that.title) : that.title == null;

    }

    @Override
    public int hashCode() {
        int result = id;
        result = 31 * result + (title != null ? title.hashCode() : 0);
        result = 31 * result + daysInPeriod;
        return result;
    }

    @Override
    public String toString() {
        return "PeriodInDaysType{" +
                "id=" + id +
                ", title='" + title + '\'' +
                ", daysInPeriod=" + daysInPeriod +
                '}';
    }

    public PeriodInDaysType() {
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public int getDaysInPeriod() {
        return daysInPeriod;
    }

    public void setDaysInPeriod(int daysInPeriod) {
        this.daysInPeriod = daysInPeriod;
    }
}
