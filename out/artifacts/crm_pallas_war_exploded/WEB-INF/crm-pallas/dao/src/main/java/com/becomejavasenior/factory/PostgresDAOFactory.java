package com.becomejavasenior.factory;

import com.becomejavasenior.DAO.*;
import com.becomejavasenior.DAO.Imp.*;
import com.becomejavasenior.DataBaseUtil;

import java.sql.Connection;
import java.sql.SQLException;

/**
 * Created by Artem on 20.11.2016.
 */
public class PostgresDAOFactory extends AbstractDAOFactory {


    public static Connection getConnection() throws SQLException {
        return DataBaseUtil.getConnection();
    }

    @Override
    public CompanyDAO getCompanyDAO() {
        return new CompanyDAOImpl();
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
        return new UserDAOImpl();
    }

    @Override
    public ContactDAO getContactDAO() {
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


}
