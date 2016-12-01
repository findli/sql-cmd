package com.becomejavasenior.DAO.Imp;

import com.becomejavasenior.DAO.DaoException;
import com.becomejavasenior.DAO.NoteDAO;
import com.becomejavasenior.DataBaseUtil;
import com.becomejavasenior.bean.Note;
import com.becomejavasenior.bean.User;
import com.becomejavasenior.exceptions.DatabaseException;
import com.becomejavasenior.factory.PostgresDAOFactory;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class NoteDAOImpl extends AbstractDAOImpl<Note> implements NoteDAO<Note> {

    @Override
    void createStatement(PreparedStatement preparedStatement, Note note) throws DaoException {
        try {
            preparedStatement.setString(1, note.getNoteText());
            preparedStatement.setInt(2, note.getCreatedUser().getId());
            preparedStatement.setTimestamp(3, new Timestamp(note.getDateCreate().getTime()));
            preparedStatement.setBoolean(4, note.isDeleted());

        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    @Override
    void updateStatement(PreparedStatement preparedStatement, Note note) throws DaoException {
        try {
            preparedStatement.setString(1, note.getNoteText());
            preparedStatement.setInt(2, note.getCreatedUser().getId());
            preparedStatement.setTimestamp(3, new Timestamp(note.getDateCreate().getTime()));
            preparedStatement.setBoolean(4, note.isDeleted());

        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    @Override
    String getAllQuery() {
        return DataBaseUtil.getQuery("SELECT * FROM crm_pallas.note WHERE is_deleted = FALSE");
    }

    @Override
    String getByIdQuery() {
        return DataBaseUtil.getQuery("SELECT * FROM crm_pallas.note WHERE id=?");
    }

    @Override
    String getCreateQuery() {
        return DataBaseUtil.getQuery("INSERT INTO crm_pallas.note (note_text, created_by_user_id, creation_date_time) values (?,?,?)");

    }

    @Override
    String getDeleteQuery() {
        return DataBaseUtil.getQuery("DELETE FROM crm_pallas.note WHERE id = ?");
    }

    @Override
    String getUpdateQuery() {
        return DataBaseUtil.getQuery("UPDATE crm_pallas.note SET note_text = ?, created_by_user_id = ?, " +
                "creation_date_time = ? WHERE id = ?");
    }

    @Override
    public List<Note> getAll() throws DaoException, ClassNotFoundException {
        List<Note> notes = new ArrayList<>();
        Note note;
        User createdUser;

        try (Connection connection = PostgresDAOFactory.getConnection();
             Statement statement = connection.createStatement();
             ResultSet resultSet = statement.executeQuery(getAllQuery())) {

            while (resultSet.next()) {

                note = new Note();
                createdUser = new User();

                note.setId(resultSet.getInt("id"));
                createdUser.setId(resultSet.getInt("created_by_user_id"));
                note.setCreatedUser(createdUser);
                note.setNoteText(resultSet.getString("note_text"));
                note.setDateCreate(resultSet.getDate("creation_date_time"));
                note.setDeleted(resultSet.getBoolean("is_deleted"));

                notes.add(note);
            }
        } catch (SQLException ex) {
            throw new DatabaseException(ex);
        }

        return notes;
    }

    @Override
    public List<Note> getByFilter(String query) {
        return null;
    }

    @Override
    Note getEntity(ResultSet resultSet) throws DaoException {
        return null;
    }

}
