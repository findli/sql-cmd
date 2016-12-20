package com.becomejavasenior.DAO.mapper;

import com.becomejavasenior.DAO.*;
import com.becomejavasenior.bean.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Component;

import java.sql.ResultSet;
import java.sql.SQLException;

@Component
public class DealRowMapper implements RowMapper<Deal> {

    private static final String FIELD_ID = "id";
    private static final String FIELD_TITLE = "title";
    private static final String FIELD_COMPANY_ID = "company_id";
    private static final String FIELD_BUDGET = "budget";
    private static final String FIELD_STAGE_ID = "stage_id";
    private static final String FIELD_RESPONSIBLE_USER_ID = "responsible_user_id";
    private static final String FIELD_IS_DELETED = "is_deleted";
    private static final String FIELD_CREATED = "created";
    private static final String FIELD_UPDATED = "updated";
    private static final String FIELD_PRIMARY_CONTACT_ID = "primary_contact_id";
    
    @Autowired
    CompanyDao companyDao;

    @Autowired
    ContactDao contactDao;
    
    @Autowired
    StageDao stageDao;
    
    @Autowired
    UserDao userDao;
    

    @Override
    public Deal mapRow(ResultSet resultSet, int i) throws SQLException {
        Deal deal = new Deal();
        
        deal.setId(resultSet.getInt(FIELD_ID));
        deal.setTitle(resultSet.getString(FIELD_TITLE));
        deal.setBudget(resultSet.getInt(FIELD_BUDGET));
        deal.setDeleted(resultSet.getBoolean(FIELD_IS_DELETED));
        deal.setCreateDate(resultSet.getDate(FIELD_CREATED));
        
        if(resultSet.getObject(FIELD_COMPANY_ID, Integer.class) != null) {
            Company company = null;
            try {
                company = (Company) companyDao.getById(resultSet.getInt(FIELD_COMPANY_ID));
            } catch (DaoException e) {
                e.printStackTrace();
            }
            deal.setCompany(company);
        }

        if(resultSet.getObject(FIELD_STAGE_ID, Integer.class) != null) {
            Stage stage = null;
            try {
                stage = (Stage) stageDao.getById(resultSet.getInt(FIELD_STAGE_ID));
            } catch (DaoException e) {
                e.printStackTrace();
            }
            deal.setStage(stage);
        }

        if(resultSet.getObject(FIELD_PRIMARY_CONTACT_ID, Integer.class) != null) {
            Contact contact = null;
            try {
                contact = (Contact) contactDao.getById(resultSet.getInt(FIELD_PRIMARY_CONTACT_ID));
            } catch (DaoException e) {
                e.printStackTrace();
            }
            deal.setPrimaryContact(contact);
        }

        if(resultSet.getObject(FIELD_RESPONSIBLE_USER_ID, Integer.class) != null) {
            User user = null;
            try {
                user = (User) userDao.getById(resultSet.getInt(FIELD_RESPONSIBLE_USER_ID));
            } catch (DaoException e) {
                e.printStackTrace();
            }
            deal.setResponsibleUser(user);
        }
        
        return deal;
    }

}
