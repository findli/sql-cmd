package com.becomejavasenior.DAO.Imp;

import com.becomejavasenior.DAO.AbstractDAO;
import com.becomejavasenior.bean.Address;

import java.sql.PreparedStatement;
import java.sql.ResultSet;

public class AddressDaoJdbcImpl extends AbstractDAOImpl<Address> implements AbstractDAO<Address>{

    void createStatement(PreparedStatement preparedStatement, Address entity) {

    }

    void updateStatement(PreparedStatement preparedStatement, Address entity) {

    }

    Address getEntity(ResultSet resultSet) {
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