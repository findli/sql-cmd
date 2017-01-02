package com.becomejavasenior.DAO.Imp;


import com.becomejavasenior.DAO.*;
import com.becomejavasenior.DAO.JdbcTempale.AbstractDaoJdbcTemplate;
import com.becomejavasenior.DAO.mapper.TaskRowMapper;
import com.becomejavasenior.bean.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.PreparedStatementCreator;
import org.springframework.jdbc.core.PreparedStatementSetter;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.jdbc.support.GeneratedKeyHolder;
import org.springframework.jdbc.support.KeyHolder;
import org.springframework.stereotype.Repository;

import java.sql.*;
import java.util.List;

@Repository("taskDao")
public class TaskDaoImpl extends AbstractDaoJdbcTemplate<Task> implements TaskDao<Task>{

    @Autowired
    TaskRowMapper TASK_ROW_MAPPER;

    private static final String SELECT_ALL_SQL = "SELECT * FROM crm_pallas.task WHERE NOT is_deleted";

    private static final String UPDATE_SQL = "UPDATE crm_pallas.task SET title = ?, task_type_id = ?, description = ?, deadline_date = ?, deadline_time = ?, period_in_days_type_id = ?, period_in_minutes = ?, responsible_user_id = ?, is_finished = ?, is_deleted = ? WHERE id = ?";

    private static final String INSERT_SQL = "INSERT INTO crm_pallas.task (title, task_type_id, description, deadline_date, deadline_time, period_in_days_type_id, period_in_minutes, responsible_user_id, is_finished, is_deleted ) VALUES(?,?,?,?,?,?,?,?,?,?)";

    private static final String SELECT_BY_NAME = "SELECT * FROM crm_pallas.task WHERE NOT is_deleted AND title = ?";

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

    @Override
    public void delete(Integer id) throws DaoException {
        delete(id, "task");
    }

    @Override
    public Task create(Task task){
        if (task.getId() != 0) {
            throw new DatabaseException("task id must be obtained from DB");
        }
        Date sqlDate = new Date(task.getDeadlineDate().getTime());

        PreparedStatementCreator preparedStatementCreator = connection -> {
            PreparedStatement preparedStatement = connection.prepareStatement(INSERT_SQL, new String[]{"id"});

            preparedStatement.setString(1, task.getTitle());
            preparedStatement.setInt(2, task.getTaskType().getId());
            preparedStatement.setString(3, task.getDescription());
            preparedStatement.setDate(4, sqlDate);
            preparedStatement.setTime(5, task.getDeadlineTime());
            preparedStatement.setInt(6, task.getPeriodInDaysType().getId());
            preparedStatement.setInt(7, task.getPeriodInMinutes());
            preparedStatement.setInt(8, task.getResponsibleUser().getId());
            preparedStatement.setBoolean(9, task.isFinished());
            preparedStatement.setBoolean(10, task.isDeleted());

            return preparedStatement;
        };
        KeyHolder keyHolder = new GeneratedKeyHolder();
        jdbcTemplate.update(preparedStatementCreator, keyHolder);
        int id=(int) keyHolder.getKey();
        task.setId(id);
        return task;
    }

    @Override
    public Task update(Task task){
        if (task.getId() == 0) {
            throw new DatabaseException("task must be created before update");
        }
        Date sqlDate = new Date(task.getDeadlineDate().getTime());

        PreparedStatementSetter preparedStatementSetter = preparedStatement -> {


            preparedStatement.setString(1, task.getTitle());
            preparedStatement.setInt(2, task.getTaskType().getId());
            preparedStatement.setString(3, task.getDescription());
            preparedStatement.setDate(4, sqlDate);
            preparedStatement.setTime(5, task.getDeadlineTime());
            preparedStatement.setInt(6, task.getPeriodInDaysType().getId());
            preparedStatement.setInt(7, task.getPeriodInMinutes());
            preparedStatement.setInt(8, task.getResponsibleUser().getId());
            preparedStatement.setBoolean(9, task.isFinished());
            preparedStatement.setBoolean(10, task.isDeleted());
            preparedStatement.setInt(11, task.getId());
        };
        jdbcTemplate.update(UPDATE_SQL, preparedStatementSetter);
        return task;
    }

    @Override
    public List<Task> getAll()throws DaoException, ClassNotFoundException{
        return jdbcTemplate.query(SELECT_ALL_SQL, TASK_ROW_MAPPER);
    }

    @Override
    public Task getById(Integer id){
        Task task = jdbcTemplate.queryForObject(SELECT_ALL_SQL + " AND id = ?", TASK_ROW_MAPPER, id);
        return task;
    }

    @Override
    public Task getByName(String name){
        Task task = jdbcTemplate.queryForObject(SELECT_BY_NAME, TASK_ROW_MAPPER, name);
        return task;
    }

    @Override
    public List<Task> getTasksForList(int id) {
        return jdbcTemplate.query(SELECT_TASKS_FOR_LIST.replace("?", String.valueOf(id)), TASK_FOR_LIST_ROW_MAPPER);
    }

    private final RowMapper<Task> TASK_FOR_LIST_ROW_MAPPER= (resultSet, i) -> {
        Task task = new Task();
        TaskType taskType = new TaskType();
        User responsibleUser = new User();
        task.setId(resultSet.getInt("id"));
        task.setTitle(resultSet.getString("title"));
        taskType.setType(resultSet.getString("typeTytle"));
        task.setTaskType(taskType);
        task.setDescription(resultSet.getString("description"));
        task.setDeadlineDate(resultSet.getDate("deadlineDate"));
        responsibleUser.setlName(resultSet.getString("lName"));
        task.setResponsibleUser(responsibleUser);
        return task;
    };
}