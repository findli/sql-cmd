package com.becomejavasenior.servlets;

import com.becomejavasenior.bean.*;
import com.becomejavasenior.service.CompanyService;
import com.becomejavasenior.service.impl.CompanyServiceImpl;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@WebServlet(name = "companyaddservlet", urlPatterns = "/companyadd")
public class CompanyAddServlet extends HttpServlet {

    private CompanyService companyService = new CompanyServiceImpl();

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        HttpSession session = req.getSession();
        CompanyService companyService = new CompanyServiceImpl();


        resp.sendRedirect("/pages/company_add.jsp");
    }

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        HttpSession session = request.getSession();
        ContactService contactService = new ContactServiceImpl();

        List<Contact> contactList = null;

        try {
            contactList = contactService.getAll();
        } catch (DaoException e) {
            e.printStackTrace();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }

        session.setAttribute("contactList", contactList);
        request.getRequestDispatcher("/pages/deal_add.jsp").forward(request, response);

    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.setCharacterEncoding("UTF-8");
        response.setContentType("text/html");

        Company company = getCompanyFromRequest(request);
        Adress address = getAddressFromRequest(request);

        companyService.createNewCompany(company, user, address);

        response.sendRedirect("/deal");
    }

    private Company getCompanyFromRequest(HttpServletRequest request) {
        Company company = new Company();
        company.setTitle(request.getParameter("companyName"));

        User user = new User();
        user.setlName(request.getParameter("responsibleUser"));
        company.setResponsibleUser(user);

        String noteContent = request.getParameter("noteCompany");
        if (!noteContent.isEmpty()) {
            List<Note> noteList = new ArrayList<>();
            Note note = new Note();
            note.setNoteText(request.getParameter("noteCompany"));
            note.setDeleted(false);

            note.setDateCreate(new Date());
            User creator = new User();
            creator.setId(1); //TODO: change to user under which the logged in
            note.setCreatedUser(creator);
            noteList.add(note);
            company.setCompanyNote(noteList);
        } else {
            List<Note> noteList = new ArrayList<>();
            company.setCompanyNote(noteList);
        }
        return company;
    }

    private Deal getDealFromRequest(HttpServletRequest request) {
        Deal deal = new Deal();
        deal.setTitle(request.getParameter("dealName"));

        User user = new User();
        user.setlName(request.getParameter("responsibleUser"));
        deal.setResponsibleUser(user);

        deal.setCreateDate(new Date());
        deal.setDeleted(false);

        String noteContent = request.getParameter("noteDeal");
        if (!noteContent.isEmpty()) {
            List<Note> noteList = new ArrayList<>();
            Note note = new Note();
            note.setNoteText(request.getParameter("noteDeal"));
            note.setDeleted(false);

            note.setDateCreate(new Date());
            User creator = new User();
            creator.setId(1); //TODO: change to user under which the logged in
            note.setCreatedUser(creator);
            noteList.add(note);
            deal.setDealNote(noteList);
        } else {
            List<Note> noteList = new ArrayList<>();
            deal.setDealNote(noteList);
        }

        if (!request.getParameter("dealBudget").isEmpty()) {
            deal.setBudget(new Integer(request.getParameter("dealBudget")));
        }
        return deal;
    }
    private Contact getContactFromRequest(HttpServletRequest request) {
        Contact contact = new Contact();
        return contact;
    }
    private Task getTaskFromRequest(HttpServletRequest request) {
        Task task = new Task();
        return task;
    }
    private File getFileFromRequest(HttpServletRequest request) {
        File attachedFile = new File();
        return attachedFile;
    }
}
