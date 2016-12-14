package com.becomejavasenior.service.impl;

import com.becomejavasenior.DAO.*;
import com.becomejavasenior.DAO.Imp.*;
import com.becomejavasenior.bean.*;
import com.becomejavasenior.service.ContactService;
import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service(value = "contactService")
public class ContactServiceImpl implements ContactService {

    public static Logger log = Logger.getLogger(CompanyServiceImpl.class);

    private final UserDao userDao;
    private final ContactDao contactDao;

    @Autowired
    public ContactServiceImpl(UserDao userDao,
                              ContactDao contactDao) {
        this.userDao = userDao;
        this.contactDao = contactDao;
    }

    @Override
    public Contact create(Contact contact) throws DaoException {
        return (Contact) contactDao.create(contact);

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
        return (Contact) contactDao.getById(id);
    }

    @Override
    public void delete(int id) throws DaoException {
        contactDao.delete(id);
    }

    @Override
    public List<Contact> getContactsForList(int id) {
        return contactDao.getContactsForList(id);
    }

    @Override
    public void createNewContact(Contact contact, Tag tag, File file) throws DaoException, ClassNotFoundException {
        User user = responsibleUserWithId(contact.getResponsibleUser());
        contact.setResponsibleUser(user);

        contactDao.create(contact);
    }

    public User responsibleUserWithId(User user) throws ClassNotFoundException, DaoException {

        List<User> userList = userDao.getAll();
        for (int i = 0; i < userList.size(); i++) {
            if (userList.get(i).getlName().equals(user.getlName())){
                user = userList.get(i);
                break;
            }
        }

        return user;
    }

}