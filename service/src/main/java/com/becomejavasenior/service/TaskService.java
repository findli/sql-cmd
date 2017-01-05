package com.becomejavasenior.service;


import com.becomejavasenior.DAO.DaoException;
import com.becomejavasenior.bean.*;

import java.util.Date;
import java.util.List;

public interface TaskService {

    List<Task> getAll() throws DaoException, ClassNotFoundException;

    void addTask(Task task) throws DaoException;

    void delete(int id) throws DaoException;

    Task getById(int id) throws DaoException;

    Task update(Task task) throws DaoException;

    List<Task> getTasksForList(int id);

    public List getTaskForDashboard() throws DaoException, ClassNotFoundException;

    public List<Task> getAllTasksForFilter(Date fromDate, Date toDate, int period_id, int task_type_id, int user_id) throws DaoException, ClassNotFoundException;

    public List<Task> getOverdueTasksForFilter(Date fromDate, Date toDate, int period_id, int task_type_id, int user_id) throws DaoException, ClassNotFoundException;

    public List<Task> getDeletedTasksForFilter(Date fromDate, Date toDate, int period_id, int task_type_id, int user_id) throws DaoException, ClassNotFoundException;

    List getTaskForDashboard() throws DaoException, ClassNotFoundException;
}
