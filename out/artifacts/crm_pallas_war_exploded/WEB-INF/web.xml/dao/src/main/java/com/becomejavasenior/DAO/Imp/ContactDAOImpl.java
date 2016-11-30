package com.becomejavasenior.DAO.Imp;

import com.becomejavasenior.DAO.ContactDAO;
import com.becomejavasenior.DataBaseUtil;
import com.becomejavasenior.bean.Company;
import com.becomejavasenior.bean.Contact;
import com.becomejavasenior.bean.User;
import com.becomejavasenior.exceptions.DatabaseException;
import com.becomejavasenior.factory.PostgresDAOFactory;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class ContactDAOImpl extends AbstractDAOImpl<Contact> implements ContactDAO<Contact> {

    private static final String SELECT_DEALS_FOR_LIST = "SELECT *"+
            "FROM crm_pallas.contact \n" +
    "JOIN crm_pallas.company on crm_pallas.contact.company_id = crm_pallas.company.id \n"+
    "JOIN crm_pallas.user ON crm_pallas.contact.responsible_user_id = crm_pallas.user.id \n";

    @Override
    void createStatement(PreparedStatement preparedStatement, Contact contact) {

        try {
            preparedStatement.setString(1, contact.getfName());
            preparedStatement.setString(2, contact.getlName());
            preparedStatement.setString(3, contact.getEmail());
            preparedStatement.setString(4, contact.getPosition());
            preparedStatement.setString(5, contact.getSkype());
            preparedStatement.setInt(6, contact.getCompany().getId());
            preparedStatement.setInt(7, contact.getResponsibleUser().getId());
//            preparedStatement.setDate(8, new Date(contact.getCreated().getTime()) );
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    @Override
    void updateStatement(PreparedStatement preparedStatement, Contact contact) {

        try {
            preparedStatement.setString(1, contact.getfName());
            preparedStatement.setString(2, contact.getlName());
            preparedStatement.setString(3, contact.getEmail());
            preparedStatement.setString(4, contact.getPosition());
            preparedStatement.setString(5, contact.getSkype());
            preparedStatement.setInt(6, contact.getCompany().getId());
            preparedStatement.setInt(7, contact.getResponsibleUser().getId());
//            preparedStatement.setDate(8, new Date(contact.getUpdated().getTime()));
//            preparedStatement.setBoolean(9, contact.isDeleted());
            preparedStatement.setInt(10, contact.getId());
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    @Override
    Contact getEntity(ResultSet resultSet) {
        Contact contact = new Contact();
        Company company;
//        CompanyDAO<Company> companyDao = new CompanyDAOImpl();
        List<String> taskList = new ArrayList<String>();
        List<String> eventHistoryList = new ArrayList<String>();
        List<String> phoneList = new ArrayList<String>();

        try {
            contact.setId(resultSet.getInt("contact_id"));
            contact.setfName(resultSet.getString("fName"));
            contact.setlName(resultSet.getString("lName"));
            contact.setPosition(resultSet.getString("position"));
            contact.setSkype(resultSet.getString("skype"));
            contact.setEmail(resultSet.getString("email"));
            contact.setDeleted(resultSet.getBoolean("deleted"));
//            company = companyDao.getById(resultSet.getInt("company_id"));
//            contact.setCompany(company);
            taskList.add(resultSet.getString("tasks"));
//            contact.setTasks(taskList);
            phoneList.add(resultSet.getString("phoneNumbers"));
//            contact.setPhoneNumbers(phoneList);
            eventHistoryList.add(resultSet.getString("events"));
//            contact.setEvents(eventHistoryList);
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return contact;
    }

    @Override
    String getCreateQuery() {
        return DataBaseUtil.getQuery("INSERT INTO contact (fName, lName, email, position, skype, company_id, responsible_id, created) values (?,?,?,?,?,?,?,?)");
    }

    @Override
    String getUpdateQuery() {
        return DataBaseUtil.getQuery("UPDATE contact SET fName = ?, lName = ?, email = ?, position = ?, skype =?, company_id = ? " +
                "responsible_id = ?, updated = ?, deleted = ? WHERE contact_id = ?");
    }

    @Override
    String getDeleteQuery() {
        return DataBaseUtil.getQuery("DELETE FROM contact WHERE contact_id = ?");
    }

    @Override
    String getByIdQuery() {
        return DataBaseUtil.getQuery("SELECT * FROM contact WHERE contact_id=?");
    }

    @Override
    String getAllQuery() {
        return DataBaseUtil.getQuery("SELECT * FROM contact");
    }

/*    @Override
    public List<Contact> getByFilter(String query) {

        List<Contact> contactList = new ArrayList<Contact>();

        try {
            Connection connection = DataBaseUtil.getConnection();
            PreparedStatement preparedStatement = connection.prepareStatement(query);
            ResultSet resultSet = preparedStatement.executeQuery();
            while (resultSet.next()) {
                contactList.add(getEntity(resultSet));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return contactList;
    }*/

    // TODO Write queries to filter

    @Override
    public List<Contact> getContactsForList() {
        List<Contact> contacts = new ArrayList<>();
        Contact contact;
        Company company;
        User user;

        try (Connection connection = PostgresDAOFactory.getConnection();
             PreparedStatement statement = connection.prepareStatement(SELECT_DEALS_FOR_LIST)) {

            ResultSet resultSet = statement.executeQuery();
            while (resultSet.next()) {
                company = new Company();
                contact = new Contact();
                user = new User();
                contact.setfName(resultSet.getString("first_name"));
                contact.setlName(resultSet.getString("last_name"));
                company.setId(resultSet.getInt("companyId"));
                contact.setCompany(company);
                contact.setPosition(resultSet.getString("post"));
                contact.setEmail(resultSet.getString("email"));
                contact.setSkype(resultSet.getString("skype"));
                user.setId(resultSet.getInt("userId"));
                contact.setResponsibleUser(user);
                contact.setDeleted(resultSet.getBoolean("is_deleted"));
                contacts.add(contact);
            }
        } catch (SQLException ex) {
            throw new DatabaseException(ex);
        }

        return contacts;
    }
}