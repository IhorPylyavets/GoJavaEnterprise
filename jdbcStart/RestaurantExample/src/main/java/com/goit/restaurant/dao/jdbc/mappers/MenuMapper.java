package com.goit.restaurant.dao.jdbc.mappers;

import com.goit.restaurant.model.Menu;
import org.springframework.jdbc.core.RowMapper;

import java.sql.ResultSet;
import java.sql.SQLException;

public class MenuMapper implements RowMapper<Menu> {
    @Override
    public Menu mapRow(ResultSet resultSet, int i) throws SQLException {
        Menu menu = new Menu();
        menu.setId(resultSet.getInt("ID"));
        menu.setMenuTitle(resultSet.getString("MENU_TITLE"));
        return menu;
    }
}
