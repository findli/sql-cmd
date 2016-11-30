package com.becomejavasenior.DAO.Imp;

import com.becomejavasenior.DAO.AddressDao;
import com.becomejavasenior.DAO.DaoException;
import com.becomejavasenior.bean.Address;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

public class AddressDaoImpl extends AbstractDaoImpl<Address> implements AddressDao<Address> {

    @Override
    public void createStatement(PreparedStatement statement, Address address) throws DaoException {

        try {

            statement.setString(1, address.getCountry());
            statement.setString(2, address.getCity());
            statement.setString(3, address.getStreet());
            statement.setString(4, address.getBuildNum());
            statement.setInt(5, address.getZipcode());
            statement.setString(6, address.getOfficeRoom());

        } catch (SQLException e) {

            throw new DaoException("Can't create statement for Address", e);

        }
    }

    @Override
    public void updateStatement(PreparedStatement statement, Address address) throws DaoException {

        try {

            statement.setString(1, address.getCountry());
            statement.setString(2, address.getCity());
            statement.setString(3, address.getStreet());
            statement.setString(4, address.getBuildNum());
            statement.setInt(5, address.getZipcode());
            statement.setString(6, address.getOfficeRoom());

        } catch (SQLException e) {

            throw new DaoException("Can't update statement for Address", e);

        }
    }

    @Override
    public Address getByName(String str) throws DaoException, ClassNotFoundException {
        return null;
    }

    @Override
    public Address getEntity(ResultSet resultSet) throws DaoException {

        Address address = new Address();

        try {

            address.setId(resultSet.getInt("id"));
            address.setCountry(resultSet.getString("country"));
            address.setCity(resultSet.getString("city"));
            address.setStreet(resultSet.getString("street"));
            address.setBuildNum(resultSet.getString("building_number"));
            address.setZipcode(resultSet.getInt("zipcode"));
            address.setOfficeRoom(resultSet.getString("office_room"));

        } catch (SQLException e){

            throw new DaoException("Can't get entity for Address", e);

        }

        return address;
    }

    public String getCreateQuery() {
        return "INSERT INTO crm_pallas.address (country, city, street, building_number, zipcode, office_room) VALUES (?, ?, ?, ?, ?, ?)";
    }

    public String getUpdateQuery() {
        return "UPDATE crm_pallas.address SET country = ?, city = ?, street = ?, building_number = ?, zipcode = ?, office_room = ?";
    }

    public String getDeleteQuery() {
        return "DELETE FROM crm_pallas.address WHERE id = ?";
    }

    public String getByIdQuery() {
        return "SELECT * FROM crm_pallas.address WHERE id = ?";
    }

    public String getAllQuery() {
        return "SELECT * FROM crm_pallas.address";
    }

    @Override
    public List<Address> getByFilter(String query) {
        return null;
    }

}
