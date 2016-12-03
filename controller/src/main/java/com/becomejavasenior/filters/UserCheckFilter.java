package com.becomejavasenior.filters;

import com.becomejavasenior.Entity.User;

import javax.servlet.*;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.io.IOException;

@WebFilter(filterName = "UserCheckFilter")
public class UserCheckFilter implements javax.servlet.Filter {
    private String LOGIN_ACTION_URI;

    public void destroy() {
    }

    public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws ServletException, IOException {
        System.out.println("UserCheckFilter.doFilter()");
        HttpServletRequest requestLocal = (HttpServletRequest) request;
        HttpSession session = requestLocal.getSession();
        User user = (User) session.getAttribute("user");

        if (user == null && !LOGIN_ACTION_URI.equals(requestLocal.getRequestURI())) {
            RequestDispatcher rd = requestLocal.getRequestDispatcher("/login.jsp");
            rd.forward(requestLocal, response);
            return;
        }
        chain.doFilter(requestLocal, response);
    }

    public void init(FilterConfig filterConfig) throws ServletException {
        LOGIN_ACTION_URI = filterConfig.getInitParameter("loginActionURI");
    }

}


