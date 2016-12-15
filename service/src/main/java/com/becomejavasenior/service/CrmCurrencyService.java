package com.becomejavasenior.service;

import com.becomejavasenior.DAO.DaoException;
import com.becomejavasenior.bean.CrmCurrency;

import java.util.List;

public interface CrmCurrencyService {
    CrmCurrency create(CrmCurrency crmCurrency) throws DaoException;
    void update(CrmCurrency crmCurrency) throws DaoException;
    List<CrmCurrency> getAll() throws DaoException, ClassNotFoundException;
    CrmCurrency getById(int id) throws DaoException;
    void delete(int id) throws DaoException;
}
