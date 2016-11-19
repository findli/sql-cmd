package com.becomejavasenior.service;

import com.becomejavasenior.DAO.DAOException;
import com.becomejavasenior.bean.Stage;

import java.util.List;

public interface StageService {
    Stage create(Stage t) throws DAOException;
    void update(Stage t) throws DAOException;
    List<Stage> getAll() throws DAOException, ClassNotFoundException;
    Stage getById(int id) throws DAOException;
    void delete(int id) throws DAOException;
}
