package com.becomejavasenior.service;

import com.becomejavasenior.DAO.DAOException;
import com.becomejavasenior.bean.Deal;

import java.util.List;

public interface DealService {
    Deal create(Deal t) throws DAOException;
    void update(Deal t) throws DAOException;
    List<Deal> getAll();
    Deal getById(int id) throws DAOException;
    void delete(int id) throws DAOException;

}
