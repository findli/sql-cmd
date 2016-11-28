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
public class Headers extends HttpServlet {

    private String message;

    public void init() throws ServletException {
        // Do required initialization
    }

    public void doPost(HttpServletRequest request, HttpServletResponse response) {

    }

    public void doGet(HttpServletRequest request,
                      HttpServletResponse response)
            throws ServletException, IOException {
        // Set response content type
        PrintWriter out = new PrintWriter(response.getWriter());

        String params[] = request.getParameterValues("key1");
        out.println(request.getParameter("key1"));
        out.println(Arrays.toString(params));
        Enumeration<String> parameterNames = request.getParameterNames();
        out.println(parameterNames);
        out.println(new Date().toString());
    }

    public void destroy() {
        // do nothing.
    }
}
