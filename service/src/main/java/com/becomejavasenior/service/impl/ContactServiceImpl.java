package com.becomejavasenior.service.impl;

import com.becomejavasenior.DAO.ContactDAO;
import com.becomejavasenior.DAO.DaoException;
import com.becomejavasenior.DAO.Imp.ContactDAOImpl;
import com.becomejavasenior.bean.Contact;
import com.becomejavasenior.service.ContactService;
import org.apache.log4j.Logger;

import java.util.List;

public class ContactServiceImpl implements ContactService {

    public static Logger log = Logger.getLogger(CompanyServiceImpl.class);

    private ContactDAO<Contact> contactDAO = new ContactDAOImpl();

    @Override
    public Contact create(Contact contact) throws DaoException {
        return contactDAO.create(contact);
    }

    @Override
    public void update(Contact contact) throws DaoException {
        contactDAO.update(contact);
    }

    @Override
    public List<Contact> getAll() throws DaoException, ClassNotFoundException {
        return contactDAO.getAll();
    }

    @Override
    public Contact getById(int id) throws DaoException {
        return contactDAO.getById(id);
    }

    @Override
    public void delete(int id) throws DaoException {
        contactDAO.delete(id);
    }
}
