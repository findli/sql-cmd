package com.becomejavasenior.DAO.Imp;

import com.becomejavasenior.DAO.AbstractDAO;
import com.becomejavasenior.bean.Company;

import java.sql.PreparedStatement;
import java.sql.ResultSet;

public class CompanyDaoJdbcImpl extends AbstractDAOImpl<Company> implements AbstractDAO<Company> {

    public static Logger log = Logger.getLogger(CompanyDaoJdbcImpl.class.getName());

    public void createStatement(PreparedStatement statement, Company entity) {

    }

    public void updateStatement(PreparedStatement statement, Company entity) {

    }

    public Company getEntity(ResultSet resultSet) {

        return null;
    }

    public String getCreateQuery() {
        return "INSERT INTO company (title, phone_number, email, website, address_id, responsible_user_id, is_deleted) VALUES (?, ?, ?, ?, ?, ?, ?)";
    }

    public String getUpdateQuery() {
        return "UPDATE company SET title = ?, phone_number = ?, email = ?, website = ?, address_id = ?, responsible_user_id = ?, is_deleted = ?";
    }

    public String getDeleteQuery() {
        return "DELETE FROM company WHERE id = ?";
    }

    public String getByIdQuery() {
        return "SELECT * FROM company WHERE id = ?";
    }

    public String getAllQuery() {
        return "SELECT * FROM company";
    }
}