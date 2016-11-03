package com.becomejavasenior.DAO.Imp;

import com.becomejavasenior.DAO.AbstractDAO;
import com.becomejavasenior.bean.Company;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class CompanyDaoJdbcImpl extends AbstractDAOImpl<Company> implements AbstractDAO<Company> {

    public static Logger log = Logger.getLogger(CompanyDaoJdbcImpl.class.getName());

    public void createStatement(PreparedStatement statement, Company company {

        try{

            statement.setString(1, company.getTitle());
            statement.setString(2, company.getPhoneNumber());
            statement.setString(3, company.getEmail());
            statement.setString(4, company.getWebsite());
            statement.setInt(5, company.getAddress().getId());
            statement.setInt(6, company.getResponsibleUser().getId());
            statement.setBoolean(7, company.isDeleted());

        } catch (SQLException e) {
            log.warn("Can't create statement for Company");
            throw new DAOException("Can't create statement for Company", e);
        }

    }

    public void updateStatement(PreparedStatement statement, Company company) {

        try{

            statement.setString(1, company.getTitle());
            statement.setString(2, company.getPhoneNumber());
            statement.setString(3, company.getEmail());
            statement.setString(4, company.getWebsite());
            statement.setInt(5, company.getAddress().getId());
            statement.setInt(6, company.getResponsibleUser().getId());
            statement.setBoolean(7, company.isDeleted());

        } catch (SQLException e) {
            log.warn("Can't update statement for Company");
            throw new DAOException("Can't update statement for Company", e);
        }
    }

    public Company getEntity(ResultSet resultSet) {

        Company company = new Company();
        AddressDaoJdbcImpl address = new AddressDaoJdbcImpl();
        UserDaoJdbcImpl user = new UserDaoJdbcImpl();

        try{

            company.setId(resultSet.getInt("id"));
            company.setTitle(resultSet.getString("title"));
            company.setPhoneNumber(resultSet.getString("phone_number"));
            company.setEmail(resultSet.getString("email"));
            company.setWebsite(resultSet.getString("website"));
            company.setAddress(address.getById(resultSet.getInt("address_id")));
            company.setResponsibleUser(user.getById(resultSet.getInt("responsible_user_id")));
            company.setDeleted(resultSet.getBoolean("is_deleted"));

        } catch (SQLException e){
            log.warn("Can't get entity from Company");
            throw new DAOException("Can't get entity from Company", e);
        }
        return company;
    }

    public String getCreateQuery() {
        return "INSERT INTO company (title, phone_number, email, website, address_id, responsible_user_id, is_deleted) VALUES (?, ?, ?, ?, ?, ?, ?)";
    }

    public String getUpdateQuery() {
        return "UPDATE company SET title = ?, phone_number = ?, email = ?, website = ?, address_id = ?, responsible_user_id = ?, is_deleted = ?";
    }

    public String getDeleteQuery() {
        return "DELETE FROM company WHERE id = ?";
    }

    public String getByIdQuery() {
        return "SELECT * FROM company WHERE id = ?";
    }

    public String getAllQuery() {
        return "SELECT * FROM company";
    }
}