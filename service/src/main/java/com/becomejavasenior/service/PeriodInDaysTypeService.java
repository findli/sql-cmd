package com.becomejavasenior.service;


import com.becomejavasenior.DAO.DaoException;
import com.becomejavasenior.bean.PeriodInDaysType;

import java.util.List;

public interface PeriodInDaysTypeService {
    public PeriodInDaysType getById(int id) throws DaoException;
    public List<PeriodInDaysType> getAll() throws DaoException, ClassNotFoundException;
}
