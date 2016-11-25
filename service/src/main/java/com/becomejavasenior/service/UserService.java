package com.becomejavasenior.service;

import com.becomejavasenior.DAO.DAOException;
import com.becomejavasenior.bean.User;

import java.util.List;

public interface UserService {
    User create(User t) throws DAOException;
    void update(User t) throws DAOException;
    List<User> getAll() throws DAOException, ClassNotFoundException;
    User getById(int id) throws DAOException;
    void delete(int id) throws DAOException;

}
