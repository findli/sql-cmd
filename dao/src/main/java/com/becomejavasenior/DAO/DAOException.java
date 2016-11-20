package com.becomejavasenior.DAO;

/*import org.apache.log4j.Logger;*/

import java.sql.SQLException;


public class DAOException extends Exception {
    public DAOException(String s, SQLException e) {
    }
/*

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

    }*/


}

