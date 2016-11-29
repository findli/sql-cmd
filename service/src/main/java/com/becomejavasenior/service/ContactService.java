package com.becomejavasenior.service;

import com.becomejavasenior.DAO.DaoException;
import com.becomejavasenior.bean.Contact;

import java.util.List;

/**
 * Created by alpo123 on 28.11.16.
 */
public interface ContactService {
    Contact create(Contact t) throws DaoException;

    void update(Contact t) throws DaoException;

    List<Contact> getAll() throws DaoException, ClassNotFoundException;

    Contact getById(int id) throws DaoException;

    void delete(int id) throws DaoException;
}
