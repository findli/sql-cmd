package w7.dao;

import w7.om.Meet;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;

// ContactAttributeDAO - unify with MeetDAO
public class MeetDAO implements DAO<Meet> {

   // enum AttributeType {MEET, EMAIL}


    private LinkedHashMap<Long, Meet> data = new LinkedHashMap(100);
    private Connection conn;
    private String filter;
    private ResultSet rs;
    private PreparedStatement stm;

    public MeetDAO() {
        conn = w2.DBConnection.getConnection("az_organizer");
    }

    @Override
    public void refresh() {
        data.clear();
        ResultSet rs;
        try {
            stm = conn.prepareStatement("select meet.idMeet, meetDate from contact" +
                    " inner join contact_has_meet on  contact_has_meet.idContact=contact.idContact" +
                    " inner join meet on  contact_has_meet.idMeet=meet.idMeet" +
                    " where contact.idContact = ?");
            stm.setInt(1, Integer.parseInt(filter));
            rs = stm.executeQuery();
            while (rs.next()) {
                Meet meet = new Meet(rs.getLong("idMeet"), rs.getString("meetDate"));
                data.put(meet.getIdMeet(), meet);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    @Override
    public List<Meet> getAsList() {
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
            PreparedStatement stm = conn.prepareStatement("SELECT meetDate from meet where idMeet=?");
            stm.setInt(1, id);
            rs = stm.executeQuery();
            while (rs.next()) {
                email = rs.getString("meetDate");
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return email;
    }

    @Override
    public String update(int id, String item) {
        try {
            stm = conn.prepareStatement("UPDATE meet SET meetDate=? WHERE idMeet=?");
            stm.setString(1, item);
            stm.setInt(2, id);
            stm.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return getByID(id);
    }

    @Override
    public Iterator<Meet> iterator() {
        return data.values().iterator();
    }

    public <T> void typeClass(Class<T> type){

    }
}
