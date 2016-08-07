package com.goit.restaurant.dao.mappers;

import com.goit.restaurant.model.Warehouse;
import org.springframework.jdbc.core.RowMapper;

import java.sql.ResultSet;
import java.sql.SQLException;

public class WarehouseMapper implements RowMapper<Warehouse>{
    @Override
    public Warehouse mapRow(ResultSet resultSet, int i) throws SQLException {
        return new Warehouse(resultSet.getInt("ID"), resultSet.getInt("INGREDIENT_ID"), resultSet.getFloat("AMOUNT"));
    }
}
