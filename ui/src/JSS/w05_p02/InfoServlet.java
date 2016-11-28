package JSS.w05_p02;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Enumeration;

// не надо писать в web.xml
//@WebServlet(name = "Image1Servlet", urlPatterns = "/test/image1")
@WebServlet(name = "InfoServlet", urlPatterns = {"/test/servlet-info"}, loadOnStartup = 0, initParams = {})
public class InfoServlet extends HttpServlet {
    long hitCounter;
    long usersCounter;

    @Override
    public void init() throws ServletException {
        super.init();
        usersCounter = 0;
        hitCounter = 0;
    }

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doGet(request, response);
    }

    // реинтерабильность
    // если бы происходило запись в файл, то этот блок должен быть synchronize
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        // поток закроется все равно когда сборщик мусора освободится НО когда слишком много запросов в ед времени - нужно закрывать.
        request.setCharacterEncoding("UTF-8");
        response.setContentType("text/html;charset=UTF-8");

        PrintWriter writer = response.getWriter();

        writer.println("<!doctype html>\n" +
                "<html lang=\"en\">\n" +
                "<head>\n" +
                "    <meta charset=\"UTF-8\">\n" +
                "    <meta name=\"viewport\"\n" +
                "          content=\"width=device-width, user-scalable=no, initial-scale=1.0, maximum-scale=1.0, minimum-scale=1.0\">\n" +
                "    <meta http-equiv=\"X-UA-Compatible\" content=\"ie=edge\">\n" +
                "    <title></title>\n" +
                "</head>\n" +
                "<body>\n" +
                "\n<br/>" + request.getRequestURL() +
                "\n<br/>" + request.getRequestURI() +
                "\n<br/>" + request.getContextPath() +
                "\n<br/>" + request.getServletPath() +
                "\n<br/>" + request.getPathInfo() +
                "\n<br/>" + request.getQueryString() +
                "\n<br/>++hitCounter: " + (++hitCounter));

        if (request.getSession(true).isNew()) {
            usersCounter++;
        }
        writer.println("session counter:" + usersCounter);
        writer.println("<table>\n" +
                "    <tr>\n" +
                "        <td>header name</td>\n" +
                "        <td>header values</td>\n" +
                "    </tr>");
        Enumeration<String> headerNames = request.getHeaderNames();
        while (headerNames.hasMoreElements()) {
            String name = headerNames.nextElement();
            writer.println("<tr><td>" +
                    "" + name +
                    "</td><td>");
            for (Enumeration<String> headers = request.getHeaders(name); headers.hasMoreElements(); ) {
                writer.println(headers.nextElement() + ", \t");
            }
            writer.println("</td></tr>");
        }
        writer.println("</table>");
    }
}
