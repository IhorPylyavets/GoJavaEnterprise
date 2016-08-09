package com.goit.restaurant.dao.jdbc.mappers;

import com.goit.restaurant.model.Order;
import org.springframework.jdbc.core.RowMapper;

import java.sql.ResultSet;
import java.sql.SQLException;

public class OrderMapper implements RowMapper<Order>{
    @Override
    public Order mapRow(ResultSet resultSet, int i) throws SQLException {
        return new Order(
                resultSet.getInt("ID"),
                resultSet.getInt("EMPLOYEE_ID"),
                resultSet.getInt("DESK_ID"),
                resultSet.getTimestamp("ORDER_DATE"));
    }
}
