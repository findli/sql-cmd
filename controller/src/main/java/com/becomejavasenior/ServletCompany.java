package com.becomejavasenior;

import com.becomejavasenior.DAO.Imp.TaskDAOImpl;
import com.becomejavasenior.DAO.TaskDAO;
import com.becomejavasenior.bean.*;

import javax.servlet.annotation.WebServlet;

@WebServlet("main.java.com.becomejavasenior.ServletCompany")
public class ServletCompany extends javax.servlet.http.HttpServlet {

    private TaskDAO<Task> taskDAO = new TaskDAOImpl();

    protected void doPost(javax.servlet.http.HttpServletRequest request, javax.servlet.http.HttpServletResponse response) throws javax.servlet.ServletException, java.io.IOException {

    }

    protected void doGet(javax.servlet.http.HttpServletRequest request, javax.servlet.http.HttpServletResponse response) throws javax.servlet.ServletException, java.io.IOException {

        Contact contact = new Contact();
        Company company = new Company();
        Deal deal = new Deal();
        Task task = new Task();

        company.setTitle(request.getParameter("formCompany"));
        company.setTags(request.getParameter("formTag"));
        company.setPhoneNumber(request.getParameter("formPhone"));
        company.setEmail(request.getParameter("formEmail"));
        company.setWebsite(request.getParameter("formWeb"));
        company.setAdress(request.getParameter("formAddress"));


        /*add contact*/
        if (request.getParameter("modalButContact") != null) {
            contact.setfName(request.getParameter("modalContactName"));
            contact.setlName(request.getParameter("modalContactSurname"));
            contact.setPosition(request.getParameter("modalContactPosition"));
            contact.setEmail(request.getParameter("modalContactEmail"));
            contact.setSkype(request.getParameter("modalContactSkype"));
        }

       /* add deal*/
        if (request.getParameter("modalButDeal") != null) {
            deal.setTitle(request.getParameter("modalDealTitle"));
            deal.setBudget(request.getParameter("modalDealBudget"));
        }

        /* add task*/
        if (request.getParameter("modalButTask") != null) {
            task.setDeadlineDate(request.getParameter("myCalendar-1"));
            task.setTime(request.getParameter("timeChoose"));
            task.setDescription(request.getParameter("modalTaskDesc"));
        }


        /*remove task*/
        int idTask = Integer.parseInt(request.getParameter("idTask"));
        if (request.getParameter("formTaskDel") != null) {
            taskDAO.delete(idTask);
        }

         /*remove note*/
        int idNote = Integer.parseInt(request.getParameter("idNote"));
        if (request.getParameter("formNoteDel") != null) {
            taskDAO.delete(idNote);
        }

            /*remove file*/
        int idFile = Integer.parseInt(request.getParameter("idFile"));
        if (request.getParameter("formFileDel") != null) {
            taskDAO.delete(idFile);
        }


        request.getRequestDispatcher("company.jsp").forward(request, response);
    }

}
