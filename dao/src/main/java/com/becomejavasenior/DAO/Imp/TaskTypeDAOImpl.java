package com.becomejavasenior.DAO.Imp;


import com.becomejavasenior.DAO.DAOException;
import com.becomejavasenior.DAO.TaskTypeDAO;
import com.becomejavasenior.bean.TaskType;
import com.becomejavasenior.exceptions.DatabaseException;
import com.becomejavasenior.factory.PostgresDAOFactory;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class TaskTypeDAOImpl extends AbstractDAOImpl<TaskType> implements TaskTypeDAO<TaskType> {

    @Override
    public String getCreateQuery(){
        return "INSERT INTO crm_pallas.task_type (title) VALUES(?)";
    }

    @Override
    public String getUpdateQuery(){
        return "UPDATE crm_pallas.task_type SET title = ?";
    }

    @Override
    public String getDeleteQuery(){
        return "DELETE FROM crm_pallas.task_type WHERE id = ?";
    }

    @Override
    public String getAllQuery(){
        return "SELECT * FROM crm_pallas.task_type";
    }

    @Override
    public List<TaskType> getByFilter(String query) {
        return null;
    }

    @Override
    public String getByIdQuery(){
        return "SELECT * FROM crm_pallas.task_type WHERE id = ?";
    }

    @Override
    public void createStatement(PreparedStatement preparedStatement, TaskType taskType) throws DAOException{
        try {
            preparedStatement.setString(1, taskType.getType());
        } catch (SQLException e){
            throw new DAOException("Can't create statement for Task", e);
        }
    }

    @Override
    public void updateStatement(PreparedStatement preparedStatement, TaskType taskType) throws DAOException{
        try {
            preparedStatement.setString(1, taskType.getType());
        } catch (SQLException e){
            throw new DAOException("Can't update statement for TaskType", e);
        }
    }

    @Override
    public TaskType getEntity(ResultSet resultSet) throws DAOException{
        TaskType taskType = new TaskType();
        try {
            taskType.setId(resultSet.getInt("id"));
            taskType.setType(resultSet.getString("title"));

        } catch (SQLException e){
            throw new DAOException("Can't get entity from Company", e);
        }
        return taskType;
    }

    @Override
    public List<TaskType> getAll() throws DAOException, ClassNotFoundException {
        List<TaskType> taskTypes = new ArrayList<>();
        TaskType taskType;

        try (Connection connection = PostgresDAOFactory.getConnection();
             Statement statement = connection.createStatement();
             ResultSet resultSet = statement.executeQuery(getAllQuery())) {
            while (resultSet.next()) {
                taskType = new TaskType();
                taskType.setId(resultSet.getInt("id"));
                taskType.setType(resultSet.getString("title"));

                taskTypes.add(taskType);
            }
        } catch (SQLException ex) {
            throw new DatabaseException(ex);
        }

        return taskTypes;
    }

}
