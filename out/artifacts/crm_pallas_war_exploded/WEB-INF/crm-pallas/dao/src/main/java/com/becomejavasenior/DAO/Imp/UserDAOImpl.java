package com.becomejavasenior.DAO.Imp;


import com.becomejavasenior.DAO.DAOException;
import com.becomejavasenior.DAO.LanguageDAO;
import com.becomejavasenior.DAO.UserDAO;
import com.becomejavasenior.bean.Language;
import com.becomejavasenior.bean.User;

import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class UserDAOImpl extends AbstractDAOImpl<User> implements UserDAO<User> {

    @Override
    public String getCreateQuery(){
        return "INSERT INTO user (first_name, last_name, password_hash, email, is_admin, rights, photo_path, is_notification_enabled, note, creation_date_time, language_id ) VALUES(?,?,?,?,?,?,?,?,?,?,?)";
    }

    @Override
    public String getUpdateQuery(){
        return "UPDATE user SET first_name = ?, last_name = ?, password_hash = ?, email = ?, is_admin = ?, rights = ?, photo_path = ?, is_notification_enabled = ?, note = ?, creation_date_time = ?, language_id = ?";
    }

    @Override
    public String getDeleteQuery(){
        return "DELETE FROM user WHERE id = ?";
    }

    @Override
    public String getAllQuery(){
        return "SELECT * FROM user";
    }

    @Override
    public String getByIdQuery(){
        return "SELECT * FROM user WHERE id = ?";
    }

    @Override
    public void createStatement(PreparedStatement preparedStatement, User user) throws DAOException{
        Date sqlDate = new Date(user.getDateCreate().getTime());
        try {
            preparedStatement.setString(1, user.getfName());
            preparedStatement.setString(2, user.getlName());
            preparedStatement.setString(3, user.getPassword());
            preparedStatement.setString(4, user.getEmail());
            preparedStatement.setBoolean(5, user.is_admin());
            preparedStatement.setInt(6, user.getRights());
            preparedStatement.setString(7, user.getPhotoPath());
            preparedStatement.setBoolean(8, user.is_notification());
            preparedStatement.setString(9, user.getNote());
            preparedStatement.setDate(10, sqlDate);
            preparedStatement.setInt(11, user.getLanguage().getId());
        } catch (SQLException e){
            throw new DAOException("Can't create statement for User", e);
        }
    }

    @Override
    public void updateStatement(PreparedStatement preparedStatement, User user) throws DAOException{
        Date sqlDate = new Date(user.getDateCreate().getTime());
        try {
            preparedStatement.setString(1, user.getfName());
            preparedStatement.setString(2, user.getlName());
            preparedStatement.setString(3, user.getPassword());
            preparedStatement.setString(4, user.getEmail());
            preparedStatement.setBoolean(5, user.is_admin());
            preparedStatement.setInt(6, user.getRights());
            preparedStatement.setString(7, user.getPhotoPath());
            preparedStatement.setBoolean(8, user.is_notification());
            preparedStatement.setString(9, user.getNote());
            preparedStatement.setDate(10, sqlDate);
            preparedStatement.setInt(11, user.getLanguage().getId());
        } catch (SQLException e){
            throw new DAOException("Can't update statement for User", e);
        }
    }

    @Override
    public User getEntity(ResultSet resultSet) throws DAOException{
        User user = new User();
        LanguageDAO<Language> languageDAO = new LanguageDAOImpl();
        try {
            user.setId(resultSet.getInt("id"));
            user.setfName(resultSet.getString("first_name"));
            user.setlName(resultSet.getString("last_name"));
            user.setPassword(resultSet.getString("password_hash"));
            user.setEmail(resultSet.getString("email"));
            user.setAdmin(resultSet.getBoolean("is_admin"));
            user.setRights(resultSet.getInt("rights"));
            user.setPhotoPath(resultSet.getString("photo_path"));
            user.setNotification(resultSet.getBoolean("is_notification_enabled"));
            user.setNote(resultSet.getString("note"));
            user.setDateCreate(resultSet.getDate("creation_date_time"));
            user.setLanguage(languageDAO.getById(resultSet.getInt("language_id")));
        } catch (SQLException e){
            throw new DAOException("Can't get entity from User", e);
        }
        return user;
    }
}
