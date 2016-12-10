package com.becomejavasenior.DAO.Imp;

import com.becomejavasenior.DAO.DaoException;
import com.becomejavasenior.DAO.PhoneDao;
import com.becomejavasenior.bean.Phone;
import com.becomejavasenior.bean.PhoneType;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

public class PhoneDaoImpl extends AbstractDaoImpl<Phone> implements PhoneDao<Phone> {

    @Override
    public Phone getByName(String str) throws DaoException, ClassNotFoundException {
        return null;
    }

    @Override
    public Phone create(Phone entity) throws DaoException {
        return super.create(entity);
    }

    @Override
    void createStatement(PreparedStatement statement, Phone entity) throws DaoException {

        try {

            statement.setString(1, entity.getPhoneType().name());
            statement.setString(2, entity.getPhoneNumber());

        } catch (SQLException e) {

            throw new DaoException("Can't create statement for Phone", e);

        }
    }

    @Override
    void updateStatement(PreparedStatement statement, Phone entity) throws DaoException {
        try {

            statement.setString(1, entity.getPhoneType().name());
            statement.setString(2, entity.getPhoneNumber());

        } catch (SQLException e) {

            throw new DaoException("Can't update statement for Phone", e);

        }
    }

    @Override
    public Phone update(Phone entity) throws DaoException {
        return super.update(entity);
    }

    @Override
    public void delete(Integer id) throws DaoException {
        super.delete(id);
    }

    @Override
    public Phone getById(Integer id) throws DaoException {
        return super.getById(id);
    }

    @Override
    Phone getEntity(ResultSet resultSet) throws DaoException {
        Phone phone = new Phone();
        PhoneType phoneType;

        try {

            phone.setId(resultSet.getInt("id"));
            phone.setPhoneType(phoneType.resultSet.getInt("phone_type_1"));
            phone.setCity(resultSet.getString("city"));
            address.setStreet(resultSet.getString("street"));
            address.setBuildNum(resultSet.getString("building_number"));
            address.setZipcode(resultSet.getInt("zipcode"));
            address.setOfficeRoom(resultSet.getString("office_room"));

        } catch (SQLException e){

            throw new DaoException("Can't get entity for Address", e);

        }

        return address;
    }

    @Override
    public List<Phone> getAll() throws DaoException, ClassNotFoundException {
        return super.getAll();
    }

    @Override
    String getCreateQuery() {
        return null;
    }

    @Override
    String getUpdateQuery() {
        return null;
    }

    @Override
    String getDeleteQuery() {
        return null;
    }

    @Override
    String getByIdQuery() {
        return null;
    }

    @Override
    String getAllQuery() {
        return null;
    }

    @Override
    public List<Phone> getByFilter(String query) {
        return null;
    }
}
