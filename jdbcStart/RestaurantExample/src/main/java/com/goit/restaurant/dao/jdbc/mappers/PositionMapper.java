package com.goit.restaurant.dao.jdbc.mappers;

import com.goit.restaurant.model.Position;
import org.springframework.jdbc.core.RowMapper;

import java.sql.ResultSet;
import java.sql.SQLException;

public class PositionMapper implements RowMapper<Position>{
    @Override
    public Position mapRow(ResultSet resultSet, int i) throws SQLException {
        Position position = new Position();
        position.setId(resultSet.getInt("ID"));
        position.setPositionTitle(resultSet.getString("POSITION_TITLE"));
        return position;
    }
}
