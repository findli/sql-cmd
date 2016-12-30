package com.becomejavasenior.DAO.mapper;


import com.becomejavasenior.bean.PeriodInDaysType;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Component;

import java.sql.ResultSet;
import java.sql.SQLException;

@Component
public class PeriodInDaysTypeRowMapper implements RowMapper<PeriodInDaysType> {

    private static final String FIELD_ID = "id";
    private static final String FIELD_TITLE = "title";
    private static final String FIELD_DAYS_IN_PERIOD = "days_in_period";

    @Override
    public PeriodInDaysType mapRow(ResultSet resultSet, int i) throws SQLException {
        PeriodInDaysType periodInDaysType = new PeriodInDaysType();

        periodInDaysType.setId(resultSet.getInt(FIELD_ID));
        periodInDaysType.setTitle(resultSet.getString(FIELD_TITLE));
        periodInDaysType.setDaysInPeriod(resultSet.getInt(FIELD_DAYS_IN_PERIOD));
        return periodInDaysType;
    }
}
