package com.becomejavasenior.DAO.Imp;

import com.becomejavasenior.DAO.DaoException;
import com.becomejavasenior.DAO.LanguageDao;
import com.becomejavasenior.bean.Language;
import org.springframework.stereotype.Repository;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

@Repository("languageDao")
public class LanguageDaoImpl extends AbstractDaoImpl<Language> implements LanguageDao<Language> {

    @Override
    public String getCreateQuery() {
        return "INSERT INTO crm_pallas.language (title, short_title ) VALUES(?,?)";
    }

    @Override
    public String getUpdateQuery() {
        return "UPDATE crm_pallas.language SET title = ?, short_title = ? WHERE id = ?";
    }

    @Override
    public String getDeleteQuery() {
        return "DELETE FROM crm_pallas.language WHERE id = ?";
    }

    @Override
    public String getAllQuery() {
        return "SELECT * FROM crm_pallas.language";
    }

    @Override
    public List<Language> getByFilter(String query) {
        return null;
    }

    @Override
    public String getByIdQuery() {
        return "SELECT * FROM crm_pallas.language WHERE id = ?";
    }

    @Override
    public void createStatement(PreparedStatement preparedStatement, Language language) throws DaoException {
        try {
            preparedStatement.setString(1, language.getTitle());
            preparedStatement.setString(2, language.getShortTitle());
        } catch (SQLException e){
            throw new DaoException("Can't create statement for Language", e);
        }
    }

    @Override
    public void updateStatement(PreparedStatement preparedStatement, Language language) throws DaoException {
        try {
            preparedStatement.setString(1, language.getTitle());
            preparedStatement.setString(2, language.getShortTitle());
            preparedStatement.setInt(3, language.getId());
        } catch (SQLException e){
            throw new DaoException("Can't update statement for Language", e);
        }
    }

    @Override
    public Language getByName(String str) throws DaoException, ClassNotFoundException {
        return null;
    }

    @Override
    public Language getEntity(ResultSet resultSet) throws DaoException{
        Language language = new Language();
        try {
            language.setId(resultSet.getInt("id"));
            language.setTitle(resultSet.getString("title"));
            language.setShortTitle(resultSet.getString("short_title"));

        } catch (SQLException e){
            throw new DaoException("Can't get entity from Language", e);
        }
        return language;
    }
}