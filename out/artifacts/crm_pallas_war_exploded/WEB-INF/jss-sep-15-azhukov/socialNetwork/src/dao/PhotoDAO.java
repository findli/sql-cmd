package dao;

import javax.servlet.ServletOutputStream;
import java.awt.*;
import java.io.InputStream;
import java.io.Serializable;
import java.sql.*;


public class PhotoDAO implements Serializable {

   /* private ResultSet rs;
    private PreparedStatement stm;
    private Connection conn;

    public PhotoDAO() {
        conn = om.DBConnection.getConnection("az_socialnetwork");
    }

    public Blob getPhotoCollection(int idProfile) {
        Blob image= null;
        ServletOutputStream out = response.getOutputStream();
        try {
            stm = conn.prepareStatement("select data from photos\n" +
                    "inner join activity_objects on activity_objects.id_activity = photos.fk_activity_odjects\n" +
                    "where fk_profile= ?");
            stm.setInt(1, idProfile);
            rs = stm.executeQuery();
            while (rs.next()){
                image = rs.getBlob("data");
            }
            InputStream in = image.getBinaryStream();
            int length = (int) image.length();
            int bufferSize = 1024;
            byte[] buffer = new byte[bufferSize];
            while ((length = in.read(buffer)) != -1) {
                out.write(buffer, 0, length);
            }
            in.close();
            out.flush();
        } catch (Exception e) {
            response.setContentType("text/html");
            out.println("<html><head><title>Unable To Display image</title></head>");
            out.println("<body><h4><font color='red'>Image Display Error=" + e.getMessage() +
                    "</font></h4></body></html>");
            return;
        } finally {
            try {
                rs.close();
                stmt.close();
                con.close();

        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;

    }*/
}
