package om;


public class Entry {

    private int idEntry;
    private String text;
    private Activity activity;
    private Profile profile;

    public Entry(int idEntry, String text, Activity activity) {
        this.idEntry = idEntry;
        this.text = text;
        this.activity = activity;
    }

    public int getIdEntry() {
        return idEntry;
    }

    public void setIdEntry(int idEntry) {
        this.idEntry = idEntry;
    }

    public String getText() {
        return text;
    }

    public void setText(String text) {
        this.text = text;
    }

    public Activity getActivity() {
        return activity;
    }

    public void setActivity(Activity activity) {
        this.activity = activity;
    }
}
