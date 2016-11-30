package net.javajoy.jss.w_12_3.dao;

import org.hibernate.Session;

/**
 * @author Cyril Kadomsky
 */
public class HibernateDAOFactory implements AbstractDAOFactory {

    Session session;

    public HibernateDAOFactory(Session session) {
        this.session = session;
    }

    @Override
    public AbstractEmployeeDAO getEmployeeDAO() {
        return new HibernateEmployeeDAO(session);
    }



}
