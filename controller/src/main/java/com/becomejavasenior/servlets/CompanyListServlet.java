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

@WebServlet(name="companyList", urlPatterns = "/company")
public class CompanyListServlet extends HttpServlet {

    public static Logger log = Logger.getLogger(CompanyListServlet.class);

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        log.trace("run doGet() in CompanyListServlet");
        HttpSession session = req.getSession();
        CompanyService companyService = new CompanyServiceImpl();

        List<Company> companyList = null;

        try {
            log.trace("call getAll() from service in CompanyListServlet");
            companyList = companyService.getAll();
            System.out.println(companyList);
        } catch (DAOException e) {

            log.error("DAOException in CompanyListServlet in Controller layer", e);

        } catch (ClassNotFoundException e) {

            log.error("ClassNotFoundException in CompanyListServlet in Controller layer", e);

        }

        session.setAttribute("companyList", companyList);
        req.getRequestDispatcher("pages/companyList.jsp").forward(req, resp);
    }

}
