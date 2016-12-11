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

@Service(value = "addressService")
public class AddressServiceImpl implements AddressService {

    public static Logger log = Logger.getLogger(AddressServiceImpl.class);

    private AddressDao addressDAO;

    @Autowired
    public AddressServiceImpl(AddressDao addressDAO) {
        this.addressDAO = addressDAO;
    }

    @Override
    public Address create(Address address) throws DaoException {
        return (Address) addressDAO.create(address);
    }

    @Override
    public Address update(Address address) throws DaoException {
        return (Address) addressDAO.update(address);
    }

    @Override
    public List<Address> getAll() throws DaoException, ClassNotFoundException {
        return addressDAO.getAll();
    }

    @Override
    public Address getById(int id) throws DaoException {
        return (Address) addressDAO.getById(id);
    }

    @Override
    public void delete(int id) throws DaoException {
        addressDAO.delete(id);
    }

    @Override
    public Address getByName(String name) throws DaoException, ClassNotFoundException {
        return (Address) addressDAO.getByName(name);
    }
}
