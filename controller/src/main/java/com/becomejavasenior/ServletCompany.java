package com.becomejavasenior;

import com.becomejavasenior.DAO.DaoException;
import com.becomejavasenior.bean.*;
import com.becomejavasenior.service.*;
import com.becomejavasenior.service.impl.*;

import javax.servlet.ServletException;
import javax.servlet.annotation.MultipartConfig;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.util.List;

@WebServlet(name = "ServletCompany", urlPatterns = "/company")
@MultipartConfig(maxFileSize = 102400)

public class ServletCompany extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        HttpSession session = request.getSession();

        ContactService contactService = new ContactServiceImpl();
        DealService dealService = new DealServiceImpl();
        TaskService taskService = new TaskServiceImpl();
        FileService fileService = new FileServiceImpl();
        NoteService noteService = new NoteServiceImpl();
        CompanyService companyService = new CompanyServiceImpl();


        List<Contact> contactList = contactService.getContactsForList();
        List<Deal> dealList = dealService.getDealsForList();
        List<Task> taskList = taskService.getTasksForList();
     /*   List<File> fileList = fileService.getFilesForList();*/
        List<Note> noteList = noteService.getNotesForList();
        Company company = null;
        try {
            company = companyService.getById(1);
        } catch (DaoException e) {
            e.printStackTrace();
        }


        request.setAttribute("contactList", contactList);
        request.setAttribute("dealList", dealList);
        request.setAttribute("taskList", taskList);
   /*     request.setAttribute("fileList", fileList);*/
        request.setAttribute("noteList", noteList);
        request.setAttribute("company", company);

        if (request.getParameter("formTaskDel") != null) {
           /* int idTask = Integer.parseInt(request.getParameter("idTask"));*/

       /*     System.out.println(idTask);*/

            System.out.println("!!!!!!!!!!!!!!!!");

        }

      /*  if (request.getParameter("modalButDeal") != null) {
            User user = new User();
            Deal deal = new Deal();
            Stage stage = new Stage();
            Company company = new Company();
            deal.setTitle(request.getParameter("modalDealTitle"));
            deal.setBudget(Integer.parseInt(request.getParameter("modalDealBudget")));
            stage.setId(1);
            user.setId(1);
            deal.setDeleted(false);
            company.setId(1);

            try {
                dealService.createNewDeal(deal, user, stage, company);
            } catch (DaoException | ClassNotFoundException e) {
                e.printStackTrace();
            }
        }

        if (request.getParameter("modalButContact") !=null){
            Company company = new Company();
            User user = new User();
            Contact contact = new Contact();
            contact.setfName(request.getParameter("modalContactName"));
            contact.setlName(request.getParameter("modalContactSurname"));
            company.setId(1);
            contact.setPosition(request.getParameter("modalContactPosition"));
            contact.setEmail(request.getParameter("modalContactEmail"));
            contact.setSkype(request.getParameter("modalContactSkype"));
            user.setId(1);
            contact.setDeleted(false);
            try {
                contactService.createNewContact(company, contact, user);
            } catch (DaoException | ClassNotFoundException e) {
                e.printStackTrace();
            }
        }

        if (request.getParameter("modalButTask") != null){
            Task task = new Task();
            System.out.println(request.getParameter("hiddenDate"));

        }*/

        if (request.getParameter("formUpdateCompany") != null){
            Address address = new Address();
            company.setTitle(request.getParameter("formCompany"));
            company.setPhoneNumber(request.getParameter("formPhone"));
            company.setEmail(request.getParameter("formEmail"));
            company.setWebsite(request.getParameter("formWeb"));
            address.setId(1);
            company.setAddress(address);

            try {
                companyService.update(company);
            } catch (DaoException e) {
                e.printStackTrace();
            }
        }


        request.getRequestDispatcher("company.jsp").forward(request, response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
    }

}



/*public class ServletCompany extends javax.servlet.http.HttpServlet {

    private TaskDao<Task> taskDAO = new TaskDaoImpl();

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
        company.setAddress(request.getParameter("formAddress"));*//*


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
            } catch (DaoException e) {
                e.printStackTrace();
            }
        }

         *//*remove note*//*
        int idNote = Integer.parseInt(request.getParameter("idNote"));
        if (request.getParameter("formNoteDel") != null) {
            try {
                taskDAO.delete(idNote);
            } catch (DaoException e) {
                e.printStackTrace();
            }
        }

            *//*remove file*//*
        int idFile = Integer.parseInt(request.getParameter("idFile"));
        if (request.getParameter("formFileDel") != null) {
            try {
                taskDAO.delete(idFile);
            } catch (DaoException e) {
                e.printStackTrace();
            }
        }


        request.getRequestDispatcher("company.jsp").forward(request, response);
    }

    protected void doGet(javax.servlet.http.HttpServletRequest request, javax.servlet.http.HttpServletResponse response) throws javax.servlet.ServletException, java.io.IOException {


    }

}*/
