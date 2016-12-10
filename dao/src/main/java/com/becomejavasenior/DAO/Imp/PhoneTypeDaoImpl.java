package com.becomejavasenior.DAO.Imp;

import com.becomejavasenior.DAO.DaoException;
import com.becomejavasenior.DAO.PhoneTypeDao;
import com.becomejavasenior.bean.PhoneType;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.List;

public class PhoneTypeDaoImpl extends AbstractDaoImpl<PhoneType> implements PhoneTypeDao<PhoneType> {

    @Override
    public PhoneType getByName(String str) throws DaoException, ClassNotFoundException {
        return null;
    }

    @Override
    public PhoneType create(PhoneType entity) throws DaoException {
        return super.create(entity);
    }

    @Override
    void createStatement(PreparedStatement preparedStatement, PhoneType entity) throws DaoException {

    }

    @Override
    public PhoneType update(PhoneType entity) throws DaoException {
        return super.update(entity);
    }

    @Override
    void updateStatement(PreparedStatement preparedStatement, PhoneType entity) throws DaoException {

    }

    @Override
    public void delete(Integer id) throws DaoException {
        super.delete(id);
    }

    @Override
    public PhoneType getById(Integer id) throws DaoException {
        return super.getById(id);
    }

    @Override
    PhoneType getEntity(ResultSet resultSet) throws DaoException {
        return null;
    }

    @Override
    public List<PhoneType> getAll() throws DaoException, ClassNotFoundException {
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
    public List<PhoneType> getByFilter(String query) {
        return null;
    }
}
