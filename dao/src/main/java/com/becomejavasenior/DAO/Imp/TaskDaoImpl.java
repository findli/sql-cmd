package com.becomejavasenior.DAO.Imp;

import com.becomejavasenior.DAO.*;
import com.becomejavasenior.bean.PeriodInDaysType;
import com.becomejavasenior.bean.Task;
import com.becomejavasenior.bean.TaskType;
import com.becomejavasenior.bean.User;
import com.becomejavasenior.factory.PostgresDaoFactory;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class TaskDaoImpl extends AbstractDaoImpl<Task> implements TaskDao<Task> {


    private static final String SELECT_DEALS_FOR_LIST = "SELECT crm_pallas.task.id,crm_pallas.task.title,\n" +
            "crm_pallas.task_type.title as typeTytle,\n" +
            "crm_pallas.task.description,\n" +
            "crm_pallas.task.deadline_date as deadlineDate,\n" +
            "crm_pallas.user.last_name as lName\n" +
            "FROM crm_pallas.task\n" +
            "  JOIN crm_pallas.task_type on crm_pallas.task_type.id = crm_pallas.task.task_type_id\n" +
            "  JOIN crm_pallas.period_in_days_type on crm_pallas.period_in_days_type.id = crm_pallas.task.period_in_days_type_id\n" +
            "  JOIN crm_pallas.user on crm_pallas.user.id = crm_pallas.task.responsible_user_id\n" +
            "  JOIN crm_pallas.company_task on crm_pallas.task.id = crm_pallas.company_task.task_id\n" +
            "  JOIN crm_pallas.company on crm_pallas.company_task.company_id = crm_pallas.company.id\n" +
            "WHERE crm_pallas.company.id = ?;";

    @Override
    public String getCreateQuery() {
        return "INSERT INTO task (title, task_type_id, description, deadline_date, time, period_in_days_type_id, period_in_minutes, responsible_user_id, is_finished, is_deleted ) VALUES(?,?,?,?,?,?,?,?,?,?)";
    }

    @Override
    public String getUpdateQuery() {
        return "UPDATE task SET title = ?, task_type_id = ?, description = ?, deadline_date = ?, time = ?, period_in_days_type_id = ?, period_in_minutes = ?, responsible_user_id = ?, is_finished = ?, is_deleted = ?";
    }

    @Override
    public String getDeleteQuery() {
        return "DELETE FROM crm_pallas.company_task WHERE crm_pallas.company_task.task_id =?";
    }

    @Override
    public String getAllQuery() {
        return "SELECT * FROM task";
    }

    @Override
    public List<Task> getByFilter(String query) {
        return null;
    }

    @Override
    public String getByIdQuery() {
        return "SELECT * FROM task WHERE id = ?";
    }

    @Override
    public void createStatement(PreparedStatement preparedStatement, Task task) throws DaoException {
/*//        Date sqlDate = new Date(task.getDeadlineDate().getTime());

//        Time sqlTime = new Time(task.getTime().getTime());

        try {
            preparedStatement.setString(1, task.getTitle());
            preparedStatement.setInt(2, task.getTaskTypeId());
            preparedStatement.setString(3, task.getDescription());
//            preparedStatement.setDate(4, sqlDate);
//            preparedStatement.setTime(5, sqlTime);
            preparedStatement.setInt(6, task.getPeriodInDaysTypeId());
            preparedStatement.setInt(7, task.getPeriodInMinutes());
            preparedStatement.setInt(8, task.getResponsibleUserId());
            preparedStatement.setBoolean(9, task.isFinished());
            preparedStatement.setBoolean(10, task.isDeleted());
        } catch (SQLException e) {
            throw new DaoException("Can't create statement for Task", e);
        }*/
    }

    @Override
    public void updateStatement(PreparedStatement preparedStatement, Task task) throws DaoException {
/*//        Date sqlDate = new Date(task.getDeadlineDate().getTime());
//        Time sqlTime = new Time(task.getTime().getTime());
        try {
            preparedStatement.setString(1, task.getTitle());
            preparedStatement.setInt(2, task.getTaskTypeId());
            preparedStatement.setString(3, task.getDescription());
//            preparedStatement.setDate(4, sqlDate);
//            preparedStatement.setTime(5, sqlTime);
            preparedStatement.setInt(6, task.getPeriodInDaysTypeId());
            preparedStatement.setInt(7, task.getPeriodInMinutes());
            preparedStatement.setInt(8, task.getResponsibleUserId());
            preparedStatement.setBoolean(9, task.isFinished());
            preparedStatement.setBoolean(10, task.isDeleted());
        } catch (SQLException e) {
            throw new DaoException("Can't update statement for Task", e);
        }*/
    }

    @Override
    public Task getByName(String str) throws DaoException, ClassNotFoundException {
        return null;
    }

    @Override
    public Task getEntity(ResultSet resultSet) throws DaoException {
        Task task = new Task();
        TaskTypeDao<TaskType> taskType = new TaskTypeDaoImpl();
        PeriodInDaysTypeDao<PeriodInDaysType> periodInDaysType = new PeriodInDaysTypeDaoImpl();
//        UserDao<User> user = new UserDaoImpl();
        try {
            task.setId(resultSet.getInt("id"));
            task.setTitle(resultSet.getString("title"));
//            task.setTaskTypeId(taskType.getById(resultSet.getInt("task_type_id")));
            task.setDescription(resultSet.getString("description"));
//            task.setDeadlineDate(resultSet.getDate("deadline_date"));
//            task.setTime(resultSet.getTime("time"));
//            task.setPeriodInDaysTypeId(periodInDaysType.getById(resultSet.getInt("period_in_days_type_id")));
            task.setPeriodInMinutes(resultSet.getInt("period_in_minutes"));
//            task.setResponsibleUser(user.getById(resultSet.getInt("responsible_user_id")));
            task.setFinished(resultSet.getBoolean("is_finished"));
            task.setDeleted(resultSet.getBoolean("is_deleted"));
        } catch (SQLException e) {
            throw new DaoException("Can't get entity from Task", e);
        }
        return task;
    }

    @Override
    public List<Task> getTasksForList(int id) {
        List<Task> tasks = new ArrayList<>();
        Task task;
        TaskType taskType;
        User responsibleUser;

        try (Connection connection = PostgresDaoFactory.getConnection();
             PreparedStatement statement = connection.prepareStatement(SELECT_DEALS_FOR_LIST)) {
            statement.setInt(1,id);
            ResultSet resultSet = statement.executeQuery();

            while (resultSet.next()) {
                task = new Task();
                taskType = new TaskType();
                responsibleUser = new User();
                task.setId(resultSet.getInt("id"));
                task.setTitle(resultSet.getString("title"));
                taskType.setType(resultSet.getString("typeTytle"));
                task.setTaskTypeId(taskType);
                task.setDescription(resultSet.getString("description"));
                task.setDeadLine(resultSet.getDate("deadlineDate"));
                responsibleUser.setlName(resultSet.getString("lName"));
                task.setResponsibleUserId(responsibleUser);
                tasks.add(task);
            }
        } catch (SQLException ex) {
            throw new DatabaseException(ex);
        }

        return tasks;
    }
}