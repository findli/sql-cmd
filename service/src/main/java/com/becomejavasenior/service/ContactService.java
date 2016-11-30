package com.becomejavasenior.service;


import com.becomejavasenior.DAO.DaoException;
import com.becomejavasenior.bean.Company;
import com.becomejavasenior.bean.Contact;
import com.becomejavasenior.bean.User;


import java.util.List;

public interface ContactService {

    public void createNewContact(Company company, Contact contact, User user) throws DaoException, ClassNotFoundException;
    Contact create(Contact t) throws DaoException;
    void update(Contact t) throws DaoException;
    List<Contact> getAll() throws DaoException, ClassNotFoundException;
    Contact getById(int id) throws DaoException;
    void delete(int id) throws DaoException;
    List getContactsForList();
}
