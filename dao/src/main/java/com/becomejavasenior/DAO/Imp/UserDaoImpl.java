package com.becomejavasenior.DAO.Imp;

import com.becomejavasenior.DAO.DaoException;
import com.becomejavasenior.DAO.TaskDao;
import com.becomejavasenior.bean.User;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.List;

public class UserDaoImpl extends AbstractDaoImpl<User> implements TaskDao<User> {
    @Override
    void createStatement(PreparedStatement preparedStatement, User entity) throws DaoException {

    }

    @Override
    String getAllQuery() {
        return null;
    }

    @Override
    String getByIdQuery() {
        return null;
    }

    @Override
    String getCreateQuery() {
        return null;
    }

    @Override
    String getDeleteQuery() {
        return null;
    }

    @Override
    User getEntity(ResultSet resultSet) throws DaoException {
        return null;
    }

    @Override
    String getUpdateQuery() {
        return null;
    }

    @Override
    void updateStatement(PreparedStatement preparedStatement, User entity) throws DaoException {

    }

    @Override
    public User create(User entity) throws DaoException {
        return super.create(entity);
    }

    @Override
    public void delete(Integer id) throws DaoException {
        super.delete(id);
    }

    @Override
    public List<User> getAll() throws DaoException {
        return super.getAll();
    }

    @Override
    public List<User> getByFilter(String query) {
        return null;
    }

    @Override
    public User getById(Integer id) throws DaoException {
        return super.getById(id);
    }

    @Override
    public User update(User entity) throws DaoException {
        return super.update(entity);
    }
}
