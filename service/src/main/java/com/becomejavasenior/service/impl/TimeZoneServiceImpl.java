package com.becomejavasenior.service.impl;

import com.becomejavasenior.DAO.DaoException;
import com.becomejavasenior.DAO.Imp.TimeZoneDaoImpl;
import com.becomejavasenior.DAO.TimeZoneDao;
import com.becomejavasenior.bean.TimeZone;
import com.becomejavasenior.service.TimeZoneService;

import java.util.List;

public class TimeZoneServiceImpl implements TimeZoneService{

    private TimeZoneDao<TimeZone> timeZoneDao = new TimeZoneDaoImpl();

    @Override
    public TimeZone create(TimeZone timeZone) throws DaoException {
        return timeZoneDao.create(timeZone);
    }

    @Override
    public void delete(int id) throws DaoException {
        timeZoneDao.delete(id);
    }

    @Override
    public List<TimeZone> getAll() throws DaoException, ClassNotFoundException {
        return timeZoneDao.getAll();
    }

    @Override
    public TimeZone getById(int id) throws DaoException {
        return timeZoneDao.getById(id);
    }

    @Override
    public void update(TimeZone timeZone) throws DaoException {
        timeZoneDao.update(timeZone);
    }
}
