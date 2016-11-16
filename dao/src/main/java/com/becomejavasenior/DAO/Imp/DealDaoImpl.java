package com.becomejavasenior.DAO.Imp;

import com.becomejavasenior.DAO.DAOException;
import com.becomejavasenior.DAO.DealDao;
import com.becomejavasenior.bean.Deal;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

public class DealDaoImpl extends AbstractDaoImpl<Deal> implements DealDao<Deal> {
    @Override
    void createStatement(PreparedStatement preparedStatement, Deal deal) throws DAOException {
        try {

            preparedStatement.setInt(1, deal.getCompany().getId());
            preparedStatement.setInt(2, deal.getStage().getId());
            preparedStatement.setInt(3, deal.getResponsibleUser().getId());
            preparedStatement.setString(4, deal.getTitle());
            preparedStatement.setInt(5, deal.getBudget());
            preparedStatement.setBoolean(6, deal.isDeleted());

        } catch (SQLException e) {
            e.printStackTrace();
        }

    }

    @Override
    void updateStatement(PreparedStatement preparedStatement, Deal deal) throws DAOException {
        try {

            preparedStatement.setInt(1, deal.getCompany().getId());
            preparedStatement.setInt(2, deal.getStage().getId());
            preparedStatement.setInt(3, deal.getResponsibleUser().getId());
            preparedStatement.setString(4, deal.getTitle());
            preparedStatement.setInt(5, deal.getBudget());
            preparedStatement.setBoolean(6, deal.isDeleted());

        } catch (SQLException e) {
            e.printStackTrace();
        }

    }

    @Override
    Deal getEntity(ResultSet resultSet) throws DAOException {
        return null;
    }

    @Override
    String getAllQuery() {
        return null;
    }

    @Override
    String getByIdQuery() {
        return null;
    }

    @Override
    String getCreateQuery() {
        return null;
    }

    @Override
    String getDeleteQuery() {
        return null;
    }

    @Override
    String getUpdateQuery() {
        return null;
    }

    @Override
    public List<Deal> getByFilter(String query) {
        return null;
    }
}
