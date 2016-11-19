package com.becomejavasenior.DAO.Imp;

import com.becomejavasenior.DAO.DAOException;
import com.becomejavasenior.DAO.DealDAO;
import com.becomejavasenior.DataBaseUtil;
import com.becomejavasenior.bean.*;
import com.becomejavasenior.exceptions.DatabaseException;
import com.becomejavasenior.factory.PostgresDAOFactory;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class DealDAOImpl extends AbstractDAOImpl<Deal> implements DealDAO<Deal> {

    private static final String SELECT_DEALS_FOR_LIST = "SELECT\n" +
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
            "  JOIN crm_pallas.company ON crm_pallas.contact.company_id = crm_pallas.company.id\n";

    @Override
    void createStatement(PreparedStatement preparedStatement, Deal deal) throws DAOException {
        try {

            preparedStatement.setInt(1, deal.getCompany().getId());
            preparedStatement.setInt(2, deal.getStage().getId());
            preparedStatement.setInt(3, deal.getResponsibleUser().getId());
            preparedStatement.setString(4, deal.getTitle());
            preparedStatement.setInt(5, deal.getBudget());
            preparedStatement.setBoolean(6, deal.isDeleted());

        } catch (SQLException e) {
            e.printStackTrace();
        }

    }

    @Override
    void updateStatement(PreparedStatement preparedStatement, Deal deal) throws DAOException {
        try {

            preparedStatement.setInt(1, deal.getCompany().getId());
            preparedStatement.setInt(2, deal.getStage().getId());
            preparedStatement.setInt(3, deal.getResponsibleUser().getId());
            preparedStatement.setString(4, deal.getTitle());
            preparedStatement.setInt(5, deal.getBudget());
            preparedStatement.setBoolean(6, deal.isDeleted());

        } catch (SQLException e) {
            e.printStackTrace();
        }

    }

    @Override
    Deal getEntity(ResultSet resultSet) throws DAOException {
        Deal deal = new Deal();
        CompanyDAOImpl company = new CompanyDAOImpl();
        StageDAOImpl stage = new StageDAOImpl();
        UserDAOImpl user = new UserDAOImpl();
        try {
            deal.setId(resultSet.getInt("id"));
            deal.setCompany(company.getById(resultSet.getInt("company_id")));
            deal.setStage(stage.getById(resultSet.getInt("stage_id")));
            deal.setResponsibleUser(user.getById(resultSet.getInt("responsible_user_id")));
            deal.setTitle(resultSet.getString("title"));
            deal.setBudget(resultSet.getInt("budget"));
            deal.setDeleted(resultSet.getBoolean("is_deleted"));
        } catch (SQLException e) {
            throw new DAOException("Can't get entity from Deal", e);
        }
        return deal;
    }

    @Override
    String getAllQuery() {
        return DataBaseUtil.getQuery("SELECT * FROM crm_pallas.deal");
    }

    @Override
    String getByIdQuery() {
        return DataBaseUtil.getQuery("SELECT * FROM crm_pallas.deal WHERE id=?");
    }

    @Override
    String getCreateQuery() {
        return DataBaseUtil.getQuery("INSERT INTO crm_pallas.deal (company_id, stage_id, responsible_user_id, title, budget, is_deleted) values (?,?,?,?,?,?)");
    }

    @Override
    String getDeleteQuery() {
        return DataBaseUtil.getQuery("DELETE FROM crm_pallas.deal WHERE id = ?");
    }

    @Override
    String getUpdateQuery() {
        return DataBaseUtil.getQuery("UPDATE crm_pallas.deal SET company_id = ?, stage_id = ?, " +
                "responsible_user_id = ?, title = ?, budget =?, is_deleted = ? WHERE id = ?");
    }

    @Override
    public List<Deal> getByFilter(String query) {
        List<Deal> dealList = new ArrayList<Deal>();
        try{
            Connection connection = DataBaseUtil.getConnection();
            PreparedStatement preparedStatement = connection.prepareStatement(query);
            ResultSet resultSet = preparedStatement.executeQuery();
            while (resultSet.next()) {
                dealList.add(getEntity(resultSet));
            }

        } catch (SQLException e) {
            e.printStackTrace();
        } catch (DAOException e) {
            e.printStackTrace();
        }
        return dealList;
    }

    @Override
    public List<Deal> getAll() throws DAOException, ClassNotFoundException {
        List<Deal> deals = new ArrayList<>();
        Deal deal;
        User responsibleUser;
        Company company;
        Contact contact;

        try (Connection connection = PostgresDAOFactory.getConnection();
             Statement statement = connection.createStatement();
             ResultSet resultSet = statement.executeQuery(getAllQuery())) {

            while (resultSet.next()) {

                deal = new Deal();
                responsibleUser = new User();
                company = new Company();
                Stage stage = new Stage();
                contact = new Contact();

                deal.setId(resultSet.getInt("id"));
                responsibleUser.setId(resultSet.getInt("responsible_user_id"));
                deal.setResponsibleUser(responsibleUser);
                company.setId(resultSet.getInt("company_id"));
                deal.setCompany(company);
                deal.setTitle(resultSet.getString("title"));
                deal.setBudget(resultSet.getInt("budget"));
                deal.setDeleted(false);
                stage.setId(resultSet.getInt("stage_id"));
                deal.setStage(stage);
                deal.setStage(stage);
                contact.setId(resultSet.getInt("primary_contact_id"));
                deal.setPrimaryContact(contact);

                deals.add(deal);
            }
        } catch (SQLException ex) {
            throw new DatabaseException(ex);
        }
        return deals;
    }

    @Override
    public List<Deal> getDealsForList() {
        List<Deal> deals = new ArrayList<>();
        Deal deal;
        Contact contact;
        Company company;
        Stage stage;

        try (Connection connection = PostgresDAOFactory.getConnection();
             PreparedStatement statement = connection.prepareStatement(SELECT_DEALS_FOR_LIST)) {

            ResultSet resultSet = statement.executeQuery();

            while (resultSet.next()) {

                deal = new Deal();
                company = new Company();
                contact = new Contact();
                stage = new Stage();

                deal.setTitle(resultSet.getString("title"));
                deal.setBudget(resultSet.getInt("budget"));
                stage.setTitle(resultSet.getString("stage"));
                deal.setStage(stage);
                contact.setId(resultSet.getInt("contactId"));
                contact.setlName(resultSet.getString("contact"));
                deal.setPrimaryContact(contact);
                company.setId(resultSet.getInt("companyId"));
                company.setTitle(resultSet.getString("company"));
                contact.setCompany(company);

                deals.add(deal);
            }
        } catch (SQLException ex) {
            //logger.log(Level.SEVERE, ex.getMessage(), ex);
            throw new DatabaseException(ex);
        }

        return deals;
    }
}
