package JSS;

import JSS.w03_pract.model.DatabaseConnection;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

@WebServlet(name = "dbAction", urlPatterns = {"/dbAction"})
public class DBActionServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doGet(request, response);
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String action = request.getParameter("action");
        String message = "";
        if (action != null) {
            switch (action) {
                case "delete":
                    Connection connection = DatabaseConnection.getConnection("salesdept");
                    String sql = "DELETE FROM Products WHERE id = " + request.getParameter("id");
//                    try {
//                        Statement statement = connection.createStatement();
//                        ResultSet resultSet = stm.executeQuery(sql);
//                    } catch (SQLException e) {
                    // try with resources: это чтобы после завершения блока try ресурсы автоматически освобождались: statement.close(), resultSet.close()
                    try (
                            Statement statement = connection.createStatement();
                    ) {
                        statement.executeUpdate(sql);
                        if (statement.getUpdateCount() > 0) {
                            message = "Product deleted.";
                        }
                    } catch (SQLException e) {
                        e.printStackTrace();
                    }
                    break;
                case "update":
                    break;
                case "insert":
                    break;
            }
        }
        // как бы добавить параметр - request.setParameter(name, val);
        request.setAttribute("actionStatus", message);
        // forward если есть вывод через response
        getServletContext().getRequestDispatcher("/JSS/w06_p02/DBView.jsp").include(request, response);
    }
}
