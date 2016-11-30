package dao;

import servlet.DBConnection;

import java.io.Serializable;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;


// todo : password encryption
public class AutorizationDAO implements Serializable {

    private Connection conn = null;

    public AutorizationDAO() {
        conn = servlet.DBConnection.getConnection("az_socialnetwork");
    }

    public int checkLoginPassword(String login, String password) {
        ResultSet rs;
        int idProfile = -1;
        PreparedStatement stm;
        try {
            stm = conn.prepareStatement("SELECT fk_profile FROM authorization where login = ? and password = ?");
            stm.setString(1, login);
            stm.setString(2, password);
            rs = stm.executeQuery();
            while (rs.next()) {
                idProfile = rs.getInt("fk_profile");
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return idProfile;
    }
}
