package com.becomejavasenior.DAO.Imp;

import com.becomejavasenior.DAO.*;
import com.becomejavasenior.DataBaseUtil;
import com.becomejavasenior.bean.Company;
import com.becomejavasenior.bean.Contact;
import com.becomejavasenior.bean.PhoneType;
import com.becomejavasenior.bean.User;
import com.becomejavasenior.factory.PostgresDaoFactory;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Repository;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

@Repository("contactDao")
public class ContactDaoImpl extends AbstractDaoImpl<Contact> implements ContactDao<Contact> {

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
        List<Contact> contacts = new ArrayList<>();
        Contact contact;
        Company company;
        List<String> phoneList = new ArrayList<>();
        PhoneType phoneType;
        User user;
        try (Connection connection = PostgresDaoFactory.getConnection();
             PreparedStatement statement = connection.prepareStatement(SELECT_CONTACT_FOR_LIST)) {
            statement.setInt(1,id);
            ResultSet resultSet = statement.executeQuery();
            while (resultSet.next()) {
                company = new Company();
                contact = new Contact();
                user = new User();
                contact.setId(resultSet.getInt("id"));
                contact.setfName(resultSet.getString("fName"));
                contact.setlName(resultSet.getString("lName"));
                company.setId(resultSet.getInt("companyId"));
                contact.setCompany(company);
                contact.setPosition(resultSet.getString("post"));
                contact.setEmail(resultSet.getString("email"));
                contact.setSkype(resultSet.getString("skype"));
                contacts.add(contact);
            }
        } catch (SQLException ex) {
            throw new DatabaseException(ex);
        }

        return contacts;
    }

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
}