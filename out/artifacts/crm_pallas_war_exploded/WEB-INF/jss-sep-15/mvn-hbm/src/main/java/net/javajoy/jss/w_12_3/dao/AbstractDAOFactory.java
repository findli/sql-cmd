package net.javajoy.jss.w_12_3.dao;

/**
 * @author Cyril Kadomsky
 */
public interface AbstractDAOFactory {

    AbstractEmployeeDAO getEmployeeDAO();

    // AbstractPositionDAO getPositionDAO();
}
