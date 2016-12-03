package com.becomejavasenior.service;


import com.becomejavasenior.DAO.DaoException;
import com.becomejavasenior.bean.*;

import java.util.List;

public interface TaskService {
    Task create(Task t) throws DaoException;
    void update(Task t) throws DaoException;
    List<Task> getAll() throws DaoException, ClassNotFoundException;
    Task getById(int id) throws DaoException;
    void delete(int id) throws DaoException;
    List<Task> getTasksForList(int id);
    public void createNewTask() throws DaoException, ClassNotFoundException;
}
