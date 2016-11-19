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
    private final CompanyDAO companyDAO = PostgresDAOFactory.getDAOFactory(AbstractDAOFactory.POSTGRESQL).getCompanyDAO();
    private final UserDAO userDAO = PostgresDAOFactory.getDAOFactory(AbstractDAOFactory.POSTGRESQL).getUserDAO();
    private final ContactDAO contactDAO = PostgresDAOFactory.getDAOFactory(AbstractDAOFactory.POSTGRESQL).getContactDAO();
    private final TaskDAO taskDAO = PostgresDAOFactory.getDAOFactory(AbstractDAOFactory.POSTGRESQL).getTaskDAO();
    private final DealDAO dealDAO = PostgresDAOFactory.getDAOFactory(AbstractDAOFactory.POSTGRESQL).getDealDAO();
//    private final NoteDAO noteDAO = PostgresDAOFactory.getDAOFactory(AbstractDAOFactory.POSTGRESQL).getNoteDAO();
//    private final TagDAO tagDAO = PostgresDAOFactory.getDAOFactory(AbstractDAOFactory.POSTGRESQL).getTagDAO();
//    private final FileDAO fileDAO = PostgresDAOFactory.getDAOFactory(AbstractDAOFactory.POSTGRESQL).getFileDAO();

    private DealDAO dealDao = new DealDAOImpl();


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
    public int createNewDeal(Company company, Contact contact, Deal deal, Task task, File file) throws DAOException{
        return 0;
    }
}
