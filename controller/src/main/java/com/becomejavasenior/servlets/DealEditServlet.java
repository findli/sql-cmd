package com.becomejavasenior.servlets;

import com.becomejavasenior.DAO.DaoException;
import com.becomejavasenior.bean.*;
import com.becomejavasenior.service.*;
import com.becomejavasenior.service.impl.*;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@WebServlet(name = "dealEditServlet", urlPatterns = "/dealEdit")
public class DealEditServlet extends HttpServlet {

    private DealService dealService = new DealServiceImpl();

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        HttpSession session = request.getSession();

        CompanyService companyService = new CompanyServiceImpl();
        StageService stageService = new StageServiceImpl();
        UserService userService = new UserServiceImpl();
        AddressService addressService = new AddressServiceImpl();

        int idDeal = 1;
        if (request.getParameter("idDeal") != null) {
            idDeal = Integer.parseInt(request.getParameter("idDeal"));
        }

        dealService = new DealServiceImpl();
        companyService = new CompanyServiceImpl();

        Deal deal = new Deal();
        Company company = new Company();
        Stage stage = new Stage();
        List<Stage> stages = null;
        List<User> users = null;
        Address address = new Address();

        try {
            deal = dealService.getById(idDeal);
            company = companyService.getById(deal.getCompany().getId());
            stage = stageService.getById(deal.getStage().getId());
            address = addressService.getById(company.getAddress().getId());
        } catch (DaoException e) {
            e.printStackTrace();
        }

        try {
            stages = stageService.getAll();
            users = userService.getAll();
        } catch (DaoException e) {
            e.printStackTrace();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }

        String stageTitle = deal.getStage().getTitle();
        session.setAttribute("stageTitle", stageTitle);

        stages.remove(stage.getId()-1);

        String responsibleUser = deal.getResponsibleUser().getlName();
        users.remove(deal.getResponsibleUser().getId()-1);


        session.setAttribute("address", address);
        session.setAttribute("idDeal", idDeal);
        session.setAttribute("stages", stages);
        session.setAttribute("stage", stage);
        session.setAttribute("responsibleUser", responsibleUser);
        session.setAttribute("users", users);
        session.setAttribute("company", company);
        session.setAttribute("deal", deal);
        request.getRequestDispatcher("/pages/deal_edit.jsp").forward(request, response);
    }

}
