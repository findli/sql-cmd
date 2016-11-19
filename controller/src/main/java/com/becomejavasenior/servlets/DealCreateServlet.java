package com.becomejavasenior.servlets;

import com.becomejavasenior.DAO.DAOException;
import com.becomejavasenior.bean.*;
import com.becomejavasenior.service.DealService;
import com.becomejavasenior.service.impl.DealServiceImpl;

import javax.servlet.ServletException;
import javax.servlet.annotation.MultipartConfig;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet(name = "dealCreateServlet", urlPatterns = "/dealCreate")
@MultipartConfig(maxFileSize = 102400)
public class DealCreateServlet extends HttpServlet{

    private DealService dealService = new DealServiceImpl();

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        response.sendRedirect("/pages/deal_add.jsp");
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.setCharacterEncoding("UTF-8");
        response.setContentType("text/html");

        Deal deal = new Deal();
        deal.setTitle(request.getParameter("dealName"));

        Company company = new Company();
        company.setTitle("new company");
        deal.setCompany(company);

        Stage stage = new Stage();
        stage.setTitle("new stage");
        deal.setStage(stage);

        deal.setDeleted(false);


        if (!request.getParameter("dealBudget").isEmpty()) {
            deal.setBudget(new Integer(request.getParameter("dealBudget")));
        }
        deal.setDeleted(false);

        try {
            dealService.create(deal);
        } catch (DAOException e) {
            e.printStackTrace();
        }
        System.out.println("TEST");
    }
}
