package com.becomejavasenior.service.impl;

import com.becomejavasenior.DAO.DaoException;
import com.becomejavasenior.DAO.Imp.UserDAOImpl;
import com.becomejavasenior.DAO.UserDAO;
import com.becomejavasenior.bean.User;
import com.becomejavasenior.service.UserService;

import java.util.List;

public class UserServiceImpl implements UserService {

    private UserDAO<User> userDao = new UserDAOImpl();

    @Override
    public User create(User user) throws DaoException {
        return userDao.create(user);
    }

    @Override
    public void delete(int id) throws DaoException {
        userDao.delete(id);
    }

    @Override
    public List<User> getAll() throws DaoException, ClassNotFoundException {
        return userDao.getAll();
    }

    @Override
    public User getById(int id) throws DaoException {
        return userDao.getById(id);
    }

    @Override
    public void update(User user) throws DaoException {
        userDao.update(user);
    }
}
