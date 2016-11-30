package com.becomejavasenior.service.impl;

import com.becomejavasenior.DAO.CompanyDao;
import com.becomejavasenior.DAO.DaoException;
import com.becomejavasenior.DAO.Imp.CompanyDaoImpl;
import com.becomejavasenior.bean.Company;
import com.becomejavasenior.service.CompanyService;
import org.apache.log4j.Logger;

import java.util.List;

public class CompanyServiceImpl implements CompanyService {

    public static Logger log = Logger.getLogger(CompanyServiceImpl.class);

    private CompanyDao<Company> companyDAO = new CompanyDaoImpl();

    @Override
    public Company create(Company company) throws DaoException {
        return companyDAO.create(company);
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
        return companyDAO.getById(id);
    }

    @Override
    public void update(Company company) throws DaoException {
        companyDAO.update(company);
    }
}