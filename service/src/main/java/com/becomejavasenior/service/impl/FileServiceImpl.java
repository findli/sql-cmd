package com.becomejavasenior.service.impl;

import com.becomejavasenior.DAO.DaoException;
import com.becomejavasenior.DAO.FileDao;
import com.becomejavasenior.DAO.Imp.FileDaoImpl;
import com.becomejavasenior.bean.File;
import com.becomejavasenior.bean.User;
import com.becomejavasenior.exceptions.DatabaseException;
import com.becomejavasenior.factory.PostgresDAOFactory;
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
    public List<File> getFilesForList() {
        List<File> files = new ArrayList<>();
        File file;
        User user;

        try (Connection connection = PostgresDAOFactory.getConnection();
             PreparedStatement statement = connection.prepareStatement("SELECT crm_pallas.file.id " +
                     "crm_pallas.file.file_name, \n" +
                     "crm_pallas.file.creation_date_time,\n" +
                     "crm_pallas.file.file_path,\n" +
                     "crm_pallas.file.file_size_in_bytes as fileSize,\n" +
                     "crm_pallas.user.last_name as lName\n" +
                     "FROM crm_pallas.note JOIN crm_pallas.note_file ON crm_pallas.note_file.file_id = crm_pallas.note.id\n" +
                     "JOIN crm_pallas.file on crm_pallas.file.id = crm_pallas.note_file.file_id\n" +
                     "JOIN crm_pallas.user on crm_pallas.note.created_by_user_id = crm_pallas.user.id")) {

            ResultSet resultSet = statement.executeQuery();

            while (resultSet.next()) {
                file = new File();
                user = new User();
                file.setId(resultSet.getInt("id"));
                file.setFileName(resultSet.getString("file_name"));
                file.setFilePath(resultSet.getString("file_path"));
                file.setFileSize((byte) resultSet.getInt("fileSize"));
                file.setDateCreate(resultSet.getDate("createDate"));
                user.setlName(resultSet.getString("lName"));


                files.add(file);
            }
        } catch (SQLException ex) {
            throw new DatabaseException(ex);
        }
        return files;
    }
}
