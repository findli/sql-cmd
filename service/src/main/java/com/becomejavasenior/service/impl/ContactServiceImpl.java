package com.becomejavasenior.service.impl;


import com.becomejavasenior.DAO.*;
import com.becomejavasenior.DAO.Imp.*;
import com.becomejavasenior.bean.*;
import com.becomejavasenior.service.ContactService;
import org.apache.log4j.Logger;

import java.util.List;

public class ContactServiceImpl implements ContactService {

    public static Logger log = Logger.getLogger(CompanyServiceImpl.class);

    private final CompanyDao companyDao = new CompanyDaoImpl();
    private final UserDao userDao = new UserDaoImpl();
    private final ContactDao contactDao = new ContactDaoImpl();
    private final TaskDao taskDao = new TaskDaoImpl();
    private final DealDao dealDao = new DealDaoImpl();
    private final StageDao stageDao = new StageDaoImpl();
    private final TagDao tagDao = new TagDaoImpl();//TODO: create

    private ContactDao<Contact> contactDAO = new ContactDaoImpl();

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