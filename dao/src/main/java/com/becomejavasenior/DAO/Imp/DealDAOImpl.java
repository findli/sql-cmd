package com.becomejavasenior.DAO.Imp;

import com.becomejavasenior.DAO.*;
import com.becomejavasenior.DAO.StageDAO;
import com.becomejavasenior.bean.Company;
import com.becomejavasenior.bean.Deal;
import com.becomejavasenior.bean.Stage;
import com.becomejavasenior.bean.User;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;


public class DealDAOImpl extends AbstractDAOImpl<Deal> implements DealDAO<Deal> {

    @Override
    public String getCreateQuery(){
        return "INSERT INTO deal (title, company_id, budget, stage_id, responsible_user_id, is_deleted ) VALUES(?,?,?,?,?,?)";
    }

    @Override
    public String getUpdateQuery(){
        return "UPDATE deal SET title = ?, company_id = ?, budget = ?, stage_id = ?, responsible_user_id = ?, is_deleted = ?";
    }

    @Override
    public String getDeleteQuery(){
        return "DELETE FROM deal WHERE id = ?";
    }

    @Override
    public String getAllQuery(){
        return "SELECT * FROM deal";
    }

    @Override
    public String getByIdQuery(){
        return "SELECT * FROM deal WHERE id = ?";
    }

    @Override
    public void createStatement(PreparedStatement preparedStatement, Deal deal) throws DAOException {

        try {
            preparedStatement.setString(1, deal.getTitle());
            preparedStatement.setInt(2, deal.getCompany().getId());
            preparedStatement.setInt(3, deal.getBudget());
            preparedStatement.setInt(4, deal.getStage().getId());
            preparedStatement.setInt(5, deal.getResponsibleUser().getId());
            preparedStatement.setBoolean(6, deal.isDeleted());
        } catch (SQLException e){
            throw new DAOException("Can't create statement for Deal", e);
        }
    }

    @Override
    public void updateStatement(PreparedStatement preparedStatement, Deal deal) throws DAOException {

        try {
            preparedStatement.setString(1, deal.getTitle());
            preparedStatement.setInt(2, deal.getCompany().getId());
            preparedStatement.setInt(3, deal.getBudget());
            preparedStatement.setInt(4, deal.getStage().getId());
            preparedStatement.setInt(5, deal.getResponsibleUser().getId());
            preparedStatement.setBoolean(6, deal.isDeleted());
        } catch (SQLException e){
            throw new DAOException("Can't update statement for Deal", e);
        }
    }

    @Override
    public Deal getEntity(ResultSet resultSet) throws DAOException{
        Deal deal = new Deal();
        CompanyDAO<Company> company = new CompanyDAOImpl();
        StageDAO<Stage> stage = new StageDAOImpl();
        UserDAO<User> user = new UserDAOImpl();
        try {
            deal.setId(resultSet.getInt("id"));
            deal.setTitle(resultSet.getString("title"));
            deal.setCompany(company.getById(resultSet.getInt("company_id")));
            deal.setBudget(resultSet.getInt("budget"));
            deal.setStage(stage.getById(resultSet.getInt("stage_id")));
            deal.setResponsibleUser(user.getById(resultSet.getInt("responsible_user_id")));
            deal.setIsDeleted(resultSet.getBoolean("is_deleted"));


        } catch (SQLException e){
            throw new DAOException("Can't get entity from Deal", e);
        }
        return deal;
    }
}
