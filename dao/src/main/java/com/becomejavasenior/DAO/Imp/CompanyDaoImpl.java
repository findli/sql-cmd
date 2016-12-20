package com.becomejavasenior.DAO.Imp;

import com.becomejavasenior.DAO.AddressDao;
import com.becomejavasenior.DAO.CompanyDao;
import com.becomejavasenior.DAO.DaoException;
import com.becomejavasenior.DAO.UserDao;
import com.becomejavasenior.bean.Address;
import com.becomejavasenior.bean.Company;
import com.becomejavasenior.bean.User;
import com.becomejavasenior.factory.PostgresDaoFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Repository;

import javax.sql.DataSource;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

@Repository("companyDao")
public class CompanyDaoImpl extends AbstractDaoImpl<Company> implements CompanyDao<Company> {

    @Autowired
    public CompanyDaoImpl(DataSource dataSource) {
        super(dataSource);
    }

    @Autowired
    DataSource dataSource;

    @Autowired
    @Qualifier("companyDao")
    CompanyDao companyDao;

    @Autowired
    @Qualifier("userDao")
    UserDao userDao;

    @Autowired
    @Qualifier("addressDao")
    AddressDao addressDao;

    @Override
    public void createStatement(PreparedStatement statement, Company company) throws DaoException {

        try{
            statement.setString(1, company.getTitle());
            statement.setString(2, company.getPhoneNumber());
            statement.setString(3, company.getEmail());
            statement.setString(4, company.getWebsite());
            statement.setInt(5, company.getAddress().getId());
            statement.setInt(6, company.getResponsibleUser().getId());
            statement.setBoolean(7, company.isDeleted());

        } catch (SQLException e) {

            throw new DaoException("Can't create statement for Company", e);

        }
    }

    @Override
    public void updateStatement(PreparedStatement statement, Company company) throws DaoException {

        try{

            statement.setString(1, company.getTitle());
            statement.setString(2, company.getPhoneNumber());
            statement.setString(3, company.getEmail());
            statement.setString(4, company.getWebsite());
            statement.setInt(5, company.getAddress().getId());
            statement.setInt(6, company.getResponsibleUser().getId());
            statement.setBoolean(7, company.isDeleted());
            statement.setInt(8, company.getId());

        } catch (SQLException e) {

            throw new DaoException("Can't update statement for Company", e);

        }
    }

    @Override
    public Company getByName(String str) throws DaoException, ClassNotFoundException {
        Company company = new Company();
        List<Company> companies = getAll();
        for (int i = 0; i < companies.size(); ++i) {
            if(companies.get(i).getTitle().equals(str)) {
                company = companies.get(i);
                break;
            }
        }
        return company;
    }

    @Override
    public Company getEntity(ResultSet resultSet) throws DaoException {

        Company company = new Company();
        User user;
        Address address;

        try{
            company.setId(resultSet.getInt("id"));
            company.setTitle(resultSet.getString("title"));
            company.setPhoneNumber(resultSet.getString("phone_number"));
            company.setEmail(resultSet.getString("email"));
            company.setWebsite(resultSet.getString("website"));

            address = (Address) addressDao.getById(resultSet.getInt("address_id"));
            company.setAddress(address);

            user = (User) userDao.getById(resultSet.getInt("responsible_user_id"));
            company.setResponsibleUser(user);
            company.setDeleted(resultSet.getBoolean("is_deleted"));

        } catch (SQLException e){
            throw new DaoException("Can't get entity from Company", e);
        }
        return company;
    }

    public String getCreateQuery() {
        return "INSERT INTO crm_pallas.company (title, phone_number, email, website, address_id, responsible_user_id, is_deleted) VALUES (?, ?, ?, ?, ?, ?, ?)";
    }

    public String getUpdateQuery() {
        return "UPDATE crm_pallas.company SET title = ?, phone_number = ?, email = ?, website = ?, address_id = ?, responsible_user_id = ?, is_deleted = ? WHERE id = ?";
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
            Connection connection = getConnection();
            PreparedStatement preparedStatement = connection.prepareStatement(query);
            ResultSet resultSet = preparedStatement.executeQuery();
            while (resultSet.next()) {
                companyList.add(getEntity(resultSet));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        } catch (DaoException e) {
            e.printStackTrace();
        }

        return companyList;
    }

}