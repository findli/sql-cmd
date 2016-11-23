package com.becomejavasenior.servlets;

import com.becomejavasenior.DAO.DAOException;
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
//    private CompanyService companyService = new CompanyServiceImpl();
//    private StageService stageService = new StageServiceImpl();

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        CompanyService companyService = new CompanyServiceImpl();
        StageService stageService = new StageServiceImpl();

        int idDeal = 1;
        if (request.getParameter("idDeal") != null) {
            idDeal = Integer.parseInt(request.getParameter("idDeal"));
            System.out.println("id = " + request.getParameter("idDeal"));
        } else {
            System.out.println("id = null");
        }
        HttpSession session = request.getSession();

        dealService = new DealServiceImpl();
        companyService = new CompanyServiceImpl();

        Deal deal = null;
        Company company = null;
        Stage stage = new Stage();
        List<Stage> stages = null;

        try {
            deal = dealService.getById(idDeal);
            company = companyService.getById(deal.getCompany().getId());
            stage = stageService.getById(deal.getStage().getId());
        } catch (DAOException e) {
            e.printStackTrace();
        }

        try {
            stages = stageService.getAll();
        } catch (DAOException e) {
            e.printStackTrace();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }

        session.setAttribute("stages", stages);
        session.setAttribute("stage", stage);
        session.setAttribute("company", company);
        session.setAttribute("deal", deal);
        request.getRequestDispatcher("/pages/deal_edit.jsp").forward(request, response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.setCharacterEncoding("UTF-8");
        response.setContentType("text/html");

        Deal deal = getDealFromRequest(request);
        Contact contact = getContactFromRequest(request);
        Task task = getTaskFromRequest(request);
        Company company = getCompanyFromRequest(request);
        File attachedFile = getFileFromRequest(request);

        try {
            dealService.update(deal);
//            dealService.createNewDeal(deal, contact, task, company, attachedFile);
        } catch (DAOException e) {
            e.printStackTrace();
//        } catch (ClassNotFoundException e) {
//            e.printStackTrace();
        }
        response.sendRedirect("/deal");
    }
    private Deal getDealFromRequest(HttpServletRequest request) {
        Deal deal = new Deal();
        deal.setTitle(request.getParameter("dealName"));

        User user = new User();
        user.setlName(request.getParameter("responsibleUser"));
        deal.setResponsibleUser(user);

        System.out.println("dealBudget " + request.getParameter("dealBudget"));
        int budget;
        if(request.getParameter("dealBudget")==null) {
            budget = 0;
        } else {
            budget = new Integer(request.getParameter("dealBudget"));
        }
        deal.setBudget(budget);
//        if (!request.getParameter("dealBudget").isEmpty()) {
//            deal.setBudget(new Integer(request.getParameter("dealBudget")));
//        }
        Stage stage = new Stage();
        stage.setTitle(request.getParameter("dealStage"));
        deal.setStage(stage);

//        List<Tag> tags = new ArrayList<>();
//        Tag tag = new Tag();
//        tag = request.getParameter("dealTag");
//        if (!request.getParameter("dealTag").isEmpty()) {
//            deal.setDealTag(tags);
//        }
        deal.setCreateDate(new Date());

        return deal;
    }
    private Contact getContactFromRequest(HttpServletRequest request) {
        Contact contact = new Contact();
        return contact;
    }
    private Task getTaskFromRequest(HttpServletRequest request) {
        Task task = new Task();
        return task;
    }
    private Company getCompanyFromRequest(HttpServletRequest request) {
        Company company = new Company();
        company.setTitle(request.getParameter("companyDeal"));
        System.out.println("company = " + company.getTitle());
        return company;
    }
    private File getFileFromRequest(HttpServletRequest request) {
        File attachedFile = new File();
        return attachedFile;
    }
}
