package com.becomejavasenior.servlets;

import com.becomejavasenior.DAO.DaoException;
import com.becomejavasenior.bean.*;
import org.apache.log4j.Logger;

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
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

@WebServlet(name = "ContactAddServlet", urlPatterns = "/contactAdd")
@Controller("ContactAddServlet")
public class ContactAddServlet extends HttpServlet {

    public static Logger log = Logger.getLogger(ContactAddServlet.class);
    private ContactService contactService = new ContactServiceImpl();
    CompanyService companyService = new CompanyServiceImpl();

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

        List<TaskType> TaskTypeList = null;
        List<PeriodInDaysType> PeriodInDaysTypeList = null;
        List<Contact> contactList = null;
        List<Company> companyList = null;
        List<PhoneType> phoneTypes = null;
        List<Stage> stageList = null;
      //TODO:  List<Phone> phoneList = null;


        TaskTypeService taskTypeService = new TaskTypeServiceImpl();
        PeriodInDaysTypeService periodService = new PeriodInDaysTypeServiceImpl();
        PhoneService phoneService = new PhoneServiceImpl();
        StageService stageService = new StageServiceImpl();



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
            stageList = stageService.getAll();
            log.trace("get StageList in ContactAddServlet");

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
        session.setAttribute("stageList", stageList);
        request.getRequestDispatcher("/pages/contact_add.jsp").forward(request, response);

    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException{
        request.setCharacterEncoding("UTF-8");
        response.setContentType("text/html");

        Contact contact = null;
        Company company = null;
        Task task = null;
        Deal deal = null;

        try {
            contact = getContactFromRequest(request);

            company = getCompanyFromRequest(request);
            contact.setCompany(company);
            task = getTaskFromRequest(request);
            //contact.setTasks(task);

            deal = getDealFromRequest(request);
            // set deal

        } catch (DaoException e) {
            e.printStackTrace();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
        Tag tag = getTagFromRequest(request);

        File attachedFile = getFileFromRequest(request);

     /*   try {


            //contactService.createNewContact(contact, tag, attachedFile);

        } catch (DaoException e) {

        } catch (ClassNotFoundException e){

        }*/

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

    private Company getCompanyFromRequest(HttpServletRequest request) {
        Company company = new Company();
        if (request.getParameter("nameCompany")!= "") {
            company.setTitle(request.getParameter("nameCompany"));
            company.setPhoneNumber(request.getParameter("phoneCompany"));
            company.setEmail(request.getParameter("emailCompany"));
            company.setWebsite(request.getParameter("webCompany"));
            //TODO: company.setAddress();
        } else {
            try {
                company =  companyService.getByName(request.getParameter("company"));
            } catch (DaoException e) {
                e.printStackTrace();
            } catch (ClassNotFoundException e) {
                e.printStackTrace();
            }
        }

        return company;
    }

    private Deal getDealFromRequest (HttpServletRequest request) {
        Deal deal = new Deal();
        deal.setTitle(request.getParameter("dealName"));

        Stage stage = new Stage();
        stage.setTitle(request.getParameter("stageTitle"));
        deal.setStage(stage);

        if (!request.getParameter("dealBudget").isEmpty()) {
            deal.setBudget(new Integer(request.getParameter("dealBudget")));
        }

        return deal;
    }

    private Task getTaskFromRequest (HttpServletRequest request) {

        Task task = new Task();
        TaskType taskType = new TaskType();
        User user = new User();
        PeriodInDaysType periodInDaysType = new PeriodInDaysType();

        SimpleDateFormat format = new SimpleDateFormat();
        format.applyPattern("dd.MM.yyyy HH:mm");
        Date date = null;

        TaskTypeService taskTypeService = new TaskTypeServiceImpl();
        PeriodInDaysTypeService periodInDaysService = new PeriodInDaysTypeServiceImpl();
        UserService userService = new UserServiceImpl();
        TaskService taskService = new TaskServiceImpl();

        try {
            user = userService.getById(parseString(request.getParameter("ResponsibleUserTask")));
            taskType = taskTypeService.getById(parseString(request.getParameter("TaskType")));
            date = format.parse(request.getParameter("DeadlineDate"));
            periodInDaysType = periodInDaysService.getById(parseString(request.getParameter("PeriodInDaysType")));
        }catch ( ParseException e){
            e.printStackTrace();
        }catch (DaoException e){
            e.printStackTrace();
        }
        task.setTaskType(taskType);
        task.setDeadlineDate(date);
        task.setPeriodInDaysType(periodInDaysType);
        task.setPeriodInMinutes((int) date.getTime());
        task.setResponsibleUser(user);
        task.setFinished(false);
        task.setDeleted(false);

        return task;
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

    private int parseString(String text){
        int id = Integer.parseInt(text);
        return id;
    }
}