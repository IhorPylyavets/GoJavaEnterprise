package com.goit.restaurant.dao.mappers;

import com.goit.restaurant.model.Ingredient;
import org.springframework.jdbc.core.RowMapper;

import java.sql.ResultSet;
import java.sql.SQLException;

public class IngredientMapper implements RowMapper<Ingredient>{
    @Override
    public Ingredient mapRow(ResultSet resultSet, int i) throws SQLException {
        return new Ingredient(resultSet.getInt("ID"), resultSet.getString("INGREDIENT_TITLE"));
    }
}
