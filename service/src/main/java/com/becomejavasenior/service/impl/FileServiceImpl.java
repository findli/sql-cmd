package com.becomejavasenior.service.impl;

import com.becomejavasenior.DAO.DaoException;
import com.becomejavasenior.DAO.FileDao;
import com.becomejavasenior.DAO.Imp.FileDaoImpl;
import com.becomejavasenior.bean.File;
import com.becomejavasenior.bean.User;
import com.becomejavasenior.exceptions.DatabaseException;
import com.becomejavasenior.factory.PostgresDaoFactory;
import com.becomejavasenior.service.FileService;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;


public class FileServiceImpl implements FileService {

    private final FileDao file = new FileDaoImpl();

    @Override
    public File create(File t) throws DaoException {
        return null;
    }

    @Override
    public void update(File t) throws DaoException {

    }

    @Override
    public List<File> getAll() throws DaoException, ClassNotFoundException {
        return null;
    }

    @Override
    public File getById(int id) throws DaoException {
        return null;
    }

    @Override
    public void delete(int id) throws DaoException {

    }

    @Override
    public void createNewFile() {

    }

    @Override
    public List<File> getFilesForList(int id) {
        return  file.getFilesForList(id);
    }
}
