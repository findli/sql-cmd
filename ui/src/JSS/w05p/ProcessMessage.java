package JSS.w05p;

import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

// Extend HttpServlet class
public class ProcessMessage extends HttpServlet {

    private String message;

    public void init() throws ServletException {
        // Do required initialization
    }

    public void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doGet(request, response);
    }

    public void doGet(HttpServletRequest request,
                      HttpServletResponse response)
            throws ServletException, IOException {
        // Set response content type
        request.setCharacterEncoding("UTF-8");
        response.setContentType("text/html; charset=UTF-8");

        String msg = request.getParameter("userData");

        PrintWriter out = response.getWriter();
        out.write("process message<br/>");

        if (msg != null && msg.length() != 0) {
            out.println("<!DOCTYPE HTML PUBLIC \"-//W3C//DTD HTML 4.01//EN\" \"http://www.w3.org/TR/html4/strict.dtd\">\n" +
                    "<HTML lang=\"en\">\n" +
                    "<head>\n" +
                    "    <meta http-equiv=\"Content-Type\" content=\"text/html;charset=UTF-8\">\n" +
                    "    <title>Message sent</title>\n" +
                    "</head>\n" +
                    "<body>\n" +
                    "<h1>Message received: " + msg +
                    "</h1>\n" +
                    "</body>\n" +
                    "</HTML>");
            out.close();
        } else {
//            new SendMessage().doGet(request, response);
//            out.write("else");
            response.sendRedirect("http://localhost:8080/JSS-15-09/form/send-message");
        }
    }

    @Override
    public void init(ServletConfig config) throws ServletException {
        super.init(config);

        // can be used for preliminary create db connection
        // BUT! called on every server restart!

        System.out.println("called: init(ServletConfig config)");
        System.out.println(config.getInitParameterNames());
    }

    public void destroy() {
        System.out.println("called: destroy()");
        // can be used for preliminary release db connection
    }
}
