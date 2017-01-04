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
import java.io.PrintWriter;
import java.util.List;
import java.util.logging.Logger;



@WebServlet(name = "contactEditServlet", urlPatterns = "/contactEdit")
@Controller("contactEditServlet")
public class ContactEditServlet extends HttpServlet {

//    public static Logger log = Logger.getLogger(ContactEditServlet.class);

    @Autowired
    @Qualifier("contactService")
    ContactService contactService;

    @Autowired
    @Qualifier("companyService")
    CompanyService companyService;

    @Autowired
    @Qualifier("addressService")
    AddressService addressService;

    @Autowired
    @Qualifier("dealService")
    DealService dealService;

    @Autowired
    @Qualifier("userService")
    UserService userService;

    @Autowired
    @Qualifier("stageService")
    StageService stageService;

    Contact contact;
    Deal deal;
    Company company;
    Address address;
    Stage stage;


    @Override
    public void init(ServletConfig config) throws ServletException {
        super.init(config);
        SpringBeanAutowiringSupport.processInjectionBasedOnServletContext(this, config.getServletContext());
    }

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        HttpSession session = request.getSession();

        int idContact = 1;
        if (request.getParameter("idContact") != null) {
            idContact = Integer.parseInt(request.getParameter("idContact"));

            contact = new Contact();
            deal = new Deal();
            company = new Company();
            address = new Address();
            stage = new Stage();
            List<User> users = null;
            List<Stage> stages = null;
            List<Company> companies = null;
            String str = null;

            try {
                contact = contactService.getById(idContact);
                company = companyService.getById(contact.getCompany().getId());

                deal = dealService.getById(1);

//            deal = dealService.getById(contact.getDeal().getId());
                stage = stageService.getById(deal.getStage().getId());

            } catch (DaoException e) {
                e.printStackTrace();
            }

            try {
                //   stages = stageService.getAll();
                users = userService.getAll();
                companies = companyService.getAll();
            } catch (ClassNotFoundException e) {

            } catch (DaoException e) {

            }

            String stageTitle = deal.getStage().getTitle();
            session.setAttribute("stageTitle", stageTitle);

//        stages.remove(stage.getId()-1);

            String responsibleUser = deal.getResponsibleUser().getlName();
            users.remove(deal.getResponsibleUser().getId() - 1);

            session.setAttribute("contact", contact);
            session.setAttribute("idContact", idContact);
            session.setAttribute("deal", deal);
            session.setAttribute("stages", stages);
            session.setAttribute("stage", stage);
            session.setAttribute("responsibleUser", responsibleUser);
            session.setAttribute("users", users);
            session.setAttribute("company", company);
            session.setAttribute("companies", companies);
        }

        request.getRequestDispatcher("/pages/contact_edit.jsp").forward(request, response);

    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        response.setContentType("text/plain");
        PrintWriter out = response.getWriter();

        String action = request.getParameter("action");
        int idContact = Integer.parseInt(request.getParameter("idContact"));
        contact = new Contact();

        try {
            contact = contactService.getById(idContact);
        } catch (DaoException e) {
//            log.error("DAOException in ContactEditServlet in Controller layer", e);
        }

