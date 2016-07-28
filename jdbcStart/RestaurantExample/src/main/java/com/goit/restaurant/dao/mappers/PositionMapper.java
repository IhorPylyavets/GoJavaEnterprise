package com.goit.restaurant.dao.mappers;

import com.goit.restaurant.model.Position;
import org.springframework.jdbc.core.RowMapper;

import java.sql.ResultSet;
import java.sql.SQLException;

public class PositionMapper implements RowMapper<Position>{
    @Override
    public Position mapRow(ResultSet resultSet, int i) throws SQLException {
        return new Position(resultSet.getInt("ID"), resultSet.getString("POSITION_TITLE"));
    }
}
