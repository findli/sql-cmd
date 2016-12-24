package com.becomejavasenior.DAO.Imp;

import com.becomejavasenior.DAO.DaoException;
import com.becomejavasenior.DAO.PhoneTypeDao;
import com.becomejavasenior.DataBaseUtil;
import com.becomejavasenior.bean.PhoneType;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import javax.sql.DataSource;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

@Repository("phoneTypeDao")
public class PhoneTypeDaoImpl extends AbstractDaoImpl<PhoneType> implements PhoneTypeDao<PhoneType> {

    @Autowired
    public PhoneTypeDaoImpl(DataSource dataSource) {
        super(dataSource);
    }

    @Override
    public PhoneType getByName(String str) throws DaoException, ClassNotFoundException {
        return null;
    }


    @Override
    void createStatement(PreparedStatement statement, PhoneType entity) throws DaoException {

        try {

            statement.setString(1, entity.getTitle());

        } catch (SQLException e) {

            throw new DaoException("Can't create statement for PhoneType", e);

        }
    }

    @Override
    void updateStatement(PreparedStatement statement, PhoneType entity) throws DaoException {

        try {

            statement.setString(1, entity.getTitle());

        } catch (SQLException e) {

            throw new DaoException("Can't update statement for PhoneType", e);

        }
    }

    @Override
    PhoneType getEntity(ResultSet resultSet) throws DaoException {

        PhoneType phoneType = new PhoneType();

        try {

            phoneType.setId(resultSet.getInt("id"));
            phoneType.setTitle(resultSet.getString("title"));

        } catch (SQLException e) {
            throw new DaoException("", e);
        }

        return phoneType;
    }

    @Override
    String getCreateQuery() {
        return null;
    }

    @Override
    String getUpdateQuery() {
        return null;
    }

    @Override
    String getDeleteQuery() {
        return null;
    }

    @Override
    String getByIdQuery() {
        return DataBaseUtil.getQuery("SELECT * FROM crm_pallas.phone_type WHERE id=?");
    }

    @Override
    String getAllQuery() {
        return DataBaseUtil.getQuery("SELECT * FROM crm_pallas.phone_type");
    }

    @Override
    public List<PhoneType> getByFilter(String query) {
        return null;
    }
}
