package com.becomejavasenior.service;

import com.becomejavasenior.DAO.DaoException;
import com.becomejavasenior.bean.*;

import java.util.List;


public interface ContactService {

    Contact create(Contact t) throws DaoException;

    void update(Contact t) throws DaoException;

    List<Contact> getAll() throws DaoException, ClassNotFoundException;

    Contact getById(int id) throws DaoException;

    void delete(int id) throws DaoException;

    List getContactsForList(int id);

    void createNewContact(Contact contact, Deal deal, Company company,
                          Task task) throws DaoException, ClassNotFoundException;
}