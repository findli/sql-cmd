package com.becomejavasenior.service;

import com.becomejavasenior.DAO.DaoException;
import com.becomejavasenior.bean.Phone;
import com.becomejavasenior.bean.PhoneType;

import java.util.List;

public interface PhoneService {
    Phone create(Phone t) throws DaoException;
    void update(Phone t) throws DaoException;
    List<Phone> getAll() throws DaoException, ClassNotFoundException;
    Phone getById(int id) throws DaoException;
    void delete(int id) throws DaoException;
    Phone getByName(String str) throws DaoException, ClassNotFoundException;
    List<PhoneType> getAllPhoneTypes() throws DaoException, ClassNotFoundException;
}
