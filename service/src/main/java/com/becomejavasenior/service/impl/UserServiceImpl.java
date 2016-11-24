package com.becomejavasenior.service.impl;

import com.becomejavasenior.DAO.DaoException;
import com.becomejavasenior.DAO.Imp.UserDaoImpl;
import com.becomejavasenior.DAO.UserDao;
import com.becomejavasenior.bean.User;
import com.becomejavasenior.service.userService;

import java.util.List;

public class UserServiceImpl implements userService {

    private UserDao<User> userDao = new UserDaoImpl();

    @Override
    public User create(User user) throws DaoException {
        return userDao.create(user);
    }

    @Override
    public void delete(int id) throws DaoException {
        userDao.delete(id);
    }

    @Override
    public User getByName(String str) throws DaoException, ClassNotFoundException {
        return userDao.getByName(str);
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