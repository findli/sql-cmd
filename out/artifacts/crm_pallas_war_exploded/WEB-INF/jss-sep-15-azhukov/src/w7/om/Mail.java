package w7.om;

public class Mail {

    private long idContact = -1;
    private long idMail = -1;
    private String email = null;

    public Mail(long idMail, String email) {
        this.idMail = idMail;
        this.email = email;
    }

    public long getIdContact() {
        return idContact;
    }

    public void setIdContact(long idContact) {
        this.idContact = idContact;
    }

    public String getEmail() {
        return email;
    }


    public long getIdMail() {
        return idMail;
    }

}
