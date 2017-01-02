/*
package com.becomejavasenior.servlets;

import com.becomejavasenior.DAO.DaoException;
import com.becomejavasenior.bean.*;
import com.becomejavasenior.service.*;
import com.becomejavasenior.service.impl.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;
import org.springframework.web.context.support.SpringBeanAutowiringSupport;

import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;


@WebServlet(name = "companyDetailServlet", urlPatterns = "/companyDetail")
@Controller("companyDetailServlet")
public class CompanyDetailServlet extends HttpServlet {

    @Autowired
    @Qualifier(value = "dealService")
    DealService dealService;

    @Autowired
    @Qualifier(value = "contactService")
    ContactService contactService;

    @Autowired
    @Qualifier(value = "companyService")
    CompanyService companyService;

    @Autowired
    @Qualifier("taskService")
    TaskService taskService;

    @Autowired
    @Qualifier("fileService")
    FileService fileService;

    @Autowired
    @Qualifier("noteService")
    NoteService noteService;

    @Autowired
    @Qualifier("addressService")
    AddressService addressService;

    @Override
    public void init(ServletConfig config) throws ServletException {
        super.init(config);
        SpringBeanAutowiringSupport.processInjectionBasedOnServletContext(this, config.getServletContext());
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        HttpSession session = request.getSession();

        int idCompany = 0;
        if (request.getParameter("idCompany") != null) {
            idCompany = Integer.parseInt(request.getParameter("idCompany"));
        }


        List<Contact> contactList = contactService.getContactsForList(idCompany);
        List<Deal> dealList = dealService.getDealsForList(idCompany);
        List<Task> taskList = taskService.getTasksForList(idCompany);
        List<Note> noteList = noteService.getNotesForList(idCompany);
        List<File> fileList = fileService.getFilesForList(idCompany);

        Company company = new Company();
        Address address = new Address();
        try {
            company = companyService.getById(idCompany);
            address = addressService.getById(company.getAddress().getId());
        } catch (DaoException e) {
            e.printStackTrace();
        }

        session.setAttribute("address", address);
        session.setAttribute("contactList", contactList);
        session.setAttribute("dealList", dealList);
        session.setAttribute("taskList", taskList);
        session.setAttribute("noteList", noteList);
        session.setAttribute("company", company);
        session.setAttribute("fileList", fileList);
        session.setAttribute("idCompany", idCompany);

        int idTask = 0;
        if (request.getParameter("idTask") != null) {
            idTask = Integer.parseInt(request.getParameter("idTask"));
            try {
                taskService.delete(idTask);
            } catch (DaoException e) {
                e.printStackTrace();
            }
        }
//        response.sendRedirect("/pages/companyDetail.jsp");
        request.getRequestDispatcher("/pages/companyDetail.jsp").forward(request, response);
    }

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        response.setContentType("text/plain");

        String action = request.getParameter("action");
        Address address = new Address();
        Company company = new Company();
        User user = new User();
        if (action != null) {
            if (action.startsWith("formTaskDel")) {
                String idTask = action.substring(12);
                try {
                    taskService.delete(Integer.parseInt(idTask));
                } catch (DaoException e) {
                    e.printStackTrace();
                }
            } else if (action.startsWith("formNoteDel")) {
                String idNote = action.substring(12);
                try {
                    noteService.delete(Integer.parseInt(idNote));
                } catch (DaoException e) {
                    e.printStackTrace();
                }
            } else if (action.startsWith("formFileDel")) {
                String idFile = action.substring(12);
                try {
                    fileService.delete(Integer.parseInt(idFile));
                } catch (DaoException e) {
                    e.printStackTrace();
                }
            } else if (action.startsWith("addCompany")) {
                String addressStr = request.getParameter("address");
                addressStr = addressStr.replace(" ", "");
                List<String> addressSplit = new ArrayList<>();
                Collections.addAll(addressSplit, addressStr.split(","));
                Address getIdAddress = new Address();
                address.setZipcode(Integer.parseInt(addressSplit.get(0)));
                address.setCountry(addressSplit.get(1));
                address.setCity(addressSplit.get(2));
                address.setStreet(addressSplit.get(3));
                address.setBuildNum(addressSplit.get(4));
                address.setOfficeRoom(addressSplit.get(5));
                try {
                    getIdAddress = addressService.create(address);
                } catch (DaoException e) {
                    e.printStackTrace();
                }
                company.setTitle(request.getParameter("title"));
                company.setPhoneNumber(request.getParameter("phone"));
                company.setEmail(request.getParameter("email"));
                company.setWebsite(request.getParameter("web"));
                address.setId(getIdAddress.getId());
                company.setAddress(getIdAddress);
                user.setId(1);//Доработать - брать из сессии
                company.setResponsibleUser(user);
                company.setDeleted(false);

                try {
                    companyService.create(company);
                } catch (DaoException e) {
                    e.printStackTrace();
                }

                } else if (action.startsWith("updateAddress")) {
                try {
                    company = companyService.getById(Integer.parseInt(request.getParameter("id")));
                } catch (DaoException e) {
                    e.printStackTrace();
                }
                company.setTitle(request.getParameter("title"));
                company.setEmail(request.getParameter("email"));
                company.setPhoneNumber(request.getParameter("phone"));
                company.setWebsite(request.getParameter("web"));
                String addressStr = request.getParameter("address");
                List<String> addressSplit = new ArrayList<>();
                Collections.addAll(addressSplit, addressStr.split(", "));
                address.setId(Integer.parseInt(request.getParameter("idAddress")));

                address.setZipcode(Integer.parseInt(addressSplit.get(0)));
                address.setCountry(addressSplit.get(1));
                address.setCity(addressSplit.get(2));
                address.setStreet(addressSplit.get(3));
                address.setBuildNum(addressSplit.get(4));
                address.setOfficeRoom(addressSplit.get(5));

                company.setAddress(address);
                user.setId(company.getResponsibleUser().getId());
                company.setResponsibleUser(user);
                company.setDeleted(false);
                try {
                    addressService.update(address);
                    companyService.update(company);
                } catch (DaoException e) {
                    e.printStackTrace();
                }

            }
        }
    }
}
*/
