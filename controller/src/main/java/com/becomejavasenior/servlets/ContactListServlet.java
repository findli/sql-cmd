package com.becomejavasenior.servlets;

import com.becomejavasenior.DAO.DaoException;
import com.becomejavasenior.bean.Contact;
import com.becomejavasenior.bean.User;
import com.becomejavasenior.service.ContactService;
import com.becomejavasenior.service.UserService;
import com.becomejavasenior.service.impl.ContactServiceImpl;
import com.becomejavasenior.service.impl.UserServiceImpl;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.util.List;

@WebServlet(name = "contactListServlet", urlPatterns = "/contact")
public class ContactListServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        ContactService contactService = new ContactServiceImpl();
        UserService userService = new UserServiceImpl();

        HttpSession session = request.getSession();
        List<Contact> contactList = null;
        List<User> users = null;

        try {
            contactList = contactService.getAll();
            users = userService.getAll();
        } catch (DaoException e) {
            e.printStackTrace();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }

        session.setAttribute("users", users);
        session.setAttribute("contactList", contactList);

        response.sendRedirect("/pages/contact.jsp");
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        super.doPost(req, resp);
    }
}
