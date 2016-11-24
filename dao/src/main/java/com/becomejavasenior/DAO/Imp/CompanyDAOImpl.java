package com.becomejavasenior.DAO.Imp;

import com.becomejavasenior.DAO.AddressDAO;
import com.becomejavasenior.DAO.CompanyDAO;
import com.becomejavasenior.DAO.DAOException;
import com.becomejavasenior.DAO.UserDAO;
import com.becomejavasenior.DataBaseUtil;
import com.becomejavasenior.bean.Adress;
import com.becomejavasenior.bean.Company;
import com.becomejavasenior.bean.User;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class CompanyDAOImpl extends AbstractDAOImpl<Company> implements CompanyDAO<Company> {

    @Override
    public void createStatement(PreparedStatement statement, Company company) throws DAOException{

        try{
            statement.setString(1, company.getTitle());
            statement.setString(2, company.getPhoneNumber());
            statement.setString(3, company.getEmail());
            statement.setString(4, company.getWebsite());
            statement.setInt(5, company.getAddress().getId());
            statement.setInt(6, company.getResponsibleUser().getId());
            statement.setBoolean(7, company.getIsDeleted());
        } catch (SQLException e) {
            throw new DAOException("Can't create statement for Company", e);
        }
    }

    @Override
    public void updateStatement(PreparedStatement statement, Company company) throws DAOException{

        try{

            statement.setString(1, company.getTitle());
            statement.setString(2, company.getPhoneNumber());
            statement.setString(3, company.getEmail());
            statement.setString(4, company.getWebsite());
            statement.setInt(5, company.getAddress().getId());
            statement.setInt(6, company.getResponsibleUser().getId());
            statement.setBoolean(7, company.getIsDeleted());

        } catch (SQLException e) {
            throw new DAOException("Can't update statement for Company", e);
        }
    }

    @Override
    public Company getEntity(ResultSet resultSet) throws DAOException{

        Company company = new Company();
        AddressDAO<Adress> addressDao = new AddressDAOImpl();
        UserDAO<User> userDao = new UserDAOImpl();

        try{
            company.setId(resultSet.getInt("id"));
            company.setTitle(resultSet.getString("title"));
            company.setPhoneNumber(resultSet.getString("phone_number"));
            company.setEmail(resultSet.getString("email"));
            company.setWebsite(resultSet.getString("website"));
            company.setAddress(addressDao.getById(resultSet.getInt("address_id")));
            company.setResponsibleUser(userDao.getById(resultSet.getInt("responsible_user_id")));
            company.setIsDeleted(resultSet.getBoolean("is_deleted"));

        } catch (SQLException e){

            throw new DAOException("Can't get entity from Company", e);

        }
        return company;
    }

    public String getCreateQuery() {
        return "INSERT INTO crm_pallas.company (title, phone_number, email, website, address_id, responsible_user_id, is_deleted) VALUES (?, ?, ?, ?, ?, ?, ?)";
    }

    public String getUpdateQuery() {
        return "UPDATE crm_pallas.company SET title = ?, phone_number = ?, email = ?, website = ?, address_id = ?, responsible_user_id = ?, is_deleted = ?";
    }

    public String getDeleteQuery() {
        return "DELETE FROM crm_pallas.company WHERE id = ?";
    }

    public String getByIdQuery() {
        return "SELECT * FROM crm_pallas.company WHERE id = ?";
    }

    public String getAllQuery() {
        return "SELECT * FROM crm_pallas.company";
    }

    @Override
    public List<Company> getByFilter(String query) {
        List<Company> companyList = new ArrayList<Company>();

        try {
            Connection connection = DataBaseUtil.getConnection();
            PreparedStatement preparedStatement = connection.prepareStatement(query);
            ResultSet resultSet = preparedStatement.executeQuery();
            while (resultSet.next()) {
                companyList.add(getEntity(resultSet));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        } catch (DAOException e) {
            e.printStackTrace();
        }

        return companyList;
    }
}