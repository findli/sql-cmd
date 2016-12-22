package com.becomejavasenior.DAO.mapper;

import com.becomejavasenior.bean.Stage;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Component;

import java.sql.ResultSet;
import java.sql.SQLException;

@Component
public class StageRowMapper implements RowMapper<Stage> {
    private static final String FIELD_ID = "id";
    private static final String FIELD_TITLE = "title";
    private static final String FIELD_COLOR = "color";
    private static final String FIELD_PRIORITY = "priority";
    private static final String FIELD_IS_DELETED = "is_deletable";

    @Override
    public Stage mapRow(ResultSet resultSet, int i) throws SQLException {
        Stage stage = new Stage();
        stage.setId(resultSet.getInt(FIELD_ID));
        stage.setTitle(resultSet.getString(FIELD_TITLE));
        stage.setColor(resultSet.getString(FIELD_COLOR));
        stage.setPriority(resultSet.getByte(FIELD_PRIORITY));
        stage.setDeletable(resultSet.getBoolean(FIELD_IS_DELETED));

        return stage;
    }
}