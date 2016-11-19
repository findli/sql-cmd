package com.becomejavasenior.servlets;

import com.becomejavasenior.DAO.DAOException;
import com.becomejavasenior.bean.Deal;
import com.becomejavasenior.bean.Stage;
import com.becomejavasenior.bean.User;
import com.becomejavasenior.service.DealService;
import com.becomejavasenior.service.StageService;
import com.becomejavasenior.service.UserService;
import com.becomejavasenior.service.impl.DealServiceImpl;
import com.becomejavasenior.service.impl.StageServiceImpl;
import com.becomejavasenior.service.impl.UserServiceImpl;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.util.List;

@WebServlet(name = "dealListServlet", urlPatterns = "/deal")
public class DealListServlet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        HttpSession session = request.getSession();
        DealService dealService = new DealServiceImpl();
        StageService stageService = new StageServiceImpl();
        UserService userService = new UserServiceImpl();

        List<Deal> dealList = dealService.getDealsForList();
        List<Stage> stageList = null;
        List<User> users = null;
        try {
            stageList = stageService.getAll();
            users = userService.getAll();
        } catch (DAOException e) {
            e.printStackTrace();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }

        session.setAttribute("users", users);
        session.setAttribute("stageList", stageList);
        session.setAttribute("dealList", dealList);
        response.sendRedirect("/pages/deal.jsp");
    }

}