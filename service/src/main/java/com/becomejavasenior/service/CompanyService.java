package com.becomejavasenior.service;

import com.becomejavasenior.DAO.DaoException;
import com.becomejavasenior.bean.Company;

import java.util.List;

public interface CompanyService {

    Company create(Company t) throws DaoException;

    Company update(Company t) throws DaoException;

    List<Company> getAll() throws DaoException, ClassNotFoundException;

    Company getById(int id) throws DaoException;

    void delete(int id) throws DaoException;

    Company getByName(String str) throws DaoException, ClassNotFoundException;
}
