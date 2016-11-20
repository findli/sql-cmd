package com.becomejavasenior.service;

import com.becomejavasenior.DAO.DAOException;
import com.becomejavasenior.bean.Company;

import java.util.List;

public interface CompanyService {

    Company create(Company t) throws DAOException;
    void update(Company t) throws DAOException;
    List<Company> getAll() throws DAOException, ClassNotFoundException;
    Company getById(int id) throws DAOException;
    void delete(int id) throws DAOException;
}
