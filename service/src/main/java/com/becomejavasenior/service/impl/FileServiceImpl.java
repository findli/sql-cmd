package com.becomejavasenior.service.impl;

import com.becomejavasenior.DAO.DaoException;
import com.becomejavasenior.DAO.FileDao;
import com.becomejavasenior.DAO.Imp.FileDaoImpl;
import com.becomejavasenior.bean.File;
import com.becomejavasenior.service.FileService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.sql.DataSource;
import java.util.List;

@Service(value = "fileService")
public class FileServiceImpl implements FileService {

    private final FileDao fileDao;

    @Autowired
    public FileServiceImpl(FileDao fileDao) {
        this.fileDao = fileDao;
    }

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
        fileDao.delete(id);
    }

    @Override
    public void createNewFile() {

    }

    @Override
    public List<File> getFilesForList(int id) {
        return  fileDao.getFilesForList(id);
    }
}