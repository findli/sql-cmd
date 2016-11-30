package JSS.w06_p03;

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
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

@WebServlet(name = "uploadServlet", urlPatterns = {"/uploadServlet"})
@MultipartConfig(location="d:/temp", maxFileSize = 16*1024*1024, fileSizeThreshold = 0)
public class UploadServlet extends HttpServlet {

    private final String JDBC_DRIVER = "com.mysql.jdbc.Driver";
    private final String DB_URL = "jdbc:mysql://localhost/salesdept?useUnicode=true&characterEncoding=utf8";
    // Database credentials
    private final String DB_USER = "root";
    private final String DB_PASS = "1234";

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        String productDescr = null;
        String productPrice = null;
        Part filePart = null;
        InputStream inputStream = null;         // input stream of the upload file

        // get values of text fields
        productDescr = request.getParameter("description")==null ? "" : request.getParameter("description");
        productPrice = request.getParameter("price")==null ? "" : request.getParameter("price");
        // get part
        filePart = request.getPart("manual");

        System.out.println(filePart.getName());
        System.out.println(filePart.getContentType());
        System.out.println(filePart.getSize());

        if(filePart == null) {
            // set the message in request scope
            request.setAttribute("message", "Select File!!!!");

            // forward request to the jsp page
            getServletContext().getRequestDispatcher("/JSS/w06_p03/AddProductWithParts.jsp").forward(request, response);
            return;
        }

        // get part input stream
        inputStream = filePart.getInputStream();

        Connection conn = null; // connection to the database
        String message = "";

        try {
            // connect to the database
            DriverManager.registerDriver(new com.mysql.jdbc.Driver());
            conn = DriverManager.getConnection(DB_URL, DB_USER, DB_PASS);

            // construct SQL statement
            String sql = "INSERT INTO products (description, price, manual) values (?, ?, ?)";
            PreparedStatement statement = conn.prepareStatement(sql);
            statement.setString(1,productDescr);
            statement.setString(2,productPrice);
            if (inputStream!=null) {
                statement.setBlob(3, inputStream);
            }
            int n = statement.executeUpdate();
            if (n>0) {
                message = "Product was added";
            } else {
                message = "Product was not added";
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
            getServletContext().getRequestDispatcher("/JSS/w06_p03/AddProductWithParts.jsp").forward(request, response);
        }



    }

}
