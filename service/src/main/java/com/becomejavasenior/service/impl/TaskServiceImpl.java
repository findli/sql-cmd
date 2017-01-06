package com.becomejavasenior.service.impl;


import com.becomejavasenior.DAO.DaoException;
import com.becomejavasenior.DAO.TaskDao;
import com.becomejavasenior.bean.Task;
import com.becomejavasenior.service.TaskService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@Service(value = "taskService")
public class TaskServiceImpl implements TaskService {

    private final TaskDao taskDAO;
    List<Task> listTasks = new ArrayList<Task>();
    Task task = null;

    @Autowired
    public TaskServiceImpl(TaskDao taskDAO) {
        this.taskDAO = taskDAO;
    }

    public List<Task> getAll() throws DaoException, ClassNotFoundException {
        listTasks = taskDAO.getAll();
        return listTasks;
    }

    public void addTask(Task task) throws DaoException {
        taskDAO.create(task);
    }

    public void delete(int id) throws DaoException {
        taskDAO.delete(id);
    }

    public Task getById(int id) throws DaoException {
        task = (Task) taskDAO.getById(id);
        return task;
    }


    @Override
    public List<Task> getTasksForList(int id) {
        return taskDAO.getTasksForList(id);
    }


    public Task update(Task task) throws DaoException {
        task = (Task) taskDAO.update(task);
        return task;
    }

    // Возвращает ArrayList где '0' элемент это количество задач со статусом "In progress"
    //                          '1' элемент это количество задач со статусом "Done"
    //                          '2' элемент это количество задач со статусом "Overdue"
    //
    public List getTaskForDashboard() throws DaoException, ClassNotFoundException {
        List returnList = new ArrayList<>();
        int tasksInProgress = 0;
        int tasksDone = 0;
        int tasksOverdue = 0;
        listTasks = taskDAO.getAll();
        for (int i = 0; i < listTasks.size(); i++) {
            if (listTasks.get(i).getTaskType().getType().equals("In Progress")) {
                tasksInProgress++;
            }
            if (listTasks.get(i).getTaskType().getType().equals("Done")) {
                tasksDone++;
            }
            if (listTasks.get(i).getTaskType().getType().equals("Overdue")) {
                tasksOverdue++;
            }
        }
        returnList.add(tasksInProgress);
        returnList.add(tasksDone);
        returnList.add(tasksOverdue);
        return returnList;
    }

    public List<Task> getAllTasksForFilter(Date fromDate, Date toDate, int period_id, int task_type_id, int user_id) throws DaoException, ClassNotFoundException {
        java.sql.Date sqlFromDate = null;
        java.sql.Date sqlToDate = null;
        if (fromDate != null) {
            sqlFromDate = new java.sql.Date(fromDate.getTime());
        }
        if (toDate != null) {
            sqlToDate = new java.sql.Date(toDate.getTime());
        }
        listTasks = taskDAO.getAllTasksForFilter(sqlFromDate, sqlToDate, period_id, task_type_id, user_id);
        return listTasks;
    }

    public List<Task> getOverdueTasksForFilter(Date fromDate, Date toDate, int period_id, int task_type_id, int user_id) throws DaoException, ClassNotFoundException {
        java.sql.Date sqlFromDate = null;
        java.sql.Date sqlToDate = null;
        if (fromDate != null) {
            sqlFromDate = new java.sql.Date(fromDate.getTime());
        }
        if (toDate != null) {
            sqlToDate = new java.sql.Date(toDate.getTime());
        }
        listTasks = taskDAO.getOverdueTasksForFilter(sqlFromDate, sqlToDate, period_id, task_type_id, user_id);
        return listTasks;
    }

    public List<Task> getDeletedTasksForFilter(Date fromDate, Date toDate, int period_id, int task_type_id, int user_id) throws DaoException, ClassNotFoundException {
        java.sql.Date sqlFromDate = null;
        java.sql.Date sqlToDate = null;
        if (fromDate != null) {
            sqlFromDate = new java.sql.Date(fromDate.getTime());
        }
        if (toDate != null) {
            sqlToDate = new java.sql.Date(toDate.getTime());
        }
        listTasks = taskDAO.getDeletedTasksForFilter(sqlFromDate, sqlToDate, period_id, task_type_id, user_id);
        return listTasks;
    }
}

