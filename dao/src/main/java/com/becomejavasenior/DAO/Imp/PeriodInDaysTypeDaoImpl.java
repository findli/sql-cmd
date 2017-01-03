package com.becomejavasenior.DAO.Imp;

import com.becomejavasenior.DAO.DaoException;
import com.becomejavasenior.DAO.JdbcTempale.AbstractDaoJdbcTemplate;
import com.becomejavasenior.DAO.PeriodInDaysTypeDao;
import com.becomejavasenior.DAO.mapper.PeriodInDaysTypeRowMapper;
import com.becomejavasenior.bean.PeriodInDaysType;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.PreparedStatementCreator;
import org.springframework.jdbc.core.PreparedStatementSetter;
import org.springframework.jdbc.support.GeneratedKeyHolder;
import org.springframework.jdbc.support.KeyHolder;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Repository;

import javax.sql.DataSource;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

@Repository("periodInDaysTypeDao")
public class PeriodInDaysTypeDaoImpl extends AbstractDaoJdbcTemplate<PeriodInDaysType> implements PeriodInDaysTypeDao<PeriodInDaysType> {

    @Autowired
    private PeriodInDaysTypeRowMapper PERIOD_IN_DAYS_TYPE_ROW_MAPPER;

    private static final String INSERT_SQL = "INSERT INTO crm_pallas.period_in_days_type (title, daysInPeriod) VALUES(?, ?)";

    private static final String UPDATE_SQL = "UPDATE crm_pallas.period_in_days_type SET title = ?, daysInPeriod = ? WHERE id = ?";

    private static final String SELECT_ALL_SQL = "SELECT * FROM crm_pallas.period_in_days_type";

    private static final String SELECT_BY_NAME = "SELECT * FROM crm_pallas.period_in_days_type WHERE title = ?";

    @Override
    public void delete(Integer id) throws DaoException {
        delete(id, "period_in_days_type");
    }

    @Override
    public PeriodInDaysType create(PeriodInDaysType periodInDaysType) {
        if (periodInDaysType.getId() != 0) {
            throw new com.becomejavasenior.DAO.DatabaseException("periodInDaysType id must be obtained from DB");
        }
        PreparedStatementCreator preparedStatementCreator = connection -> {
            PreparedStatement preparedStatement = connection.prepareStatement(INSERT_SQL, new String[]{"id"});
            preparedStatement.setString(1, periodInDaysType.getTitle());
            preparedStatement.setInt(2, periodInDaysType.getDaysInPeriod());
            return preparedStatement;
        };
        KeyHolder keyHolder = new GeneratedKeyHolder();
        jdbcTemplate.update(preparedStatementCreator, keyHolder);
        int id=(int) keyHolder.getKey();
        periodInDaysType.setId(id);
        return periodInDaysType;
    }

    @Override
    public PeriodInDaysType update(PeriodInDaysType periodInDaysType){
        if (periodInDaysType.getId() == 0) {
            throw new com.becomejavasenior.DAO.DatabaseException("taskType must be created before update");
        }
        PreparedStatementSetter preparedStatementSetter = preparedStatement -> {
            preparedStatement.setString(1, periodInDaysType.getTitle());
            preparedStatement.setInt(2, periodInDaysType.getDaysInPeriod());
        };
        jdbcTemplate.update(UPDATE_SQL, preparedStatementSetter);
        return periodInDaysType;
    }

    @Override
    public List<PeriodInDaysType> getAll()throws DaoException, ClassNotFoundException{
        return jdbcTemplate.query(SELECT_ALL_SQL, PERIOD_IN_DAYS_TYPE_ROW_MAPPER);
    }

    @Override
    public PeriodInDaysType getById(Integer id){
        PeriodInDaysType periodInDaysType = jdbcTemplate.queryForObject(SELECT_ALL_SQL + " WHERE id = ?", PERIOD_IN_DAYS_TYPE_ROW_MAPPER, id);
        return periodInDaysType;
    }

    @Override
    public PeriodInDaysType getByName(String name){
        PeriodInDaysType periodInDaysType = jdbcTemplate.queryForObject(SELECT_BY_NAME, PERIOD_IN_DAYS_TYPE_ROW_MAPPER, name);
        return periodInDaysType;
    }

}
