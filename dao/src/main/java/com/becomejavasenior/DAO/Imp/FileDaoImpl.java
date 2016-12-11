package com.becomejavasenior.DAO.Imp;

import com.becomejavasenior.DAO.DaoException;
import com.becomejavasenior.DAO.FileDao;
import com.becomejavasenior.bean.File;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Repository;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.List;

@Repository("fileDao")
public class FileDaoImpl extends AbstractDaoImpl<File> implements FileDao<File> {
    @Override
    public File getByName(String str) throws DaoException, ClassNotFoundException {
        return null;
    }

    @Override
    void createStatement(PreparedStatement preparedStatement, File entity) throws DaoException {

    }

    @Override
    void updateStatement(PreparedStatement preparedStatement, File entity) throws DaoException {

    }

    @Override
    File getEntity(ResultSet resultSet) throws DaoException {
        return null;
    }

    @Override
    String getCreateQuery() {
        return null;
    }

    @Override
    String getUpdateQuery() {
        return null;
    }

    @Override
    String getDeleteQuery() {
        return null;
    }

    @Override
    String getByIdQuery() {
        return null;
    }

    @Override
    String getAllQuery() {
        return null;
    }

    @Override
    public List<File> getByFilter(String query) {
        return null;
    }
}
