package com.becomejavasenior.service.impl;

import com.becomejavasenior.DAO.DaoException;
import com.becomejavasenior.DAO.Imp.PhoneDaoImpl;
import com.becomejavasenior.DAO.Imp.PhoneTypeDaoImpl;
import com.becomejavasenior.DAO.PhoneDao;
import com.becomejavasenior.DAO.PhoneTypeDao;
import com.becomejavasenior.bean.Phone;
import com.becomejavasenior.bean.PhoneType;
import com.becomejavasenior.service.PhoneService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import java.util.List;

@Service(value = "phoneService")
public class PhoneServiceImpl implements PhoneService {

    private final PhoneDao phoneDao;
    private final PhoneTypeDao phoneTypeDao;

    @Autowired
    public PhoneServiceImpl(PhoneDao phoneDao, PhoneTypeDao phoneTypeDao) {
        this.phoneDao = phoneDao;
        this.phoneTypeDao = phoneTypeDao;
    }

    @Override
    public Phone create(Phone t) throws DaoException {
        return (Phone) phoneDao.create(t);
    }

    @Override
    public void update(Phone t) throws DaoException {
        phoneDao.update(t);
    }

    @Override
    public List<Phone> getAll() throws DaoException, ClassNotFoundException {
        return phoneDao.getAll();
    }



    @Override
    public Phone getById(int id) throws DaoException {
        return (Phone) phoneDao.getById(id);
    }

    @Override
    public void delete(int id) throws DaoException {
        phoneDao.delete(id);
    }

    @Override
    public Phone getByName(String str) throws DaoException, ClassNotFoundException {
        return null;
    }

    @Override
    public List<PhoneType> getAllPhoneTypes() throws DaoException, ClassNotFoundException {
        return phoneTypeDao.getAll();
    }
}
