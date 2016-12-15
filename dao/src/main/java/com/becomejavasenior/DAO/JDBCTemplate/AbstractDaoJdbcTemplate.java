package com.becomejavasenior.DAO.JDBCTemplate;

import com.becomejavasenior.DAO.AbstractDao;
import com.becomejavasenior.DAO.DaoException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
abstract class AbstractDaoJdbcTemplate<T> implements AbstractDao<T> {

    @Autowired
    protected JdbcTemplate jdbcTemplate;

    public AbstractDaoJdbcTemplate() {
    }

    @Override
    public T create(T entity) throws DaoException {
        return null;
    }

    @Override
    public T update(T entity) throws DaoException {
        return null;
    }

    @Override
    public void delete(Integer id) throws DaoException {

    }

    @Override
    public T getById(Integer id) throws DaoException {
        return null;
    }

    @Override
    public T getByName(String str) throws DaoException, ClassNotFoundException {
        return null;
    }

    @Override
    public List<T> getAll() throws DaoException, ClassNotFoundException {
        return null;
    }
}