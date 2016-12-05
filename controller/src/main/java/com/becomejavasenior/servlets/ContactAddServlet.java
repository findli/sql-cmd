package com.becomejavasenior.servlets;

import com.becomejavasenior.DAO.DaoException;
import com.becomejavasenior.bean.Company;
import com.becomejavasenior.bean.Contact;
import com.becomejavasenior.bean.Deal;
import com.becomejavasenior.bean.Task;
import com.becomejavasenior.service.ContactService;
import com.becomejavasenior.service.impl.ContactServiceImpl;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;

@WebServlet(name = "ContactAddServlet", urlPatterns = "/contactAdd")
public class ContactAddServlet extends HttpServlet {

    private ContactService contactService = new ContactServiceImpl();

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        HttpSession session = request.getSession();


        response.sendRedirect("/pages/contact_add.jsp");

    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException{
        request.setCharacterEncoding("UTF-8");
        response.setContentType("text/html");

        Contact contact = getContactFromRequest(request);
        Deal deal = getDealFromRequest(request);
        Task task = getTaskFromRequest(request);
        Company company = getCompanyFromRequest(request);

        try {
            contactService.create(contact);
        } catch (DaoException e) {

        }
    }
}
