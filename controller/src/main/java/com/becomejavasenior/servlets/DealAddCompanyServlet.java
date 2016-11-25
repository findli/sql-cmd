package com.becomejavasenior.servlets;

import com.becomejavasenior.DAO.DAOException;
import com.becomejavasenior.bean.Company;
import com.becomejavasenior.service.CompanyService;
import com.becomejavasenior.service.impl.CompanyServiceImpl;
import org.apache.log4j.Logger;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.util.List;

@Deprecated
@WebServlet(name="dealAddCompanyServlet", urlPatterns = "/deal_add_company")
public class DealAddCompanyServlet extends HttpServlet {

    public static Logger log = Logger.getLogger(DealAddDealServlet.class);

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        log.trace("run doGet() in DealAddCompanyServlet");

        HttpSession session = request.getSession();
        CompanyService companyService = new CompanyServiceImpl();

        List<Company> companyList = null;

        try {
            companyList = companyService.getAll();
        } catch (DAOException e) {
            e.printStackTrace();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }

        session.setAttribute("companyList", companyList);
        request.getRequestDispatcher("/pages/deal_add.jsp").forward(request, response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        log.trace("run doPost() in DealAddCompanyServlet");
        response.sendRedirect("/pages/deal_add.jsp");
    }
}
