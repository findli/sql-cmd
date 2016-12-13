package com.becomejavasenior.service;


import com.becomejavasenior.DAO.DaoException;
import com.becomejavasenior.bean.Task;

import java.util.List;

public interface TaskService {
    public List<Task> getAll() throws DaoException, ClassNotFoundException;
    public void addTask(Task task) throws DaoException;
    public  void deleteTask(int id) throws DaoException;
    public Task getById(int id) throws DaoException;
    public Task update(Task task) throws DaoException;
    List<Task> getTasksForList(int id);
}
