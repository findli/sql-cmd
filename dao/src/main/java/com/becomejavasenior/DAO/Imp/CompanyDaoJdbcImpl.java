package com.becomejavasenior.DAO.Imp;

import com.becomejavasenior.DAO.AbstractDAO;
import com.becomejavasenior.bean.Company;

import java.sql.PreparedStatement;
import java.sql.ResultSet;

public class CompanyDaoJdbcImpl extends AbstractDAOImpl<Company> implements AbstractDAO<Company> {

    void createStatement(PreparedStatement preparedStatement, Company entity) {

    }

    void updateStatement(PreparedStatement preparedStatement, Company entity) {

    }

    Company getEntity(ResultSet resultSet) {
        return null;
    }

    String getCreateQuery() {
        return null;
    }

    String getUpdateQuery() {
        return null;
    }

    String getDeleteQuery() {
        return null;
    }

    String getByIdQuery() {
        return null;
    }

    String getAllQuery() {
        return null;
    }
}