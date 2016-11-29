package com.becomejavasenior.servlets;

import org.apache.log4j.Logger;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@Deprecated
@WebServlet(name="dealAddDealServlet", urlPatterns = "/deal_add_deal")
public class DealAddDealServlet extends HttpServlet {

    public static Logger log = Logger.getLogger(DealAddDealServlet.class);

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        log.trace("run doGet() in DealAddDealServlet");
        response.sendRedirect("/pages/deal_add.jsp");
    }
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        log.trace("run doPost() in DealAddDealServlet");
        response.sendRedirect("/pages/deal_add.jsp");
    }
}
