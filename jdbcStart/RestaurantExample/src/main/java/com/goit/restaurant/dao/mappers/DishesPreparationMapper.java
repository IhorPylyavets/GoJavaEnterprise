package com.goit.restaurant.dao.mappers;

import com.goit.restaurant.model.DishesPreparation;
import org.springframework.jdbc.core.RowMapper;

import java.sql.ResultSet;
import java.sql.SQLException;

public class DishesPreparationMapper implements RowMapper<DishesPreparation>{
    @Override
    public DishesPreparation mapRow(ResultSet resultSet, int i) throws SQLException {
        return new DishesPreparation(resultSet.getInt("ID"), resultSet.getInt("DISHES_ID"),
                resultSet.getInt("EMPLOYEE_ID"), resultSet.getInt("ORDER_ID"),
                resultSet.getString("DATE_PREPARATIONS"));
    }
}
