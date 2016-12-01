package com.becomejavasenior.service;

import com.becomejavasenior.DAO.DaoException;
import com.becomejavasenior.bean.Address;
import com.becomejavasenior.bean.Company;
import com.becomejavasenior.bean.Task;

import java.util.List;

public interface CompanyService {

    Company create(Company t) throws DaoException;

    void update(Company t) throws DaoException;

    List<Company> getAll() throws DaoException, ClassNotFoundException;

    Company getById(int id) throws DaoException;

    void delete(int id) throws DaoException;

    void createNewCompany(Company company, Address address, Task task);

}

