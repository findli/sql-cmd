package com.becomejavasenior.servlets;

import com.becomejavasenior.DAO.DaoException;
import com.becomejavasenior.bean.*;
import com.becomejavasenior.service.*;
import com.becomejavasenior.service.impl.*;
import org.apache.log4j.Logger;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.util.List;

@WebServlet(name = "ContactAddServlet", urlPatterns = "/contactAdd")
public class ContactAddServlet extends HttpServlet {

    public static Logger log = Logger.getLogger(ContactAddServlet.class);
    private ContactService contactService = new ContactServiceImpl();

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        HttpSession session = request.getSession();

        List<TaskType> TaskTypeList = null;
        List<PeriodInDaysType> PeriodInDaysTypeList = null;
        List<Contact> contactList = null;
        List<Company> companyList = null;
        List<PhoneType> phoneTypes = null;
      //TODO:  List<Phone> phoneList = null;

        CompanyService companyService = new CompanyServiceImpl();
        TaskTypeService taskTypeService = new TaskTypeServiceImpl();
        PeriodInDaysTypeService periodService = new PeriodInDaysTypeServiceImpl();
        PhoneService phoneService = new PhoneServiceImpl();



        try {
            contactList = contactService.getAll();
            log.trace("get contactList in ContactAddServlet");
            companyList = companyService.getAll();
            log.trace("get companyList in ContactAddServlet");
            TaskTypeList = taskTypeService.getAll();
            log.trace("get TaskTypeList in ContactAddServlet");
            PeriodInDaysTypeList = periodService.getAll();
            log.trace("get PeriodInDaysTypeList in ContactAddServlet");
            phoneTypes = phoneService.getAllPhoneTypes();
            log.trace("get PhoneTypeList in ContactAddServlet");

        } catch (DaoException e) {
            log.warn("DaoException in ContactAddServlet");
            e.printStackTrace();
        } catch (ClassNotFoundException e) {
            log.warn("ClassNotFoundException in ContactAddServlet");
            e.printStackTrace();
        }

        session.setAttribute("TaskTypeList", TaskTypeList);
        session.setAttribute("PeriodInDaysTypeList", PeriodInDaysTypeList);
        session.setAttribute("contactList", contactList);
        session.setAttribute("companyList", companyList);
        session.setAttribute("phoneTypes", phoneTypes);
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
        CompanyService companyService = new CompanyServiceImpl();

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