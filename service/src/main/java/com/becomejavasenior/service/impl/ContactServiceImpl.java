package com.becomejavasenior.service.impl;

import com.becomejavasenior.DAO.*;
import com.becomejavasenior.bean.Company;
import com.becomejavasenior.bean.Contact;
import com.becomejavasenior.bean.User;
import com.becomejavasenior.factory.AbstractDAOFactory;
import com.becomejavasenior.factory.PostgresDAOFactory;
import com.becomejavasenior.service.ContactService;

import java.util.List;


public class ContactServiceImpl implements ContactService {

    private final CompanyDao companyDao = PostgresDAOFactory.getDAOFactory(AbstractDAOFactory.POSTGRESQL).getCompanyDAO();
    private final UserDao userDao = PostgresDAOFactory.getDAOFactory(AbstractDAOFactory.POSTGRESQL).getUserDAO();
    private final ContactDao contactDao = PostgresDAOFactory.getDAOFactory(AbstractDAOFactory.POSTGRESQL).getContactDAO();

    @Override
    public void createNewContact(Company company, Contact contact, User user) throws DaoException, ClassNotFoundException {

     /*   company = companyWithId(company);
        contact.setCompany(company);

        User user = responsibleUserWithId(contact.getResponsibleUser());
        contact.setResponsibleUser(user);*/

        company = (Company) companyDao.getById(1);
        contact.setCompany(company);
        user = (User) userDao.getById(1);
        contact.setResponsibleUser(user);

        contactDao.create(contact);
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
    public List<Contact> getContactsForList() {
        return contactDao.getContactsForList();
    }

    private User responsibleUserWithId(User user) throws ClassNotFoundException, DaoException {
        List<User> users = userDao.getAll();
        for (User user1 : users) {
            if (user1.getlName().equals(user.getlName())) {
                user = user1;
                break;
            }
        }
        return user;
    }

    private Company companyWithId(Company company) throws ClassNotFoundException, DaoException {
        List<Company> companies = companyDao.getAll();
        for (Company company1 : companies) {
            if (company1.getTitle().equals(company.getTitle())) {
                company = company1;
                break;
            }
        }
        return company;
    }
}
