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

// value bu default is urlPattern ???
@WebServlet(name = "uploadServlet", urlPatterns = {"/uploadServlet"})
// fileSizeThreshold - in memory not in /tmp/file
@MultipartConfig(location = "/tmp/upload-test", maxFileSize = 16 * 1024 * 1024, fileSizeThreshold = 100 * 1024)// byte
public class UploadServlet extends HttpServlet {
    private final String JDBC_DRIVER = "com.mysql.jdbc.Driver";
    private final String DB_URL = "jdbc:mysql://localhost/java_jss_salesdept?useUnicode=true&characterEncoding=utf8";
    // Database credentials
    private final String DB_USER = "root";
    private final String DB_PASS = "123";

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String productDescription = null;
        String productPrice = null;
        Part filePart = null;
        InputStream inputStream = null;

        // get values of text fields
        productDescription = request.getParameter("description") == null ? "" : request.getParameter("description");
        productPrice = request.getParameter("price") == null ? "" : request.getParameter("price");
        // get part
        filePart = request.getPart("manual");

        System.out.println(filePart.getName());
        System.out.println(filePart.getContentType());
        System.out.println(filePart.getSize());

        if (filePart == null) {
            // set the message in request scope
            request.setAttribute("message", "Select File!!!");

            // forward request to the jsp page
            getServletContext().getRequestDispatcher("/JSS/w06_p03/AddProductWithParts.jsp").forward(request, response);
            return;
        }

        // get part input stream
        inputStream = filePart.getInputStream();

        Connection connection = null; // connection to the database
        String message = "";

        try {
            // connect to database
            DriverManager.registerDriver(new com.mysql.jdbc.Driver());
            connection = DriverManager.getConnection(DB_URL, DB_USER, DB_PASS);

            // construct SQL statement
            String sql = "INSERT INTO Products (description, price, manual) VALUES (?,?,?)";
            PreparedStatement statement = connection.prepareStatement(sql);
            statement.setString(1, productDescription);
            statement.setString(2, productPrice);
            if (inputStream != null) {
                statement.setBlob(3, inputStream);
            }
            int n = statement.executeUpdate(); // get affected rows or statement.getUpdateCount() for INSERT, UPADTE, DELETE
            if (n > 0) {
                message = "Product was added";
            } else {
                message = "Product was not added";
            }
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            if (connection != null) {
                try {
                    connection.close();
                } catch (SQLException e) {
                    message = "ERROR:<br />" + e.getMessage();
                    e.printStackTrace();
                }
            }
        }

        // sets the message in request scope
        request.setAttribute("message", message);

        // forward request to the form
        getServletContext().getRequestDispatcher("/JSS/w06_p03/AddProductWithParts.jsp").forward(request, response);

        /*
        read blob from db
        Blob blob = resultSet.getBlob("columnName");
        blob.getBytes(1, (int) blob.length());
        InputStream input = blob.getBinaryStream();
         */
    }
}
