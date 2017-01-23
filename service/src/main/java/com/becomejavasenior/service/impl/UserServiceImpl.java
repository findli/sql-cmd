package com.becomejavasenior.service.impl;

import com.becomejavasenior.DAO.DaoException;
import com.becomejavasenior.DAO.UserDao;
import com.becomejavasenior.bean.User;
import com.becomejavasenior.service.UserService;
import org.springframework.stereotype.Service;

import java.sql.SQLException;
import java.util.List;

@Service(value = "userService")
public class UserServiceImpl implements UserService {

    private final UserDao<User> userDao;

    public UserServiceImpl(UserDao<User> userDao) {
        this.userDao = userDao;
    }

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

    @Override
    public User getByName(String str) throws DaoException, ClassNotFoundException {
        return userDao.getByName(str);
    }

    @Override
    public boolean checkAuthorisation(String email, String password) throws SQLException {
        return userDao.checkAuthorisation(email, password);
    }

    @Override
    public User getByEmail(String email) throws SQLException {
        return userDao.getByEmail(email);
    }
}