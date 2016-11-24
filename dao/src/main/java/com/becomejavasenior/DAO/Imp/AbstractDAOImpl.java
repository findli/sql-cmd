package com.becomejavasenior.DAO.Imp;

import com.becomejavasenior.DAO.AbstractDAO;
import com.becomejavasenior.DAO.DAOException;
import com.becomejavasenior.DataBaseUtil;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public abstract class AbstractDAOImpl<T> implements AbstractDAO<T> {


    @Override
    public T create(T entity) throws DAOException{
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
                createEntity = getById(generatedId);
            }
        } catch (SQLException e) {
            throw new DAOException("Can't create Entity", e);
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

    abstract void createStatement(PreparedStatement preparedStatement, T entity) throws DAOException;

    @Override
    public T update(T entity) throws DAOException{
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
            throw new DAOException("Can't update Entity", e);
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

    abstract void updateStatement(PreparedStatement preparedStatement, T entity) throws DAOException;

    @Override
    public void delete(Integer id) throws DAOException{

        Connection connection = null;
        PreparedStatement preparedStatement = null;
        try {
            connection = DataBaseUtil.getConnection();
            String query = getDeleteQuery();
            preparedStatement = connection.prepareStatement(query);
            preparedStatement.setInt(1, id);
            preparedStatement.execute();
        } catch (SQLException e) {
            throw new DAOException("Can't delete Entity", e);
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
    public T getById(Integer id) throws DAOException{
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
            throw new DAOException("Can't get Entity by ID", e);
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

    abstract T getEntity(ResultSet resultSet) throws DAOException;

    @Override
    public List<T> getAll() throws DAOException{
        Connection connection = null;
        PreparedStatement preparedStatement = null;
        ResultSet resultSet;
        List<T> listEntity = new ArrayList<T>();
        try {
            connection = DataBaseUtil.getConnection();
            String query = getAllQuery();
            preparedStatement = connection.prepareStatement(query);
            resultSet = preparedStatement.executeQuery();

            while (resultSet.next()) {
                listEntity.add(getEntity(resultSet));
            }

        } catch (SQLException e) {
            throw new DAOException("Can't get all Entity", e);
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

        return listEntity;
    }

    abstract String getCreateQuery();

    abstract String getUpdateQuery();

    abstract String getDeleteQuery();

    abstract String getByIdQuery();

    abstract String getAllQuery();


}
