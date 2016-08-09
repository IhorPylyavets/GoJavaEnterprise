package com.goit.restaurant.dao.jdbc.mappers;

import com.goit.restaurant.model.Warehouse;
import org.springframework.jdbc.core.RowMapper;

import java.sql.ResultSet;
import java.sql.SQLException;

public class WarehouseMapper implements RowMapper<Warehouse>{
    @Override
    public Warehouse mapRow(ResultSet resultSet, int i) throws SQLException {
        Warehouse warehouse = new Warehouse();
        warehouse.setId(resultSet.getInt("ID"));
        warehouse.setIngredientId(resultSet.getInt("INGREDIENT_ID"));
        warehouse.setAmount(resultSet.getFloat("AMOUNT"));
        return warehouse;
    }
}
