package com.becomejavasenior.DAO.Imp;

import com.becomejavasenior.DAO.ContactDao;
import com.becomejavasenior.DAO.DaoException;
import com.becomejavasenior.bean.Contact;
import org.springframework.stereotype.Repository;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.List;

@Repository("contactDaoJdbcTemplate")
public class ContactDaoJdbcTemplateImpl extends AbstractDaoImpl<Contact> implements ContactDao<Contact> {

    @Override
    public List<Contact> getContactsForList(int contactId) {
        return null;
    }

    @Override
    public Contact getByName(String str) throws DaoException, ClassNotFoundException {
        return null;
    }

    @Override
    void createStatement(PreparedStatement preparedStatement, Contact entity) throws DaoException {

    }

    @Override
    void updateStatement(PreparedStatement preparedStatement, Contact entity) throws DaoException {

    }

    @Override
    Contact getEntity(ResultSet resultSet) throws DaoException {
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
    public List<Contact> getByFilter(String query) {
        return null;
    }
}
