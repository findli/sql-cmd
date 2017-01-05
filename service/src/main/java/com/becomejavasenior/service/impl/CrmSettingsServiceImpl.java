package com.becomejavasenior.service.impl;

import com.becomejavasenior.DAO.CrmSettingsDao;
import com.becomejavasenior.DAO.DaoException;
import com.becomejavasenior.DAO.Imp.CrmSettingsDaoImpl;
import com.becomejavasenior.bean.CrmSettings;
import com.becomejavasenior.service.CrmSettingsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service(value = "crmSettingsService")
public class CrmSettingsServiceImpl implements CrmSettingsService{

    private final CrmSettingsDao crmSettingsDao;

    @Autowired
    public CrmSettingsServiceImpl(CrmSettingsDao crmSettingsDao) {
        this.crmSettingsDao = crmSettingsDao;
    }

    @Override
    public CrmSettings create(CrmSettings crmSettings) throws DaoException {
        return (CrmSettings) crmSettingsDao.create(crmSettings);
    }

    @Override
    public void delete(int id) throws DaoException {
        crmSettingsDao.delete(id);
    }

    @Override
    public List<CrmSettings> getAll() throws DaoException, ClassNotFoundException {
        return crmSettingsDao.getAll();
    }

    @Override
    public CrmSettings getById(int id) throws DaoException {
        return (CrmSettings) crmSettingsDao.getById(id);
    }

    @Override
    public void update(CrmSettings crmSettings) throws DaoException {
        crmSettingsDao.update(crmSettings);
    }
}