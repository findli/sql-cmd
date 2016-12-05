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
import java.util.List;

@WebServlet(name = "dealListServlet", urlPatterns = "/deal")
public class DealListServlet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        HttpSession session = request.getSession();
        DealService dealService = new DealServiceImpl();
        TaskTypeService taskTypesService = new TaskTypeServiceImpl();
        UserService userService = new UserServiceImpl();
        CompanyService companyService = new CompanyServiceImpl();

        List<Deal> dealList = dealService.getDealsForList();
        List<TaskType> taskTypeList = null;
        List<User> users = null;
        List<Company> companyList = null;
        try {
            taskTypeList = taskTypesService.getAll();
            users = userService.getAll();
            companyList = companyService.getAll();

        } catch (DaoException e) {
            e.printStackTrace();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }

        session.setAttribute("companyList", companyList);
        session.setAttribute("users", users);
        session.setAttribute("taskTypeList", taskTypeList);
        session.setAttribute("dealList", dealList);
        response.sendRedirect("/pages/deal.jsp");
    }

}