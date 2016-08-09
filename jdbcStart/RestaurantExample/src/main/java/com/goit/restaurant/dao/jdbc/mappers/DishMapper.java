package com.goit.restaurant.dao.jdbc.mappers;

import com.goit.restaurant.model.Dish;
import org.springframework.jdbc.core.RowMapper;

import java.sql.ResultSet;
import java.sql.SQLException;

public class DishMapper implements RowMapper<Dish> {
    @Override
    public Dish mapRow(ResultSet resultSet, int i) throws SQLException {
        return new Dish(
                resultSet.getInt("ID"),
                resultSet.getString("DISHE_TITLE"),
                resultSet.getInt("CATEGORY_ID"),
                resultSet.getFloat("PRICE"),
                resultSet.getFloat("WEIGHT"));
    }
}
