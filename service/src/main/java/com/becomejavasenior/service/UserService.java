package com.becomejavasenior.service;

import com.becomejavasenior.DAO.DaoException;
import com.becomejavasenior.bean.User;

import java.sql.SQLException;
import java.util.List;

public interface UserService {
    User create(User t) throws DaoException;
    void update(User t) throws DaoException;
    List<User> getAll() throws DaoException, ClassNotFoundException;
    User getById(int id) throws DaoException;
    void delete(int id) throws DaoException;

    User getByName(String str) throws DaoException, ClassNotFoundException;

    boolean checkAuthorisation(String email, String password) throws SQLException;

    Object getByEmail(String email) throws SQLException;
}