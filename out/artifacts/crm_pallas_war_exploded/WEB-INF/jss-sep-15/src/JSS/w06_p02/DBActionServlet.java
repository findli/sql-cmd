package JSS.w06_p02;

import JSS.w03_pract.model.DatabaseConnection;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.sql.Connection;
import java.sql.SQLException;
import java.sql.Statement;

/**
 * @author Cyril Kadomsky
 */
@WebServlet(name = "dbAction", urlPatterns = {"/dbAction"})
public class DBActionServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doGet(request,response);
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String action = request.getParameter("action");
        String message = "";
        if (action!=null) {
            switch (action) {
                case "delete" :
                    Connection conn = DatabaseConnection.getConnection("salesdept");
                    String sql = "DELETE FROM Products WHERE id='" + request.getParameter("id") + "'";  // Todo : Use PreparedStatement!!!!
                    System.out.println(sql);
                    try (
                        Statement stm = conn.createStatement();
                    ) {
                        stm.executeUpdate(sql);
                        if (stm.getUpdateCount() > 0) {
                            message = "Product deleted!";
                        }

                    } catch (SQLException e) {
                        e.printStackTrace();
                    }
                    break;
                case "update" : break;
                case "insert" : break;

            }
        }
        request.setAttribute("actionStatus",message);
        getServletContext().getRequestDispatcher("/JSS/w06_p02/DBView.jsp").forward(request,response);


    }
}
