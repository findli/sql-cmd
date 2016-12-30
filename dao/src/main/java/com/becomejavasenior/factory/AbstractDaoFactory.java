package com.becomejavasenior.factory;

import com.becomejavasenior.DAO.*;

public abstract class AbstractDaoFactory {

    public static final int POSTGRESQL = 1;

    public abstract CompanyDao getCompanyDao();
//    public abstract ContactDao getContactDao();
//    public abstract DealDao getDealDao();
//    public abstract TaskDao getTaskDao();
    public abstract UserDao getUserDao();
    public abstract StageDao getStageDao();
    public abstract AddressDao getAddressDao();
//    public abstract PeriodInDaysTypeDao getPeriodInDaysTypeDao();
//    public abstract TaskTypeDao getTaskTypeDao();


    public static AbstractDaoFactory getDaoFactory(int factory) {
        switch (factory) {
            case POSTGRESQL:
                return new PostgresDaoFactory();
            default:
                return null;
        }
    }
}