package com.becomejavasenior.service.impl;

import com.becomejavasenior.DAO.AddressDao;
import com.becomejavasenior.DAO.DaoException;
import com.becomejavasenior.DAO.Imp.AddressDaoImpl;
import com.becomejavasenior.bean.Address;
import com.becomejavasenior.service.AddressService;
import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/*@Service(value = "addressService")*/
public class AddressServiceImpl implements AddressService {

    public static Logger log = Logger.getLogger(AddressServiceImpl.class);

    private AddressDao addressDao;

    @Autowired
    public AddressServiceImpl(AddressDao addressDao) {
        this.addressDao = addressDao;
    }

    @Override
    public Address create(Address address) throws DaoException {
        return (Address) addressDao.create(address);
    }

    @Override
    public Address update(Address address) throws DaoException {
        return (Address) addressDao.update(address);
    }

    @Override
    public List<Address> getAll() throws DaoException, ClassNotFoundException {
        return addressDao.getAll();
    }

    @Override
    public Address getById(int id) throws DaoException {
        return (Address) addressDao.getById(id);
    }

    @Override
    public void delete(int id) throws DaoException {
        addressDao.delete(id);
    }

    @Override
    public Address getByName(String name) throws DaoException, ClassNotFoundException {
        return (Address) addressDao.getByName(name);
    }
}
