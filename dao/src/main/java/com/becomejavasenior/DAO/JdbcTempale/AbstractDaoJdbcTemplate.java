package com.becomejavasenior.DAO.JdbcTempale;

import com.becomejavasenior.DAO.AbstractDao;
import com.becomejavasenior.DAO.DaoException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public abstract class AbstractDaoJdbcTemplate<T> implements AbstractDao<T> {

//    static final String ERROR_PARSE_RESULT_SET = "error while parsing result set for ";
//    static final String ERROR_PREPARING_INSERT = "error while preparing INSERT statement for ";
//    static final String ERROR_PREPARING_UPDATE = "error while preparing UPDATE statement for ";
//    static final String ERROR_ID_MUST_BE_FROM_DBMS = "id must be obtained from DB, cannot create record in ";
//    static final String ERROR_GIVEN_ID = ", given id value is: ";
//    static final String ERROR_SELECT_ALL = "error while reading all records";
//    static final String ERROR_SELECT_1 = "error while reading record by key";
//
//    static final String FIELD_ID = "id";
//    static final String FIELD_NAME = "name";

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
