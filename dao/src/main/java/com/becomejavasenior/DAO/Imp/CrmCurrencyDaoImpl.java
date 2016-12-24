package com.becomejavasenior.DAO.Imp;

import com.becomejavasenior.DAO.CrmCurrencyDao;
import com.becomejavasenior.DAO.DaoException;
import com.becomejavasenior.bean.CrmCurrency;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

public class CrmCurrencyDaoImpl extends AbstractDaoImpl<CrmCurrency> implements CrmCurrencyDao<CrmCurrency>{

    @Override
    public String getCreateQuery(){
        return "INSERT INTO crm_pallas.currency (title, short_title) VALUES(?,?)";
    }

    @Override
    public String getUpdateQuery(){
        return "UPDATE crm_pallas.currency SET title = ?, short_title = ? WHERE id = ?";
    }

    @Override
    public String getDeleteQuery(){
        return "DELETE FROM crm_pallas.currency WHERE id = ?";
    }

    @Override
    public String getAllQuery(){
        return "SELECT * FROM crm_pallas.currency";
    }

    @Override
    public String getByIdQuery(){
        return "SELECT * FROM crm_pallas.currency WHERE id = ?";
    }

    @Override
    public void createStatement(PreparedStatement preparedStatement, CrmCurrency crmCurrency) throws DaoException {
        try {
            preparedStatement.setString(1, crmCurrency.getTitle());
            preparedStatement.setString(2, crmCurrency.getShortTitle());
        } catch (SQLException e) {
            throw new DaoException("Can't create statement for CrmCurrency", e);
        }
    }

    @Override
    public void updateStatement(PreparedStatement preparedStatement, CrmCurrency crmCurrency) throws DaoException {
        try {
            preparedStatement.setString(1, crmCurrency.getTitle());
            preparedStatement.setString(2, crmCurrency.getShortTitle());
        } catch (SQLException e) {
            throw new DaoException("Can't update statement for CrmCurrency", e);
        }
    }

    @Override
    public CrmCurrency getEntity(ResultSet resultSet) throws DaoException{
        CrmCurrency crmCurrency = new CrmCurrency();
        try {
            crmCurrency.setId(resultSet.getInt("id"));
            crmCurrency.setTitle(resultSet.getString("title"));
            crmCurrency.setShortTitle(resultSet.getString("short_title"));
        }catch (SQLException e){
            throw new DaoException("Can't get entity from CrmCurrency", e);
        }
        return crmCurrency;
    }

    @Override
    public CrmCurrency getByName(String str) throws DaoException, ClassNotFoundException {
        return null;
    }

    @Override
    public List<CrmCurrency> getByFilter(String query) {
        return null;
    }
}
