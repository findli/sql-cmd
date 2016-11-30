package JSS.w05_p02;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet(name = "Redirect", urlPatterns = {"/a/*","/A/*"} )
public class Redirect extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doGet(request,response);
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        // contextPath + pathInfo.toLowerCase() + queryString()

        String contextPath = request.getContextPath();
        String pathInfo = request.getPathInfo();
        String queryString = request.getQueryString();

        String newURI = "";

        if (contextPath != null && contextPath != "/") {
            newURI += contextPath;
        }
        if (pathInfo != null && pathInfo != "") {
            newURI += pathInfo.toLowerCase();
        }
        if (queryString != null && queryString != "") {
            newURI += "?" + contextPath;
        }

        System.out.println(newURI);

        response.sendRedirect(newURI);

    }
}
