package com.becomejavasenior.servlets;

import com.becomejavasenior.DAO.DaoException;
import com.becomejavasenior.bean.*;
import com.becomejavasenior.service.*;
import com.becomejavasenior.service.impl.*;
import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.ApplicationContext;
import org.springframework.stereotype.Controller;
import org.springframework.web.context.support.SpringBeanAutowiringSupport;
import org.springframework.web.context.support.WebApplicationContextUtils;

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

@WebServlet(name = "dealEditServlet", urlPatterns = "/dealEdit")
@Controller("dealEditServlet")
public class DealEditServlet extends HttpServlet {

    public static Logger log = Logger.getLogger(DealEditServlet.class);
    private ApplicationContext context;

    @Autowired
    @Qualifier("dealService")
    DealService dealService;

    @Autowired
    @Qualifier("companyService")
    CompanyService companyService;

    @Autowired
    @Qualifier("addressService")
    AddressService addressService;

    @Autowired
    @Qualifier("stageService")
    StageService stageService;

    @Autowired
    @Qualifier("userService")
    UserService userService;

    String str = null;
    Deal deal;
    Company company;
    Address address;

    @Override
    public void init(ServletConfig config) throws ServletException {
        super.init(config);
        SpringBeanAutowiringSupport.processInjectionBasedOnServletContext(this, config.getServletContext());
    }

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        HttpSession session = request.getSession();

        Deal deal = new Deal();
        Company company = new Company();
        Stage stage = new Stage();
        List<Stage> stages = null;
        List<User> users = null;
        Address address = new Address();

        int idDeal = 1;
        if (request.getParameter("idDeal") != null) {
            idDeal = Integer.parseInt(request.getParameter("idDeal"));

            try {
                deal = dealService.getById(idDeal);
                company = companyService.getById(deal.getCompany().getId());
                stage = stageService.getById(deal.getStage().getId());
                address = addressService.getById(company.getAddress().getId());
            } catch (DaoException e) {
                e.printStackTrace();
            }
            try {
                stages = stageService.getAll();
                users = userService.getAll();
            } catch (DaoException | ClassNotFoundException e) {
                e.printStackTrace();
            }
            String stageTitle = deal.getStage().getTitle();
            session.setAttribute("stageTitle", stageTitle);

            stages.remove(stage.getId()-1);

            String responsibleUser = deal.getResponsibleUser().getlName();
            users.remove(deal.getResponsibleUser().getId()-1);

            session.setAttribute("address", address);
            session.setAttribute("idDeal", idDeal);
            session.setAttribute("stages", stages);
            session.setAttribute("stage", stage);
            session.setAttribute("responsibleUser", responsibleUser);
            session.setAttribute("users", users);
            session.setAttribute("company", company);
            session.setAttribute("deal", deal);
        }

        request.getRequestDispatcher("/pages/deal_edit.jsp").forward(request, response);
    }
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        response.setContentType("text/plain");
        PrintWriter out = response.getWriter();

        String action = request.getParameter("action");
        int idDeal = Integer.parseInt(request.getParameter("idDeal"));
        deal = new Deal();

        try {
            deal = dealService.getById(idDeal);
        } catch (DaoException e) {
            log.error("DAOException in DealEditServlet in Controller layer", e);
        }

        if (action.equals("editDealDeal")) {

            log.trace("editDealDeal");

            str = getNameDealFromRequest(request) + "; \n";
            try {
                str += getStageFromRequest(request) + "; \n";
                str += getBudgetFromRequest(request) + "; \n";
                str += getUserFromRequest(request) + "; \n";
            } catch (DaoException e) {
                log.error("DAOException in DealEditServlet in Controller layer", e);
            } catch (ClassNotFoundException e) {
                e.printStackTrace();
            }

            dealUpdate();
            out.print(str);

        } else if (action.equals("editDealCompany")) {
            company = new Company();
            int idCompany = deal.getCompany().getId();
            int idAddress = deal.getCompany().getAddress().getId();

            try {
                company = companyService.getById(idCompany);
                address = addressService.getById(idAddress);
            } catch (DaoException e) {
                e.printStackTrace();
            }

            str = getNameCompanyFromRequest(request) + "; \n";
            str += getPhoneFromRequest(request) + "; \n";
            str += getEmailFromRequest(request) + "; \n";
            str += getWebFromRequest(request) + "; \n";
            str += getCountryFromRequest(request) + "; \n";
            str += getCityFromRequest(request) + "; \n";
            str += getStreetFromRequest(request) + "; \n";
            str += getZipcodeFromRequest(request) + "; \n";
            str += getBuildingFromRequest(request) + "; \n";
            str += getRoomFromRequest(request) + " \n";

            addressUpdate();
            company.setAddress(address);
            User user = new User();
            user.setId(1); //TODO: change to user under which the logged in
            company.setResponsibleUser(user);
            company.setDeleted(false);
            companyUpdate();
            out.print(str);

        }
    }
//    public List<Contact> contactsFromDeal(Deal deal) {
//        List<Contact> contacts = new ArrayList<>();
//        for (int i = 0; i < deal.getDealContact().size(); ++i) {
//            contacts.add(deal.getDealContact().get(i));
//        }
//        return contacts;
//    }


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

}
