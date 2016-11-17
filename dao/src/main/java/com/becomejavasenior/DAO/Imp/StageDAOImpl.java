package com.becomejavasenior.DAO.Imp;

import java.sql.*;

import com.becomejavasenior.DAO.DAOException;
import com.becomejavasenior.DAO.StageDAO;
import com.becomejavasenior.bean.Stage;
import com.becomejavasenior.exceptions.DatabaseException;
import com.becomejavasenior.factory.PostgresDAOFactory;

import java.util.ArrayList;
import java.util.List;


public class StageDAOImpl extends AbstractDAOImpl<Stage> implements StageDAO<Stage> {

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
    public List<Stage> getByFilter(String query) {
        return null;
    }

    @Override
    public String getByIdQuery(){
        return "SELECT * FROM crm_pallas.stage WHERE id = ?";
    }

    @Override
    public void createStatement(PreparedStatement preparedStatement, Stage stage){
     try {
         preparedStatement.setString(1, stage.getTitle());
         preparedStatement.setString(2, stage.getColor());
         preparedStatement.setInt(3, stage.getPriority());
         preparedStatement.setBoolean(4, stage.is_deletable());
     } catch (SQLException e){
         e.printStackTrace();
     }
    }

    @Override
    public void updateStatement(PreparedStatement preparedStatement, Stage stage){
        try {
            preparedStatement.setString(1, stage.getTitle());
            preparedStatement.setString(2, stage.getColor());
            preparedStatement.setInt(3, stage.getPriority());
            preparedStatement.setBoolean(4, stage.is_deletable());
        } catch (SQLException e){
            e.printStackTrace();
        }
    }

    @Override
    public Stage getEntity(ResultSet resultSet){
        Stage stage = new Stage();
        try {
          stage.setId(resultSet.getInt("id"));
            stage.setTitle(resultSet.getString("title"));
            stage.setColor(resultSet.getString("color"));
            stage.setPriority(resultSet.getInt("priority"));
            stage.setDeletable(resultSet.getBoolean("is_deletable"));
        } catch (SQLException e){
            e.printStackTrace();
        }
        return stage;
    }

    @Override
    public Stage getById(Integer id) throws DAOException {
        try (Connection connection = PostgresDAOFactory.getConnection();
             PreparedStatement statement = connection.prepareStatement(getByIdQuery() + " AND id = ?")) {

            statement.setInt(1, id);

            List<Stage> stageList = parseResultSet(statement.executeQuery());
            return stageList == null || stageList.isEmpty() ? null : stageList.get(0);
        } catch (SQLException ex) {
            throw new DatabaseException(ex);
        }
    }

    private List<Stage> parseResultSet(ResultSet resultSet) throws SQLException {

        List<Stage> stageList = new ArrayList<>();
        try {
            while (resultSet.next()) {
                Stage stage = new Stage();
                stage.setId(resultSet.getInt("id"));
                stage.setTitle(resultSet.getString("title"));
                stage.setColor(resultSet.getString("color"));
                stage.setPriority(resultSet.getByte("priority"));
                stage.setDeletable(false);
                stageList.add(stage);
            }
        } catch (Exception e) {
            throw new DatabaseException(e);
        }
        return stageList;
    }
}
