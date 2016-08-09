package com.goit.restaurant.dao.jdbc;

import com.goit.restaurant.dao.jdbc.mappers.MenuMapper;
import com.goit.restaurant.dao.MenuDao;
import com.goit.restaurant.model.Menu;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.transaction.annotation.Transactional;

import javax.sql.DataSource;
import java.util.List;

public class JdbcMenuDao implements MenuDao {
    private static final Logger LOGGER = LoggerFactory.getLogger(JdbcMenuDao.class);

    private DataSource dataSource;
    private JdbcTemplate jdbcTemplateObject;

    @Override
    @Transactional
    public void createMenu(Menu menu) {
        String sql = "INSERT INTO MENUS (MENU_TITLE) VALUES (?)";
        jdbcTemplateObject.update(sql, menu.getMenuTitle());
        LOGGER.info(String.format("Menu with MENU_TITLE %s is creating in DB", menu.getMenuTitle()));
    }

    @Override
    @Transactional
    public Menu findMenuById(int id) {
        String SQL = "SELECT * FROM MENUS WHERE ID = ?";
        return jdbcTemplateObject.queryForObject(SQL, new Object[]{id}, new MenuMapper());
    }

    @Override
    @Transactional
    public List<Menu> getAllMenu() {
        String SQL = "SELECT * FROM MENUS";
        return jdbcTemplateObject.query(SQL, new MenuMapper());
    }

    @Override
    @Transactional
    public void deleteMenu(int id) {
        String SQL = "DELETE FROM MENUS WHERE ID = ?";
        jdbcTemplateObject.update(SQL, id);
        LOGGER.info(String.format("Menu with %d is deleting from DB", id));
    }

    @Override
    @Transactional
    public void updateMenuTitle(int id, String newMenuTitle) {
        String SQL = "UPDATE MENUS SET MENU_TITLE = ? WHERE ID = ?";
        jdbcTemplateObject.update(SQL, newMenuTitle, id);
        LOGGER.info(String.format("Menu with %d is updating in DB", id));
    }

    public void setDataSource(DataSource dataSource) {
        this.dataSource = dataSource;
        this.jdbcTemplateObject = new JdbcTemplate(dataSource);
    }
}
