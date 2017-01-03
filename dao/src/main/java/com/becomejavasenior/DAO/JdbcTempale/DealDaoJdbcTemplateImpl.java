package com.becomejavasenior.DAO.JdbcTempale;

import com.becomejavasenior.DAO.DaoException;
import com.becomejavasenior.DAO.DatabaseException;
import com.becomejavasenior.DAO.DealDao;
import com.becomejavasenior.DAO.mapper.ContactRowMapper;
import com.becomejavasenior.DAO.mapper.DealRowMapper;
import com.becomejavasenior.DAO.mapper.StageRowMapper;
import com.becomejavasenior.bean.Company;
import com.becomejavasenior.bean.Contact;
import com.becomejavasenior.bean.Deal;
import com.becomejavasenior.bean.Stage;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.PreparedStatementCreator;
import org.springframework.jdbc.core.PreparedStatementSetter;
import org.springframework.jdbc.support.GeneratedKeyHolder;
import org.springframework.jdbc.support.KeyHolder;
import org.springframework.stereotype.Repository;
import org.springframework.jdbc.core.RowMapper;

import javax.sql.DataSource;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;

@Repository("dealDao")
public class DealDaoJdbcTemplateImpl extends AbstractDaoJdbcTemplate<Deal> implements DealDao<Deal> {

    @Autowired
    DealRowMapper DEAL_ROW_MAPPER;

    @Autowired
    ContactRowMapper CONTACT_ROW_MAPPER;

    @Autowired
    StageRowMapper STAGE_ROW_MAPPER;

    private static final String SELECT_DEALS_FOR_LIST_BY_ID = "SELECT\n" +
            "  crm_pallas.deal.id AS dealId,\n" +
            "  crm_pallas.deal.title,\n" +
            "  crm_pallas.deal.budget,\n" +
            "  crm_pallas.stage.title AS stage,\n" +
            "  crm_pallas.contact.id AS contactId,\n" +
            "  crm_pallas.contact.last_name AS contact,\n" +
            "  crm_pallas.company.id AS companyId,\n" +
            "  crm_pallas.company.title AS company\n" +
            "FROM crm_pallas.deal\n" +
            "  JOIN crm_pallas.stage ON crm_pallas.deal.stage_id = crm_pallas.stage.id\n" +
            "  JOIN crm_pallas.contact ON crm_pallas.deal.primary_contact_id = crm_pallas.contact.id\n" +
            "  JOIN crm_pallas.company ON crm_pallas.deal.company_id = crm_pallas.company.id\n " +
            "WHERE crm_pallas.company.id= '?'; ";

    private static final String SELECT_DEALS_FOR_LIST = "SELECT\n" +
            "  crm_pallas.deal.id AS dealId,\n" +
            "  crm_pallas.deal.title,\n" +
            "  crm_pallas.deal.budget,\n" +
            "  crm_pallas.stage.title AS stage,\n" +
            "  crm_pallas.contact.id AS contactId,\n" +
            "  crm_pallas.contact.last_name AS contact,\n" +
            "  crm_pallas.company.id AS companyId,\n" +
            "  crm_pallas.company.title AS company\n" +
            "FROM crm_pallas.deal\n" +
            "  JOIN crm_pallas.stage ON crm_pallas.deal.stage_id = crm_pallas.stage.id\n" +
            "  JOIN crm_pallas.contact ON crm_pallas.deal.primary_contact_id = crm_pallas.contact.id\n" +
            "  JOIN crm_pallas.company ON crm_pallas.deal.company_id = crm_pallas.company.id ORDER BY dealId DESC\n";

    private static final String SELECT_ALL_CONTACT = "SELECT c1.id AS contactId, c1.first_name, c1.last_name, c1.post AS position, c1.email, c1.skype, c2.id AS companyId, c2.title, cp.phone_number, pt.title AS phone_type\n" +
            "FROM crm_pallas.deal d\n" +
            "  INNER JOIN crm_pallas.deal_contact cd ON ( d.id = cd.deal_id  )\n" +
            "  INNER JOIN crm_pallas.contact c1 ON ( cd.contact_id = c1.id  )\n" +
            "  INNER JOIN crm_pallas.company c2 ON ( c1.company_id = c2.id  )\n" +
            "  LEFT OUTER JOIN crm_pallas.contact_phone cp ON ( c1.id = cp.contact_id  )\n" +
            "  LEFT OUTER JOIN crm_pallas.phone_type pt ON ( cp.phone_type_id = pt.id  ) WHERE d.title ='?';";

    private static final String SELECT_ALL_STAGES = "SELECT * FROM crm_pallas.stage ORDER BY id LIMIT 4";

    private static final String SELECT_ALL_DEAL_BY_STAGE = "SELECT deal.id, deal.title, deal.budget, company.id AS companyId, company.title AS companyName\n" +
            "  FROM crm_pallas.deal\n" +
            "  JOIN crm_pallas.company ON crm_pallas.company.id = crm_pallas.deal.company_id\n" +
            "  WHERE crm_pallas.deal.id IN (SELECT crm_pallas.deal.id\n" +
            "                  FROM crm_pallas.deal\n" +
            "                    JOIN crm_pallas.stage ON crm_pallas.deal.stage_id = crm_pallas.stage.id WHERE crm_pallas.stage.title='?');";

