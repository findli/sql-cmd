package com.becomejavasenior.bean;

import java.io.Serializable;

public class PeriodInDaysType implements Serializable {
    protected int id;
    protected String title;
    protected int daysInPeriod;

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
