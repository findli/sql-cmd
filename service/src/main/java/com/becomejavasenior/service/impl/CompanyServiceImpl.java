package com.becomejavasenior.service.impl;

import com.becomejavasenior.DAO.CompanyDao;
import com.becomejavasenior.DAO.DaoException;
import com.becomejavasenior.DAO.Imp.CompanyDaoImpl;
import com.becomejavasenior.bean.Company;
import com.becomejavasenior.service.CompanyService;
import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service(value = "companyService")
public class CompanyServiceImpl implements CompanyService {

    public static Logger log = Logger.getLogger(CompanyServiceImpl.class);

    private CompanyDao companyDAO;

    @Autowired
    public CompanyServiceImpl(CompanyDao companyDAO) {
        this.companyDAO = companyDAO;
    }

    @Override
    public Company create(Company company) throws DaoException {
        return (Company) companyDAO.create(company);
    }

    @Override
    public void delete(int id) throws DaoException {
        companyDAO.delete(id);
    }

    @Override
    public List<Company> getAll() throws DaoException, ClassNotFoundException {
        log.trace("getAll() in CompanyServiceImpl");
        return companyDAO.getAll();
    }

    @Override
    public Company getById(int id) throws DaoException {
        return (Company) companyDAO.getById(id);
    }

    @Override
    public Company update(Company company) throws DaoException {
        return (Company) companyDAO.update(company);
    }

    @Override
    public Company getByName(String str) throws DaoException, ClassNotFoundException {
        return (Company) companyDAO.getByName(str);
    }
}
