package com.becomejavasenior.servlets;

import com.becomejavasenior.DAO.DAOException;
import com.becomejavasenior.bean.Deal;
import com.becomejavasenior.service.DealService;
import com.becomejavasenior.service.impl.DealServiceImpl;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.util.List;

@WebServlet(name = "DealListServlet", urlPatterns = "/deal")
public class DealListServlet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        HttpSession session = request.getSession();
        DealService dealService = new DealServiceImpl();
        List<Deal> dealList = null;
        try {
            dealList = dealService.getAll();
        } catch (DAOException e) {
            e.printStackTrace();
        }

        session.setAttribute("dealList", dealList);
        session.setAttribute("dealService", dealService);
        response.sendRedirect("/pages/deal.jsp");

    }
}