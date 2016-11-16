package com.becomejavasenior.service.impl;

import com.becomejavasenior.DAO.DAOException;
import com.becomejavasenior.DAO.DealDAO;
import com.becomejavasenior.DAO.Imp.DealDAOImpl;
import com.becomejavasenior.bean.Deal;
import com.becomejavasenior.service.DealService;

import java.util.List;

public class DealServiceImpl implements DealService {

    private DealDAO dealDao = new DealDAOImpl();
    private Deal deal = new Deal();


    public Deal create (Deal deal) throws DAOException {
        return (Deal)dealDao.create(deal);
    }

    public void update(Deal deal) throws DAOException {
        dealDao.update(deal);
    }

    public Deal getById(int id) throws DAOException {
        return (Deal)dealDao.getById(id);
    }


    public void delete(int id) throws DAOException {
        dealDao.delete(id);
    }

    public List<Deal> getAll() throws DAOException {
        return dealDao.getAll();
    }
}
