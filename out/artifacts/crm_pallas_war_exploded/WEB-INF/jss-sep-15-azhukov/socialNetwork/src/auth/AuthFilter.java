package auth;

import javax.servlet.*;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * @author Cyril Kadomsky
 */
@WebFilter(filterName = "AuthFilter",
        urlPatterns = {"/auth/*"},
        dispatcherTypes = {DispatcherType.REQUEST,DispatcherType.FORWARD,DispatcherType.INCLUDE}
)
public class AuthFilter implements Filter {

    public void init(FilterConfig config) throws ServletException {
        // init parameters
    }

    public void destroy() {
    }

    public void doFilter(ServletRequest req, ServletResponse resp, FilterChain chain) throws ServletException, IOException {

        // Authorization

        HttpServletRequest request = (HttpServletRequest) req;
        HttpServletResponse response = (HttpServletResponse) resp;
        if (request.getSession(false)!=null || request.getServletPath().equals("/auth/LoginServlet") ) {
            // Check permissions for request.getRequestURL()
            chain.doFilter(req, resp);

        } else {
            ServletContext application = request.getServletContext();
            RequestDispatcher dispatcher = application.getRequestDispatcher("/auth/Login.html");
            dispatcher.forward(request,response);
        }

    }


}
