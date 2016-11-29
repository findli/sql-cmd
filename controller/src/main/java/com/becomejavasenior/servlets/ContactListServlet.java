package com.becomejavasenior.servlets;

import com.becomejavasenior.DAO.DAOException;
import com.becomejavasenior.bean.Contact;
import com.becomejavasenior.service.ContactService;
import com.becomejavasenior.service.impl.ContactServiceImpl;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.util.List;

@WebServlet(name = "contactlistservlet", urlPatterns = "/contact")
public class ContactListServlet extends HttpServlet{

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        ContactService contactService = new ContactServiceImpl();

        List<Contact> contactList = null;
        HttpSession session = req.getSession();

        try {
            contactList = contactService.getAll();
        } catch (DAOException e) {

        } catch (ClassNotFoundException e){

        }

        session.setAttribute("contactList", contactList);
        resp.sendRedirect("/pages/contact_list.jsp");
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        super.doPost(req, resp);
    }
}
