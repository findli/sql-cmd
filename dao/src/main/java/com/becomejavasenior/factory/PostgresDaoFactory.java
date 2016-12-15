package com.becomejavasenior.factory;

import com.becomejavasenior.DAO.*;
import com.becomejavasenior.DAO.Imp.*;
import com.becomejavasenior.DAO.StageDao;
import com.becomejavasenior.DataBaseUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.sql.DataSource;
import java.sql.Connection;
import java.sql.SQLException;

@Service
public class PostgresDaoFactory extends AbstractDaoFactory {

//    public static Connection getConnection() throws SQLException {
//        return DataBaseUtil.getConnection();
//    }
    @Autowired
    private DataSource dataSource;

    public Connection getConnection() throws SQLException {
        return dataSource.getConnection();
    }


    @Override
    public CompanyDao getCompanyDAO() {
        return new CompanyDaoImpl(dataSource);
    }

    @Override
    public ContactDao getContactDAO() {
        return new ContactDaoImpl(dataSource);
    }

    @Override
    public DealDao getDealDAO() {
        return new DealDaoImpl(dataSource);
    }

    @Override
    public TaskDao getTaskDAO() {
        return new TaskDaoImpl(dataSource);
    }

    @Override
    public UserDao getUserDAO() {
        return new UserDaoImpl(dataSource);
    }

    @Override
    public StageDao getStageDAO() {
        return new StageDaoImpl(dataSource);
    }

    @Override
    public PeriodInDaysTypeDao getPeriodInDaysTypeDAO() {
        return new PeriodInDaysTypeDaoImpl(dataSource);
    }

    @Override
    public TaskTypeDao getTaskTypeDAO() {
        return new TaskTypeDaoImpl(dataSource);
    }

    @Override
    public AddressDao getAddressDAO() {
        return new AddressDaoImpl(dataSource);
    }
}