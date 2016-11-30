package com.becomejavasenior;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet(name = "AddDealServlet")
public class AddDealServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

/*        DealService dealService = new DealServiceImpl();
        User user = new User();
        Deal deal = new Deal();
        Stage stage = new Stage();
        Company company = new Company();
        deal.setTitle(request.getParameter("modalDealTitle"));
        deal.setBudget(Integer.parseInt(request.getParameter("modalDealBudget")));
        stage.setId(1);
        user.setId(1);
        deal.setDeleted(false);
        company.setId(1);

        try {
            dealService.createNewDeal(deal, user, stage, company);
        } catch (DaoException e) {
            e.printStackTrace();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
        response.sendRedirect("/company.jsp");*/
    }
}
