package com.becomejavasenior.bean;

import java.io.Serializable;
import java.util.Objects;

public class PeriodInDaysType implements Serializable {

    private int id;
    private String title;
    private int daysInPeriod;

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

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof PeriodInDaysType)) return false;
        PeriodInDaysType that = (PeriodInDaysType) o;
        return id == that.id &&
                daysInPeriod == that.daysInPeriod &&
                Objects.equals(title, that.title);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, title, daysInPeriod);
    }

    @Override
    public String toString() {
        return "PeriodInDaysType{" +
                "id=" + id +
                ", title='" + title + '\'' +
                ", daysInPeriod=" + daysInPeriod +
                '}';
    }
}
