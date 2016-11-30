package com.becomejavasenior.DAO;

/*import org.apache.log4j.Logger;*/

import java.sql.SQLException;


public class DaoException extends Exception {
    public DaoException(String s, SQLException e) {
    }
/*

    public static Logger log = Logger.getLogger(DaoException.class);

    public DaoException() {

        super();

    }

    public DaoException(String errorMsg) {

        super(errorMsg);
        log.error(errorMsg);

    }

    public DaoException(String errorMsg, SQLException exception) {

        super(errorMsg);
        log.error(errorMsg, exception);

    }*/


}

