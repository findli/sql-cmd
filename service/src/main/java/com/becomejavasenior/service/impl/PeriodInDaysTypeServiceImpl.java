package com.becomejavasenior.service.impl;

import com.becomejavasenior.DAO.DaoException;
import com.becomejavasenior.DAO.Imp.PeriodInDaysTypeDaoImpl;
import com.becomejavasenior.DAO.PeriodInDaysTypeDao;
import com.becomejavasenior.bean.PeriodInDaysType;
import com.becomejavasenior.service.PeriodInDaysTypeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.sql.DataSource;
import java.util.ArrayList;
import java.util.List;

@Service(value = "periodInDaysTypeService")
public class PeriodInDaysTypeServiceImpl implements PeriodInDaysTypeService{

    List<PeriodInDaysType> listPeriods = new ArrayList<PeriodInDaysType>();

    private final PeriodInDaysTypeDao periodDAO;

    @Autowired
    public PeriodInDaysTypeServiceImpl(PeriodInDaysTypeDao periodDAO) {
        this.periodDAO = periodDAO;
    }

    @Override
    public PeriodInDaysType getById(int id) throws DaoException {
        PeriodInDaysType periodInDaysType = (PeriodInDaysType) periodDAO.getById(id);
        return periodInDaysType;
    }

    @Override
    public List<PeriodInDaysType> getAll() throws DaoException, ClassNotFoundException{
        listPeriods = periodDAO.getAll();
        return  listPeriods;
    }
}