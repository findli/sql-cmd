package com.becomejavasenior.DAO.Imp;

import java.sql.*;

import com.becomejavasenior.DAO.DaoException;
import com.becomejavasenior.bean.Stage;
import com.becomejavasenior.exceptions.DatabaseException;

import com.becomejavasenior.factory.PostgresDaoFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import javax.sql.DataSource;
import java.util.ArrayList;
import java.util.List;

@Repository("stageDao")
public class StageDaoImpl extends AbstractDaoImpl<Stage> implements com.becomejavasenior.DAO.StageDao<Stage> {

    @Autowired
    public StageDaoImpl(DataSource dataSource) {
        super(dataSource);
    }

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
        return "SELECT * FROM crm_pallas.stage ORDER BY id";
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
    public Stage getByName(String str) throws DaoException, ClassNotFoundException {
        Stage stage = new Stage();
        List<Stage> stages = getAll();
        for (int i = 0; i < stages.size(); ++i) {
            if(stages.get(i).getTitle().equals(str)) {
                stage = stages.get(i);
                break;
            }
        }
        return stage;
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

    @Override
    public List<Stage> getAll() throws DaoException, ClassNotFoundException {
        List<Stage> stages = new ArrayList<>();
        Stage stage;

        try (Connection connection = getConnection();
             Statement statement = connection.createStatement();
             ResultSet resultSet = statement.executeQuery(getAllQuery())) {

            while (resultSet.next()) {

                stage = new Stage();
                stage.setId(resultSet.getInt("id"));
                stage.setTitle(resultSet.getString("title"));

                stages.add(stage);
            }
        } catch (SQLException ex) {
            throw new DatabaseException(ex);
        }
        return stages;
    }
}

