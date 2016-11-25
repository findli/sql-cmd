package com.becomejavasenior.service.impl;

import com.becomejavasenior.DAO.DAOException;
import com.becomejavasenior.DAO.Imp.UserDAOImpl;
import com.becomejavasenior.DAO.UserDAO;
import com.becomejavasenior.bean.User;

import java.util.List;

public class UserServiceImpl implements UserService {

    private UserDAO<User> userDao = new UserDAOImpl();

    @Override
    public User create(User user) throws DAOException {
        return userDao.create(user);
    }

    @Override
    public void delete(int id) throws DAOException {
        userDao.delete(id);
    }

    @Override
    public List<User> getAll() throws DAOException, ClassNotFoundException {
        return userDao.getAll();
    }

    @Override
    public User getById(int id) throws DAOException {
        return userDao.getById(id);
    }

    @Override
    public void update(User user) throws DAOException {
        userDao.update(user);
    }
}
