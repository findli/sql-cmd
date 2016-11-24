package com.becomejavasenior.service;

import com.becomejavasenior.DAO.DAOException;
import com.becomejavasenior.bean.TaskType;

import java.util.List;

public interface TaskTypeService {
    TaskType create(TaskType t) throws DAOException;
    void update(TaskType t) throws DAOException;
    List<TaskType> getAll() throws DAOException, ClassNotFoundException;
    TaskType getById(int id) throws DAOException;
    void delete(int id) throws DAOException;
}
