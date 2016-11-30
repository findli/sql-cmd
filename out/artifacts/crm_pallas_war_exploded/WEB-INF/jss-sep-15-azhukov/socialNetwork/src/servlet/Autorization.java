package servlet;


public class Autorization {

    int idProfile;
    String login;
    String password;        // todo : Protect passwords with hashing (MessageDigest)

    public Autorization(int idProfile, String login, String password) {
        this.idProfile = idProfile;
        this.login = login;
        this.password = password;
    }

    public int getIdProfile() {
        return idProfile;
    }

    public void setIdProfile(int idProfile) {
        this.idProfile = idProfile;
    }

    public String getLogin() {
        return login;
    }

    public void setLogin(String login) {
        this.login = login;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }
}
