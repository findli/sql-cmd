package com.becomejavasenior.DAO;

import java.sql.SQLException;

public interface UserDao<User> extends AbstractDao<User> {
    public boolean checkAuthorisation(String email, String password) throws SQLException;

    User getByEmail(String email) throws SQLException;
}
