package JSS.w_12_3.dao;

import org.hibernate.Session;

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
