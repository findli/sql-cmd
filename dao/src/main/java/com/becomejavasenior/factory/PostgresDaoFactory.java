package com.becomejavasenior.factory;

import com.becomejavasenior.DAO.*;
import com.becomejavasenior.DAO.Imp.*;
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
    public CompanyDao getCompanyDao() {
        return new CompanyDaoImpl(dataSource);
    }

 /*   @Override
    public ContactDao getContactDao() {
        return new ContactDaoImpl(dataSource);
    }*/

//    @Override
//    public DealDao getDealDao() {
//        return new DealDaoJdbcTemplateImpl(dataSource);
//    }

/*    @Override
    public TaskDao getTaskDao() {
        return new TaskDaoImpl(dataSource);
    } */

    @Override
    public UserDao getUserDao() {
        return new UserDaoImpl(dataSource);
    }

    @Override
    public StageDao getStageDao() {
        return new StageDaoImpl(dataSource);
    }

//    @Override
//    public PeriodInDaysTypeDao getPeriodInDaysTypeDao() {
//        return new PeriodInDaysTypeDaoImpl(dataSource);
//    }

//    @Override
//    public TaskTypeDao getTaskTypeDao() {
//        return new TaskTypeDaoImpl(dataSource);
//    }

    @Override
    public AddressDao getAddressDao() {
        return new AddressDaoImpl(dataSource);
    }

}