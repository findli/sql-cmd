package com.becomejavasenior.DAO;

import java.sql.SQLException;

/**
 * Created by Artem on 16.11.2016.
 */
public class DAOException extends Exception {
    public static Logger log = Logger.getLogger(DAOException.class);

    public DAOException() {

        super();

    }

    public DAOException(String errorMsg) {

        super(errorMsg);
        log.error(errorMsg);

    }

    public DAOException(String errorMsg, SQLException exception) {

        super(errorMsg);
        log.error(errorMsg, exception);

    }
}
