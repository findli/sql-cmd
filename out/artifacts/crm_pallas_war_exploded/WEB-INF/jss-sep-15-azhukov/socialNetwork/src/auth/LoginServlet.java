package auth;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.*;
import java.io.IOException;
import java.io.PrintWriter;

@WebServlet("/auth/LoginServlet")
public class LoginServlet extends HttpServlet {
    private final String userID = "user1";
    private final String password = "pw1";
    static int i = 1;

    protected void doPost(HttpServletRequest request,
                          HttpServletResponse response) throws ServletException, IOException {

        // get request parameters for userID and password
        String user = request.getParameter("user");
        String pwd = request.getParameter("pwd");

        if( authenticate(user, pwd) ){

            HttpSession session = request.getSession(true);
            session.setAttribute("login",user);
            response.sendRedirect("/social/auth/LoginSuccess.jsp");
        } else {
            ServletContext application = request.getServletContext();
            RequestDispatcher dispatcher = application.getRequestDispatcher("/auth/Login.html");
            PrintWriter out = response.getWriter();
            dispatcher.include(request,response);
            out.println("<font color='red'> Try again !!!!! </font> <br>");

        }

    }

    private boolean authenticate(String user, String pwd) {

        // todo : password hashing + salting
        return userID.equals(user) && password.equals(pwd);
    }

}