package com.becomejavasenior.service;

import com.becomejavasenior.DAO.DAOException;
import com.becomejavasenior.bean.Deal;
import com.becomejavasenior.bean.Stage;

import java.util.List;

public interface DealService {
    Deal create(Deal t) throws DAOException;
    void update(Deal t) throws DAOException;
    List<Deal> getAll() throws DAOException, ClassNotFoundException;
    Deal getById(int id) throws DAOException;
    void delete(int id) throws DAOException;
    List<Stage> getAllStage();
    List<Deal> getDealsForList();

}
