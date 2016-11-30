package dao;

import om.Profile;
import servlet.DBConnection;

import java.io.Serializable;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.*;

public class ProfilesDAO implements Serializable {

    private Connection conn = null;
    private ResultSet rs;
    private PreparedStatement stm;
   // private int filter;
//    private LinkedHashMap<Integer, Profiles> data = new LinkedHashMap();
    private List<Profile> list = new ArrayList<>();  // CK : do not store data copy inside dao

    public ProfilesDAO() {
        conn = servlet.DBConnection.getConnection("az_socialnetwork");
    }

    // todo:  CK :  Make it   Profile getInfo(int idProfile)

    public void refresh(int idProfile) {
        try {
            //filter = idProfile;  
            stm = conn.prepareStatement("select * from profiles where id_profile = ?");
            stm.setInt(1,idProfile);
            rs = stm.executeQuery();
            while (rs.next()) {
                Profile profiles = new Profile(rs.getInt("id_profile"), rs.getString("first_name"), rs.getString("last_name"),
                        rs.getDate("date_birth"), rs.getString("sex"), rs.getString("country"), rs.getString("city"));
           //     data.put(profiles.getIdProfile(), profiles);
                list.add(profiles);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public List<Profile> getAsListColl() {
      //  return (Collections) Collections.unmodifiableList((List) data.values());
        return list;
    }

  /* public List<Profiles> getAsList() {
       List list = new ArrayList(data.size());
       data.values().forEach(o -> list.add(o));
       return list;
   }*/

   /* public void setFilter(String filter) {
        this.filter = filter;
    }*/



    /*public String getName(int idProfile) {
        return null;
    }*/
}
