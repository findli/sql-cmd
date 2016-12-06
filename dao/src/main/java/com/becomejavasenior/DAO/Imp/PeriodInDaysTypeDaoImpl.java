package com.becomejavasenior.DAO.Imp;


import com.becomejavasenior.DAO.DaoException;
import com.becomejavasenior.DAO.PeriodInDaysTypeDao;
import com.becomejavasenior.bean.PeriodInDaysType;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

public class PeriodInDaysTypeDaoImpl extends AbstractDaoImpl<PeriodInDaysType> implements PeriodInDaysTypeDao<PeriodInDaysType> {

    @Override
    public String getCreateQuery(){
        return "INSERT INTO crm_pallas.period_in_days_type (title, daysInPeriod) VALUES(?, ?)";
    }

    @Override
    public String getUpdateQuery(){
        return "UPDATE crm_pallas.period_in_days_type SET title = ?, daysInPeriod = ? WHERE id = ?";
    }

    @Override
    public String getDeleteQuery(){
        return "DELETE FROM crm_pallas.period_in_days_type WHERE id = ?";
    }

    @Override
    public String getAllQuery(){
        return "SELECT * FROM crm_pallas.period_in_days_type";
    }

    @Override
    public List<PeriodInDaysType> getByFilter(String query) {
        return null;
    }

    @Override
    public String getByIdQuery(){
        return "SELECT * FROM crm_pallas.period_in_days_type WHERE id = ?";
    }

    @Override
    public void createStatement(PreparedStatement preparedStatement, PeriodInDaysType periodInDaysType) throws DaoException {
        try {
            preparedStatement.setString(1, periodInDaysType.getTitle());
            preparedStatement.setInt(2, periodInDaysType.getDaysInPeriod());
        } catch (SQLException e){
            throw new DaoException("Can't create statement for PeriodInDaysType", e);
        }
    }

    @Override
    public void updateStatement(PreparedStatement preparedStatement, PeriodInDaysType periodInDaysType) throws DaoException {
        try {
            preparedStatement.setString(1, periodInDaysType.getTitle());
            preparedStatement.setInt(2, periodInDaysType.getDaysInPeriod());
            preparedStatement.setInt(3, periodInDaysType.getId());
        } catch (SQLException e){
            throw new DaoException("Can't update statement for PeriodInDaysType", e);
        }
    }

    @Override
    public PeriodInDaysType getEntity(ResultSet resultSet) throws DaoException {
        PeriodInDaysType periodInDaysType = new PeriodInDaysType();
        try {
            periodInDaysType.setId(resultSet.getInt("id"));
            periodInDaysType.setTitle(resultSet.getString("title"));
            periodInDaysType.setDaysInPeriod(resultSet.getInt("days_In_Period"));

        } catch (SQLException e){
            throw new DaoException("Can't get entity from PeriodInDaysType", e);
        }
        return periodInDaysType;
    }

    @Override
    public PeriodInDaysType getByName(String str) throws DaoException, ClassNotFoundException {
        return null;
    }
}
