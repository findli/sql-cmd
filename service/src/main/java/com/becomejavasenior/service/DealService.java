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
    List<Deal> getDealsForList(int id);
    List<Deal> getDealsForList();
    void createNewDeal(Deal deal, Contact contact, Task task, Company company, Note note) throws DaoException, ClassNotFoundException;
    List<Contact> getContactsByDealName(String dealName);
    List<Stage> getAllStage();
    List<Deal> getAllDealsByStage(String stage);
    List getDealsForDashboard() throws DaoException, ClassNotFoundException;
    List<Deal> getListDealWithTask() throws DaoException, ClassNotFoundException;
    List<Deal> getListDealWithNotTask() throws DaoException, ClassNotFoundException;


}