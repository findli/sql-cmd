package com.becomejavasenior.DAO.Imp;


import com.becomejavasenior.DAO.DAOException;
import com.becomejavasenior.DAO.StageDAO;
import com.becomejavasenior.bean.Stage;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class StageDAOImpl extends AbstractDAOImpl<Stage> implements StageDAO<Stage> {

    @Override
    public String getCreateQuery(){
        return "INSERT INTO stage (title, color, priority, is_deletable) VALUES(?,?,?,?)";
    }

    @Override
    public String getUpdateQuery(){
        return "UPDATE stage SET title = ?, color = ?, priority = ?, is_deletable = ?";
    }

    @Override
    public String getDeleteQuery(){
        return "DELETE FROM stage WHERE id = ?";
    }

    @Override
    public String getAllQuery(){
        return "SELECT * FROM stage";
    }

    @Override
    public String getByIdQuery(){
        return "SELECT * FROM stage WHERE id = ?";
    }

    @Override
    public void createStatement(PreparedStatement preparedStatement, Stage stage) throws DAOException{
        try {
            preparedStatement.setString(1, stage.getTitle());
            preparedStatement.setString(2, stage.getColor());
            preparedStatement.setInt(3, stage.getPriority());
            preparedStatement.setBoolean(4, stage.is_deletable());
        } catch (SQLException e){
            throw new DAOException("Can't create statement for Stage", e);
        }
    }

    @Override
    public void updateStatement(PreparedStatement preparedStatement, Stage stage) throws DAOException{
        try {
            preparedStatement.setString(1, stage.getTitle());
            preparedStatement.setString(2, stage.getColor());
            preparedStatement.setInt(3, stage.getPriority());
            preparedStatement.setBoolean(4, stage.is_deletable());
        } catch (SQLException e){
            throw new DAOException("Can't update statement for Stage", e);
        }
    }

    @Override
    public Stage getEntity(ResultSet resultSet) throws DAOException{
        Stage stage = new Stage();
        try {
            stage.setId(resultSet.getInt("id"));
            stage.setTitle(resultSet.getString("title"));
            stage.setColor(resultSet.getString("color"));
            stage.setPriority(resultSet.getInt("priority"));
            stage.setDeletable(resultSet.getBoolean("is_deletable"));
        } catch (SQLException e){
            throw new DAOException("Can't get entity from Stage", e);
        }
        return stage;
    }

}

