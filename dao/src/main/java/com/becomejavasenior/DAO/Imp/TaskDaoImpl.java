package com.becomejavasenior.DAO.Imp;


import com.becomejavasenior.DAO.*;
import com.becomejavasenior.bean.*;
import com.becomejavasenior.factory.PostgresDaoFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import javax.sql.DataSource;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;

@Repository("taskDao")
public class TaskDaoImpl extends AbstractDaoImpl<Task> implements TaskDao<Task> {

    private static final String SELECT_TASKS_FOR_LIST = "SELECT crm_pallas.task.id,crm_pallas.task.title,\n" +
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
            "WHERE crm_pallas.company.id = ? AND crm_pallas.task.is_finished = FALSE;";


    @Autowired
    public TaskDaoImpl(DataSource dataSource) {
        super(dataSource);
    }

    @Autowired
    DataSource dataSource;

    @Override
    public List<Task> getTasksForList(int id) {
        List<Task> tasks = new ArrayList<>();
        Task task;
        TaskType taskType;
        User responsibleUser;

        try (Connection connection = getConnection();
             PreparedStatement statement = connection.prepareStatement(SELECT_TASKS_FOR_LIST)) {
            statement.setInt(1, id);
            ResultSet resultSet = statement.executeQuery();

            while (resultSet.next()) {
                task = new Task();
                taskType = new TaskType();
                responsibleUser = new User();
                task.setId(resultSet.getInt("id"));
                task.setTitle(resultSet.getString("title"));
                taskType.setType(resultSet.getString("typeTytle"));
                task.setTaskType(taskType);
                task.setDescription(resultSet.getString("description"));
                task.setDeadlineDate(resultSet.getDate("deadlineDate"));
                responsibleUser.setlName(resultSet.getString("lName"));
                task.setResponsibleUser(responsibleUser);
                tasks.add(task);
            }
        } catch (SQLException ex) {
            throw new DatabaseException(ex);
        }

        return tasks;
    }

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
        TaskTypeDao<TaskType> taskType = new TaskTypeDaoImpl(dataSource);
        PeriodInDaysTypeDao<PeriodInDaysType> periodInDaysType = new PeriodInDaysTypeDaoImpl(dataSource);
        UserDao<User> user = new UserDaoImpl(dataSource);
        try {
            task.setId(resultSet.getInt("id"));
            task.setTitle(resultSet.getString("title"));
            task.setTaskType(taskType.getById(resultSet.getInt("task_type_id")));
            task.setDescription(resultSet.getString("description"));
            task.setDeadlineDate(resultSet.getDate("deadline_date"));
            task.setDeadlineTime(resultSet.getTime("deadline_time"));
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