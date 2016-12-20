package com.becomejavasenior.DAO.JdbcTempale;

import com.becomejavasenior.DAO.ContactDao;
import com.becomejavasenior.DAO.DaoException;
import com.becomejavasenior.DAO.mapper.ContactRowMapper;
import com.becomejavasenior.bean.Contact;
import org.springframework.jdbc.core.namedparam.MapSqlParameterSource;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository("contactDaoJdbcTemplate")
public class ContactDaoJdbcTemplateImpl extends AbstractDaoJdbcTemplate<Contact> implements ContactDao<Contact> {

    private NamedParameterJdbcTemplate namedParameterJdbcTemplate;

    private static final String SELECT_ALL_SQL = "SELECT * FROM crm_pallas.contact WHERE NOT is_deleted";

    private static final String SELECT_BY_NAME = "SELECT * FROM crm_pallas.contact WHERE NOT is_deleted AND name = :str";

    public ContactDaoJdbcTemplateImpl(NamedParameterJdbcTemplate namedParameterJdbcTemplate) {
        this.namedParameterJdbcTemplate = namedParameterJdbcTemplate;
    }

    @Override
    public List<Contact> getContactsForList(int id) {
        List<Contact> contacts = namedParameterJdbcTemplate.query(SELECT_ALL_SQL, new ContactRowMapper());
        return contacts;
    }

    @Override
    public void delete(Integer id) throws DaoException {

    }

    @Override
    public Contact getByName(String str) throws DaoException, ClassNotFoundException {
        Contact contact = (Contact) namedParameterJdbcTemplate.query(SELECT_BY_NAME, new MapSqlParameterSource("str", String.valueOf(str)), new ContactRowMapper());
        return contact;
    }

    @Override
    public Contact create(Contact o) {
        return null;
    }

    @Override
    public Contact update(Contact contact) {
        return null;
    }

    @Override
    public List<Contact> getAll() throws DaoException, ClassNotFoundException {
        return null;
    }

    @Override
    public Contact getById(Integer id) throws DaoException {
        return null;
    }
}
