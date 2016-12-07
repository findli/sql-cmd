package com.becomejavasenior.service;

import com.becomejavasenior.DAO.DaoException;
import com.becomejavasenior.bean.*;

import java.util.List;

public interface DealService {
    Deal create(Deal t) throws DaoException;
    Deal update(Deal t) throws DaoException;
    List<Deal> getAll() throws DaoException, ClassNotFoundException;
    Deal getById(int id) throws DaoException;
    void delete(int id) throws DaoException;
    List<Deal> getDealsForList();
    public void createNewDeal(Deal deal, Contact contact, Task task, Company company, File file) throws DaoException, ClassNotFoundException;

}
