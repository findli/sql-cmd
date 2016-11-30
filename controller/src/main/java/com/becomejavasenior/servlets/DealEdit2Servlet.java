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
    String str;
    Deal deal;

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        response.setContentType("text/plain");
        PrintWriter out = response.getWriter();

        String action = request.getParameter("action");

        if (action.equals("editDealDeal")) {
            str = getNameFromRequest(request) + " \n";
//            try {
//                str+= getStageFromRequest(request) + " \n";
//            } catch (DaoException e) {
//                e.printStackTrace();
//            } catch (ClassNotFoundException e) {
//                e.printStackTrace();
//            }
            out.print(str);

        } else if (action.equals("demo2")){
//            int number1 = Integer.parseInt(request.getParameter("number1"));
//            int number2 = Integer.parseInt(request.getParameter("number2"));
//            out.print(number1 + number2);
        }
    }
    public String getNameFromRequest(HttpServletRequest request) {
        DealService dealService = new DealServiceImpl();
        String dealNewName = request.getParameter("newDeal");
        deal = new Deal();
        int id = Integer.parseInt(request.getParameter("idDeal"));
        try {
            deal = dealService.getById(id);
        } catch (DaoException e) {
            e.printStackTrace();
        }

        deal.setTitle(dealNewName);

        try {
            deal = dealService.update(deal);
        } catch (DaoException e) {
            e.printStackTrace();
        }

        return "new name = " + deal.getTitle();
    }
//    public Stage stageByName(String str) throws ClassNotFoundException, DaoException {
//        StageService stageService = new StageServiceImpl();
//        List<Stage> stages = stageService.getAll();
//        int id = 0;
//        for (int i = 0; i < stages.size(); ++i) {
//            if (stages.get(i).getTitle().equals(str)) {
//                id = stages.get(i).getId();
//                break;
//            }
//        }
//        return stages.get(id);
//    }
//    public String getStageFromRequest(HttpServletRequest request) throws DaoException, ClassNotFoundException {
//        DealService dealService = new DealServiceImpl();
//        String dealNewStage = request.getParameter("newStage");
//        Stage stage = new Stage();
//        int id = Integer.parseInt(request.getParameter("idDeal"));
//        try {
//            stage = dealService.getById(id).getStage();
//        } catch (DaoException e) {
//            e.printStackTrace();
//        }
//
//        deal.setStage(stageByName(dealNewStage));
//
//        try {
//            deal = dealService.update(deal);
//        } catch (DaoException e) {
//            e.printStackTrace();
//        }
//        return "new stage = " + deal.getStage().getTitle();
//    }

}
