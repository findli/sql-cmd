package com.becomejavasenior.DAO.Imp;


import com.becomejavasenior.DAO.DaoException;
import com.becomejavasenior.DAO.StageDao;
import com.becomejavasenior.bean.Stage;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class StageDaoImpl extends AbstractDaoImpl<Stage> implements StageDao<Stage> {

    @Override
    public String getCreateQuery(){
        return "INSERT INTO crm_pallas.stage (title, color, priority, is_deletable) VALUES(?,?,?,?)";
    }

    @Override
    public String getUpdateQuery(){
        return "UPDATE crm_pallas.stage SET title = ?, color = ?, priority = ?, is_deletable = ?";
    }

    @Override
    public String getDeleteQuery(){
        return "DELETE FROM crm_pallas.stage WHERE id = ?";
    }

    @Override
    public String getAllQuery(){
        return "SELECT * FROM crm_pallas.stage";
    }

    @Override
    public String getByIdQuery(){
        return "SELECT * FROM crm_pallas.stage WHERE id = ?";
    }

    @Override
    public void createStatement(PreparedStatement preparedStatement, Stage stage) throws DaoException {
        try {
            preparedStatement.setString(1, stage.getTitle());
            preparedStatement.setString(2, stage.getColor());
            preparedStatement.setInt(3, stage.getPriority());
            preparedStatement.setBoolean(4, stage.is_deletable());
        } catch (SQLException e){
            throw new DaoException("Can't create statement for Stage", e);
        }
    }

    @Override
    public void updateStatement(PreparedStatement preparedStatement, Stage stage) throws DaoException {
        try {
            preparedStatement.setString(1, stage.getTitle());
            preparedStatement.setString(2, stage.getColor());
            preparedStatement.setInt(3, stage.getPriority());
            preparedStatement.setBoolean(4, stage.is_deletable());
        } catch (SQLException e){
            throw new DaoException("Can't update statement for Stage", e);
        }
    }

    @Override
    public Stage getEntity(ResultSet resultSet) throws DaoException {
        Stage stage = new Stage();
        try {
            stage.setId(resultSet.getInt("id"));
            stage.setTitle(resultSet.getString("title"));
            stage.setColor(resultSet.getString("color"));
            stage.setPriority(resultSet.getInt("priority"));
            stage.setDeletable(resultSet.getBoolean("is_deletable"));
        } catch (SQLException e){
            throw new DaoException("Can't get entity from Stage", e);
        }
        return stage;
    }

}

