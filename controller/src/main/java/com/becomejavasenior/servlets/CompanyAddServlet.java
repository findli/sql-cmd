package com.becomejavasenior.servlets;

import com.becomejavasenior.service.CompanyService;
import com.becomejavasenior.service.impl.CompanyServiceImpl;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;

@WebServlet(name = "companyaddservlet", urlPatterns = "/companyadd")
public class CompanyAddServlet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        HttpSession session = req.getSession();
        CompanyService companyService = new CompanyServiceImpl();


        resp.sendRedirect("/pages/company_add.jsp");
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        super.doPost(req, resp);
    }
}
