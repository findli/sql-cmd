package com.becomejavasenior.DAO.Imp;

import com.becomejavasenior.DAO.AbstractDao;
import com.becomejavasenior.DAO.DaoException;
import com.becomejavasenior.DAO.TimeZoneDao;
import com.becomejavasenior.bean.TimeZone;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import javax.sql.DataSource;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

@Repository("timeZoneDao")
public class TimeZoneDaoImpl extends AbstractDaoImpl<TimeZone> implements TimeZoneDao<TimeZone> {

    @Autowired
    public TimeZoneDaoImpl(DataSource dataSource) {
        super(dataSource);
    }

    @Override
    public String getCreateQuery(){
        return "INSERT INTO crm_pallas.timezone (title, shift_in_hours) VALUES(?,?)";
    }

    @Override
    public String getUpdateQuery(){
        return "UPDATE crm_pallas.timezone SET title = ?, shift_in_hours = ? WHERE id = ?";
    }

    @Override
    public String getDeleteQuery(){
        return "DELETE FROM crm_pallas.timezone WHERE id = ?";
    }

    @Override
    public String getAllQuery(){
        return "SELECT * FROM crm_pallas.timezone";
    }

    @Override
    public String getByIdQuery(){
        return "SELECT * FROM crm_pallas.timezone WHERE id = ?";
    }

    @Override
    public void createStatement(PreparedStatement preparedStatement, TimeZone timeZone) throws DaoException {
        try {
            preparedStatement.setString(1, timeZone.getTitle());
            preparedStatement.setString(2, String.valueOf(timeZone.getShiftInHours()));
        } catch (SQLException e) {
            throw new DaoException("Can't create statement for TimeZone", e);
        }
    }

    @Override
    public void updateStatement(PreparedStatement preparedStatement, TimeZone timeZone) throws DaoException {
        try {
            preparedStatement.setString(1, timeZone.getTitle());
            preparedStatement.setString(2, String.valueOf(timeZone.getShiftInHours()));
        } catch (SQLException e) {
            throw new DaoException("Can't update statement for TimeZone", e);
        }
    }

    @Override
    public TimeZone getEntity(ResultSet resultSet) throws DaoException{
        TimeZone timeZone = new TimeZone();
        try {
            timeZone.setId(resultSet.getInt("id"));
            timeZone.setTitle(resultSet.getString("title"));
            timeZone.setShiftInHours(Integer.parseInt(resultSet.getString("shift_in_hours")));
        }catch (SQLException e){
            throw new DaoException("Can't get entity from TimeZone", e);
        }
        return timeZone;
    }

    @Override
    public TimeZone getByName(String str) throws DaoException, ClassNotFoundException {
        return null;
    }

    @Override
    public List<TimeZone> getByFilter(String query) {
        return null;
    }
}