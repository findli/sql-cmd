package com.becomejavasenior.DAO.Imp;

import com.becomejavasenior.DAO.*;
import com.becomejavasenior.bean.CrmCurrency;
import com.becomejavasenior.bean.CrmSettings;
import com.becomejavasenior.bean.Language;
import com.becomejavasenior.bean.TimeZone;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

public class CrmSettingsDaoImpl extends AbstractDaoImpl<CrmSettings> implements CrmSettingsDao<CrmSettings>{

    @Override
    public String getCreateQuery(){
        return "INSERT INTO crm_pallas.settings (default_language_id, timezone_id, currency_id) VALUES(?,?,?)";
    }

    @Override
    public String getUpdateQuery(){
        return "UPDATE crm_pallas.settings SET default_language_id = ?, timezone_id = ?, currency_id = ? WHERE id = ?";
    }

    @Override
    public String getDeleteQuery(){
        return "DELETE FROM crm_pallas.settings WHERE id = ?";
    }

    @Override
    public String getAllQuery(){
        return "SELECT * FROM crm_pallas.settings";
    }

    @Override
    public String getByIdQuery(){
        return "SELECT * FROM crm_pallas.settings WHERE id = ?";
    }

    @Override
    public void createStatement(PreparedStatement preparedStatement, CrmSettings crmSettings) throws DaoException {
        try {
            preparedStatement.setInt(1, crmSettings.getLanguage().getId());
            preparedStatement.setInt(2, crmSettings.getTimeZone().getId());
            preparedStatement.setInt(3, crmSettings.getCrmCurrency().getId());
        } catch (SQLException e) {
            throw new DaoException("Can't create statement for CrmSettings", e);
        }
    }

    @Override
    public void updateStatement(PreparedStatement preparedStatement, CrmSettings crmSettings) throws DaoException {
        try {
            preparedStatement.setInt(1, crmSettings.getLanguage().getId());
            preparedStatement.setInt(2, crmSettings.getTimeZone().getId());
            preparedStatement.setInt(3, crmSettings.getCrmCurrency().getId());
            preparedStatement.setInt(4, crmSettings.getId());
        } catch (SQLException e) {
            throw new DaoException("Can't update statement for CrmSettings", e);
        }
    }

    @Override
    public CrmSettings getEntity(ResultSet resultSet) throws DaoException{
        CrmSettings crmSettings = new CrmSettings();
        LanguageDao<Language> languageDao = new LanguageDaoImpl();
        TimeZoneDao<TimeZone> timeZoneDao = new TimeZoneDaoImpl();
        CrmCurrencyDao<CrmCurrency> crmCurrencyDao = new CrmCurrencyDaoImpl();
        try {
            crmSettings.setId(resultSet.getInt("id"));
            crmSettings.setLanguage(languageDao.getById(resultSet.getInt("default_language_id")));
            crmSettings.setTimeZone(timeZoneDao.getById(resultSet.getInt("timezone_id")));
            crmSettings.setCrmCurrency(crmCurrencyDao.getById(resultSet.getInt("currency_id")));
        }catch (SQLException e){
            throw new DaoException("Can't get entity from TimeZone", e);
        }
        return crmSettings;
    }

    @Override
    public CrmSettings getByName(String str) throws DaoException, ClassNotFoundException {
        return null;
    }

    @Override
    public List<CrmSettings> getByFilter(String query) {
        return null;
    }
}
