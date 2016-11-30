package servlet;

import javax.servlet.ServletException;
import javax.servlet.annotation.MultipartConfig;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.Part;
import java.io.IOException;
import java.io.InputStream;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

@WebServlet(name = "UploadServlet", urlPatterns = {"/UploadServlet"})
@MultipartConfig(location = "d:/temp", maxFileSize = 16 * 1024 * 1024, fileSizeThreshold = 0)
public class UploadServlet extends HttpServlet {

    private Connection conn;

    public UploadServlet() {
        conn = DBConnection.getConnection("az_socialnetwork");
    }

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        Part filePart = null;
        InputStream inputStream = null;         // input stream of the upload file
        filePart = request.getPart("manual"); //AZ: manual????

   /*     System.out.println(filePart.getName());
        System.out.println(filePart.getContentType());
        System.out.println(filePart.getSize());*/

        if (filePart == null) {
            // set the message in request scope
            request.setAttribute("message", "Select File!!!!");

            // forward request to the jsp page
            getServletContext().getRequestDispatcher("/photoGallery.jsp").forward(request, response);
            return;
        }

        // get part input stream
        inputStream = filePart.getInputStream();

        // Connection conn = null; // connection to the database
        String message = "";

        try {
            String sql = "INSERT INTO photos (photo_file_name, fk_activity_odjects, data) values (?, ?, ?)";
            PreparedStatement statement = conn.prepareStatement(sql);
            statement.setString(1, "photo1");
            statement.setInt(2, 2);
            if (inputStream != null) {
                statement.setBlob(3, inputStream);
            }
            int n = statement.executeUpdate();
            if (n > 0) {
                message = "Photo was added";
            } else {
                message = "Photo was not added";
            }


        } catch (SQLException ex) {
            message = "SQL ERROR:<br>" + ex.getMessage() + "<br>" + ex.getSQLState();
            ex.printStackTrace();
        } finally {
            if (conn != null) {
                try {
                    conn.close();
                } catch (SQLException ex) {
                    message = "ERROR:<br>" + ex.getMessage();
                    ex.printStackTrace();
                }
            }
            // sets the message in request scope
            request.setAttribute("message", message);

            // forward request to the form
            getServletContext().getRequestDispatcher("/photoGallery.jsp").forward(request, response);
        }
    }

}
