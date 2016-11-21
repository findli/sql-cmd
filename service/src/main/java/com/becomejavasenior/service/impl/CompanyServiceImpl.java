package com.becomejavasenior.service.impl;

import com.becomejavasenior.DAO.CompanyDAO;
import com.becomejavasenior.DAO.DAOException;
import com.becomejavasenior.DAO.Imp.CompanyDAOImpl;
import com.becomejavasenior.bean.Company;
import com.becomejavasenior.service.CompanyService;

import java.util.List;

public class CompanyServiceImpl implements CompanyService {


    private CompanyDAO<Company> companyDAO = new CompanyDAOImpl();

    public Company create(Company company) throws DAOException {
        return companyDAO.create(company);
    }

    public void delete(int id) throws DAOException {
        companyDAO.delete(id);
    }

    public List<Company> getAll() throws DAOException, ClassNotFoundException {
        return companyDAO.getAll();
    }

    public Company getById(int id) throws DAOException {
        return companyDAO.getById(id);
    }

    public void update(Company company) throws DAOException {
        companyDAO.update(company);
    }
}
