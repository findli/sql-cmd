package w7.om;

public class Meet {

    private long idMeet = -1;
    private String dateMeet = null;

    public Meet(long idMeet, String dateMeet) {
        this.idMeet = idMeet;
        this.dateMeet = dateMeet;
    }

    public String getDateMeet() {
        return dateMeet;
    }

    public long getIdMeet() {
        return idMeet;
    }

    public void setIdMeet(int idMeet) {
        this.idMeet = idMeet;
    }
}
