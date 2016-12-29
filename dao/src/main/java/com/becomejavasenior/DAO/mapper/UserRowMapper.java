package com.becomejavasenior.DAO.mapper;

import com.becomejavasenior.DAO.DaoException;
import com.becomejavasenior.DAO.LanguageDao;
import com.becomejavasenior.bean.Language;
import com.becomejavasenior.bean.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Component;

import java.sql.ResultSet;
import java.sql.SQLException;

@Component
public class UserRowMapper implements RowMapper<User> {

    @Autowired
    LanguageDao languageDao;

    @Override
    public User mapRow(ResultSet resultSet, int i) throws SQLException {

        User user = new User();

        user.setId(resultSet.getInt("id"));
        user.setfName(resultSet.getString("first_name"));

        if(resultSet.getObject("language_id", Integer.class) != null) {
            Language language = null;
            try {
                language = (Language) languageDao.getById(resultSet.getInt("language_id"));
            } catch (DaoException e) {
                e.printStackTrace();
            }
            user.setLanguage(language);
        }

        user.setlName(resultSet.getString("last_name"));
        user.setPassword(resultSet.getString("password_hash"));
        user.setEmail(resultSet.getString("email"));
        user.setAdmin(resultSet.getBoolean("is_admin"));
        user.setRights(resultSet.getInt("rights"));
        user.setPhotoPath(resultSet.getString("photo_path"));
        user.setNotification(resultSet.getBoolean("is_notification_enabled"));
        user.setNote(resultSet.getString("note"));
        user.setDateCreate(resultSet.getDate("creation_date_time"));

        return user;
    }
}
