package com.becomejavasenior.DAO.Imp;

import com.becomejavasenior.DAO.AbstractDAO;
import com.becomejavasenior.bean.Address;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class AddressDaoJdbcImpl extends AbstractDAOImpl<Address> implements AbstractDAO<Address>{

    public static Logger log = Logger.getLogger(AddressDaoJdbcImpl.class.getName());

    public void createStatement(PreparedStatement preparedStatement, Address entity) {

        try {

        } catch (SQLException e){

        }
    }

    public void updateStatement(PreparedStatement preparedStatement, Address entity) {

    }

    public Address getEntity(ResultSet resultSet) {

        return null;
    }

    public String getCreateQuery() {
        return "INSERT INTO address (country, city, street, building_number, zipcode, office_room) VALUES (?, ?, ?, ?, ?, ?)";
    }

    public String getUpdateQuery() {
        return "UPDATE address SET country = ?, city = ?, street = ?, building_number = ?, zipcode = ?, office_room = ?";
    }

    public String getDeleteQuery() {
        return "DELETE FROM address WHERE id = ?";
    }

    public String getByIdQuery() {
        return "SELECT * FROM address WHERE id = ?";
    }

    public String getAllQuery() {
        return "SELECT * FROM address";
    }
}