package om;

import java.sql.Date;

public class Activity {

    private int idActivity;
    private Date date;
    private Profile profile;

    public Activity(int idActivity, Date date) {
        this.idActivity = idActivity;
        this.date = date;
    }

    public Activity(int idActivity, Date date, Profile profile) {
        this.idActivity = idActivity;
        this.date = date;
        this.profile = profile;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    public int getIdActivity() {
        return idActivity;
    }

    public void setIdActivity(int idActivity) {
        this.idActivity = idActivity;
    }

    public Profile getProfile() {
        return profile;
    }

    public void setProfile(Profile profile) {
        this.profile = profile;
    }
}
