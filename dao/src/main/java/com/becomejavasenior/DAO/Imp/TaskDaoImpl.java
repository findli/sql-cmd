package com.becomejavasenior.DAO.Imp;


import com.becomejavasenior.DAO.*;
import com.becomejavasenior.bean.*;

import java.sql.*;
import java.util.List;

public class TaskDaoImpl extends AbstractDaoImpl<Task> implements TaskDao<Task> {

    @Override
    public String getCreateQuery(){
        return "INSERT INTO crm_pallas.task (title, task_type_id, description, deadline_date, period_in_days_type_id, period_in_minutes, responsible_user_id, is_finished, is_deleted ) VALUES(?,?,?,?,?,?,?,?,?)";
    }

    @Override
    public String getUpdateQuery(){
        return "UPDATE crm_pallas.task SET title = ?, task_type_id = ?, description = ?, deadline_date = ?, period_in_days_type_id = ?, period_in_minutes = ?, responsible_user_id = ?, is_finished = ?, is_deleted = ? WHERE id = ?";
    }

    @Override
    public String getDeleteQuery(){
        return "DELETE FROM crm_pallas.task WHERE id = ?";
    }

    @Override
    public String getAllQuery(){
        return "SELECT * FROM crm_pallas.task";
    }

    @Override
    public String getByIdQuery(){
        return "SELECT * FROM crm_pallas.task WHERE id = ?";
    }

    @Override
    public void createStatement(PreparedStatement preparedStatement, Task task) throws DaoException{
        Date sqlDate = new Date(task.getDeadlineDate().getTime());
        try {
            preparedStatement.setString(1, task.getTitle());
            preparedStatement.setInt(2, task.getTaskType().getId());
            preparedStatement.setString(3, task.getDescription());
            preparedStatement.setDate(4, sqlDate);
            preparedStatement.setInt(5, task.getPeriodInDaysType().getId());
            preparedStatement.setInt(6, task.getPeriodInMinutes());
            preparedStatement.setInt(7, task.getResponsibleUser().getId());
            preparedStatement.setBoolean(8, task.isFinished());
            preparedStatement.setBoolean(9, task.isDeleted());
        } catch (SQLException e){
            throw new DaoException("Can't create statement for Task", e);
        }
    }

    @Override
    public void updateStatement(PreparedStatement preparedStatement, Task task) throws DaoException{
        Date sqlDate = new Date(task.getDeadlineDate().getTime());
        try {
            preparedStatement.setString(1, task.getTitle());
            preparedStatement.setInt(2, task.getTaskType().getId());
            preparedStatement.setString(3, task.getDescription());
            preparedStatement.setDate(4, sqlDate);
            preparedStatement.setInt(5, task.getPeriodInDaysType().getId());
            preparedStatement.setInt(6, task.getPeriodInMinutes());
            preparedStatement.setInt(7, task.getResponsibleUser().getId());
            preparedStatement.setBoolean(8, task.isFinished());
            preparedStatement.setBoolean(9, task.isDeleted());
            preparedStatement.setInt(10, task.getId());
        } catch (SQLException e){
            throw new DaoException("Can't update statement for Task", e);
        }
    }

    @Override
    public Task getEntity(ResultSet resultSet) throws DaoException{
        Task task = new Task();
        TaskTypeDao<TaskType> taskType = new TaskTypeDaoImpl();
        PeriodInDaysTypeDao<PeriodInDaysType> periodInDaysType = new PeriodInDaysTypeDaoImpl();
        UserDao<User> user = new UserDaoImpl();
        try {
            task.setId(resultSet.getInt("id"));
            task.setTitle(resultSet.getString("title"));
            task.setTaskType(taskType.getById(resultSet.getInt("task_type_id")));
            task.setDescription(resultSet.getString("description"));
            task.setDeadlineDate(resultSet.getDate("deadline_date"));
            task.setPeriodInDaysType(periodInDaysType.getById(resultSet.getInt("period_in_days_type_id")));
            task.setPeriodInMinutes(resultSet.getInt("period_in_minutes"));
            task.setResponsibleUser(user.getById(resultSet.getInt("responsible_user_id")));
            task.setFinished(resultSet.getBoolean("is_finished"));
            task.setDeleted(resultSet.getBoolean("is_deleted"));
        } catch (SQLException e){
            throw new DaoException("Can't get entity from Task", e);
        }
        return task;
    }

    @Override
    public Task getByName(String name) throws DaoException, ClassNotFoundException{
        return null;
    }

    @Override
    public List<Task> getByFilter(String filter){
        return null;
    }

}