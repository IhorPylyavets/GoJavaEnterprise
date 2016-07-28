package com.goit.restaurant.dao;

import com.goit.restaurant.model.Menu;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import javax.sql.DataSource;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class MenuDaoImpl implements MenuDao{

    private DataSource dataSource;
    private static final Logger LOGGER = LoggerFactory.getLogger(MenuDaoImpl.class);

    @Override
    @Transactional(propagation = Propagation.MANDATORY)
    public Menu createMenu(String menuTitle) {
        try (Connection connection = dataSource.getConnection();
             PreparedStatement statement =
                     connection.prepareStatement("INSERT INTO MENUS (MENU_TITLE) VALUES (?) RETURNING ID, MENU_TITLE")){

            Menu resultMenu = new Menu();

            statement.setString(1, menuTitle);
            ResultSet resultSet = statement.executeQuery();

            if (resultSet.next()) {
                resultMenu.setId(resultSet.getInt(1));
                resultMenu.setMenuTitle(resultSet.getString(2));
            }
            LOGGER.info(String.format("Menu with MENU_TITLE %s is creating in DB", menuTitle));

            return resultMenu;
        } catch (SQLException e) {
            LOGGER.error("Exception occurred while connection to DB: ", e);
            throw new RuntimeException(e);
        }
    }

    @Override
    @Transactional(propagation = Propagation.MANDATORY)
    public Menu loadMenuById(int id) {
        try (Connection connection = dataSource.getConnection();
             PreparedStatement statement =
                     connection.prepareStatement("SELECT * FROM MENUS WHERE ID = ?")){

            statement.setInt(1, id);
            ResultSet resultSet = statement.executeQuery();
            if (resultSet.next()) {
                return new Menu(resultSet.getInt("ID"), resultSet.getString("MENU_TITLE"));
            } else {
                throw new RuntimeException("Cannot find Menu with id " + id);
            }
        } catch (SQLException e) {
            LOGGER.error("Exception occurred while connection to DB: ", e);
            throw new RuntimeException(e);
        }
    }

    @Override
    @Transactional(propagation = Propagation.MANDATORY)
    public List<Menu> getAllMenu() {
        try (Connection connection = dataSource.getConnection();
             Statement statement = connection.createStatement()){

            List<Menu> resultList = new ArrayList<>();

            String sql = "SELECT * FROM MENUS";
            ResultSet resultSet = statement.executeQuery(sql);

            while (resultSet.next()) {
                resultList.add(new Menu(resultSet.getInt("ID"), resultSet.getString("MENU_TITLE")));
            }

            return resultList;
        } catch (SQLException e) {
            LOGGER.error("Exception occurred while connection to DB: ", e);
            throw new RuntimeException(e);
        }
    }

    @Override
    @Transactional(propagation = Propagation.MANDATORY)
    public void deleteMenu(int id) {
        try (Connection connection = dataSource.getConnection();
             PreparedStatement statement = connection.prepareStatement("DELETE FROM MENUS WHERE ID = ?")){

            statement.setInt(1, id);
            statement.execute();

            LOGGER.info(String.format("Menu with ID %d is deleting from DB", id));
        } catch (SQLException e) {
            LOGGER.error("Exception occurred while connection to DB: ", e);
            throw new RuntimeException(e);
        }
    }

    @Override
    @Transactional(propagation = Propagation.MANDATORY)
    public void updateMenu(int id, String newMenuTitle) {
        try (Connection connection = dataSource.getConnection();
             PreparedStatement statement = connection.prepareStatement("UPDATE MENUS SET MENU_TITLE=? WHERE ID = ?")){

            statement.setString(1, newMenuTitle);
            statement.setInt(2, id);
            statement.execute();

            LOGGER.info(String.format("Menu with ID %d is updating from DB", id));
        } catch (SQLException e) {
            LOGGER.error("Exception occurred while connection to DB: ", e);
            throw new RuntimeException(e);
        }
    }

    @Override
    @Transactional(propagation = Propagation.MANDATORY)
    public String readMenuMetadata() {
        try (Connection connection = dataSource.getConnection();
             Statement statement = connection.createStatement()){

            StringBuilder sb = new StringBuilder();

            String sql = "SELECT * FROM MENUS";
            ResultSet resultSet = statement.executeQuery(sql);
            ResultSetMetaData metaData = resultSet.getMetaData();

            int n = metaData.getColumnCount();
            for (int i = 1; i<n+1; i++) {
                sb.append(metaData.getColumnClassName(i));
                sb.append("====" + metaData.getColumnName(i) + "\n");
            }

            return sb.toString();
        } catch (SQLException e) {
            LOGGER.error("Exception occurred while connection to DB: ", e);
            throw new RuntimeException(e);
        }
    }

    public void setDataSource(DataSource dataSource) {
        this.dataSource = dataSource;
    }
}
