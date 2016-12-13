package com.becomejavasenior.DAO.Imp;

import com.becomejavasenior.DAO.AbstractDao;


import com.becomejavasenior.DAO.DaoException;
import com.becomejavasenior.DataBaseUtil;
import org.apache.log4j.Logger;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public abstract class AbstractDaoImpl<T> implements AbstractDao<T> {

    public static Logger log = Logger.getLogger(AbstractDaoImpl.class);

    @Override
    public T create(T entity) throws DaoException {
        T createEntity = null;
        Connection connection = null;
        PreparedStatement preparedStatement = null;
        ResultSet resultSet;
        try {
            connection = DataBaseUtil.getConnection();
            String query = getCreateQuery();
            preparedStatement = connection.prepareStatement(query, Statement.RETURN_GENERATED_KEYS);
            createStatement(preparedStatement, entity);
            preparedStatement.executeUpdate();
            resultSet = preparedStatement.getGeneratedKeys();
            if (resultSet.next()) {
                Integer generatedId = resultSet.getInt(1);
                System.out.println("generated id = " + generatedId);
                createEntity = getById(generatedId);
            }
        } catch (SQLException e) {

            throw new DaoException("Can't create Entity " + entity, e);

        } finally {
            if (preparedStatement != null) try {
                preparedStatement.close();
            } catch (SQLException logOrIgnore) {
                logOrIgnore.printStackTrace();
            }
            if (connection != null) try {
                connection.close();
            } catch (SQLException logOrIgnore) {
                logOrIgnore.printStackTrace();
            }
        }
        return createEntity;
    }

    abstract void createStatement(PreparedStatement preparedStatement, T entity) throws DaoException;

    @Override
    public T update(T entity) throws DaoException {
        T updateEntity = null;
        Connection connection = null;
        PreparedStatement preparedStatement = null;
        try {
            connection = DataBaseUtil.getConnection();
            String query = getUpdateQuery();
            preparedStatement = connection.prepareStatement(query);
            updateStatement(preparedStatement, entity);
            preparedStatement.executeUpdate();
            updateEntity = entity;
        } catch (SQLException e) {
            throw new DaoException("Can't update Entity", e);
        } finally {
            if (preparedStatement != null) try {
                preparedStatement.close();
            } catch (SQLException logOrIgnore) {
                logOrIgnore.printStackTrace();
            }
            if (connection != null) try {
                connection.close();
            } catch (SQLException logOrIgnore) {
                logOrIgnore.printStackTrace();
            }
        }
        return updateEntity;
    }

    abstract void updateStatement(PreparedStatement preparedStatement, T entity) throws DaoException;

    @Override
    public void delete(Integer id) throws DaoException {

        Connection connection = null;
        PreparedStatement preparedStatement = null;
        try {
            connection = DataBaseUtil.getConnection();
            String query = getDeleteQuery();
            preparedStatement = connection.prepareStatement(query);
            preparedStatement.setInt(1, id);
            preparedStatement.execute();
        } catch (SQLException e) {
            throw new DaoException("Can't delete Entity", e);
        } finally {
            if (preparedStatement != null) try {
                preparedStatement.close();
            } catch (SQLException logOrIgnore) {
                logOrIgnore.printStackTrace();
            }
            if (connection != null) try {
                connection.close();
            } catch (SQLException logOrIgnore) {
                logOrIgnore.printStackTrace();
            }
        }

    }

    @Override
    public T getById(Integer id) throws DaoException {
        T entity = null;
        Connection connection = null;
        PreparedStatement preparedStatement = null;
        ResultSet resultSet;
        try {
            connection = DataBaseUtil.getConnection();
            String query = getByIdQuery();
            preparedStatement = connection.prepareStatement(query);
            preparedStatement.setInt(1, id);
            resultSet = preparedStatement.executeQuery();
            if (resultSet.next()) {
                entity = getEntity(resultSet);
            }
        } catch (SQLException e) {
            throw new DaoException("Can't get Entity by ID", e);
        } finally {
            if (preparedStatement != null) try {
                preparedStatement.close();
            } catch (SQLException logOrIgnore) {
                logOrIgnore.printStackTrace();
            }
            if (connection != null) try {
                connection.close();
            } catch (SQLException logOrIgnore) {
                logOrIgnore.printStackTrace();
            }
        }
        return entity;
    }

    abstract T getEntity(ResultSet resultSet) throws DaoException;

    @Override

    public List<T> getAll() throws DaoException, ClassNotFoundException {
        log.trace("Call getAll() in AbstractDaoImpl");

        Connection connection = null;
        PreparedStatement preparedStatement = null;
        ResultSet resultSet;
        List<T> listEntity = new ArrayList<>();
        try {
            log.trace("Open connection");
            connection = DataBaseUtil.getConnection();
            String query = getAllQuery();
            log.trace("Create statement");
            preparedStatement = connection.prepareStatement(query);
            resultSet = preparedStatement.executeQuery();
            log.trace("Get resultset");

            while (resultSet.next()) {
                listEntity.add(getEntity(resultSet));
            }

        } catch (SQLException e) {
            throw new DaoException("Can't get all Entity", e);
        } finally {
            if (preparedStatement != null) try {
                log.trace("close statement");
                preparedStatement.close();
            } catch (SQLException logOrIgnore) {
                logOrIgnore.printStackTrace();
            }
            if (connection != null) try {
                log.trace("close connection");
                connection.close();
            } catch (SQLException logOrIgnore) {
                logOrIgnore.printStackTrace();
            }
        }

        log.trace("return List entity");
        return listEntity;
    }

    abstract String getCreateQuery();

    abstract String getUpdateQuery();

    abstract String getDeleteQuery();

    abstract String getByIdQuery();

    abstract String getAllQuery();

    public abstract List<T> getByFilter(String query);

}