package com.becomejavasenior.service.impl;

import com.becomejavasenior.DAO.DaoException;
import com.becomejavasenior.DAO.Imp.TaskTypeDaoImpl;
import com.becomejavasenior.DAO.TaskTypeDao;
import com.becomejavasenior.bean.TaskType;
import com.becomejavasenior.service.TaskTypeService;

import java.util.List;

public class TaskTypeServiceImpl implements TaskTypeService {

    private TaskTypeDao<TaskType> taskTypeDao = new TaskTypeDaoImpl();

    @Override
    public TaskType create(TaskType taskType) throws DaoException {
        return taskTypeDao.create(taskType);
    }

    @Override
    public void delete(int id) throws DaoException {
        taskTypeDao.delete(id);
    }

    @Override
    public List<TaskType> getAll() throws DaoException, ClassNotFoundException {
        return taskTypeDao.getAll();
    }

    @Override
    public TaskType getById(int id) throws DaoException {
        return taskTypeDao.getById(id);
    }

    @Override
    public void update(TaskType taskType) throws DaoException {
        taskTypeDao.update(taskType);
    }
}
