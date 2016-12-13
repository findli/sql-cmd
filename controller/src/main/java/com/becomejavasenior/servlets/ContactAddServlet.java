package com.becomejavasenior.servlets;

import com.becomejavasenior.DAO.DaoException;
import com.becomejavasenior.bean.*;
import com.becomejavasenior.service.CompanyService;
import com.becomejavasenior.service.ContactService;
import com.becomejavasenior.service.impl.CompanyServiceImpl;
import com.becomejavasenior.service.impl.ContactServiceImpl;
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
import java.util.Date;
import java.util.List;

@WebServlet(name = "ContactAddServlet", urlPatterns = "/contactAdd")
@Controller("ContactAddServlet")
public class ContactAddServlet extends HttpServlet {

    @Autowired
    @Qualifier("contactService")
    private ContactService contactService;

    @Autowired
    @Qualifier("companyService")
    private CompanyService companyService;

    @Override
    public void init(ServletConfig config) throws ServletException {
        super.init(config);
        SpringBeanAutowiringSupport.processInjectionBasedOnServletContext(this, config.getServletContext());
    }

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        HttpSession session = request.getSession();

        List<Contact> contactList = null;
        List<Company> companyList = null;

        try {
            contactList = contactService.getAll();
            companyList = companyService.getAll();
        } catch (DaoException e) {
            e.printStackTrace();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }

        session.setAttribute("contactList", contactList);
        session.setAttribute("companyList", companyList);
        request.getRequestDispatcher("/pages/contact_add.jsp").forward(request, response);

    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException{
        request.setCharacterEncoding("UTF-8");
        response.setContentType("text/html");

        Contact contact = null;
        try {
            contact = getContactFromRequest(request);
        } catch (DaoException e) {
            e.printStackTrace();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
        Tag tag = getTagFromRequest(request);

        File attachedFile = getFileFromRequest(request);

        try {

            contactService.createNewContact(contact, tag, attachedFile);

        } catch (DaoException e) {

        } catch (ClassNotFoundException e){

        }

        response.sendRedirect("/contact");
    }

    private Contact getContactFromRequest(HttpServletRequest request) throws DaoException, ClassNotFoundException {
        Contact contact = new Contact();

        contact.setfName(request.getParameter("fName"));
        contact.setlName(request.getParameter("lName"));
        contact.setPosition(request.getParameter("position"));
        //TODO:   contact.setContactPhone(request.getParameter("formPhone"));
        contact.setEmail(request.getParameter("Email"));
        contact.setSkype(request.getParameter("Skype"));
        contact.setDeleted(false);

        User user = new User();
        user.setlName(request.getParameter("responsibleUser"));
        contact.setResponsibleUser(user);
        Company company = new Company();
        company = companyService.getByName(request.getParameter("company"));
        contact.setCompany(company);

//        String noteContent = request.getParameter("noteContact");
//        if (!noteContent.isEmpty()){
//            List<Note> noteList = new ArrayList<>();
//            Note note = new Note();
//            note.setNoteText(noteContent);
//            note.setDeleted(false);
//
//            note.setDateCreate(new Date());
//            User noteCreator = new User();
//            noteCreator.setId(1); //TODO: bind with log in
//            note.setCreatedUser(noteCreator);
//            noteList.add(note);
//            contact.setContactNote(noteList);
//        } else {
//            List<Note> noteList = new ArrayList<>();
//            contact.setContactNote(noteList);
//        }

        return contact;
    }

    private Tag getTagFromRequest(HttpServletRequest request){
        Tag tag = new Tag();
        tag.setTitle(request.getParameter("Tag"));

        return tag;
    }

    private File getFileFromRequest(HttpServletRequest request){
        File attachedFile = new File();

        return attachedFile;
    }
}