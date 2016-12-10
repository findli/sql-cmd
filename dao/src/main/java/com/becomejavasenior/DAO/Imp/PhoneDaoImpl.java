package com.becomejavasenior.DAO.Imp;

import com.becomejavasenior.DAO.ContactDao;
import com.becomejavasenior.DAO.DaoException;
import com.becomejavasenior.DAO.PhoneDao;
import com.becomejavasenior.DAO.PhoneTypeDao;
import com.becomejavasenior.DataBaseUtil;
import com.becomejavasenior.bean.Contact;
import com.becomejavasenior.bean.Phone;
import com.becomejavasenior.bean.PhoneType;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class PhoneDaoImpl extends AbstractDaoImpl<Phone> implements PhoneDao<Phone> {

    @Override
    public Phone getByName(String str) throws DaoException, ClassNotFoundException {
        return null;
    }

    @Override
    void createStatement(PreparedStatement statement, Phone entity) throws DaoException {

        try {

            statement.setInt(1, entity.getContact().getId());
            statement.setInt(2, entity.getPhoneType().getId());
            statement.setString(3, entity.getPhoneNumber());

        } catch (SQLException e) {

            throw new DaoException("Can't create statement for Phone", e);

        }
    }

    @Override
    void updateStatement(PreparedStatement statement, Phone entity) throws DaoException {
        try {

            statement.setInt(1, entity.getContact().getId());
            statement.setInt(2, entity.getPhoneType().getId());
            statement.setString(3, entity.getPhoneNumber());

        } catch (SQLException e) {

            throw new DaoException("Can't update statement for Phone", e);

        }
    }

    @Override
    Phone getEntity(ResultSet resultSet) throws DaoException {

        Phone phone = new Phone();
        PhoneTypeDao<PhoneType> phoneTypeDao = new PhoneTypeDaoImpl();
        ContactDao<Contact> contactDao = new ContactDaoImpl();

        try {

            phone.setId(resultSet.getInt("id"));
            phone.setContact(contactDao.getById(resultSet.getInt("contact_id")));
            phone.setPhoneType(phoneTypeDao.getById(resultSet.getInt("phone_type_id")));
            phone.setPhoneNumber(resultSet.getString("phone_number"));

        } catch (SQLException e){

            throw new DaoException("Can't get entity for Phone", e);

        }

        return phone;
    }

    @Override
    String getCreateQuery() {
        return DataBaseUtil.getQuery("INSERT INTO crm_pallas.contact_phone (title, contact_id, phone_type_id, phone_number) values (?,?,?,?)");
    }

    @Override
    String getUpdateQuery() {
        return DataBaseUtil.getQuery("UPDATE INTO crm_pallas.contact_phone SET title = ?, contact_id = ?, phone_type_id = ?, phone_number = ? WHERE id = ?");
    }

    @Override
    String getDeleteQuery() {
        return DataBaseUtil.getQuery("DELETE FROM crm_pallas.contact_phone WHERE id = ?");
    }

    @Override
    String getByIdQuery() {
        return DataBaseUtil.getQuery("SELECT * FROM crm_pallas.contact_phone WHERE id=?");
    }

    @Override
    String getAllQuery() {
        return DataBaseUtil.getQuery("SELECT * FROM crm_pallas.contact_phone");
    }

    @Override
    public List<Phone> getByFilter(String query) {

        List<Phone> phoneList = new ArrayList();

        try {
            Connection connection = DataBaseUtil.getConnection();
            PreparedStatement preparedStatement = connection.prepareStatement(query);
            ResultSet resultSet = preparedStatement.executeQuery();
            while (resultSet.next()) {
                phoneList.add(getEntity(resultSet));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        } catch (DaoException e) {
            e.printStackTrace();
        }

        return phoneList;
    }
}
