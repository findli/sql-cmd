package com.becomejavasenior.service.impl;

import com.becomejavasenior.DAO.*;
import com.becomejavasenior.DAO.Imp.AddressDAOImpl;
import com.becomejavasenior.DAO.Imp.CompanyDAOImpl;
import com.becomejavasenior.DAO.Imp.TaskDAOImpl;
import com.becomejavasenior.DAO.Imp.UserDAOImpl;
import com.becomejavasenior.bean.Address;
import com.becomejavasenior.bean.Company;
import com.becomejavasenior.bean.Task;
import com.becomejavasenior.service.CompanyService;
import org.apache.log4j.Logger;

import java.util.List;

public class CompanyServiceImpl implements CompanyService {

    public static Logger log = Logger.getLogger(CompanyServiceImpl.class);

    private final CompanyDAO companyDao = new CompanyDAOImpl();
    private final AddressDAO addressDao = new AddressDAOImpl();
    private final UserDAO userDao = new UserDAOImpl();
    private final TaskDAO taskDao = new TaskDAOImpl();

    private CompanyDAO<Company> companyDAO = new CompanyDAOImpl();

    @Override
    public Company create(Company company) throws DaoException {
        return companyDAO.create(company);
    }

    @Override
    public void delete(int id) throws DaoException {
        companyDAO.delete(id);
    }

    @Override
    public void createNewCompany(Company company, Address address, Task task) {

        address = addressWithId(address);
        company.setAddress(address);


    }

    @Override
    public List<Company> getAll() throws DaoException, ClassNotFoundException {
        log.trace("getAll() in CompanyServiceImpl");
        return companyDAO.getAll();
    }

    @Override
    public Company getById(int id) throws DaoException {
        return companyDAO.getById(id);
    }

    @Override
    public void update(Company company) throws DaoException {
        companyDAO.update(company);
    }

    public Address addressWithId(Address address) {
        List<Address> addresses = addressDao.getAll();
        return address;
    }
}
