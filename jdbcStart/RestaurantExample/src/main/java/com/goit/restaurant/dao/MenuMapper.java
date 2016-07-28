package com.goit.restaurant.dao;

import com.goit.restaurant.model.Menu;
import org.springframework.jdbc.core.RowMapper;

import java.sql.ResultSet;
import java.sql.SQLException;

public class MenuMapper implements RowMapper<Menu> {
    @Override
    public Menu mapRow(ResultSet resultSet, int i) throws SQLException {
        return new Menu(resultSet.getInt("ID"), resultSet.getString("MENU_TITLE"));
    }
}
