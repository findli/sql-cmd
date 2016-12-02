package com.becomejavasenior.service.impl;

import com.becomejavasenior.DAO.*;
import com.becomejavasenior.DAO.Imp.AddressDaoImpl;
import com.becomejavasenior.DAO.Imp.CompanyDaoImpl;
import com.becomejavasenior.DAO.Imp.TaskDaoImpl;
import com.becomejavasenior.DAO.Imp.UserDaoImpl;
import com.becomejavasenior.bean.Address;
import com.becomejavasenior.bean.Company;
import com.becomejavasenior.bean.Task;
import com.becomejavasenior.service.CompanyService;
import org.apache.log4j.Logger;

import java.util.List;

public class CompanyServiceImpl implements CompanyService {

    public static Logger log = Logger.getLogger(CompanyServiceImpl.class);

    private final CompanyDao companyDao = new CompanyDaoImpl();
    private final AddressDao addressDao = new AddressDaoImpl();
    private final UserDao userDao = new UserDaoImpl();
    private final TaskDao taskDao = new TaskDaoImpl();

    @Override
    public Company create(Company company) throws DaoException {
        return (Company) companyDao.create(company);
    }

    @Override
    public void delete(int id) throws DaoException {
        companyDao.delete(id);
    }

    @Override
    public List<Company> getAll() throws DaoException, ClassNotFoundException {
        log.trace("getAll() in CompanyServiceImpl");
        return (List<Company>) companyDao.getAll();
    }

    @Override
    public Company getById(int id) throws DaoException {
        return (Company) companyDao.getById(id);
    }

    @Override
    public Company update(Company company) throws DaoException {
        return (Company) companyDao.update(company);
    }

    @Override
    public Company getByName(String str) {
        try {
            return (Company)companyDao.getByName(str);
        } catch (ClassNotFoundException e) {

        } catch (DaoException e) {

        }
        return null;
    }


    public Address addressWithId(Address address) {

        try {
            List<Address> addresses = addressDao.getAll();
        } catch (ClassNotFoundException e){

        }catch (DaoException e){

        }
        return address;
    }
}
