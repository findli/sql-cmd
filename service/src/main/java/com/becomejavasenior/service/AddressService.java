package com.becomejavasenior.service;

import com.becomejavasenior.DAO.DaoException;
import com.becomejavasenior.bean.Address;

import java.util.List;

public interface AddressService {

    Address create(Address t) throws DaoException;

    Address update(Address t) throws DaoException;

    List<Address> getAll() throws DaoException, ClassNotFoundException;

    Address getById(int id) throws DaoException;

    void delete(int id) throws DaoException;

    Address getByName(String str) throws DaoException, ClassNotFoundException;

}
