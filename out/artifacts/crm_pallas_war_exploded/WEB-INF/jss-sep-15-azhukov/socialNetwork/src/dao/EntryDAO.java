package dao;


import om.Activity;
import om.Entry;
import om.Profile;

import java.io.Serializable;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class EntryDAO implements Serializable {

    private Connection conn = null;
    private PreparedStatement stm;
    private ResultSet rs;
    private List<Entry> listParentActitvity = new ArrayList<>();
    private List<Entry> listChildActitvity = new ArrayList<>();

    public EntryDAO() {
        conn = servlet.DBConnection.getConnection("az_socialnetwork");
    }

    public void getPosts(int idProfile) {   // todo : return List
        listParentActitvity.clear();
        try {
            stm = conn.prepareStatement("select * from entry\n" +
                    "inner join activity_objects on activity_objects.id_activity = entry.fk_activity\n" +
                    "where fk_profile = ? and isRoot =1");
            stm.setInt(1, idProfile);
            rs = stm.executeQuery();
            while (rs.next()) {
                Activity activity = new Activity(rs.getInt("id_activity"), rs.getDate("created"));
                Entry entry = new Entry(rs.getInt("id_entry"), rs.getString("text"), activity);
                listParentActitvity.add(entry);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }


    public void getComments(int idParentEntry) {
        listChildActitvity.clear();
        try {
            stm = conn.prepareStatement("select * from activity_hier\n" +
                    "inner join activity_objects on activity_objects.id_activity = activity_hier.fk_child\n" +
                    "inner join entry on entry.fk_activity = activity_objects.id_activity\n" +
                    "inner join profiles on profiles.id_profile = activity_objects.fk_profile\n" +
                    "where fk_parent = ?");
            stm.setInt(1, idParentEntry);
            rs = stm.executeQuery();
            while (rs.next()) {
                Profile profile  =new Profile(rs.getString("first_name"), rs.getString("last_name"));
                Activity activity = new Activity(rs.getInt("id_activity"), rs.getDate("created"), profile);
                Entry entry = new Entry(rs.getInt("id_entry"), rs.getString("text"), activity);
                listChildActitvity.add(entry);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public List<Entry> getListParent() {
        return listParentActitvity;
    }

    public List<Entry> getListChild(){
        return listChildActitvity;
    }

}
