package w7.dao;

import w7.om.Mail;

import java.sql.*;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;

public class EmailDAO implements DAO<Mail> {

    private LinkedHashMap<Long, Mail> data = new LinkedHashMap(100);
    //   private List list = new ArrayList<>(100);
    private Connection conn;
    private String filter;
    private ResultSet rs;
    private PreparedStatement stm;

    public EmailDAO() {
        conn = w2.DBConnection.getConnection("az_organizer");
    }

    @Override
    public void refresh() {
        data.clear();
        try {
            stm = conn.prepareStatement("SELECT * FROM e_mail WHERE idContact =?");
            stm.setString(1, filter);
            rs = stm.executeQuery();
            while (rs.next()) {
                Mail mail = new Mail(rs.getLong("idMail"), rs.getString("e_mail"));
                data.put(mail.getIdMail(), mail);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }


    @Override
    public List<Mail> getAsList() {
        List list = new ArrayList(data.size());
        data.values().forEach(o -> list.add(o));
        return list;
    }

    @Override
    public void setFilter(String filter) {
        this.filter = filter;
    }

    @Override
    public void remove(int id) {

    }

    @Override
    public String getByID(int id) {
        String email = null;
        try {
            stm = conn.prepareStatement("SELECT e_mail from az_organizer.e_mail where idMail =?");
            stm.setInt(1, id);
            rs = stm.executeQuery();
            while (rs.next()) {
                email = rs.getString("e_mail");
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return email;
    }

    @Override
    public String update(int id, String item) {
        try {
            stm = conn.prepareStatement("UPDATE e_mail SET e_mail =? where idMail =?");
            stm.setString(1, item);
            stm.setInt(2, id);
            stm.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return getByID(id);
    }

    @Override
    public <T> void typeClass(Class<T> type) {

    }

    @Override
    public Iterator iterator() {
        return data.values().iterator();
    }

    public LinkedHashMap<Long, Mail> getData() {
        return data;
    }

}
