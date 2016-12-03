package com.becomejavasenior.service.impl;

import com.becomejavasenior.DAO.ContactDao;
import com.becomejavasenior.DAO.DaoException;
import com.becomejavasenior.DAO.Imp.ContactDaoImpl;
import com.becomejavasenior.bean.Contact;
import com.becomejavasenior.service.ContactService;
import org.apache.log4j.Logger;

import java.util.List;

public class ContactServiceImpl implements ContactService {
    public static Logger log = Logger.getLogger(CompanyServiceImpl.class);

    private ContactDao<Contact> contactDao = new ContactDaoImpl();

    @Override
    public Contact create(Contact contact) throws DaoException {
        return contactDao.create(contact);
    }

    @Override
    public void update(Contact contact) throws DaoException {
        contactDao.update(contact);
    }

    @Override
    public List<Contact> getAll() throws DaoException, ClassNotFoundException {
        return contactDao.getAll();
    }

    @Override
    public Contact getById(int id) throws DaoException {
        return contactDao.getById(id);
    }

    @Override
    public void delete(int id) throws DaoException {
        contactDao.delete(id);
    }

    @Override
    public List<Contact> getContactsForList(int id) {
        return contactDao.getContactsForList(id);
    }
}
