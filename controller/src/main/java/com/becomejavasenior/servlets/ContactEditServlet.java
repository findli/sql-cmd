package com.becomejavasenior.servlets;

import com.becomejavasenior.bean.Address;
import com.becomejavasenior.bean.Company;
import com.becomejavasenior.bean.Deal;
import com.becomejavasenior.service.CompanyService;
import com.becomejavasenior.service.ContactService;
import com.becomejavasenior.service.impl.CompanyServiceImpl;
import com.becomejavasenior.service.impl.ContactServiceImpl;
import org.apache.log4j.Logger;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet(name = "contactEditServlet", urlPatterns = "/contactEdit")
public class ContactEditServlet extends HttpServlet {

    public static Logger log = Logger.getLogger(ContactEditServlet.class);

    ContactService contactService = new ContactServiceImpl();
    CompanyService companyService = new CompanyServiceImpl();
    Deal deal;
    Company company;
    Address address;

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        

        response.sendRedirect("/pages/contact_edit.jsp");
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        super.doPost(req, resp);
    }

}
