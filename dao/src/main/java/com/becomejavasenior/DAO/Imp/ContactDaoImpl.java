package com.becomejavasenior.DAO.Imp;

import com.becomejavasenior.DAO.*;
import com.becomejavasenior.DataBaseUtil;
import com.becomejavasenior.bean.Company;
import com.becomejavasenior.bean.Contact;
import com.becomejavasenior.bean.Phone;
import com.becomejavasenior.bean.User;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class ContactDaoImpl extends AbstractDaoImpl<Contact> implements ContactDao<Contact> {

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
            preparedStatement.setBoolean(8, contact.isDeleted());
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
            preparedStatement.setBoolean(8, contact.isDeleted());
            preparedStatement.setInt(9, contact.getId());
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    @Override
    public Contact getByName(String str) throws DaoException, ClassNotFoundException {
        return null;
    }

    @Override
    Contact getEntity(ResultSet resultSet) throws DaoException {
        Contact contact = new Contact();
        Company company;
        User user;
        CompanyDao<Company> companyDao = new CompanyDaoImpl();
        UserDao<User> userDAO = new UserDaoImpl();
        PhoneDao<Phone> phoneDao  = new PhoneDaoImpl();

        List<String> taskList = new ArrayList<String>();
        List<String> eventHistoryList = new ArrayList<String>();
        List<String> phoneList = new ArrayList<String>();

        try {
            contact.setId(resultSet.getInt("id"));
            contact.setfName(resultSet.getString("first_name"));
            contact.setlName(resultSet.getString("last_name"));
            contact.setPosition(resultSet.getString("post"));
            contact.setSkype(resultSet.getString("skype"));
            contact.setEmail(resultSet.getString("email"));
            contact.setDeleted(resultSet.getBoolean("is_deleted"));
            contact.setCompany(companyDao.getById(resultSet.getInt("company_id")));
            contact.setResponsibleUser(userDAO.getById(resultSet.getInt("responsible_user_id")));
      //      contact.setPhone(phoneDao.getById(resultSet.getInt("phone_id")));


//            taskList.add(resultSet.getString("tasks"));
//            contact.setTasks(taskList);
//            phoneList.add(resultSet.getString("phoneNumbers"));
//            contact.setPhoneNumbers(phoneList);
//            eventHistoryList.add(resultSet.getString("events"));
//            contact.setEvents(eventHistoryList);
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return contact;
    }

    @Override
    String getCreateQuery() {
        return DataBaseUtil.getQuery("INSERT INTO crm_pallas.contact (first_name, last_name, email, post, skype, company_id, responsible_user_id, is_deleted) values (?,?,?,?,?,?,?,?)");
    }

    @Override
    String getUpdateQuery() {
        return DataBaseUtil.getQuery("UPDATE crm_pallas.contact SET first_name = ?, last_name = ?, email = ?, post = ?, skype =?, company_id = ? " +
                "responsible_user_id = ?, is_deleted = ? WHERE id = ?");
    }

    @Override
    String getDeleteQuery() {
        return DataBaseUtil.getQuery("DELETE FROM crm_pallas.contact WHERE id = ?");
    }

    @Override
    String getByIdQuery() {
        return DataBaseUtil.getQuery("SELECT * FROM crm_pallas.contact WHERE id=?");
    }

    @Override
    String getAllQuery() {
        return DataBaseUtil.getQuery("SELECT * FROM crm_pallas.contact");
    }

    @Override
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
        } catch (DaoException e) {
            e.printStackTrace();
        }

        return contactList;
    }

    // TODO Write queries to filter
}