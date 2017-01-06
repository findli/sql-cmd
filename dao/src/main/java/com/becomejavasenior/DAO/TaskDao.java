package com.becomejavasenior.DAO;


import com.becomejavasenior.bean.Task;

import java.sql.Date;
import java.util.List;

public interface TaskDao<Task> extends AbstractDao<Task> {

    List<Task> getTasksForList(int id);
    public List<Task> getAllTasksForFilter(Date fromDate, Date toDate, int period_id, int task_type_id, int user_id);
    public List<Task> getOverdueTasksForFilter(Date fromDate, Date toDate, int period_id, int task_type_id, int user_id);
    public List<Task> getDeletedTasksForFilter(Date fromDate, Date toDate, int period_id, int task_type_id, int user_id);
}
