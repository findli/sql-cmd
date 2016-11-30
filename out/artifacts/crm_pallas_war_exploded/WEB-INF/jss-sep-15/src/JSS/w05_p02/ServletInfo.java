package JSS.w05_p02;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Enumeration;

@WebServlet(name = "ServletInfo",urlPatterns = "/info/*")
public class ServletInfo extends HttpServlet {

    long hitCounter;
    long usersCounter;


    protected void doPost(HttpServletRequest request, HttpServletResponse resp) throws ServletException, IOException {
        doGet(request,resp);
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        request.setCharacterEncoding("UTF-8");
        response.setContentType("text/html;charset=UTF-8");


        PrintWriter out = response.getWriter();


        // URL parsing

        out.println("<html> <body>");

        out.println("<h3>Url parsing </h3>");

        out.println("getRequestURL() = " + request.getRequestURL() + "<br>");
        out.println("getRequestURI() = " + request.getRequestURI() + "<br>");
        out.println("getContextPath() = " + request.getContextPath() + "<br>");
        out.println("getServletPath() = " + request.getServletPath() + "<br>");
        out.println("getPathInfo() = " + request.getPathInfo() + "<br>");
        out.println("getQueryString() = " + request.getQueryString() + "<br>");



        out.println("<p> Hit Counter : " + (++hitCounter) + "<br>");

        if (request.getSession(true).isNew()) {
            usersCounter++;
        }
        out.println("Users Counter : " + usersCounter + "<br>");


        out.println("<h3>Headers </h3>");


        out.println("<table width = '90%' align='center' border = '1' bordercolor='#AA0000' cellspacing='0'> " +
                "<tr bordercolor='#00AA00'> " +
                    "<th bordercolor='#000000' bgcolor = \"#AAAAAA\"> <font face='tahoma' color='gray'> Hedar Name </font> </th> " +
                    "<th bordercolor='#000000' bgcolor = \"#AAAAAA\"> <font face='tahoma' color='gray'> Values </font> </th> " +
                "</tr>");
        Enumeration<String> headerNames = request.getHeaderNames();
        while(headerNames.hasMoreElements()) {
            String name = headerNames.nextElement();
            out.println( "<tr> <td>" + name + "</td> <td> ");
            for ( Enumeration<String> values =  request.getHeaders(name); values.hasMoreElements(); ) {
                out.println( values.nextElement() + ", \t ");
            }
            out.print("</td></tr>");
        }
        out.println("</table>");

        out.println("</body> </html> ");




    }


    @Override
    public void init() throws ServletException {
        super.init();
        hitCounter = 0;
        usersCounter = 0;
    }
}
