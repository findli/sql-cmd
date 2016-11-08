package com.becomejavasenior.DAO.Imp;

import com.becomejavasenior.DAO.AbstractDAO;
import com.becomejavasenior.DAO.DAOException;
import com.becomejavasenior.DataBaseUtil;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public abstract class AbstractDAOImpl<T> implements AbstractDAO<T> {



    public T create(T entity) {
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
            e.printStackTrace();
        } catch (DAOException e) {
            e.printStackTrace();
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


    public T update(T entity) {
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
            e.printStackTrace();
        } catch (DAOException e) {
            e.printStackTrace();
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


    public void delete(Integer id) {

        Connection connection = null;
        PreparedStatement preparedStatement = null;
        try {
            connection = DataBaseUtil.getConnection();
            String query = getDeleteQuery();
            preparedStatement = connection.prepareStatement(query);
            preparedStatement.setInt(1, id);
            preparedStatement.execute();
        } catch (SQLException e) {
            e.printStackTrace();
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


    public T getById(Integer id) {
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
            e.printStackTrace();
        } catch (DAOException e) {
            e.printStackTrace();
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


    public List<T> getAll() {
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
            e.printStackTrace();
        } catch (DAOException e) {
            e.printStackTrace();
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