        if (action.equals("editContactContact")) {
//            log.trace("editContactContact");

            try {
                //getPhoneFromRequest(request);
                getUserFromRequest(request);
            } catch (DaoException e) {
//                log.error("DAOException in ContactEditServlet in Controller layer", e);
            } catch (ClassNotFoundException e) {
                e.printStackTrace();
            }

            contactUpdate();

        } else if (action.equals("editContactDeal")){
            deal = new Deal();
        //    int idDeal = company.getDeal().getId();
          //  int idStage = company.getDeal().getStage().getId();

            //try {
          //      deal = dealService.getById(idDeal);
          //      stage = getStageFromRequest(request);
                getBudgetFromRequest(request);
                getNameDealFromRequest(request);
        //    } catch (DaoException e) {

         //   } catch (ClassNotFoundException e) {



            dealUpdate();

        } else if (action.equals("editContactCompany")){
            company = new Company();
            int idCompany = contact.getCompany().getId();
            int idAddress = contact.getCompany().getAddress().getId();

            try {
                company = companyService.getById(idCompany);
                address = addressService.getById(idAddress);
            } catch (DaoException e) {
                e.printStackTrace();
            }



            getNameCompanyFromRequest(request);
            getPhoneFromRequest(request);
            getEmailFromRequest(request);
            getWebFromRequest(request);
            getCountryFromRequest(request);
            getCityFromRequest(request);
            getStreetFromRequest(request);
            getZipcodeFromRequest(request);
            getBuildingFromRequest(request);
            getRoomFromRequest(request);

            addressUpdate();
            company.setAddress(address);
            companyUpdate();

        }

    }

    public String getRoomFromRequest(HttpServletRequest request) {

        String room = request.getParameter("room");
        address.setOfficeRoom(room);

        return "Building = " + address.getOfficeRoom();
    }
    public String getBuildingFromRequest(HttpServletRequest request) {

        String building = request.getParameter("building");
        address.setBuildNum(building);

        return "Building = " + address.getBuildNum();
    }

    public String getZipcodeFromRequest(HttpServletRequest request) {

        int zipcode = Integer.valueOf(request.getParameter("zipcode"));
        address.setZipcode(zipcode);

        return "Zipcode = " + address.getZipcode();
    }

    public String getStreetFromRequest(HttpServletRequest request) {

        String street = request.getParameter("street");
        address.setStreet(street);

        return "Street = " + address.getStreet();
    }

    public String getCityFromRequest(HttpServletRequest request) {

        String city = request.getParameter("city");
        address.setCity(city);

        return "City = " + address.getCity();
    }


    public String getCountryFromRequest(HttpServletRequest request) {

        String country = request.getParameter("country");
        address.setCountry(country);

        return "Country = " + address.getCountry();
    }

    public String getWebFromRequest(HttpServletRequest request) {

        String newWeb = request.getParameter("newWeb");
        company.setWebsite(newWeb);

        return "Web = " + company.getWebsite();
    }

    public String getEmailFromRequest(HttpServletRequest request) {

        String newEmail = request.getParameter("newEmail");
        company.setEmail(newEmail);

        return "Email = " + company.getEmail();
    }

    public String getPhoneFromRequest(HttpServletRequest request) {

        String newPhone = request.getParameter("newPhone");
        company.setPhoneNumber(newPhone);

        return "Phone = " + company.getPhoneNumber();
    }

    public String getNameCompanyFromRequest(HttpServletRequest request) {

        String companyNewName = request.getParameter("newCompany");
        company.setTitle(companyNewName);

        return "Name = " + company.getTitle();
    }

    public String getBudgetFromRequest(HttpServletRequest request) {

        int dealNewBudget = Integer.valueOf(request.getParameter("newBudget"));
        deal.setBudget(dealNewBudget);
//        try {
//            deal = dealService.update(deal);
//        } catch (DaoException e) {
//            e.printStackTrace();
//        }
        return "Budget = " + deal.getBudget();
    }

    public String getNameDealFromRequest(HttpServletRequest request) {

        String dealNewName = request.getParameter("newDeal");
        deal.setTitle(dealNewName);

        return "Name = " + deal.getTitle();
    }

    public String getStageFromRequest(HttpServletRequest request) throws DaoException, ClassNotFoundException {

        String dealNewStage = request.getParameter("newStage");
        Stage stage = stageService.getByName(dealNewStage);
        deal.setStage(stage);

        return "Stage = " + deal.getStage().getTitle();
    }

    public String getUserFromRequest(HttpServletRequest request) throws DaoException, ClassNotFoundException {

        String dealNewUser = request.getParameter("newUser");
        User user = userService.getByName(dealNewUser);
        deal.setResponsibleUser(user);

        return "User = " + deal.getResponsibleUser().getlName();
    }

    public void companyUpdate() {
        try {
            company = companyService.update(company);
        } catch (DaoException e) {
            e.printStackTrace();
        }
    }

    public void dealUpdate() {
        try {
            deal = dealService.update(deal);
        } catch (DaoException e) {
            e.printStackTrace();
        }
    }

    public void addressUpdate() {
        try {
            address = addressService.update(address);
        } catch (DaoException e) {
            e.printStackTrace();
        }
    }

    public void contactUpdate() {
        try {
            contactService.update(contact);
        } catch (DaoException e) {
            e.printStackTrace();
        }
    }

}
