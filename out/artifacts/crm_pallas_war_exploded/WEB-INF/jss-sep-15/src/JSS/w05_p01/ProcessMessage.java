package JSS.w05_p01;

import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

public class ProcessMessage extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doGet(request,response);
    }

    public void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException
    {
        req.setCharacterEncoding("UTF-8");
        resp.setContentType("text/html; charset=UTF-8");

        String msg = req.getParameter("userData");

        if ( msg != null && msg.length() != 0 ) {
            PrintWriter out = resp.getWriter();
            out.println( "<html>" +
                         "<head>" +
                         "<title>Message sent</title>" +
                         "</head>" +
                         "<body bgcolor=#aaffee>" );
            out.println( "<h2>Recieved message</h2>" + msg );
            out.println( "</body></html>"  );
            out.close();
        } else {
            resp.sendRedirect("http://localhost:8080/JSS-15-09/clock");

        }
    }

    @Override
    public void init() throws ServletException {
        super.init();

        System.out.println(" init() fired !!!!!!!!!!");
    }

    @Override
    public void init(ServletConfig config) throws ServletException {
        super.init(config);
        System.out.println(" init(ServletConfig config) fired !!!!!!!!!!");
    }

    @Override
    public void destroy() {
        super.destroy();
        System.out.println(" destroy() fired !!!!!!!!!!");
    }
}
