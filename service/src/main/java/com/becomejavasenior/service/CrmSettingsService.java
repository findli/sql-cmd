package com.becomejavasenior.service;


import com.becomejavasenior.DAO.DaoException;
import com.becomejavasenior.bean.CrmSettings;

import java.util.List;

public interface CrmSettingsService {
    CrmSettings create(CrmSettings crmSettings) throws DaoException;
    void update(CrmSettings crmSettings) throws DaoException;
    List<CrmSettings> getAll() throws DaoException, ClassNotFoundException;
    CrmSettings getById(int id) throws DaoException;
    void delete(int id) throws DaoException;
}
