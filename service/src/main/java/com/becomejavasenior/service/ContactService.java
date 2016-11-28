package com.becomejavasenior.service;

import com.becomejavasenior.DAO.DAOException;
import com.becomejavasenior.bean.Contact;

import java.util.List;

/**
 * Created by alpo123 on 28.11.16.
 */
public interface ContactService {
    Contact create(Contact t) throws DAOException;

    void update(Contact t) throws DAOException;

    List<Contact> getAll() throws DAOException, ClassNotFoundException;

    Contact getById(int id) throws DAOException;

    void delete(int id) throws DAOException;
}
