package com.becomejavasenior.servlets;

import com.becomejavasenior.DAO.DaoException;
import com.becomejavasenior.bean.Deal;
import com.becomejavasenior.bean.Stage;
import com.becomejavasenior.service.DealService;
import com.becomejavasenior.service.impl.DealServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.ApplicationContext;
import org.springframework.web.context.support.SpringBeanAutowiringSupport;
import org.springframework.web.context.support.WebApplicationContextUtils;

import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.util.List;

@WebServlet(name = "dealFunnelServlet", urlPatterns = "/funnel")
public class DealFunnelServlet extends HttpServlet {

    @Autowired
    @Qualifier("dealService")
    DealService dealService;

    @Override
    public void init(ServletConfig config) throws ServletException {
        super.init(config);
        SpringBeanAutowiringSupport.processInjectionBasedOnServletContext(this, config.getServletContext());
    }

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        HttpSession session = request.getSession (false);
//        DealService dealService = new DealServiceImpl();

        List<Stage> stageList = dealService.getAllStage();
        session.setAttribute("stageList", stageList);
        session.setAttribute("dealService", dealService);

        List<Deal> dealList = null;
        try {
            dealList = dealService.getAll();
        } catch (DaoException e) {
            e.printStackTrace();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }

        session.setAttribute("dealList", dealList);

        response.sendRedirect("/pages/funnel.jsp");


    }

}