    private static final String SELECT_ALL_SQL = "SELECT * FROM crm_pallas.deal WHERE NOT is_deleted";

    private static final String UPDATE_SQL = "UPDATE crm_pallas.deal SET title = ?, company_id = ?, " +
            "budget = ?, stage_id = ?, responsible_user_id =?, is_deleted = ?, primary_contact_id = ? WHERE id = ?";

    private static final String INSERT_SQL = "INSERT INTO crm_pallas.deal " +
            "(title, company_id, budget, stage_id, responsible_user_id,  is_deleted, created, primary_contact_id) " +
            "values (?,?,?,?,?,?,?,?)";

    private static final String INSERT_DEAL_CONTACT_SQL = "INSERT INTO deal_contact (deal_id, contact_id) VALUES (?, ?)";

    private static final String SELECT_DEAL_WITH_TASK = "SELECT * FROM crm_pallas.deal INNER JOIN crm_pallas.deal_task ON crm_pallas.deal_task.deal_id = crm_pallas.deal.id ORDER BY id;";

    private static final String SELECT_DEAL_WITH_NOT_TASK = "SELECT * FROM crm_pallas.deal RIGHT JOIN crm_pallas.deal_task ON crm_pallas.deal_task.deal_id != crm_pallas.deal.id ORDER BY id;";

    @Override
    public void delete(Integer id) throws DaoException {
        delete(id, "deal");
    }


    @Override
    public Deal getByName(String str) throws DaoException, ClassNotFoundException {
        Deal deal = new Deal();
        List<Deal> deals = getAll();
        for (int i = 0; i < deals.size(); ++i) {
            if(deals.get(i).getTitle().equals(str)) {
                deal = deals.get(i);
                break;
            }
        }
        return deal;
    }

    @Override
    public Deal create(Deal deal) {
        if (deal.getId() != 0) {
            throw new DatabaseException("deal id must be obtained from DB");
        }

        PreparedStatementCreator preparedStatementCreator = connection -> {
            PreparedStatement preparedStatement = connection.prepareStatement(INSERT_SQL, new String[]{"id"});

            preparedStatement.setString(1, deal.getTitle());
            preparedStatement.setInt(2, deal.getCompany().getId());
            preparedStatement.setInt(3, deal.getBudget());
            preparedStatement.setInt(4, deal.getStage().getId());
            preparedStatement.setInt(5, deal.getResponsibleUser() == null ? null : deal.getResponsibleUser().getId());
            preparedStatement.setBoolean(6, deal.isDeleted());
            preparedStatement.setTimestamp(7, new Timestamp(deal.getCreateDate() == null ? System.currentTimeMillis() : deal.getCreateDate().getTime()));
            preparedStatement.setInt(8, deal.getPrimaryContact().getId());

            return preparedStatement;
        };

        KeyHolder keyHolder = new GeneratedKeyHolder();
        jdbcTemplate.update(preparedStatementCreator, keyHolder);
        int id=(int) keyHolder.getKey();
        deal.setId(id);
        if (deal.getContacts() != null && deal.getContacts().size() > 0) {
            for (Contact contact : deal.getContacts()) {
                addContactToDeal(deal, contact);
            }
        }
        return deal;
    }

    @Override
    public Deal update(Deal deal) {
        if (deal.getId() == 0) {
            throw new DatabaseException("deal must be created before update");
        }

        PreparedStatementSetter preparedStatementSetter = preparedStatement -> {

            preparedStatement.setString(1, deal.getTitle());
            preparedStatement.setInt(2, deal.getCompany().getId());
            preparedStatement.setInt(3, deal.getBudget());
            preparedStatement.setInt(4, deal.getStage().getId());
            preparedStatement.setObject(5, deal.getResponsibleUser() == null ? null : deal.getResponsibleUser().getId());
            preparedStatement.setBoolean(6, deal.isDeleted());
            preparedStatement.setObject(7, deal.getPrimaryContact() == null ? null : deal.getPrimaryContact().getId(), Types.INTEGER);
            preparedStatement.setInt(8, deal.getId());
            preparedStatement.executeUpdate();
        };
        jdbcTemplate.update(UPDATE_SQL, preparedStatementSetter);
        return deal;
    }

    @Override
    public List<Deal> getAll() throws DaoException, ClassNotFoundException {
        return jdbcTemplate.query(SELECT_ALL_SQL, DEAL_ROW_MAPPER);
    }

    @Override
    public Deal getById(Integer id) throws DaoException {
        Deal deal = jdbcTemplate.queryForObject(SELECT_ALL_SQL + " AND id = ?", DEAL_ROW_MAPPER, id);
        return deal;
    }

