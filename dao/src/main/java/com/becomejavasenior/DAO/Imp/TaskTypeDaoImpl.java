package com.becomejavasenior.DAO.Imp;

import com.becomejavasenior.DAO.DaoException;
import com.becomejavasenior.DAO.JdbcTempale.AbstractDaoJdbcTemplate;
import com.becomejavasenior.DAO.TaskTypeDao;
import com.becomejavasenior.DAO.mapper.TaskTypeRowMapper;
import com.becomejavasenior.bean.TaskType;
import com.becomejavasenior.exceptions.DatabaseException;

import com.becomejavasenior.factory.PostgresDaoFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.PreparedStatementCreator;
import org.springframework.jdbc.core.PreparedStatementSetter;
import org.springframework.jdbc.support.GeneratedKeyHolder;
import org.springframework.jdbc.support.KeyHolder;
import org.springframework.stereotype.Repository;

import javax.sql.DataSource;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;

@Repository("taskTypeDao")
public class TaskTypeDaoImpl extends AbstractDaoJdbcTemplate<TaskType> implements TaskTypeDao<TaskType> {

    @Autowired
    private TaskTypeRowMapper TASKTYPE_ROW_MAPPER;

    private static final String INSERT_SQL = "INSERT INTO crm_pallas.task_type (title) VALUES(?)";

    private static final String UPDATE_SQL = "UPDATE crm_pallas.task_type SET title = ? WHERE id = ?";

    private static final String SELECT_ALL_SQL = "SELECT * FROM crm_pallas.task_type";

    private static final String SELECT_BY_NAME =  "SELECT * FROM crm_pallas.task_type WHERE title = ?";

    @Override
    public void delete(Integer id) throws DaoException {
        delete(id, "task_type");
    }

    @Override
    public TaskType create(TaskType taskType) {
        if (taskType.getId() != 0) {
            throw new com.becomejavasenior.DAO.DatabaseException("taskType id must be obtained from DB");
        }
        PreparedStatementCreator preparedStatementCreator = connection -> {
            PreparedStatement preparedStatement = connection.prepareStatement(INSERT_SQL, new String[]{"id"});
            preparedStatement.setString(1, taskType.getType());
            return preparedStatement;
        };
        KeyHolder keyHolder = new GeneratedKeyHolder();
        jdbcTemplate.update(preparedStatementCreator, keyHolder);
        int id=(int) keyHolder.getKey();
        taskType.setId(id);
        return taskType;
    }

    @Override
    public TaskType update(TaskType taskType){
        if (taskType.getId() == 0) {
            throw new com.becomejavasenior.DAO.DatabaseException("taskType must be created before update");
        }
        PreparedStatementSetter preparedStatementSetter = preparedStatement -> {
            preparedStatement.setString(1, taskType.getType());
        };
        jdbcTemplate.update(UPDATE_SQL, preparedStatementSetter);
        return taskType;
    }

    @Override
    public List<TaskType> getAll()throws DaoException, ClassNotFoundException{
        return jdbcTemplate.query(SELECT_ALL_SQL, TASKTYPE_ROW_MAPPER);
    }

    @Override
    public TaskType getById(Integer id){
        TaskType taskType = jdbcTemplate.queryForObject(SELECT_ALL_SQL + " WHERE id = ?", TASKTYPE_ROW_MAPPER, id);
        return taskType;
    }

    @Override
    public TaskType getByName(String name){
        TaskType taskType = jdbcTemplate.queryForObject(SELECT_BY_NAME, TASKTYPE_ROW_MAPPER, name);
        return taskType;
    }

}