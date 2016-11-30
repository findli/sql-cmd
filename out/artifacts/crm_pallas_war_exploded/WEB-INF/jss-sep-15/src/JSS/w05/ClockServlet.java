package JSS.w05;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.Date;

public class ClockServlet extends javax.servlet.http.HttpServlet {
    protected void doPost(javax.servlet.http.HttpServletRequest request, javax.servlet.http.HttpServletResponse response) throws javax.servlet.ServletException, IOException {
        doGet(request,response);
    }

    protected void doGet(javax.servlet.http.HttpServletRequest request, javax.servlet.http.HttpServletResponse response) throws javax.servlet.ServletException, IOException {
            PrintWriter out = new PrintWriter( response.getWriter() );
            out.println(new Date().toString());

    }
}
