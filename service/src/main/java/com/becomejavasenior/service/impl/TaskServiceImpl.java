package com.becomejavasenior.service.impl;


import com.becomejavasenior.DAO.DaoException;
import com.becomejavasenior.DAO.Imp.TaskDaoImpl;
import com.becomejavasenior.DAO.TaskDao;
import com.becomejavasenior.bean.Task;
import com.becomejavasenior.service.TaskService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.sql.DataSource;
import java.util.ArrayList;
import java.util.List;

@Service(value = "taskService")
public class TaskServiceImpl implements TaskService {

    List<Task> listTasks = new ArrayList<Task>();
    private final TaskDao taskDAO;
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
}
