package com.becomejavasenior.service.impl;

import com.becomejavasenior.DAO.*;
import com.becomejavasenior.DAO.Imp.*;
import com.becomejavasenior.DAO.StageDao;
import com.becomejavasenior.bean.*;
import com.becomejavasenior.service.DealService;

import java.util.List;

public class DealServiceImpl implements DealService {
//    private final CompanyDao companyDao = PostgresDAOFactory.getDAOFactory(AbstractDAOFactory.POSTGRESQL).getCompanyDAO();
//    private final UserDao userDao = PostgresDAOFactory.getDAOFactory(AbstractDAOFactory.POSTGRESQL).getUserDAO();
//    private final ContactDao contactDao = PostgresDAOFactory.getDAOFactory(AbstractDAOFactory.POSTGRESQL).getContactDAO();
//    private final TaskDao taskDao = PostgresDAOFactory.getDAOFactory(AbstractDAOFactory.POSTGRESQL).getTaskDAO();
//    private final DealDao dealDao = PostgresDAOFactory.getDAOFactory(AbstractDAOFactory.POSTGRESQL).getDealDAO();
//    private final StageDao stageDao = PostgresDAOFactory.getDAOFactory(AbstractDAOFactory.POSTGRESQL).getStageDAO();
    private final CompanyDao companyDao = new CompanyDaoImpl();
    private final UserDao userDao = new UserDaoImpl();
    private final ContactDao contactDao = new ContactDaoImpl();
    private final TaskDao taskDao = new TaskDaoImpl();
    private final DealDao dealDao = new DealDaoImpl();
    private final StageDao stageDao = new StageDaoImpl();



    public Deal create (Deal deal) throws DaoException {
        return (Deal) dealDao.create(deal);
    }

    public Deal update(Deal deal) throws DaoException {
        return (Deal) dealDao.update(deal);
    }

    public Deal getById(int id) throws DaoException {
        return (Deal)dealDao.getById(id);
    }


    public void delete(int id) throws DaoException {
        dealDao.delete(id);
    }

    public List<Deal> getAll() throws DaoException, ClassNotFoundException {
        return dealDao.getAll();
    }
    @Override
    public List<Contact> getContactsByDealName(String dealName) {
        return dealDao.getContactsByDealName(dealName);
    }


    @Override
    public List<Deal> getDealsForList() {
        return dealDao.getDealsForList();
    }

    @Override
    public void createNewDeal(Deal deal, Contact contact, Task task2, Company company, File file2) throws DaoException, ClassNotFoundException {

        contact = contactWithId(contact);
        deal.setPrimaryContact(contact);

        company = companyWithId(company);
        deal.setCompany(company);

        Stage stage;
        stage = (Stage) stageDao.getById(1);
        deal.setStage(stage);

        User user = responsibleUserWithId(deal.getResponsibleUser());
        deal.setResponsibleUser(user);

        dealDao.create(deal);

    }

// Необходимо править
    public Contact contactWithId(Contact contact) throws ClassNotFoundException, DaoException {
//        List<Contact> contacts = contactDao.getAll();
//        for(int i = 0; i < contacts.size(); i++) {
//            if(contacts.get(i).getlName().equals(contact.getlName())) {
//                contact = contacts.get(i);
//                break;
//            }
//        }
        contact = (Contact) contactDao.getById(1);
        return contact;
    }

    public User responsibleUserWithId(User user) throws ClassNotFoundException, DaoException {
        List<User> users = userDao.getAll();
        for(int i = 0; i < users.size(); i++) {
            if(users.get(i).getlName().equals(user.getlName())) {
                user = users.get(i);
                break;
            }
        }
        return user;
    }

    public Company companyWithId(Company company) throws ClassNotFoundException, DaoException {

        List<Company> companies = companyDao.getAll();
        for(int i = 0; i < companies.size(); i++) {
            if(companies.get(i).getTitle().equals(company.getTitle())) {
                company = companies.get(i);
                break;
            }
        }
        return company;
    }
}