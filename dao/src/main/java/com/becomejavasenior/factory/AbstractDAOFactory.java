package com.becomejavasenior.factory;

import com.becomejavasenior.DAO.*;

public abstract class AbstractDAOFactory {

    public static final int POSTGRESQL = 1;

    public abstract CompanyDAO getCompanyDAO();
    public abstract ContactDAO getContactDAO();
    public abstract DealDAO getDealDAO();
    public abstract TaskDAO getTaskDAO();
    public abstract UserDAO getUserDAO();
    public abstract StageDAO getStageDAO();
    public abstract AddressDAO getAddressDAO();
    public abstract PeriodInDaysTypeDAO getPeriodInDaysTypeDAO();
    public abstract TaskTypeDAO getTaskTypeDAO();


    public static AbstractDAOFactory getDAOFactory(int factory) {
        switch (factory) {
            case POSTGRESQL:
                return new PostgresDAOFactory();
            default:
                return null;
        }
    }
}
