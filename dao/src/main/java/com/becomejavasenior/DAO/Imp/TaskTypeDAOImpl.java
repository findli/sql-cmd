package com.becomejavasenior.DAO.Imp;


import com.becomejavasenior.DAO.DAOException;
import com.becomejavasenior.DAO.TaskTypeDAO;
import com.becomejavasenior.bean.TaskType;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class TaskTypeDAOImpl extends AbstractDAOImpl<TaskType> implements TaskTypeDAO<TaskType>{

    @Override
    public String getCreateQuery(){
        return "INSERT INTO task_type (title) VALUES(?)";
    }

    @Override
    public String getUpdateQuery(){
        return "UPDATE task_type SET title = ?";
    }

    @Override
    public String getDeleteQuery(){
        return "DELETE FROM task_type WHERE id = ?";
    }

    @Override
    public String getAllQuery(){
        return "SELECT * FROM task_type";
    }

    @Override
    public String getByIdQuery(){
        return "SELECT * FROM task_type WHERE id = ?";
    }

    @Override
    public void createStatement(PreparedStatement preparedStatement, TaskType taskType) throws DAOException{
        try {
            preparedStatement.setString(1, taskType.getTitle());
        } catch (SQLException e){
            throw new DAOException("Can't create statement for Task", e);
        }
    }

    @Override
    public void updateStatement(PreparedStatement preparedStatement, TaskType taskType) throws DAOException{
        try {
            preparedStatement.setString(1, taskType.getTitle());
        } catch (SQLException e){
            throw new DAOException("Can't update statement for TaskType", e);
        }
    }

    @Override
    public TaskType getEntity(ResultSet resultSet) throws DAOException{
        TaskType taskType = new TaskType();
        try {
            taskType.setId(resultSet.getInt("id"));
            taskType.setTitle(resultSet.getString("title"));

        } catch (SQLException e){
            throw new DAOException("Can't get entity from Company", e);
        }
        return taskType;
    }
}
