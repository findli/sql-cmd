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

//    private DealDAO dealDao = new DealDAOImpl();


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
    public void createNewDeal(Deal deal) throws DAOException {
        Contact contact = new Contact();
        contact.setId(1);
        contact.setlName("Ivanishenko");
        deal.setPrimaryContact(contact);

        Company company = new Company();
        company.setId(1);
        company.setTitle("BRAVO");
        deal.setCompany(company);

        Stage stage = new Stage();
        stage.setId(1);
        stage.setTitle("Stage");
        deal.setStage(stage);

//        User user = new User();
//        user.setId(1);
//        user.setlName("Agapov");
//        deal.setResponsibleUser(user);

        deal.setDeleted(false);

        dealDao.create(deal);

    }
}
