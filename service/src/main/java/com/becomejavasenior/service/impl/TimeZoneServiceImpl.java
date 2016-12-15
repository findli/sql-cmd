package com.becomejavasenior.service.impl;

import com.becomejavasenior.DAO.DaoException;
import com.becomejavasenior.DAO.Imp.TimeZoneDaoImpl;
import com.becomejavasenior.DAO.TimeZoneDao;
import com.becomejavasenior.bean.TimeZone;
import com.becomejavasenior.service.TimeZoneService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service(value = "timeZoneService")
public class TimeZoneServiceImpl implements TimeZoneService{

    private TimeZoneDao timeZoneDao;

    @Autowired
    public TimeZoneServiceImpl(TimeZoneDao timeZoneDao) {
        this.timeZoneDao = timeZoneDao;
    }

    @Override
    public TimeZone create(TimeZone timeZone) throws DaoException {
        return (TimeZone) timeZoneDao.create(timeZone);
    }

    @Override
    public void delete(int id) throws DaoException {
        timeZoneDao.delete(id);
    }

    @Override
    public List<TimeZone> getAll() throws DaoException, ClassNotFoundException {
        System.out.println("THIS");
        return timeZoneDao.getAll();
    }

    @Override
    public TimeZone getById(int id) throws DaoException {
        return (TimeZone) timeZoneDao.getById(id);
    }

    @Override
    public void update(TimeZone timeZone) throws DaoException {
        timeZoneDao.update(timeZone);
    }
}
