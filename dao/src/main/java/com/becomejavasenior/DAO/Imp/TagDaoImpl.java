package com.becomejavasenior.DAO.Imp;

import com.becomejavasenior.DAO.DaoException;
import com.becomejavasenior.DAO.DatabaseException;
import com.becomejavasenior.DAO.TagDao;
import com.becomejavasenior.DataBaseUtil;
import com.becomejavasenior.bean.Tag;
import com.becomejavasenior.factory.PostgresDaoFactory;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class TagDaoImpl extends AbstractDaoImpl<Tag> implements TagDao<Tag> {

    @Override
    public Tag create(Tag entity) throws DaoException {
        return super.create(entity);
    }

    @Override
    void createStatement(PreparedStatement statement, Tag entity) throws DaoException {
        try {
            statement.setString(1, entity.getTitle());
        } catch (SQLException e) {
            throw new DaoException("createStatement in TagDaoImpl", e);
        }
    }

    @Override
    void updateStatement(PreparedStatement statement, Tag entity) throws DaoException {
        try {
            statement.setString(1, entity.getTitle());
        } catch (SQLException e){
            throw new DaoException("updateStatement in TagDaoImpl", e);
        }
    }

    @Override
    public Tag getByName(String str) throws DaoException, ClassNotFoundException {
        return null;
    }

    @Override
    Tag getEntity(ResultSet resultSet) throws DaoException {

        Tag tag = new Tag();

        try {
            tag.setId(resultSet.getInt("id"));
            tag.setTitle(resultSet.getString("title"));

        } catch (SQLException e) {
            throw new DaoException("Can't get entity from Tag", e);
        }
        return tag;
    }

    @Override
    public List<Tag> getAll() throws DaoException, ClassNotFoundException {
        List<Tag> tagList = new ArrayList<>();
        Tag tag;

        try (Connection connection = PostgresDaoFactory.getConnection();
             Statement statement = connection.createStatement();
             ResultSet resultSet = statement.executeQuery(getAllQuery())) {

            while (resultSet.next()) {

                tag = new Tag();

                tag.setId(resultSet.getInt("id"));
                tag.setTitle(resultSet.getString("title"));

                tagList.add(tag);
            }
        } catch (SQLException ex) {
            throw new DatabaseException(ex);
        }
        return tagList;
    }

    @Override
    public Tag update(Tag entity) throws DaoException {
        return super.update(entity);
    }

    @Override
    public void delete(Integer id) throws DaoException {
        super.delete(id);
    }

    @Override
    public Tag getById(Integer id) throws DaoException {
        return super.getById(id);
    }



    @Override
    String getCreateQuery() {
        return DataBaseUtil.getQuery("INSERT INTO crm_pallas.tag (title) values (?)");
    }

    @Override
    String getUpdateQuery() {
        return DataBaseUtil.getQuery("UPDATE crm_pallas.tag SET title = ? WHERE id = ?");
    }

    @Override
    String getDeleteQuery() {
        return DataBaseUtil.getQuery("DELETE FROM crm_pallas.tag WHERE id = ?");
    }

    @Override
    String getByIdQuery() {
        return DataBaseUtil.getQuery("SELECT * FROM crm_pallas.tag WHERE id=?");
    }

    @Override
    String getAllQuery() {
        return DataBaseUtil.getQuery("SELECT * FROM crm_pallas.tag");
    }

    @Override
    public List<Tag> getByFilter(String query) {
        return null;
    }
}
