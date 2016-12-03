package com.becomejavasenior.service;

import com.becomejavasenior.DAO.DaoException;
import com.becomejavasenior.bean.TaskType;

import java.util.List;

public interface TaskTypeService {
    TaskType create(TaskType t) throws DaoException;
    void update(TaskType t) throws DaoException;
    List<TaskType> getAll() throws DaoException, ClassNotFoundException;
    TaskType getById(int id) throws DaoException;
    void delete(int id) throws DaoException;
}
