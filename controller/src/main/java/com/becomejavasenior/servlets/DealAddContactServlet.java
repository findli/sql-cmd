package com.becomejavasenior.servlets;

import org.apache.log4j.Logger;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet(name="dealAddContactServlet", urlPatterns = "/deal_add_contact")
public class DealAddContactServlet extends HttpServlet {

    public static Logger log = Logger.getLogger(DealAddDealServlet.class);

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        log.trace("run doGet() in DealAddContactServlet");
        response.sendRedirect("/pages/deal_add.jsp");
    }
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        log.trace("run doPost() in DealAddContactServlet");
        response.sendRedirect("/pages/deal_add.jsp");
    }
}
