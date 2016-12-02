package com.becomejavasenior.factory;

import com.becomejavasenior.DAO.*;
import com.becomejavasenior.DAO.Imp.*;
import com.becomejavasenior.DAO.StageDao;
import com.becomejavasenior.DataBaseUtil;

import java.sql.Connection;
import java.sql.SQLException;

public class PostgresDAOFactory extends AbstractDAOFactory {

    public static Connection getConnection() throws SQLException {
        return DataBaseUtil.getConnection();
    }

    @Override
    public CompanyDao getCompanyDAO() {
        return new CompanyDaoImpl();
    }

    @Override
    public ContactDao getContactDAO() {
        return new ContactDaoImpl();
    }

    @Override
    public DealDao getDealDAO() {
        return new DealDaoImpl();
    }

    @Override
    public TaskDao getTaskDAO() {
        return new TaskDaoImpl();
    }

    @Override
    public UserDao getUserDAO() {
        return new UserDaoImpl();
    }

    @Override
    public StageDao getStageDAO() {
        return new StageDaoImpl();
    }

    @Override
    public PeriodInDaysTypeDao getPeriodInDaysTypeDAO() {
        return new PeriodInDaysTypeDaoImpl();
    }

    @Override
    public TaskTypeDao getTaskTypeDAO() {
        return new TaskTypeDaoImpl();
    }

    @Override
    public AddressDao getAddressDAO() {
        return new AddressDaoImpl();
    }
}
