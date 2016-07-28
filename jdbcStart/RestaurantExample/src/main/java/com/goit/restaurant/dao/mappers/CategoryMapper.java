package com.goit.restaurant.dao.mappers;

import com.goit.restaurant.model.Category;
import org.springframework.jdbc.core.RowMapper;

import java.sql.ResultSet;
import java.sql.SQLException;

public class CategoryMapper implements RowMapper<Category>{
    @Override
    public Category mapRow(ResultSet resultSet, int i) throws SQLException {
        return new Category(resultSet.getInt("ID"), resultSet.getString("CATEGORY_TITLE"));
    }
}
