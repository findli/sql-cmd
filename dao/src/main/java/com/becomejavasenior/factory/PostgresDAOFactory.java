package com.becomejavasenior.factory;

import com.becomejavasenior.DAO.*;
import com.becomejavasenior.DAO.Imp.*;
import com.becomejavasenior.DataBaseUtil;
//import org.postgresql.jdbc2.optional.ConnectionPool;

import java.sql.Connection;
import java.sql.SQLException;

public class PostgresDAOFactory extends AbstractDAOFactory {

    public static Connection getConnection() throws SQLException {
        return DataBaseUtil.getConnection();
    }

    @Override
    public CompanyDAO getCompanyDAO() {
        return new CompanyDAOImpl();
    }

    @Override
    public ContactDAO getContactDAO() {
        return new ContactDAOImpl();
    }

    @Override
    public DealDAO getDealDAO() {
        return new DealDAOImpl();
    }

    @Override
    public TaskDAO getTaskDAO() {
        return new TaskDAOImpl();
    }

    @Override
    public UserDAO getUserDAO() {
        return null;
    }

    @Override
    public StageDAO getStageDAO() {
        return new StageDAOImpl();
    }

    @Override
    public PeriodInDaysTypeDAO getPeriodInDaysTypeDAO() {
        return new PeriodInDaysTypeDAOImpl();
    }

    @Override
    public TaskTypeDAO getTaskTypeDAO() {
        return new TaskTypeDAOImpl();
    }

    @Override
    public AddressDAO getAddressDAO() {
        return new AddressDAOImpl();
    }
}
