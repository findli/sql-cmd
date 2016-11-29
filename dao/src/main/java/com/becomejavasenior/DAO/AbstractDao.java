package com.becomejavasenior.DAO;

import java.util.List;

public interface AbstractDao<T> {

    T create(T entity) throws DaoException;

    T update(T entity) throws DaoException;

    void delete(Integer id) throws DaoException;

    T getById(Integer id) throws DaoException;

    List<T> getAll() throws DaoException, ClassNotFoundException;
}