    @Override
    public List<Deal> getDealsForList(int id) {
        return jdbcTemplate.query(SELECT_DEALS_FOR_LIST_BY_ID.replace("?", String.valueOf(id)), DEAL_ROW_MAPPER);
    }

    @Override
    public List<Deal> getDealsForList() {
        return jdbcTemplate.query(SELECT_DEALS_FOR_LIST, DEAL_FOR_LIST_ROW_MAPPER);
    }

    @Override
    public List<Contact> getContactsByDealName(String dealName) {
        return jdbcTemplate.query(SELECT_ALL_CONTACT.replace("?", dealName), CONTACT_FOR_DEAL_ROW_MAPPER);
    }

    @Override
    public List<Stage> getAllStage() {
        return jdbcTemplate.query(SELECT_ALL_STAGES, STAGE_ROW_MAPPER);
    }

    @Override
    public List<Deal> getDealsByStage(String stage) {
        return jdbcTemplate.query(SELECT_ALL_DEAL_BY_STAGE.replace("?", stage), DEAL_FOR_STAGE_ROW_MAPPER);
    }

    public List<Deal> getDealWithTask(){
        return jdbcTemplate.query(SELECT_DEAL_WITH_TASK, DEAL_ROW_MAPPER);
    }

    public List<Deal> getDealWithNotTask(){
        return jdbcTemplate.query(SELECT_DEAL_WITH_NOT_TASK, DEAL_ROW_MAPPER);
    }

    private final RowMapper<Deal> DEAL_FOR_STAGE_ROW_MAPPER = (resultSet, i) -> {
        Deal deal = new Deal();
        Company company = new Company();

        deal.setId(resultSet.getInt("id"));
        deal.setTitle(resultSet.getString("title"));
        deal.setBudget(resultSet.getInt("budget"));
        company.setId(resultSet.getInt("companyId"));
        company.setTitle(resultSet.getString("companyName"));
        deal.setCompany(company);

        return deal;
    };

    private final RowMapper<Deal> DEAL_FOR_LIST_ROW_MAPPER = (resultSet, i) -> {
        Deal deal = new Deal();
        Company company = new Company();
        Contact contact = new Contact();
        Stage stage = new Stage();

        deal.setId(resultSet.getInt("dealId"));
        deal.setTitle(resultSet.getString("title"));
        deal.setBudget(resultSet.getInt("budget"));
        stage.setTitle(resultSet.getString("stage"));
        deal.setStage(stage);
        contact.setId(resultSet.getInt("contactId"));
        contact.setlName(resultSet.getString("contact"));

        company.setId(resultSet.getInt("companyId"));
        company.setTitle(resultSet.getString("company"));
        contact.setCompany(company);
        deal.setPrimaryContact(contact);
        deal.setCompany(company);

        return deal;
    };

    private final RowMapper<Contact> CONTACT_FOR_DEAL_ROW_MAPPER = (resultSet, i) -> {
        Contact contact = new Contact();
        contact.setId(resultSet.getInt("contactId"));
        contact.setlName(resultSet.getString("last_name"));
        contact.setfName(resultSet.getString("first_name"));

        return contact;
    };

    public void addContactToDeal(Deal deal, Contact contact) {
        if (deal != null && deal.getId() > 0 && contact != null && contact.getId() > 0) {
            PreparedStatementSetter preparedStatementSetter = preparedStatement -> {
                preparedStatement.setInt(1, deal.getId());
                preparedStatement.setInt(2, contact.getId());
                preparedStatement.executeUpdate();
            };
            jdbcTemplate.update(INSERT_DEAL_CONTACT_SQL, preparedStatementSetter);
        }
    }
/*
    @Override
    public List<Contact> getContactsByDealName(String dealTitle) {
        List<Contact> contacts = new ArrayList<>();
        CompanyDao<Company> company = new CompanyDaoImpl(dataSource);
        Contact contact;
        UserDao<User> user = new UserDaoImpl(dataSource);

        try (Connection connection = getConnection();
             PreparedStatement statement = connection.prepareStatement(SELECT_ALL_CONTACT)) {

            statement.setString(1, dealTitle);
            ResultSet resultSet = statement.executeQuery();

            while (resultSet.next()) {

                contact = new Contact();
                contact.setId(resultSet.getInt("contactId"));
                contact.setlName(resultSet.getString("last_name"));
                contact.setfName(resultSet.getString("first_name"));
//                contact.setPosition(resultSet.getString("position"));
//                contact.setCompany(company.getById(resultSet.getInt("companyId")));
//                contact.setEmail(resultSet.getString("email"));
//                contact.setSkype(resultSet.getString("skype"));
//                contact.setResponsibleUser(user.getById(resultSet.getInt("responsible_user_id")));
//                contact.setDeleted(resultSet.getBoolean("is_deleted"));
                /*
                Here you need to add the phone type and the phone to display in the editing form of the Deals
                 */
/*
                contacts.add(contact);
            }
        } catch (SQLException ex) {
            //logger.log(Level.SEVERE, ex.getMessage(), ex);
            throw new DatabaseException(ex);
        }

        return contacts;
    }
    */

}
