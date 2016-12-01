package com.becomejavasenior.servlets;

import com.becomejavasenior.DAO.DaoException;
import com.becomejavasenior.bean.Deal;
import com.becomejavasenior.bean.TaskType;
import com.becomejavasenior.bean.User;
import com.becomejavasenior.service.DealService;
import com.becomejavasenior.service.TaskTypeService;
import com.becomejavasenior.service.UserService;
import com.becomejavasenior.service.impl.DealServiceImpl;
import com.becomejavasenior.service.impl.TaskTypeServiceImpl;
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
        TaskTypeService taskTypesService = new TaskTypeServiceImpl();
        UserService UserService = new UserServiceImpl();

        List<Deal> dealList = dealService.getDealsForList();
        List<TaskType> taskTypeList = null;
        List<User> users = null;
        try {
            taskTypeList = taskTypesService.getAll();
            users = UserService.getAll();
        } catch (DaoException e) {
            e.printStackTrace();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }

        session.setAttribute("users", users);
        session.setAttribute("taskTypeList", taskTypeList);
        session.setAttribute("dealList", dealList);
        request.getRequestDispatcher("/pages/deal.jsp").forward(request, response);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        super.doPost(req, resp);
    }
}