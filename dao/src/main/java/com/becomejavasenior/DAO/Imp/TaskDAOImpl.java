package com.becomejavasenior.DAO.Imp;


import com.becomejavasenior.DAO.PeriodInDaysTypeDAO;
import com.becomejavasenior.DAO.TaskDAO;
import com.becomejavasenior.DAO.TaskTypeDAO;
import com.becomejavasenior.bean.PeriodInDaysType;
import com.becomejavasenior.bean.TaskType;
import com.becomejavasenior.bean.User;

import java.sql.*;

public class TaskDAOImpl extends AbstractDAOImpl<Task> implements TaskDAO<Task> {

    @Override
    public String getCreateQuery(){
        return "INSERT INTO task (title, task_type_id, description, deadline_date, time, period_in_days_type_id, period_in_minutes, responsible_user_id, is_finished, is_deleted ) VALUES(?,?,?,?,?,?,?,?,?,?)";
    }

    @Override
    public String getUpdateQuery(){
        return "UPDATE task SET title = ?, task_type_id = ?, description = ?, deadline_date = ?, time = ?, period_in_days_type_id = ?, period_in_minutes = ?, responsible_user_id = ?, is_finished = ?, is_deleted = ?";
    }

    @Override
    public String getDeleteQuery(){
        return "DELETE FROM task WHERE id = ?";
    }

    @Override
    public String getAllQuery(){
        return "SELECT * FROM task";
    }

    @Override
    public String getByIdQuery(){
        return "SELECT * FROM task WHERE id = ?";
    }

    @Override
    public void createStatement(PreparedStatement preparedStatement, Task task) throws DAOException{
        Date sqlDate = new Date(task.getDeadlineDate().getTime());
        Time sqlTime = new Time(task.getTime().getTime());
        try {
            preparedStatement.setString(1, task.getTitle());
            preparedStatement.setInt(2, task.getTaskType().getId());
            preparedStatement.setString(3, task.getDescription());
            preparedStatement.setDate(4, sqlDate);
            preparedStatement.setTime(5, sqlTime);
            preparedStatement.setInt(6, task.getPeriodInDaysType().getId());
            preparedStatement.setInt(7, task.getPeriodInMinutes());
            preparedStatement.setInt(8, task.getResponsibleUser().getId());
            preparedStatement.setBoolean(9, task.isFinished());
            preparedStatement.setBoolean(10, task.isDeleted());
        } catch (SQLException e){
            throw new DAOException("Can't create statement for Task", e);
        }
    }

    @Override
    public void updateStatement(PreparedStatement preparedStatement, Task task) throws DAOException{
        Date sqlDate = new Date(task.getDeadlineDate().getTime());
        Time sqlTime = new Time(task.getTime().getTime());
        try {
            preparedStatement.setString(1, task.getTitle());
            preparedStatement.setInt(2, task.getTaskType().getId());
            preparedStatement.setString(3, task.getDescription());
            preparedStatement.setDate(4, sqlDate);
            preparedStatement.setTime(5, sqlTime);
            preparedStatement.setInt(6, task.getPeriodInDaysType().getId());
            preparedStatement.setInt(7, task.getPeriodInMinutes());
            preparedStatement.setInt(8, task.getResponsibleUser().getId());
            preparedStatement.setBoolean(9, task.isFinished());
            preparedStatement.setBoolean(10, task.isDeleted());
        } catch (SQLException e){
            throw new DAOException("Can't update statement for Task", e);
        }
    }

    @Override
    public Task getEntity(ResultSet resultSet) throws DAOException{
        Task task = new Task();
        TaskTypeDAO<TaskType> taskType = new TaskTypeDAOImpl();
        PeriodInDaysTypeDAO<PeriodInDaysType> periodInDaysType = new PeriodInDaysTypeDAOImpl();
        UserDAO<User> user = new UserDAOImpl();
        try {
            task.setId(resultSet.getInt("id"));
            task.setTitle(resultSet.getString("title"));
            task.setTaskType(taskType.getById(resultSet.getInt("task_type_id")));
            task.setDescription(resultSet.getString("description"));
            task.setDeadlineDate(resultSet.getDate("deadline_date"));
            task.setTime(resultSet.getTime("time"));
            task.setPeriodInDaysType(periodInDaysType.getById(resultSet.getInt("period_in_days_type_id")));
            task.setPeriodInMinutes(resultSet.getInt("period_in_minutes"));
            task.setResponsibleUser(user.getById(resultSet.getInt("responsible_user_id")));
            task.setFinished(resultSet.getBoolean("is_finished"));
            task.setDeleted(resultSet.getBoolean("is_deleted"));
        } catch (SQLException e){
            throw new DAOException("Can't get entity from Task", e);
        }
        return task;
    }
}
