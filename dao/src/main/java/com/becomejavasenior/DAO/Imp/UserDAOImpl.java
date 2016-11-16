package com.becomejavasenior.DAO.Imp;

import com.becomejavasenior.DAO.DAOException;
import com.becomejavasenior.DAO.TaskDAO;
import com.becomejavasenior.bean.User;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.List;

public class UserDAOImpl extends AbstractDAOImpl<User> implements TaskDAO<User> {
    @Override
    void createStatement(PreparedStatement preparedStatement, User entity) throws DAOException {

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
    User getEntity(ResultSet resultSet) throws DAOException {
        return null;
    }

    @Override
    String getUpdateQuery() {
        return null;
    }

    @Override
    void updateStatement(PreparedStatement preparedStatement, User entity) throws DAOException {

    }

    @Override
    public User create(User entity) throws DAOException {
        return super.create(entity);
    }

    @Override
    public void delete(Integer id) throws DAOException {
        super.delete(id);
    }

    @Override
    public List<User> getAll() throws DAOException {
        return super.getAll();
    }

    @Override
    public List<User> getByFilter(String query) {
        return null;
    }

    @Override
    public User getById(Integer id) throws DAOException {
        return super.getById(id);
    }

    @Override
    public User update(User entity) throws DAOException {
        return super.update(entity);
    }
}
