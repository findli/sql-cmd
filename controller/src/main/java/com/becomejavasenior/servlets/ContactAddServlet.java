package com.becomejavasenior.servlets;

import com.becomejavasenior.DAO.DaoException;
import com.becomejavasenior.bean.*;
import com.becomejavasenior.service.ContactService;
import com.becomejavasenior.service.impl.ContactServiceImpl;

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
public class ContactAddServlet extends HttpServlet {

    private ContactService contactService = new ContactServiceImpl();

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
        request.getRequestDispatcher("/pages/contact_add.jsp").forward(request, response);

    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException{
        request.setCharacterEncoding("UTF-8");
        response.setContentType("text/html");

        Contact contact = getContactFromRequest(request);
        Tag tag = getTagFromRequest(request);

        File attachedFile = getFileFromRequest(request);

        try {

            contactService.createNewContact(contact, tag, attachedFile);

        } catch (DaoException e) {

        } catch (ClassNotFoundException e){

        }

        response.sendRedirect("/contact");
    }

    private Contact getContactFromRequest(HttpServletRequest request){
        Contact contact = new Contact();

        contact.setfName(request.getParameter("fName"));
        contact.setlName(request.getParameter("lName"));
        contact.setPosition(request.getParameter("Post"));
     //TODO:   contact.setContactPhone(request.getParameter("formPhone"));
        contact.setEmail(request.getParameter("Email"));
        contact.setSkype(request.getParameter("Skype"));

        User user = new User();
        user.setlName(request.getParameter("responsibleUser"));
        contact.setResponsibleUser(user);

        String noteContent = request.getParameter("noteContact");
        if (!noteContent.isEmpty()){
            List<Note> noteList = new ArrayList<>();
            Note note = new Note();
            note.setNoteText(noteContent);
            note.setDeleted(false);

            note.setDateCreate(new Date());
            User noteCreator = new User();
            noteCreator.setId(1); //TODO: bind with log in
            note.setCreatedUser(noteCreator);
            noteList.add(note);
            contact.setContactNote(noteList);
        } else {
            List<Note> noteList = new ArrayList<>();
            contact.setContactNote(noteList);
        }

        return contact;
    }

    private Tag getTagFromRequest(HttpServletRequest request){
        Tag tag = new Tag();
        tag.setTitle(request.getParameter("companyTag"));

        return tag;
    }

    private File getFileFromRequest(HttpServletRequest request){
        File attachedFile = new File();

        return attachedFile;
    }
}
