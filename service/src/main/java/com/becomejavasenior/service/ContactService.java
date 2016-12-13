package com.becomejavasenior.service;

import com.becomejavasenior.DAO.DaoException;
import com.becomejavasenior.bean.Contact;
import com.becomejavasenior.bean.File;
import com.becomejavasenior.bean.Tag;

import java.util.List;


public interface ContactService {

    Contact create(Contact t) throws DaoException;

    void update(Contact t) throws DaoException;

    List<Contact> getAll() throws DaoException, ClassNotFoundException;

    Contact getById(int id) throws DaoException;

    void delete(int id) throws DaoException;

    List getContactsForList(int id);

    public void createNewContact(Contact contact, Tag tag, File file) throws DaoException, ClassNotFoundException;;

}