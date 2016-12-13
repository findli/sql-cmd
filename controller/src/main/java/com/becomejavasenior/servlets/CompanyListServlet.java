package com.becomejavasenior.servlets;

import com.becomejavasenior.DAO.DaoException;
import com.becomejavasenior.bean.Company;
import com.becomejavasenior.service.CompanyService;
import com.becomejavasenior.service.impl.CompanyServiceImpl;
import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;
import org.springframework.web.context.support.SpringBeanAutowiringSupport;

import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.util.List;

@WebServlet(name="companyList", urlPatterns = "/company")
@Controller("companyListServlet")
public class CompanyListServlet extends HttpServlet {

    public static Logger log = Logger.getLogger(CompanyListServlet.class);

    @Autowired
    @Qualifier("companyService")
    CompanyService companyService;

    @Override
    public void init(ServletConfig config) throws ServletException {
        super.init(config);
        SpringBeanAutowiringSupport.processInjectionBasedOnServletContext(this, config.getServletContext());
    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        log.trace("run doGet() in CompanyListServlet");
        HttpSession session = req.getSession();

        List<Company> companyList = null;

        try {
            log.trace("call getAll() from service in CompanyListServlet");
            companyList = companyService.getAll();
        } catch (DaoException e) {

            log.error("DaoException in CompanyListServlet in Controller layer", e);

        } catch (ClassNotFoundException e) {

            log.error("ClassNotFoundException in CompanyListServlet in Controller layer", e);

        }

        session.setAttribute("companyList", companyList);
        req.getRequestDispatcher("pages/company.jsp").forward(req, resp);
    }

}
