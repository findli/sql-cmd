package JSS.w06_p01;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

@WebServlet("/LoginServlet")
public class LoginServlet extends HttpServlet {
    private final String userID = "user1";
    private final String password = "pw1";
    static int i = 1;

    protected void doPost(HttpServletRequest request,
                          HttpServletResponse response) throws ServletException, IOException {

        // get request parameters for userID and password
        String user = request.getParameter("user");
        String pwd = request.getParameter("pwd");

        if(userID.equals(user) && password.equals(pwd)){
            Cookie cookie = new Cookie("user_id",user);
            cookie.setMaxAge(2*60);
            response.addCookie( cookie );

            response.sendRedirect("/JSS-15-09/JSS/w06_p01/LoginSuccess.jsp");

            //request.getSession(true);
        }else{
//            response.sendRedirect("/JSS-15-09/JSS/w06_p01/Login.html");
//            response.setStatus(300);
//            response.setHeader("Location","/JSS-15-09/LogoutServlet");

//            response.setIntHeader("Refresh",2);
//            response.getWriter().println("Hit count = " + i);

            ServletContext application = request.getServletContext();
            RequestDispatcher dispatcher = application.getRequestDispatcher("/JSS/w06_p01/Login.html");
            PrintWriter out = response.getWriter();
            dispatcher.include(request,response);
            out.println("<font color='red'> Try again !!!!! </font> <br>");

        }

    }

}