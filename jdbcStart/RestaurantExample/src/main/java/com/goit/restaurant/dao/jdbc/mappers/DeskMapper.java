package com.goit.restaurant.dao.jdbc.mappers;

import com.goit.restaurant.model.Desk;
import org.springframework.jdbc.core.RowMapper;

import java.sql.ResultSet;
import java.sql.SQLException;

public class DeskMapper implements RowMapper<Desk> {
    @Override
    public Desk mapRow(ResultSet resultSet, int i) throws SQLException {
        return new Desk(resultSet.getInt("ID"), resultSet.getString("DESK_TITLE"),
                Desk.DeskStatus.valueOf(resultSet.getString("STATUS_OF_DESK")));
    }
}
