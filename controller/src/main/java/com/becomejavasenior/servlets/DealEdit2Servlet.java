package com.becomejavasenior.servlets;

import com.becomejavasenior.DAO.DaoException;
import com.becomejavasenior.bean.Company;
import com.becomejavasenior.bean.Deal;
import com.becomejavasenior.bean.Stage;
import com.becomejavasenior.bean.User;
import com.becomejavasenior.service.CompanyService;
import com.becomejavasenior.service.DealService;
import com.becomejavasenior.service.StageService;
import com.becomejavasenior.service.UserService;
import com.becomejavasenior.service.impl.CompanyServiceImpl;
import com.becomejavasenior.service.impl.DealServiceImpl;
import com.becomejavasenior.service.impl.StageServiceImpl;
import com.becomejavasenior.service.impl.UserServiceImpl;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

@WebServlet(name = "dealEdit2Servlet", urlPatterns = "/dealEdit2")
public class DealEdit2Servlet extends HttpServlet {
    DealService dealService = new DealServiceImpl();
    CompanyService companyService = new CompanyServiceImpl();
    String str = null;
    Deal deal;
    Company company;

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        response.setContentType("text/plain");
        PrintWriter out = response.getWriter();

        String action = request.getParameter("action");
        int idDeal = Integer.parseInt(request.getParameter("idDeal"));
        deal = new Deal();

        try {
            deal = dealService.getById(idDeal);
        } catch (DaoException e) {
            e.printStackTrace();
        }

        if (action.equals("editDealDeal")) {

            str = getNameDealFromRequest(request) + "; \n";
            try {
                str += getStageFromRequest(request) + "; \n";
                str += getBudgetFromRequest(request) + "; \n";
                str += getUserFromRequest(request) + "; \n";
            } catch (DaoException e) {
                e.printStackTrace();
            } catch (ClassNotFoundException e) {
                e.printStackTrace();
            }

            dealUpdate();
            out.print(str);

        } else if (action.equals("editDealCompany")) {
            company = new Company();
            int idCompany = deal.getCompany().getId();

            try {
                company = companyService.getById(idCompany);
            } catch (DaoException e) {
                e.printStackTrace();
            }

            str = getNameCompanyFromRequest(request) + "; \n";
            str += getPhoneFromRequest(request) + "; \n";
            str += getEmailFromRequest(request) + "; \n";
            str += getWebFromRequest(request) + "; \n";

            companyUpdate();
            out.print(str);

        }
    }

    public String getWebFromRequest(HttpServletRequest request) {

        String newWeb = request.getParameter("newWeb");
        company.setWebsite(newWeb);

        return "new Web = " + company.getWebsite();
    }

    public String getEmailFromRequest(HttpServletRequest request) {

        String newEmail = request.getParameter("newEmail");
        company.setEmail(newEmail);

        return "new Email = " + company.getEmail();
    }

    public String getPhoneFromRequest(HttpServletRequest request) {

        String newPhone = request.getParameter("newPhone");
        company.setPhoneNumber(newPhone);

        return "new Phone = " + company.getPhoneNumber();
    }

    public String getNameCompanyFromRequest(HttpServletRequest request) {

        String companyNewName = request.getParameter("newCompany");
        company.setTitle(companyNewName);

        return "new Name = " + company.getTitle();
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

    public String getNameDealFromRequest(HttpServletRequest request) {

        String dealNewName = request.getParameter("newDeal");
        deal.setTitle(dealNewName);

        return "new name = " + deal.getTitle();
    }

    public String getStageFromRequest(HttpServletRequest request) throws DaoException, ClassNotFoundException {

/*        StageService stageService = new StageServiceImpl();
        String dealNewStage = request.getParameter("newStage");
        Stage stage = stageService.getByName(dealNewStage);
        deal.setStage(stage);*/

        return "new stage = " + deal.getStage().getTitle();
    }

    public String getUserFromRequest(HttpServletRequest request) throws DaoException, ClassNotFoundException {

/*        UserService userService = new UserServiceImpl();
        String dealNewUser = request.getParameter("newUser");
        User user = userService.getByName(dealNewUser);
        deal.setResponsibleUser(user);*/

        return "new User = " + deal.getResponsibleUser().getlName();
    }

    public void companyUpdate() {
/*        try {
            company = companyService.update(company);
        } catch (DaoException e) {
            e.printStackTrace();
        }*/
    }

    public void dealUpdate() {
        try {
            deal = dealService.update(deal);
        } catch (DaoException e) {
            e.printStackTrace();
        }
    }
}
