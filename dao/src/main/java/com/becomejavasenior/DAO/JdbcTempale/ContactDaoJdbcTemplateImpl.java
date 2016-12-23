package com.becomejavasenior.DAO.JdbcTempale;

import com.becomejavasenior.DAO.ContactDao;
import com.becomejavasenior.DAO.DaoException;
import com.becomejavasenior.DAO.mapper.ContactRowMapper;
import com.becomejavasenior.DAO.mapper.DealRowMapper;
import com.becomejavasenior.DAO.mapper.StageRowMapper;
import com.becomejavasenior.bean.Contact;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.PreparedStatementCreator;
import org.springframework.jdbc.core.PreparedStatementSetter;
import org.springframework.jdbc.core.namedparam.MapSqlParameterSource;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.jdbc.support.GeneratedKeyHolder;
import org.springframework.jdbc.support.KeyHolder;
import org.springframework.stereotype.Repository;

import java.sql.PreparedStatement;
import java.util.List;

@Repository("contactDao")
public class ContactDaoJdbcTemplateImpl extends AbstractDaoJdbcTemplate<Contact> implements ContactDao<Contact> {

    @Autowired
    private NamedParameterJdbcTemplate namedParameterJdbcTemplate;

    @Autowired
    private ContactRowMapper contactRowMapper;

    @Autowired
    private DealRowMapper dealRowMapper;

    @Autowired
    private StageRowMapper stageRowMapper;

    private static final String SELECT_ALL_SQL = "SELECT * FROM crm_pallas.contact WHERE NOT is_deleted";

    private static final String SELECT_BY_NAME = "SELECT * FROM crm_pallas.contact WHERE NOT is_deleted AND name = :str";

    private static final String INSERT_SQL = "INSERT INTO crm_pallas.contact " +
            "(first_name, last_name, email, post, skype, company_id, responsible_user_id, is_deleted) " +
            "values (?,?,?,?,?,?,?,?)";

    private static final String UPDATE_SQL = "UPDATE crm_pallas.contact SET first_name = ?, last_name = ?, email = ?, post = ?, skype =?, company_id = ? " +
        "responsible_user_id = ?, is_deleted = ? WHERE id = ?";

    private static final String SELECT_CONTACT_FOR_LIST = "SELECT crm_pallas.contact.id,\n" +
            "  crm_pallas.contact.first_name as fName,\n" +
            "  crm_pallas.contact.last_name as lName,\n" +
            "  crm_pallas.contact.post,\n" +
            "  crm_pallas.contact.email,\n" +
            "  crm_pallas.contact.skype,\n" +
            "  crm_pallas.contact_phone.phone_number as phoneNumber,\n" +
            "  crm_pallas.phone_type.title,\n" +
            "  crm_pallas.company.id as companyId\n" +
            "FROM crm_pallas.contact\n" +
            "  JOIN crm_pallas.company ON crm_pallas.contact.company_id = crm_pallas.company.id\n" +
            "  JOIN crm_pallas.contact_phone ON crm_pallas.contact.id = crm_pallas.contact_phone.contact_id\n" +
            "  JOIN crm_pallas.phone_type ON crm_pallas.contact_phone.phone_type_id = crm_pallas.phone_type.id\n" +
            "where company_id = ? AND contact.is_deleted = FALSE";

    @Override
    public List<Contact> getContactsForList(int id) {
        List<Contact> contacts = namedParameterJdbcTemplate.query(SELECT_CONTACT_FOR_LIST, new ContactRowMapper());
        return contacts;
    }

    @Override
    public void delete(Integer id) throws DaoException {
        delete(id, "contact");
    }

    @Override
    public Contact getByName(String str) throws DaoException, ClassNotFoundException {
        Contact contact = (Contact) namedParameterJdbcTemplate.query(SELECT_BY_NAME, new MapSqlParameterSource("str", String.valueOf(str)), new ContactRowMapper());
        return contact;
    }

    @Override
    public Contact create(Contact contact) {
        PreparedStatementCreator preparedStatementCreator = connection -> {
            PreparedStatement preparedStatement = connection.prepareStatement(INSERT_SQL, new String[]{"id"});

            preparedStatement.setString(1, contact.getfName());
            preparedStatement.setString(2, contact.getlName());
            preparedStatement.setString(3, contact.getEmail());
            preparedStatement.setString(4, contact.getPosition());
            preparedStatement.setString(5, contact.getSkype());
            preparedStatement.setInt(6, contact.getCompany().getId());
            preparedStatement.setInt(7, contact.getResponsibleUser() == null ? null : contact.getResponsibleUser().getId());
            preparedStatement.setBoolean(8, contact.isDeleted());
            return preparedStatement;
        };

        KeyHolder keyHolder = new GeneratedKeyHolder();
        jdbcTemplate.update(preparedStatementCreator, keyHolder);
        int id=(int) keyHolder.getKey();
        contact.setId(id);

        return contact;
    }

    @Override
    public Contact update(Contact contact) {

        PreparedStatementSetter preparedStatementSetter = preparedStatement -> {

            preparedStatement.setString(1, contact.getfName());
            preparedStatement.setString(2, contact.getlName());
            preparedStatement.setString(3, contact.getEmail());
            preparedStatement.setString(4, contact.getPosition());
            preparedStatement.setString(5, contact.getSkype());
            preparedStatement.setInt(6, contact.getCompany().getId());
            preparedStatement.setInt(7, contact.getResponsibleUser() == null ? null : contact.getResponsibleUser().getId());
            preparedStatement.setBoolean(8, contact.isDeleted());
            preparedStatement.setInt(9, contact.getId());

            preparedStatement.executeQuery();
        };

        jdbcTemplate.update(UPDATE_SQL, preparedStatementSetter);
        return contact;
    }

    @Override
    public List<Contact> getAll() throws DaoException, ClassNotFoundException {
        List<Contact> contacts = namedParameterJdbcTemplate.query(SELECT_ALL_SQL, contactRowMapper);
        return contacts;
    }

    @Override
    public Contact getById(Integer id) throws DaoException {
        Contact contact = jdbcTemplate.queryForObject(SELECT_ALL_SQL + " AND id = ?", contactRowMapper, id);
        return contact;
    }
}
