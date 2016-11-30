package com.becomejavasenior;

import com.becomejavasenior.DAO.DAOException;
import com.becomejavasenior.bean.*;
import com.becomejavasenior.service.ContactService;
import com.becomejavasenior.service.impl.ContactServiceImpl;

import javax.servlet.ServletException;
import javax.servlet.annotation.MultipartConfig;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.util.Date;
import java.util.List;

/*@WebServlet(name = "ServletCompany", urlPatterns = "/contactCreate")
@MultipartConfig(maxFileSize = 102400)*/

public class ServletCompany extends HttpServlet {

    private ContactService contactService = new ContactServiceImpl();

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        HttpSession session = request.getSession();

        System.out.println("!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!1");
        response.sendRedirect("company.jsp");


    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {


        /*  request.setCharacterEncoding("UTF-8");
        response.setContentType("text/html");

        Contact contact = getContactFromRequest(request);

        User user = getFileFromRequest(request);
        Company company = getCompanyFromRequest(request);
        System.out.println("###############################");

        System.out.println(request.getParameter("modalButContact"));

        try {
            contactService.createNewContact(user,company, contact);
        } catch (DAOException e) {
            e.printStackTrace();
        }
        response.sendRedirect("/contact");*/
    }


   /* private Contact getDealFromRequest(HttpServletRequest request) {
        Contact contact = new Contact();
        contact.setfName(request.getParameter("modalContactName"));
        contact.setlName(request.getParameter("modalContactSurname"));
        contact.setPosition(request.getParameter("modalContactPosition"));
        contact.setEmail(request.getParameter("modalContactEmail"));
        contact.setSkype(request.getParameter("modalContactSkype"));

        User user = new User();
        user.setlName(request.getParameter("responsibleUser"));
        contact.setResponsibleUser(user);
        return contact;
    }

    private Contact getContactFromRequest(HttpServletRequest request) {
        Contact contact = new Contact();
        return contact;
    }

    private Company getCompanyFromRequest(HttpServletRequest request) {
        Company company = new Company();
        company.setTitle(request.getParameter("companyDeal"));
        return company;
    }

    private User getFileFromRequest(HttpServletRequest request) {
        User user = new User();
        return user;
    }*/

}




























/*public class ServletCompany extends javax.servlet.http.HttpServlet {

    private TaskDAO<Task> taskDAO = new TaskDAOImpl();

    protected void doPost(javax.servlet.http.HttpServletRequest request, javax.servlet.http.HttpServletResponse response) throws javax.servlet.ServletException, java.io.IOException {
        Contact contact = new Contact();
        Company company = new Company();
        Tag tag = new Tag();
        Deal deal = new Deal();
        Task task = new Task();
*//*
        company.setTitle(request.getParameter("formCompany"));
        tag.setTitle(request.getParameter("formTag"));
        company.setPhoneNumber(request.getParameter("formPhone"));
        company.setEmail(request.getParameter("formEmail"));
        company.setWebsite(request.getParameter("formWeb"));
        company.setAdress(request.getParameter("formAddress"));*//*


        *//*add contact*//*
        if (request.getParameter("modalButContact") != null) {
            contact.setfName(request.getParameter("modalContactName"));
            contact.setlName(request.getParameter("modalContactSurname"));
            contact.setPosition(request.getParameter("modalContactPosition"));
            contact.setEmail(request.getParameter("modalContactEmail"));
            contact.setSkype(request.getParameter("modalContactSkype"));
        }

       *//* add deal*//*
        if (request.getParameter("modalButDeal") != null) {
            deal.setTitle(request.getParameter("modalDealTitle"));
            deal.setBudget(Integer.parseInt(request.getParameter("modalDealBudget")));
        }

        *//* add task*//*
        if (request.getParameter("modalButTask") != null) {
*//*            task.setDeadlineDate(request.getParameter("myCalendar-1"));
            task.setDeadlineDate(request.getParameter("timeChoose"));*//*
            task.setDescription(request.getParameter("modalTaskDesc"));
        }


        *//*remove task*//*
        int idTask = Integer.parseInt(request.getParameter("idTask"));
        if (request.getParameter("formTaskDel") != null) {
            try {
                taskDAO.delete(idTask);
            } catch (DAOException e) {
                e.printStackTrace();
            }
        }

         *//*remove note*//*
        int idNote = Integer.parseInt(request.getParameter("idNote"));
        if (request.getParameter("formNoteDel") != null) {
            try {
                taskDAO.delete(idNote);
            } catch (DAOException e) {
                e.printStackTrace();
            }
        }

            *//*remove file*//*
        int idFile = Integer.parseInt(request.getParameter("idFile"));
        if (request.getParameter("formFileDel") != null) {
            try {
                taskDAO.delete(idFile);
            } catch (DAOException e) {
                e.printStackTrace();
            }
        }


        request.getRequestDispatcher("company.jsp").forward(request, response);
    }

    protected void doGet(javax.servlet.http.HttpServletRequest request, javax.servlet.http.HttpServletResponse response) throws javax.servlet.ServletException, java.io.IOException {


    }

}*/
