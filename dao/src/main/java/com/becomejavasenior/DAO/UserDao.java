package com.becomejavasenior.DAO;

import java.sql.SQLException;

public interface UserDao<User> extends AbstractDao<User> {
    boolean checkAuthorisation(String email, String password) throws SQLException;

    User getByEmail(String email) throws SQLException;
}
