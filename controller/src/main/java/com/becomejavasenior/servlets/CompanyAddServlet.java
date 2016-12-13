package com.becomejavasenior.servlets;

import com.becomejavasenior.DAO.DaoException;
import com.becomejavasenior.bean.*;
import com.becomejavasenior.service.CompanyService;
import com.becomejavasenior.service.impl.CompanyServiceImpl;
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

@WebServlet(name = "companyaddservlet", urlPatterns = "/companyadd")
@Controller("CompanyAddServlet")
public class CompanyAddServlet extends HttpServlet {

    @Autowired
    @Qualifier(value="companyService")
    private CompanyService companyService;

    @Override
    public void init(ServletConfig config) throws ServletException {
        super.init(config);
        SpringBeanAutowiringSupport.processInjectionBasedOnServletContext(this, config.getServletContext());
    }

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        HttpSession session = request.getSession();

        List<Company> companyList = null;

        try {
            companyList = companyService.getAll();
        } catch (DaoException e) {
            e.printStackTrace();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }

        session.setAttribute("contactList", companyList);
        request.getRequestDispatcher("/pages/company_add.jsp").forward(request, response);

    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.setCharacterEncoding("UTF-8");
        response.setContentType("text/html");

        Company company = getCompanyFromRequest(request);
        Address address = getAddressFromRequest(request);
        Task task = getTaskFromRequest(request);

      //  companyService.createNewCompany(company, address, task);

        response.sendRedirect("/company");
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
        //    company.setCompanyNote(noteList);
        } else {
            List<Note> noteList = new ArrayList<>();
         //   company.setCompanyNote(noteList);
        }

        if (!request.getParameter("companyPhone_number").isEmpty()){
            company.setPhoneNumber(new String(request.getParameter("companyPhone_number")));
        }

        if (!request.getParameter("companyEmail").isEmpty()){
            company.setEmail(new String(request.getParameter("companyEmail")));
        }

        if (!request.getParameter("companyWebsite").isEmpty()){
            company.setWebsite(new String(request.getParameter("companyWebsilte")));
        }

        company.setDeleted(false);

        return company;
    }

    private Task getTaskFromRequest(HttpServletRequest request) {
        Task task = new Task();
        return task;
    }

    private Address getAddressFromRequest(HttpServletRequest request){
        Address address = new Address();
        return address;
    }


}
