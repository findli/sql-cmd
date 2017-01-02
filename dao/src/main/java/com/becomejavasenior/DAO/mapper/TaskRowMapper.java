package com.becomejavasenior.DAO.mapper;


import com.becomejavasenior.DAO.DaoException;
import com.becomejavasenior.DAO.PeriodInDaysTypeDao;
import com.becomejavasenior.DAO.TaskTypeDao;
import com.becomejavasenior.DAO.UserDao;
import com.becomejavasenior.bean.PeriodInDaysType;
import com.becomejavasenior.bean.Task;
import com.becomejavasenior.bean.TaskType;
import com.becomejavasenior.bean.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Component;

import java.sql.ResultSet;
import java.sql.SQLException;

@Component
public class TaskRowMapper implements RowMapper<Task>{

    private static final String FIELD_ID = "id";
    private static final String FIELD_TITLE = "title";
    private static final String FIELD_TASK_TYPE_ID = "task_type_id";
    private static final String FIELD_DESCRIPTION = "description";
    private static final String FIELD_DEADLINE_DATE = "deadline_date";
    private static final String FIELD_DEADLINE_TIME = "deadline_time";
    private static final String FIELD_PERIOD_IN_DAYS = "period_in_days_type_id";
    private static final String FIELD_PERIOD_IN_MINUTES = "period_in_minutes";
    private static final String FIELD_RESPONSIBLE_USER_ID = "responsible_user_id";
    private static final String FIELD_IS_FINISHED = "is_finished";
    private static final String FIELD_IS_DELETED = "is_deleted";

    @Autowired
    TaskTypeDao taskTypeDao;

    @Autowired
    PeriodInDaysTypeDao periodInDaysTypeDao;

    @Autowired
    UserDao userDao;

    @Override
    public Task mapRow(ResultSet resultSet, int i) throws SQLException{
        Task task = new Task();

        task.setId(resultSet.getInt(FIELD_ID));
        task.setTitle(resultSet.getString(FIELD_TITLE));
        task.setDescription(resultSet.getString(FIELD_DESCRIPTION));
        task.setDeadlineDate(resultSet.getDate(FIELD_DEADLINE_DATE));
        task.setDeadlineTime(resultSet.getTime(FIELD_DEADLINE_TIME));
        task.setPeriodInMinutes(resultSet.getInt(FIELD_PERIOD_IN_MINUTES));
        task.setFinished(resultSet.getBoolean(FIELD_IS_FINISHED));
        task.setDeleted(resultSet.getBoolean(FIELD_IS_DELETED));

        if(resultSet.getObject(FIELD_TASK_TYPE_ID, Integer.class) != null) {
            TaskType taskType = null;
            try {
                taskType = (TaskType) taskTypeDao.getById(resultSet.getInt(FIELD_TASK_TYPE_ID));
            } catch (DaoException e) {
                e.printStackTrace();
            }
            task.setTaskType(taskType);
        }

        if(resultSet.getObject(FIELD_PERIOD_IN_DAYS, Integer.class) != null) {
            PeriodInDaysType periodInDaysType = null;
            try {
                periodInDaysType = (PeriodInDaysType) periodInDaysTypeDao.getById(resultSet.getInt(FIELD_PERIOD_IN_DAYS));
            } catch (DaoException e) {
                e.printStackTrace();
            }
            task.setPeriodInDaysType(periodInDaysType);
        }

        if(resultSet.getObject(FIELD_RESPONSIBLE_USER_ID, Integer.class) != null) {
            User user = null;
            try {
                user = (User) userDao.getById(resultSet.getInt(FIELD_RESPONSIBLE_USER_ID));
            } catch (DaoException e) {
                e.printStackTrace();
            }
            task.setResponsibleUser(user);
        }
        return task;
    }
}
