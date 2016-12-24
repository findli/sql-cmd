package com.becomejavasenior.service.impl;

import com.becomejavasenior.DAO.CrmCurrencyDao;
import com.becomejavasenior.DAO.DaoException;
import com.becomejavasenior.DAO.Imp.CrmCurrencyDaoImpl;
import com.becomejavasenior.bean.CrmCurrency;
import com.becomejavasenior.service.CrmCurrencyService;

import java.util.List;

public class CrmCurrencyServiceImpl implements CrmCurrencyService{

    CrmCurrencyDao<CrmCurrency> crmCurrencyDao = new CrmCurrencyDaoImpl();

    @Override
    public CrmCurrency create(CrmCurrency crmCurrency) throws DaoException {
        return crmCurrencyDao.create(crmCurrency);
    }

    @Override
    public void delete(int id) throws DaoException {
        crmCurrencyDao.delete(id);
    }

    @Override
    public List<CrmCurrency> getAll() throws DaoException, ClassNotFoundException {
        return crmCurrencyDao.getAll();
    }

    @Override
    public CrmCurrency getById(int id) throws DaoException {
        return crmCurrencyDao.getById(id);
    }

    @Override
    public void update(CrmCurrency crmCurrency) throws DaoException {
        crmCurrencyDao.update(crmCurrency);
    }
}
