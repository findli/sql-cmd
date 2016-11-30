package dao;

import om.Contact;
import om.DBConnection;
import om.Position;
import om.User;

import java.sql.*;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;

public class ContactDAO implements DAO<Contact> {

    private LinkedHashMap<Integer, Contact> data = new LinkedHashMap<>();
    private Connection conn;
    private String filter;
    private String order;
    private ResultSet rs;
    private PreparedStatement stm;

    public ContactDAO() {
        conn = DBConnection.getConnection("crius");
    }

    @Override
    public void refresh() {
        data.clear();
        try {
            String sql = "SELECT * FROM contact where id =?;";
            if (filter!=null) {
                sql += " where " + filter;
            }
            if (order!=null) {
                sql += " order by " + order;
            }
            stm = conn.prepareStatement(sql);
            stm.setInt(1, Integer.parseInt(filter));
            rs = stm.executeQuery();
            while (rs.next()) {
                User user = new User(rs.getInt("id"));
                Position position = new Position(rs.getInt("id"));
                Contact contact = new Contact(rs.getInt("id"), rs.getString("name"),rs.getInt("type_of_phone"),rs.getString("skype"),
                        rs.getString("phone"), rs.getString("email"),rs.getTimestamp("data_create"),
                        user, position, user,rs.getBoolean("delete"));
                data.put(contact.getId(), contact);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    @Override
    public List<Contact> getAsList() {
        List list = new ArrayList<>(data.size());
        data.values().forEach(o -> list.add(o));
        return list;
    }

    @Override
    public void setFilter(String filter) {
        this.filter = filter;
    }

    @Override
    public void setOrdering(String order) {
        this.order = order;
    }

    @Override
    public boolean update(int id, String columnName, String item) {
        try {
            stm = conn.prepareStatement("UPDATE contact SET columnName =? where id =?");
            stm.setString(1, item);
            stm.setInt(2, id);
            stm.executeUpdate();
            return true;
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return false;
    }

    @Override
    public void add(Contact item) {
        try {
            stm = conn.prepareStatement("insert into contact (name, type_of_phone, skype, phone, email, data_create, responsible_user_id," +
                    " position_id, create_by_id, delete) values (?,?,?,?,?,?,?,?,?,?)");
            stm.setString(1, item.getName());
            stm.setInt(2, item.getType_of_phone());
            stm.setString(3, item.getSkype());
            stm.setString(4, item.getPhone());
            stm.setString(5, item.getEmail());
            stm.setTimestamp(6, item.getDataCreate());
            stm.setInt(7, item.getResponsibleUserId().getId());
            stm.setInt(8, item.getPositionId().getId());
            stm.setInt(9, item.getCreateById().getId());
            stm.setBoolean(10, item.getDelete());
            stm.execute();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    @Override
    public boolean deleteItem(int id) {
        try {
            stm = conn.prepareStatement("DELETE FROM contact WHERE id =?");
            stm.setInt(1, id);
            stm.executeUpdate();
            return true;
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return false;
    }

    @Override
    public Iterator<Contact> iterator() {
        return data.values().iterator();
    }
}
