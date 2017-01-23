package com.becomejavasenior.service;


import com.becomejavasenior.DAO.DaoException;
import com.becomejavasenior.bean.PeriodInDaysType;

import java.util.List;

public interface PeriodInDaysTypeService {
    PeriodInDaysType getById(int id) throws DaoException;
    List<PeriodInDaysType> getAll() throws DaoException, ClassNotFoundException;
}
