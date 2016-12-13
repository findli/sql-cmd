package com.becomejavasenior.service.impl;



import com.becomejavasenior.DAO.DaoException;
import com.becomejavasenior.DAO.Imp.PeriodInDaysTypeDaoImpl;
import com.becomejavasenior.DAO.PeriodInDaysTypeDao;
import com.becomejavasenior.bean.PeriodInDaysType;
import com.becomejavasenior.service.PeriodInDaysTypeService;

import java.util.ArrayList;
import java.util.List;

public class PeriodInDaysTypeServiceImpl implements PeriodInDaysTypeService{

    List<PeriodInDaysType> listPeriods = new ArrayList<PeriodInDaysType>();
    PeriodInDaysTypeDao<PeriodInDaysType> periodDAO = new PeriodInDaysTypeDaoImpl();

    @Override
    public PeriodInDaysType getById(int id) throws DaoException {
        PeriodInDaysType periodInDaysType = periodDAO.getById(id);
        return periodInDaysType;
    }

    @Override
    public List<PeriodInDaysType> getAll() throws DaoException, ClassNotFoundException{
        listPeriods = periodDAO.getAll();
        return  listPeriods;
    }
}
