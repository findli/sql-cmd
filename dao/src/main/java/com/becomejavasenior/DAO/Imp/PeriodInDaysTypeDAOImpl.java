package com.becomejavasenior.DAO.Imp;


import com.becomejavasenior.DAO.PeriodInDaysTypeDAO;
import com.becomejavasenior.bean.PeriodInDaysType;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class PeriodInDaysTypeDAOImpl extends AbstractDAOImpl<PeriodInDaysType> implements PeriodInDaysTypeDAO<PeriodInDaysType> {

    @Override
    public String getCreateQuery(){
        return "INSERT INTO period_in_days_type (title, daysInPeriod) VALUES(?, ?)";
    }

    @Override
    public String getUpdateQuery(){
        return "UPDATE period_in_days_type SET title = ?, daysInPeriod = ?";
    }

    @Override
    public String getDeleteQuery(){
        return "DELETE FROM period_in_days_type WHERE id = ?";
    }

    @Override
    public String getAllQuery(){
        return "SELECT * FROM period_in_days_type";
    }

    @Override
    public String getByIdQuery(){
        return "SELECT * FROM period_in_days_type WHERE id = ?";
    }

    @Override
    public void createStatement(PreparedStatement preparedStatement, PeriodInDaysType periodInDaysType) throws DAOException{
        try {
            preparedStatement.setString(1, periodInDaysType.getTitle());
            preparedStatement.setInt(2, periodInDaysType.getDaysInPeriod());
        } catch (SQLException e){
            throw new DAOException("Can't create statement for PeriodInDaysType", e);
        }
    }

    @Override
    public void updateStatement(PreparedStatement preparedStatement, PeriodInDaysType periodInDaysType) throws DAOException{
        try {
            preparedStatement.setString(1, periodInDaysType.getTitle());
            preparedStatement.setInt(2, periodInDaysType.getDaysInPeriod());
        } catch (SQLException e){
            throw new DAOException("Can't update statement for PeriodInDaysType", e);
        }
    }

    @Override
    public PeriodInDaysType getEntity(ResultSet resultSet) throws DAOException{
        PeriodInDaysType periodInDaysType = new PeriodInDaysType();
        try {
            periodInDaysType.setId(resultSet.getInt("id"));
            periodInDaysType.setTitle(resultSet.getString("title"));
            periodInDaysType.setDaysInPeriod(resultSet.getInt("daysInPeriod"));

        } catch (SQLException e){
            throw new DAOException("Can't get entity from PeriodInDaysType", e);
        }
        return periodInDaysType;
    }
}
