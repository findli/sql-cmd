package com.becomejavasenior.DAO.JdbcTempale;

import com.becomejavasenior.DAO.AbstractDao;
import com.becomejavasenior.DAO.DaoException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public abstract class AbstractDaoJdbcTemplate<T> implements AbstractDao<T> {

    @Autowired
    protected JdbcTemplate jdbcTemplate;

    protected AbstractDaoJdbcTemplate() {
    }

    @Override
    abstract public T create(T o);

    @Override
    abstract public T update(T t);

    @Override
    abstract public List<T> getAll() throws DaoException, ClassNotFoundException;

    @Override
    abstract public T getById(Integer id) throws DaoException;

    public void delete(int id, String tableName /*, Logger logger*/) {
        jdbcTemplate.update("UPDATE " + tableName + " SET deleted = TRUE WHERE id = " + id);
    }

    public JdbcTemplate getJdbcTemplate() {
        return jdbcTemplate;
    }

}
