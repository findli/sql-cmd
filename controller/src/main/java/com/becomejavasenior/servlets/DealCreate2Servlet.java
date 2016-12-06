package com.becomejavasenior.servlets;

import com.becomejavasenior.DAO.DaoException;
import com.becomejavasenior.bean.Address;
import com.becomejavasenior.bean.Company;
import com.becomejavasenior.bean.User;
import com.becomejavasenior.service.AddressService;
import com.becomejavasenior.service.CompanyService;
import com.becomejavasenior.service.UserService;
import com.becomejavasenior.service.impl.AddressServiceImpl;
import com.becomejavasenior.service.impl.CompanyServiceImpl;
import com.becomejavasenior.service.impl.UserServiceImpl;
import org.apache.log4j.Logger;

import javax.servlet.ServletException;
import javax.servlet.annotation.MultipartConfig;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

@WebServlet(name = "dealCreate2Servlet", urlPatterns = "/dealCreate2")
@MultipartConfig(maxFileSize = 102400)
public class DealCreate2Servlet extends HttpServlet {

    public static Logger log = Logger.getLogger(DealCreate2Servlet.class);
    String str = null;
    Company company;
    Address address;
    AddressService addressService = new AddressServiceImpl();
    CompanyService companyService = new CompanyServiceImpl();
    UserService userService = new UserServiceImpl();

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        response.setContentType("text/plain");
        PrintWriter out = response.getWriter();



        String action = request.getParameter("action");
        company = new Company();
        address = new Address();

        if (action.equals("addDealCompany")) {
            log.trace("Processed form addDealCompany");

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

            try {
                address = addressCreate();
                company.setAddress(address);
                companyCreate();
            } catch (DaoException e) {
                e.printStackTrace();
            }


            out.print(str);


        } else if (action.equals("addDealDeal")) {
//            company = new Company();
//            int idCompany = deal.getCompany().getId();
//            int idAddress = deal.getCompany().getAddress().getId();
//
//            try {
//                company = companyService.getById(idCompany);
//                address = addressService.getById(idAddress);
//            } catch (DaoException e) {
//                e.printStackTrace();
//            }


        }
    }
    public String getNameCompanyFromRequest(HttpServletRequest request) {

        String companyNewName = request.getParameter("title");
//        if(companyNewName.equals(null)) {
//            companyNewName = "";
//        }
        company.setTitle(companyNewName);

        return "Name = " + company.getTitle();
    }
    public String getPhoneFromRequest(HttpServletRequest request) {

        String newPhone = request.getParameter("phone");
//        if(newPhone.equals(null)) {
//            newPhone = "";
//        }
        company.setPhoneNumber(newPhone);

        return "Phone = " + company.getPhoneNumber();
    }
    public String getEmailFromRequest(HttpServletRequest request) {

        String newEmail = request.getParameter("email");
//        if(newEmail.equals(null)) {
//            newEmail = "";
//        }
        company.setEmail(newEmail);

        return "Email = " + company.getEmail();
    }
    public String getWebFromRequest(HttpServletRequest request) {

        String newWeb = request.getParameter("web");
//        if(newWeb.equals(null)) {
//            newWeb = "";
//        }
        company.setWebsite(newWeb);

        return "Web = " + company.getWebsite();
    }
    public String getCountryFromRequest(HttpServletRequest request) {

        String country = request.getParameter("country");
//        if(country.equals(null)) {
//            country = "";
//        }
        address.setCountry(country);

        return "Country = " + address.getCountry();
    }
    public String getCityFromRequest(HttpServletRequest request) {

        String city = request.getParameter("city");
        address.setCity(city);

        return "City = " + address.getCity();
    }
    public String getStreetFromRequest(HttpServletRequest request) {

        String street = request.getParameter("street");
        address.setStreet(street);

        return "Street = " + address.getStreet();
    }
    public String getZipcodeFromRequest(HttpServletRequest request) {

        int zipcode = Integer.valueOf(request.getParameter("zipcode"));
        address.setZipcode(zipcode);

        return "Zipcode = " + address.getZipcode();
    }
    public String getBuildingFromRequest(HttpServletRequest request) {

        String building = request.getParameter("building");
        address.setBuildNum(building);

        return "Building = " + address.getBuildNum();
    }
    public String getRoomFromRequest(HttpServletRequest request) {

        String room = request.getParameter("room");
        address.setOfficeRoom(room);

        return "Building = " + address.getOfficeRoom();
    }
    public Address addressCreate() throws DaoException {
        return addressService.create(address);
    }

    public void companyCreate() throws DaoException {
        company.setDeleted(false);
        User user = userService.getById(1);
        company.setResponsibleUser(user);
        companyService.create(company);
    }
}
