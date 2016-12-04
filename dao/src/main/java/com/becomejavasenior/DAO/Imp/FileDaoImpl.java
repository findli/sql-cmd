package com.becomejavasenior.DAO.Imp;


import com.becomejavasenior.DAO.DaoException;
import com.becomejavasenior.DAO.FileDao;
import com.becomejavasenior.bean.File;
import com.becomejavasenior.bean.User;
import com.becomejavasenior.exceptions.DatabaseException;
import com.becomejavasenior.factory.PostgresDaoFactory;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class FileDaoImpl extends AbstractDaoImpl<File> implements FileDao {

    private static final String SELECT_DEALS_FOR_LIST = "SELECT crm_pallas.file.id,\n" +
            "  crm_pallas.user.last_name as lName,\n" +
            "  crm_pallas.file.creation_date_time as createDateFile,\n" +
            "  crm_pallas.file.file_name as fileName,\n" +
            "  crm_pallas.file.file_size_in_bytes as fileSize,\n" +
            "  crm_pallas.file.file_path as pathFile\n" +
            "FROM crm_pallas.note\n" +
            "  JOIN crm_pallas.user ON crm_pallas.note.created_by_user_id = crm_pallas.user.id\n" +
            "  JOIN crm_pallas.note_file on crm_pallas.note.id = crm_pallas.note_file.note_id\n" +
            "  JOIN crm_pallas.file on crm_pallas.note_file.file_id = crm_pallas.file.id\n" +
            "  JOIN crm_pallas.company_note on crm_pallas.note.id = crm_pallas.company_note.note_id\n" +
            "  JOIN crm_pallas.company on crm_pallas.company_note.company_id = crm_pallas.company.id\n" +
            "WHERE crm_pallas.company.id = ?";



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

    @Override
    public List<File> getFilesForList(int id) {
        List<File> files = new ArrayList<>();
        File file;
        User user;

        try (Connection connection = PostgresDaoFactory.getConnection();
             PreparedStatement statement = connection.prepareStatement(SELECT_DEALS_FOR_LIST)) {
            statement.setInt(1, id);
            ResultSet resultSet = statement.executeQuery();

            while (resultSet.next()) {
                file = new File();
                user = new User();
                file.setId(resultSet.getInt("id"));
                file.setFileName(resultSet.getString("fileName"));
                file.setFilePath(resultSet.getString("pathFile"));
                file.setFileSize((byte) resultSet.getInt("fileSize"));
                file.setDateCreate(resultSet.getDate("createDateFile"));
                user.setlName(resultSet.getString("lName"));
                files.add(file);
            }
        } catch (SQLException ex) {
            throw new DatabaseException(ex);
        }
        return files;
    }

    @Override
    public File getByName(String str) throws DaoException, ClassNotFoundException {
        return null;
    }
}
