package com.becomejavasenior.service;

import com.becomejavasenior.DAO.DAOException;
import com.becomejavasenior.bean.*;

import java.util.List;

public interface DealService {
    Deal create(Deal t) throws DAOException;
    void update(Deal t) throws DAOException;
    List<Deal> getAll() throws DAOException, ClassNotFoundException;
    Deal getById(int id) throws DAOException;
    void delete(int id) throws DAOException;
    List<Deal> getDealsForList();
    public void createNewDeal(Deal deal) throws DAOException, ClassNotFoundException;

}
