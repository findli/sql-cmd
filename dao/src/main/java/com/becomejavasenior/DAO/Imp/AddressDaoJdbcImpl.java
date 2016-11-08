package com.becomejavasenior.DAO.Imp;

import com.becomejavasenior.DAO.AbstractDAO;
import com.becomejavasenior.DAO.DAOException;
import com.becomejavasenior.DataBaseUtil;
import com.becomejavasenior.bean.Address;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;
import java.util.logging.Logger;

public class AddressDaoJdbcImpl extends AbstractDAOImpl<Address> implements AbstractDAO<Address>{

    public static Logger log = Logger.getLogger(AddressDaoJdbcImpl.class.getName());

    public void createStatement(PreparedStatement statement, Address address) throws DAOException {

        try {

            statement.setString(1, address.getCountry());
            statement.setString(2, address.getCity());
            statement.setString(3, address.getStreet());
            statement.setString(4, address.getBuildNum());
            statement.setInt(5, address.getZipcode());
            statement.setString(6, address.getOfficeRoom());

        } catch (SQLException e) {

            throw new DAOException("Can't create statement for Address", e);

        }
    }

    public void updateStatement(PreparedStatement statement, Address address) throws DAOException {

        try {

            statement.setString(1, address.getCountry());
            statement.setString(2, address.getCity());
            statement.setString(3, address.getStreet());
            statement.setString(4, address.getBuildNum());
            statement.setInt(5, address.getZipcode());
            statement.setString(6, address.getOfficeRoom());

        } catch (SQLException e) {

            throw new DAOException("Can't update statement for Address", e);

        }
    }

    public Address getEntity(ResultSet resultSet) throws DAOException {

        Address address = new Address();

        try {

            address.setId(resultSet.getInt("id"));
            address.setCountry(resultSet.getString("country"));
            address.setCity(resultSet.getString("city"));
            address.setStreet(resultSet.getString("street"));
            address.setBuildNum(resultSet.getString("build_number"));
            address.setZipcode(resultSet.getInt("zipcode"));
            address.setOfficeRoom(resultSet.getString("office_room"));

        } catch (SQLException e){

            throw new DAOException("Can't get entity for Address", e);

        }

        return address;
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

    @Override
    public List<Address> getByFilter(String query) {
        return null;
    }
}