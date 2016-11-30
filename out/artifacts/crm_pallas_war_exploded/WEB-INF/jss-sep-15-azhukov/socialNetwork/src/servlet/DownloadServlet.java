package servlet;


import javax.servlet.ServletException;
import javax.servlet.ServletOutputStream;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.InputStream;
import java.sql.*;


public class DownloadServlet extends HttpServlet {

    public synchronized void doGet(HttpServletRequest request, HttpServletResponse response)
            throws IOException, ServletException {

            Blob image = null;                      // todo -> synchronized
            Connection conn = null;
            PreparedStatement stm = null;
            ResultSet rs = null;
            ServletOutputStream out = response.getOutputStream();
            try {
                //  Class.forName("com.mysql.jdbc.Driver");
                conn = servlet.DBConnection.getConnection("az_socialnetwork");
                stm = conn.prepareStatement("select data from photos\n" +
                        "inner join activity_objects on activity_objects.id_activity = photos.fk_activity_odjects\n" +
                        "where fk_profile= ?");
                stm.setInt(1, 42);
                rs = stm.executeQuery();
                if (rs.next()) {
                    image = rs.getBlob(1);
                } else {
                    response.setContentType("text/html");

                    out.println("<font color='red'>image not found for given id</font>");

                    return;
                }
                response.setContentType("image/gif");
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
            }


    }
}
