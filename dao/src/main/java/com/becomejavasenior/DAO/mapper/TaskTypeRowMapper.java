package com.becomejavasenior.DAO.mapper;


import com.becomejavasenior.bean.TaskType;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Component;

import java.sql.ResultSet;
import java.sql.SQLException;

@Component
public class TaskTypeRowMapper implements RowMapper<TaskType> {

    private static final String FIELD_ID = "id";
    private static final String FIELD_TITLE = "title";

    @Override
    public TaskType mapRow(ResultSet resultSet, int i) throws SQLException {
        TaskType taskType = new TaskType();

        taskType.setId(resultSet.getInt(FIELD_ID));
        taskType.setType(resultSet.getString(FIELD_TITLE));
        return taskType;
    }
}
