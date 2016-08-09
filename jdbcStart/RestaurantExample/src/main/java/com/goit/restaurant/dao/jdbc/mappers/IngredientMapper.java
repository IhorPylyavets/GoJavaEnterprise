package com.goit.restaurant.dao.jdbc.mappers;

import com.goit.restaurant.model.Ingredient;
import org.springframework.jdbc.core.RowMapper;

import java.sql.ResultSet;
import java.sql.SQLException;

public class IngredientMapper implements RowMapper<Ingredient>{
    @Override
    public Ingredient mapRow(ResultSet resultSet, int i) throws SQLException {
        Ingredient ingredient = new Ingredient();
        ingredient.setId(resultSet.getInt("ID"));
        ingredient.setIngredientTitle(resultSet.getString("INGREDIENT_TITLE"));
        return ingredient;
    }
}
