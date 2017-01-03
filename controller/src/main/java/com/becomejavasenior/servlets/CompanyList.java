package com.becomejavasenior.servlets;

import com.becomejavasenior.DAO.DaoException;
import com.becomejavasenior.service.CompanyService;
import com.becomejavasenior.service.impl.CompanyServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;


import java.util.Map;

@Controller
public class CompanyList {

    private CompanyService companyService;


    @RequestMapping(value = "/company", method = RequestMethod.GET)
    public String getListCompany(Map<String, Object> company) throws ClassNotFoundException, DaoException {
        company.put("company", companyService.getAll());
        return "/pages/company";
    }

    @Autowired
    public void setCompanyService(CompanyServiceImpl companyService) {
        this.companyService = companyService;
    }
}
