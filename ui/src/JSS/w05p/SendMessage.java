package JSS.w05p;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Arrays;
import java.util.Date;
import java.util.Enumeration;

// Extend HttpServlet class
public class SendMessage extends HttpServlet {

    private String message;

    public void init() throws ServletException {
        // Do required initialization
    }

    public void doPost(HttpServletRequest request, HttpServletResponse response) {

    }

    public void doGet(HttpServletRequest request,
                      HttpServletResponse response)
            throws ServletException, IOException {

        // useful methods:
        getServletConfig();
        getServletContext();
        getServletInfo(); // переопределяется, чтобы вернуть информацию о сервлете; автор, версия) - и просмотреть можно методами сервера.

        // Set response content type
        response.setContentType("text/html; charset=UTF-8");
        PrintWriter out = new PrintWriter(response.getWriter());

        out.println("<html>\n" +
                "<head><title>Send message</title></head>\n" +
                "<body bgcolor='#f0f8ff'>\n" +
                "<form name=\"Form1\" method=\"post\" action='http://localhost:8080/JSS-15-09/form/process-message'>\n" +
                "Enter your message:<br/>\n" +
                "    <input type=\"text\" name=\"userData\"/><p>\n" +
                "    <input type=\"submit\" value=\"Send\"/>\n" +
                "</p>\n" +
                "</form>\n" +
                "</body>\n" +
                "</html>");
        out.close();
    }

    public void destroy() {
        // do nothing.
    }
}
