package com.becomejavasenior.service;

import com.becomejavasenior.DAO.DaoException;
import com.becomejavasenior.bean.Stage;

import java.util.List;

public interface StageService {
    Stage create(Stage t) throws DaoException;
    void update(Stage t) throws DaoException;
    List<Stage> getAll() throws DaoException, ClassNotFoundException;
    Stage getById(int id) throws DaoException;
    void delete(int id) throws DaoException;
    Stage getByName(String str) throws DaoException, ClassNotFoundException;
}
