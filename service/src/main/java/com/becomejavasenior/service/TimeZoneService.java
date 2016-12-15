package com.becomejavasenior.service;

import com.becomejavasenior.DAO.DaoException;
import com.becomejavasenior.bean.TimeZone;

import java.util.List;

public interface TimeZoneService {
    TimeZone create(TimeZone t) throws DaoException;
    void update(TimeZone t) throws DaoException;
    List<TimeZone> getAll() throws DaoException, ClassNotFoundException;
    TimeZone getById(int id) throws DaoException;
    void delete(int id) throws DaoException;
}
