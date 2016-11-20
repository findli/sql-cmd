package com.becomejavasenior.service.impl;

import com.becomejavasenior.DAO.DAOException;
import com.becomejavasenior.DAO.DealDAO;
import com.becomejavasenior.bean.Deal;
import com.becomejavasenior.service.DealService;

import java.util.List;

/**
 * Created by Artem on 20.11.2016.
 */
public class DealServiceImpl implements DealService {


    DealDAO dealDAO = (DealDAO) new DealServiceImpl();
    @Override
    public List<Deal> getAll() throws DAOException, ClassNotFoundException {
        return dealDAO.getAll();
    }
}
