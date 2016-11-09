package com.becomejavasenior.DAO;

import java.util.List;

public interface AbstractDAO<T> {

    T create(T entity) throws DAOException;

    T update(T entity) throws DAOException;

    void delete(Integer id) throws DAOException;

    T getById(Integer id) throws DAOException;

    List<T> getAll() throws DAOException;
}
