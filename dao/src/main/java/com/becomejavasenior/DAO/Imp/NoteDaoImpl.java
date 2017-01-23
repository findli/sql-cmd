package com.becomejavasenior.DAO.Imp;

import com.becomejavasenior.DAO.*;
import com.becomejavasenior.DataBaseUtil;
import com.becomejavasenior.bean.*;
import com.becomejavasenior.exceptions.DatabaseException;
import com.becomejavasenior.factory.PostgresDaoFactory;
import org.springframework.stereotype.Repository;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Repository;

import javax.sql.DataSource;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;

@Repository("noteDao")
public class NoteDaoImpl extends AbstractDaoImpl<Note> implements NoteDao<Note> {

    public NoteDaoImpl(DataSource dataSource) {
        super(dataSource);
    }

    @Autowired
    DataSource dataSource;

    @Autowired
    @Qualifier("userDao")
    UserDao userDao;

    @Autowired
    @Qualifier("companyDao")
    CompanyDao companyDao;

    @Autowired
    @Qualifier("contactDao")
    ContactDao contactDao;

    @Autowired
    @Qualifier("dealDao")
    DealDao dealDao;

    private static final String SELECT_NOTE_FOR_LIST= "SELECT crm_pallas.note.id as noteId,\n" +
            "crm_pallas.note.note_text,\n" +
            "crm_pallas.user.last_name as lName,\n" +
            "crm_pallas.user.first_name as fName,\n" +
            "crm_pallas.note.created_date_time as createDateNote\n" +
            "FROM crm_pallas.note\n" +
            "JOIN crm_pallas.user ON crm_pallas.note.created_by_user_id = crm_pallas.user.id\n" +
            "JOIN crm_pallas.company ON crm_pallas.note.company_id = crm_pallas.company.id\n" +
            "WHERE crm_pallas.company.id = ? AND crm_pallas.note.is_deleted = FALSE";

    @Override
    void createStatement(PreparedStatement preparedStatement, Note note) throws DaoException {
        try {
            preparedStatement.setString(1, note.getNoteText());
            preparedStatement.setInt(2, note.getCreatedUser().getId());
            preparedStatement.setTimestamp(3, new Timestamp(note.getDateCreate().getTime()));
            preparedStatement.setBoolean(4, note.isDeleted());
            preparedStatement.setInt(5, note.getContact().getId());
            preparedStatement.setInt(6, note.getCompany().getId());
            preparedStatement.setInt(7, note.getDeal().getId());


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
            preparedStatement.setInt(5, note.getContact().getId());
            preparedStatement.setInt(6, note.getCompany().getId());
            preparedStatement.setInt(7, note.getDeal().getId());
            preparedStatement.setInt(8, note.getId());

        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    @Override
    String getAllQuery() {
        return DataBaseUtil.getQuery("SELECT * FROM crm_pallas.note WHERE is_deleted = FALSE");
    }

    @Override
    public List<Note> getByFilter(String query) {
        return null;
    }

    @Override
    String getByIdQuery() {
        return DataBaseUtil.getQuery("SELECT * FROM crm_pallas.note WHERE id=?");
    }

    @Override
    String getCreateQuery() {
        return DataBaseUtil.getQuery("INSERT INTO crm_pallas.note (note_text, created_by_user_id, created_date_time, is_deleted, contact_id, company_id, deal_id) values (?,?,?,?,?,?,?)");

    }

    @Override
    String getDeleteQuery() {
        return DataBaseUtil.getQuery("DELETE FROM crm_pallas.note WHERE id = ?");
    }

    @Override
    String getUpdateQuery() {
        return DataBaseUtil.getQuery("UPDATE crm_pallas.note SET note_text = ?, created_by_user_id = ?, " +
                "creation_date_time = ?, is_deleted = ?, contact_id = ?, company_id = ?, deal_id = ? WHERE id = ?");
    }

    @Override
    public Note getByName(String str) throws DaoException, ClassNotFoundException {
        return null;
    }

    @Override
    public List<Note> getAll() throws DaoException, ClassNotFoundException {
        List<Note> notes = new ArrayList<>();
        Note note;
        User createdUser;
        Company company;
        Contact contact;
        Deal deal;

        try (Connection connection = getConnection();
             Statement statement = connection.createStatement();
             ResultSet resultSet = statement.executeQuery(getAllQuery())) {

            while (resultSet.next()) {

                note = new Note();
                createdUser = new User();
                company = new Company();
                contact = new Contact();
                deal = new Deal();

                note.setId(resultSet.getInt("id"));

                createdUser = (User) userDao.getById(resultSet.getInt("created_by_user_id"));
                note.setCreatedUser(createdUser);
                note.setNoteText(resultSet.getString("note_text"));
                note.setDateCreate(resultSet.getDate("creation_date_time"));
                note.setDeleted(resultSet.getBoolean("is_deleted"));

                company = (Company) companyDao.getById(resultSet.getInt("company_id"));
                note.setCompany(company);

                contact = (Contact) contactDao.getById(resultSet.getInt("contact_id"));
                note.setContact(contact);

                deal = (Deal) dealDao.getById(resultSet.getInt("deal_id"));
                note.setDeal(deal);

                notes.add(note);
            }
        } catch (SQLException ex) {
            throw new DatabaseException(ex);
        }

        return notes;
    }


    @Override
    Note getEntity(ResultSet resultSet) throws DaoException {
        Note note = new Note();
        User user = new User();
        Company company = new Company();
        Contact contact = new Contact();
        Deal deal = new Deal();

        try {
            note.setId(resultSet.getInt("id"));

            user = (User) userDao.getById(resultSet.getInt("created_by_user_id"));
            note.setCreatedUser(user);

            note.setNoteText(resultSet.getString("note_text"));
            note.setDateCreate(resultSet.getDate("created_date_time"));
            note.setDeleted(resultSet.getBoolean("is_deleted"));

            company = (Company) companyDao.getById(resultSet.getInt("company_id"));
            note.setCompany(company);

            contact = (Contact) contactDao.getById(resultSet.getInt("contact_id"));
            note.setContact(contact);

            deal = (Deal) dealDao.getById(resultSet.getInt("deal_id"));
            note.setDeal(deal);

        } catch (SQLException e) {
            throw new DaoException("Can't get entity from Note", e);
        }
        return note;
    }

    @Override
    public List<Note> getNotesForList(int id) {
        List<Note> notes = new ArrayList<>();
        User user;
        Note note;

        try (Connection connection = getConnection();
             PreparedStatement statement = connection.prepareStatement(SELECT_NOTE_FOR_LIST)) {
            statement.setInt(1,id);
            ResultSet resultSet = statement.executeQuery();
            while (resultSet.next()) {
                user = new User();
                note = new Note();
                note.setId(resultSet.getInt("noteId"));
                note.setNoteText(resultSet.getString("note_text"));
                user.setlName(resultSet.getString("lName"));
                note.setCreatedUser(user);
                note.setDateCreate(resultSet.getDate("createDateNote"));
                notes.add(note);
            }
        } catch (SQLException ex) {
            throw new DatabaseException(ex);
        }
        return notes;
    }

}