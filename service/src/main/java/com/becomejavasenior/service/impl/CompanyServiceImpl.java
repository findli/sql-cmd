package com.becomejavasenior.service.impl;

import com.becomejavasenior.DAO.CompanyDAO;
import com.becomejavasenior.DAO.DAOException;
import com.becomejavasenior.DAO.Imp.CompanyDAOImpl;
import com.becomejavasenior.bean.Company;
import com.becomejavasenior.service.CompanyService;

import java.util.List;

public class CompanyServiceImpl implements CompanyService {

    private CompanyDAO<Company> companyDAO = new CompanyDAOImpl();

    @Override
    public Company create(Company company) throws DAOException {
        return companyDAO.create(company);
    }

    @Override
    public void delete(int id) throws DAOException {
        companyDAO.delete(id);
    }

    @Override
    public List<Company> getAll() throws DAOException, ClassNotFoundException {
        return companyDAO.getAll();
    }

    @Override
    public Company getById(int id) throws DAOException {
        return companyDAO.getById(id);
    }

    @Override
    public void update(Company company) throws DAOException {
        companyDAO.update(company);
    }
}
