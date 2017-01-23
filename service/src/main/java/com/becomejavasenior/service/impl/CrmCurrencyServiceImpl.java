package com.becomejavasenior.service.impl;

import com.becomejavasenior.DAO.CrmCurrencyDao;
import com.becomejavasenior.DAO.DaoException;
import com.becomejavasenior.DAO.Imp.CrmCurrencyDaoImpl;
import com.becomejavasenior.bean.CrmCurrency;
import com.becomejavasenior.service.CrmCurrencyService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service(value = "crmCurrencyService")
public class CrmCurrencyServiceImpl implements CrmCurrencyService{

    private final CrmCurrencyDao crmCurrencyDao;

    @Autowired
    public CrmCurrencyServiceImpl(CrmCurrencyDao crmCurrencyDao) {
        this.crmCurrencyDao = crmCurrencyDao;
    }

    @Override
    public CrmCurrency create(CrmCurrency crmCurrency) throws DaoException {
        return (CrmCurrency) crmCurrencyDao.create(crmCurrency);
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
        return (CrmCurrency) crmCurrencyDao.getById(id);
    }

    @Override
    public void update(CrmCurrency crmCurrency) throws DaoException {
        crmCurrencyDao.update(crmCurrency);
    }
}