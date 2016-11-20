package com.becomejavasenior.service.impl;

import com.becomejavasenior.DAO.*;
import com.becomejavasenior.DAO.Imp.DealDAOImpl;
import com.becomejavasenior.bean.*;
import com.becomejavasenior.factory.AbstractDAOFactory;
import com.becomejavasenior.factory.PostgresDAOFactory;
import com.becomejavasenior.service.DealService;

import java.util.Date;
import java.util.List;

public class DealServiceImpl implements DealService {
    private final CompanyDAO companyDao = PostgresDAOFactory.getDAOFactory(AbstractDAOFactory.POSTGRESQL).getCompanyDAO();
    private final UserDAO userDao = PostgresDAOFactory.getDAOFactory(AbstractDAOFactory.POSTGRESQL).getUserDAO();
    private final ContactDAO contactDao = PostgresDAOFactory.getDAOFactory(AbstractDAOFactory.POSTGRESQL).getContactDAO();
    private final TaskDAO taskDao = PostgresDAOFactory.getDAOFactory(AbstractDAOFactory.POSTGRESQL).getTaskDAO();
    private final DealDAO dealDao = PostgresDAOFactory.getDAOFactory(AbstractDAOFactory.POSTGRESQL).getDealDAO();

    public Deal create (Deal deal) throws DAOException {
        return (Deal) dealDao.create(deal);
    }

    public void update(Deal deal) throws DAOException {
        dealDao.update(deal);
    }

    public Deal getById(int id) throws DAOException {
        return (Deal)dealDao.getById(id);
    }


    public void delete(int id) throws DAOException {
        dealDao.delete(id);
    }

    public List<Deal> getAll() throws DAOException, ClassNotFoundException {
        return dealDao.getAll();
    }

    @Override
    public List<Deal> getDealsForList() {
        return dealDao.getDealsForList();
    }

    @Override
    public void createNewDeal(Deal deal, Contact contact2, Task task2, Company company, File file2) throws DAOException, ClassNotFoundException {
        Contact contact = new Contact();
        contact.setId(1);
        contact.setlName("Ivanishenko");
        deal.setPrimaryContact(contact);

        company = companyWithId(company);
        deal.setCompany(company);

        Stage stage = new Stage();
        stage.setId(1);
        stage.setTitle("Stage");
        deal.setStage(stage);

        deal.setDeleted(false);
        User user = responsibleUserWithId(deal.getResponsibleUser());
        deal.setResponsibleUser(user);

        dealDao.create(deal);

    }

    public User responsibleUserWithId(User user) throws ClassNotFoundException, DAOException {
        List<User> users = userDao.getAll();
        for(int i = 0; i < users.size(); i++) {
            if(users.get(i).getlName().equals(user.getlName())) {
                user = users.get(i);
                break;
            }
        }
        return user;
    }
    public Company companyWithId(Company company) throws ClassNotFoundException, DAOException {
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
