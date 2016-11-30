package com.becomejavasenior.service.impl;


import com.becomejavasenior.DAO.DaoException;
import com.becomejavasenior.DAO.Imp.TaskDaoImpl;
import com.becomejavasenior.DAO.TaskDao;
import com.becomejavasenior.bean.Task;
import com.becomejavasenior.service.TaskService;

import java.util.List;

public class TaskServiceImpl implements TaskService  {

    private final TaskDao taskDAO = new TaskDaoImpl();


    @Override
    public Task create(Task t) throws DaoException {
        return (Task) taskDAO.create(t);
    }

    @Override
    public void update(Task t) throws DaoException {
        taskDAO.update(t);
    }

    @Override
    public List<Task> getAll() throws DaoException, ClassNotFoundException {
        return taskDAO.getAll();
    }

    @Override
    public Task getById(int id) throws DaoException {
        return (Task) taskDAO.getById(id);
    }

    @Override
    public void delete(int id) throws DaoException {
        taskDAO.delete(id);
    }

    @Override
    public List<Task> getTasksForList() {
        return taskDAO.getTasksForList();
    }

    @Override
    public void createNewTask() throws DaoException, ClassNotFoundException {

    }
}
