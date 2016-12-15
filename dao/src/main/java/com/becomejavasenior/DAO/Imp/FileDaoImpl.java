package com.becomejavasenior.DAO.Imp;

import com.becomejavasenior.DAO.DaoException;
import com.becomejavasenior.DAO.DatabaseException;
import com.becomejavasenior.DAO.FileDao;
import com.becomejavasenior.bean.File;
import com.becomejavasenior.bean.Note;
import com.becomejavasenior.bean.User;
import com.becomejavasenior.factory.PostgresDaoFactory;
<<<<<<< HEAD
import org.springframework.stereotype.Repository;

=======
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import javax.sql.DataSource;
>>>>>>> develop
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

@Repository("fileDao")
public class FileDaoImpl extends AbstractDaoImpl<File> implements FileDao<File> {

<<<<<<< HEAD
=======
    @Autowired
    public FileDaoImpl(DataSource dataSource) {
        super(dataSource);
    }

>>>>>>> develop
    private static final String SELECT_FILE_FOR_LIST = "SELECT\n" +
            "  crm_pallas.file.id,\n" +
            "  crm_pallas.file.file_name as fileName,\n" +
            "  crm_pallas.file.file_path as pathFile,\n" +
            "  crm_pallas.file.creation_date_time as createDateFile,\n" +
            "  crm_pallas.file.file_size_in_bytes as fileSize,\n" +
            "  crm_pallas.user.last_name as lName,\n" +
            "  crm_pallas.user.first_name as fName\n" +
            "FROM crm_pallas.file\n" +
            "JOIN crm_pallas.note ON crm_pallas.file.note_id = crm_pallas.note.id\n" +
            "JOIN crm_pallas.user ON crm_pallas.note.created_by_user_id = crm_pallas.user.id\n" +
            "JOIN crm_pallas.company ON crm_pallas.note.company_id = crm_pallas.company.id\n" +
            "WHERE crm_pallas.company.id = ?";

    @Override
    public List<File> getFilesForList(int id) {
        List<File> files = new ArrayList<>();
        File file = new File();
        User user;
        Note note;
<<<<<<< HEAD
        try (Connection connection = PostgresDaoFactory.getConnection();
=======
        try (Connection connection = getConnection();
>>>>>>> develop
             PreparedStatement statement = connection.prepareStatement(SELECT_FILE_FOR_LIST)) {
            statement.setInt(1, id);
            ResultSet resultSet = statement.executeQuery();
            while (resultSet.next()) {
                user = new User();
                note = new Note();
                file.setId(resultSet.getInt("id"));
                file.setFileName(resultSet.getString("fileName"));
                file.setFilePath(resultSet.getString("pathFile"));
                file.setFileSize((byte) resultSet.getInt("fileSize"));
                file.setDateCreate(resultSet.getDate("createDateFile"));
                user.setlName(resultSet.getString("lName"));
                user.setfName(resultSet.getString("fName"));
                note.setCreatedUser(user);
                file.setFileNote(note);
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
