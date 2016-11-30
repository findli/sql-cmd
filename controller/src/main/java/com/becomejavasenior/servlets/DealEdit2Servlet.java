package com.becomejavasenior.servlets;

import com.becomejavasenior.DAO.DaoException;
import com.becomejavasenior.bean.Deal;
import com.becomejavasenior.bean.Stage;
import com.becomejavasenior.service.DealService;
import com.becomejavasenior.service.StageService;
import com.becomejavasenior.service.impl.DealServiceImpl;
import com.becomejavasenior.service.impl.StageServiceImpl;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

@WebServlet(name = "dealEdit2Servlet", urlPatterns = "/dealEdit2")
public class DealEdit2Servlet extends HttpServlet {
    DealService dealService = new DealServiceImpl();
    String str;
    Deal deal;

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        response.setContentType("text/plain");
        PrintWriter out = response.getWriter();

        String action = request.getParameter("action");

        if (action.equals("editDealDeal")) {
            deal = new Deal();
            int id = Integer.parseInt(request.getParameter("idDeal"));
            try {
                deal = dealService.getById(id);
            } catch (DaoException e) {
                e.printStackTrace();
            }

            str = getNameFromRequest(request) + " \n";
            try {
                str += getStageFromRequest(request) + " \n";
                str += getBudgetFromRequest(request) + " \n";
            } catch (DaoException e) {
                e.printStackTrace();
            } catch (ClassNotFoundException e) {
                e.printStackTrace();
            }
            out.print(str);

        } else if (action.equals("demo2")){
//            int number1 = Integer.parseInt(request.getParameter("number1"));
//            int number2 = Integer.parseInt(request.getParameter("number2"));
//            out.print(number1 + number2);
        }
    }
    public String getBudgetFromRequest(HttpServletRequest request) {
        int dealNewBudget = Integer.valueOf(request.getParameter("newBudget"));
        deal.setBudget(dealNewBudget);
        try {
            deal = dealService.update(deal);
        } catch (DaoException e) {
            e.printStackTrace();
        }
        return "new Budget = " + deal.getBudget();
    }

    public String getNameFromRequest(HttpServletRequest request) {

        String dealNewName = request.getParameter("newDeal");


        deal.setTitle(dealNewName);

        try {
            deal = dealService.update(deal);
        } catch (DaoException e) {
            e.printStackTrace();
        }

        return "new name = " + deal.getTitle();
    }

    public String getStageFromRequest(HttpServletRequest request) throws DaoException, ClassNotFoundException {
        DealService dealService = new DealServiceImpl();
        StageService stageService = new StageServiceImpl();
        String dealNewStage = request.getParameter("newStage");
        Stage stage = stageService.getByName(dealNewStage);
        deal.setStage(stage);

        try {
            deal = dealService.update(deal);
        } catch (DaoException e) {
            e.printStackTrace();
        }
        return "new stage = " + deal.getStage().getTitle();
    }

}
