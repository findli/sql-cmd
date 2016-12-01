package com.becomejavasenior.service;

import com.becomejavasenior.DAO.DaoException;
import com.becomejavasenior.bean.*;

import java.util.List;

public interface FileService {

    File create(File t) throws DaoException;
    void update(File t) throws DaoException;
    List<File> getAll() throws DaoException, ClassNotFoundException;
    File getById(int id) throws DaoException;
    void delete(int id) throws DaoException;
    List<File> getFilesForList();
    public void createNewFile() throws DaoException, ClassNotFoundException;
}
