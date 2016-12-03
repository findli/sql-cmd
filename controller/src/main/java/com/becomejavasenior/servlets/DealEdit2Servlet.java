package com.becomejavasenior.servlets;

import com.becomejavasenior.DAO.DaoException;
import com.becomejavasenior.bean.*;
import com.becomejavasenior.service.*;
import com.becomejavasenior.service.impl.*;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

@Deprecated
@WebServlet(name = "dealEdit2Servlet", urlPatterns = "/dealEdit2")
public class DealEdit2Servlet extends HttpServlet {
    DealService dealService = new DealServiceImpl();
    CompanyService companyService = new CompanyServiceImpl();
    AddressService addressService = new AddressServiceImpl();
    String str = null;
    Deal deal;
    Company company;
    Address address;

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        response.setContentType("text/plain");
        PrintWriter out = response.getWriter();

        String action = request.getParameter("action");
        int idDeal = Integer.parseInt(request.getParameter("idDeal"));
        deal = new Deal();

        try {
            deal = dealService.getById(idDeal);
        } catch (DaoException e) {
            e.printStackTrace();
        }

        if (action.equals("editDealDeal")) {

            str = getNameDealFromRequest(request) + "; \n";
            try {
                str += getStageFromRequest(request) + "; \n";
                str += getBudgetFromRequest(request) + "; \n";
                str += getUserFromRequest(request) + "; \n";
            } catch (DaoException e) {
                e.printStackTrace();
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
            companyUpdate();
            out.print(str);

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

        StageService stageService = new StageServiceImpl();
        String dealNewStage = request.getParameter("newStage");
        Stage stage = stageService.getByName(dealNewStage);
        deal.setStage(stage);

        return "Stage = " + deal.getStage().getTitle();
    }

    public String getUserFromRequest(HttpServletRequest request) throws DaoException, ClassNotFoundException {

        UserService userService = new UserServiceImpl();
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