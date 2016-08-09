package com.goit.restaurant.dao.jdbc.mappers;

import com.goit.restaurant.model.Category;
import org.springframework.jdbc.core.RowMapper;

import java.sql.ResultSet;
import java.sql.SQLException;

public class CategoryMapper implements RowMapper<Category>{
    @Override
    public Category mapRow(ResultSet resultSet, int i) throws SQLException {
        Category category = new Category();
        category.setId(resultSet.getInt("ID"));
        category.setCategoryTitle(resultSet.getString("CATEGORY_TITLE"));
        return category;
    }
}
