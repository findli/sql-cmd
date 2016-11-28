package JSS.w06_p;

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

@WebServlet(name = "LoginServlet", urlPatterns = {"/LoginServlet"}, loadOnStartup = 1)
public class LoginServlet extends HttpServlet {
    static int i = 1;
    private final String userID = "user1";
    private final String password = "pw1";

    public void doPost(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {

        System.out.println("LoginServlet");

        String user = request.getParameter("user");
        String password = request.getParameter("password");

        System.out.println(user);
        System.out.println(password);

        if (userID.equals(user) && this.password.equals(password)) {
            Cookie cookie = new Cookie("user_id", user);
            cookie.setMaxAge(2 * 60);
            response.addCookie(cookie);

//            request.getSession(true); true для создания сессии, если нет

            response.sendRedirect("/JSS-15-09/w06_p01/LoginSuccess.jsp");
        } else {
//            response.sendRedirect("/JSS-15-09/w06_p/Login.html");
//            response.setStatus(300);
//            response.setHeader("Location", "/JSS-15-09/w06_p/Login.html");

            ServletContext application = request.getServletContext();
            // только в контексте пути /JSS-15-09
            // только что доступно в папке web
            // RequestDispatcher позволяет направить запрос к произвольному ресурсу внутри контекста
            // application.getRequestDispatcher - чтобы получить соответствующий ресурсу объект
            RequestDispatcher dispatcher = application.getRequestDispatcher("/w06_p01/Login.html");
            PrintWriter writer = response.getWriter();
//            writer.println(""); will show html text without dispatch
            dispatcher.include(request, response);
            writer.println("Try again !!!! <br />");
        }
    }

    public void doGet(HttpServletRequest request,
                      HttpServletResponse response)
            throws ServletException, IOException {
        System.out.println("GET LoginServlet");
//        doPost(request, response);
//        response.setStatus(302);
//        response.setIntHeader("Refresh:", 2);
//        response.getWriter().println("Hit count = " + i++);
    }
}
