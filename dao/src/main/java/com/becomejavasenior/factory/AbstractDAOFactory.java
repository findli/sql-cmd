package com.becomejavasenior.factory;

import com.becomejavasenior.DAO.*;

public abstract class AbstractDAOFactory {

    public static final int POSTGRESQL = 1;

    public abstract CompanyDao getCompanyDAO();
    public abstract ContactDao getContactDAO();
    public abstract DealDao getDealDAO();
    public abstract TaskDao getTaskDAO();
    public abstract UserDao getUserDAO();
    public abstract StageDao getStageDAO();
    public abstract AddressDao getAddressDAO();
    public abstract PeriodInDaysTypeDao getPeriodInDaysTypeDAO();
    public abstract TaskTypeDao getTaskTypeDAO();


    public static AbstractDAOFactory getDAOFactory(int factory) {
        switch (factory) {
            case POSTGRESQL:
                return new PostgresDAOFactory();
            default:
                return null;
        }
    }
}