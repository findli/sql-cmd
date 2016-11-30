package om;


public class Photo {

    private int idPhoto;
    private String namePhoto;
    private int fkActivity;
    private String url;
    private Byte[] data;
    private String mime;

    public Photo(int idPhoto, String namePhoto, int fkActivity, String url, Byte[] data, String mime) {
        this.idPhoto = idPhoto;
        this.namePhoto = namePhoto;
        this.fkActivity = fkActivity;
        this.url = url;
        this.data = data;
        this.mime = mime;
    }

    public int getIdPhoto() {
        return idPhoto;
    }

    public void setIdPhoto(int idPhoto) {
        this.idPhoto = idPhoto;
    }

    public String getNamePhoto() {
        return namePhoto;
    }

    public void setNamePhoto(String namePhoto) {
        this.namePhoto = namePhoto;
    }

    public int getFkActivity() {
        return fkActivity;
    }

    public void setFkActivity(int fkActivity) {
        this.fkActivity = fkActivity;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public Byte[] getData() {
        return data;
    }

    public void setData(Byte[] data) {
        this.data = data;
    }

    public String getMime() {
        return mime;
    }

    public void setMime(String mime) {
        this.mime = mime;
    }
}
