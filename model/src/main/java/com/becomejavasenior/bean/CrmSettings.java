package com.becomejavasenior.bean;


import java.io.Serializable;
import com.becomejavasenior.bean.Language;

public class CrmSettings implements Serializable{

    private int id;
    private Language language;
    private TimeZone timeZone;
    private CrmCurrency crmCurrency;

    public CrmSettings(){}

    public void setId(int id) {
        this.id = id;
    }

    public void setLanguage(Language language) {
        this.language = language;
    }

    public void setTimeZone(TimeZone timeZone) {
        this.timeZone = timeZone;
    }

    public void setCrmCurrency(CrmCurrency crmCurrency) {
        this.crmCurrency = crmCurrency;
    }

    public int getId() {
        return id;
    }

    public Language getLanguage() {
        return language;
    }

    public TimeZone getTimeZone() {
        return timeZone;
    }

    public CrmCurrency getCrmCurrency() {
        return crmCurrency;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        CrmSettings crmSettings = (CrmSettings) o;

        if (language != null ? !language.equals(crmSettings.language) : crmSettings.language != null) return false;
        if (timeZone != null ? !timeZone.equals(crmSettings.timeZone) : crmSettings.timeZone != null) return false;
        if (crmCurrency != null ? !crmCurrency.equals(crmSettings.crmCurrency) : crmSettings.crmCurrency != null) return false;
        return id != crmSettings.id;
    }

    @Override
    public int hashCode(){
        int result = id;
        result = 31 * result + (language != null ? language.hashCode() : 0);
        result = 31 * result + (timeZone != null ? timeZone.hashCode() : 0);
        result = 31 * result + (crmCurrency != null ? crmCurrency.hashCode() : 0);
        return result;
    }

    @Override
    public String toString(){
        return "Stage{" +
                "id=" + id +
                ", language='" + language + '\'' +
                ", timeZone='" + timeZone + '\'' +
                ", crmCurrency=" + crmCurrency +
                '}';
    }
}
