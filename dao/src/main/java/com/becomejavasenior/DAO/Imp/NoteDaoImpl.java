package com.becomejavasenior.DAO.Imp;


import com.becomejavasenior.DAO.DaoException;
import com.becomejavasenior.DAO.NoteDao;
import com.becomejavasenior.bean.Note;
import com.becomejavasenior.bean.User;
import com.becomejavasenior.exceptions.DatabaseException;
import com.becomejavasenior.factory.PostgresDAOFactory;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class NoteDaoImpl extends AbstractDaoImpl<Note> implements NoteDao<Note> {

    @Override
    void createStatement(PreparedStatement preparedStatement, Note entity) throws DaoException {

    }

    @Override
    void updateStatement(PreparedStatement preparedStatement, Note entity) throws DaoException {

    }

    @Override
    Note getEntity(ResultSet resultSet) throws DaoException {
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
    public List<Note> getFilesForNote() {
        List<Note> notes = new ArrayList<>();
        User user;
        Note note;

        try (Connection connection = PostgresDAOFactory.getConnection();
             PreparedStatement statement = connection.prepareStatement("SELECT crm_pallas.note.id as noteId, crm_pallas.note.note_text,\n" +
                     "crm_pallas.user.last_name as lName,\n" +
                     "crm_pallas.note.creation_date_time as createDateNote,\n" +
                     "crm_pallas.file.id as fileId,\n" +
                     "crm_pallas.file.file_name,\n" +
                     "crm_pallas.file.creation_date_time as createDateFile,\n" +
                     "crm_pallas.file.file_path,\n" +
                     "crm_pallas.file.file_size_in_bytes as fileSize\n" +
                     "FROM crm_pallas.note\n" +
                     "JOIN crm_pallas.user ON crm_pallas.note.created_by_user_id = crm_pallas.user.id\n" +
                     "JOIN crm_pallas.note_file ON crm_pallas.note_file.file_id = crm_pallas.note.id\n" +
                     "JOIN crm_pallas.file on crm_pallas.file.id = crm_pallas.note_file.file_id")) {

            ResultSet resultSet = statement.executeQuery();
            while (resultSet.next()) {
                user = new User();
                note = new Note();
                note.setId(resultSet.getInt("noteId"));
                note.setNoteText(resultSet.getString("note_text"));
                user.setlName(resultSet.getString("lName"));
                note.setCreatedByUserId(user);
                note.setDateCreate(resultSet.getDate("createDateNote"));
                notes.add(note);
            }
        } catch (SQLException ex) {
            throw new DatabaseException(ex);
        }
        return notes;
    }
}
