package com.goit.restaurant.dao;

import com.goit.restaurant.model.Ingredient;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class IngredientDaoImpl implements SimpleDao<Ingredient>{

    private static final Logger LOGGER = LoggerFactory.getLogger(IngredientDaoImpl.class);

    public IngredientDaoImpl() {
        DaoCommons.loadDriver();
    }

    @Override
    public Ingredient create(String title) {
        try (Connection connection = DriverManager.getConnection(DaoCommons.URL, DaoCommons.USER, DaoCommons.PASSWORD);
             PreparedStatement statement =
                     connection.prepareStatement("INSERT INTO INGREDIENT (TITLE) VALUES (?) RETURNING ID, TITLE ")){

            Ingredient resultDesk = new Ingredient();

            statement.setString(1, title);
            ResultSet resultSet = statement.executeQuery();

            if (resultSet.next()) {
                resultDesk.setId(resultSet.getInt(1));
                resultDesk.setTitle(resultSet.getString(2));
            }
            LOGGER.info(String.format("Ingredient with TITLE %s is creating in DB", title));

            return resultDesk;
        } catch (SQLException e) {
            LOGGER.error("Exception occurred while connection to DB: " + DaoCommons.URL, e);
            throw new RuntimeException(e);
        }
    }

    @Override
    public Ingredient load(int id) {
        try (Connection connection = DriverManager.getConnection(DaoCommons.URL, DaoCommons.USER, DaoCommons.PASSWORD);
             PreparedStatement statement =
                     connection.prepareStatement("SELECT * FROM INGREDIENT WHERE ID = ?")){

            statement.setInt(1, id);

            ResultSet resultSet = statement.executeQuery();
            if (resultSet.next()) {
                return new Ingredient(resultSet.getInt("ID"), resultSet.getString("TITLE"));
            } else {
                throw new RuntimeException("Cannot find Ingredient with ID " + id);
            }
        } catch (SQLException e) {
            LOGGER.error("Exception occurred while connection to DB: " + DaoCommons.URL, e);
            throw new RuntimeException(e);
        }
    }

    @Override
    public List<Ingredient> getAll() {
        try (Connection connection = DriverManager.getConnection(DaoCommons.URL, DaoCommons.USER, DaoCommons.PASSWORD);
             Statement statement = connection.createStatement()){

            List<Ingredient> resultList = new ArrayList<>();

            String sql = "SELECT * FROM INGREDIENT";
            ResultSet resultSet = statement.executeQuery(sql);

            while (resultSet.next()) {
                resultList.add(new Ingredient(resultSet.getInt("ID"), resultSet.getString("TITLE")));
            }

            return resultList;
        } catch (SQLException e) {
            LOGGER.error("Exception occurred while connection to DB: " + DaoCommons.URL, e);
            throw new RuntimeException(e);
        }
    }

    @Override
    public void delete(int id) {
        try (Connection connection = DriverManager.getConnection(DaoCommons.URL, DaoCommons.USER, DaoCommons.PASSWORD);
             PreparedStatement statement = connection.prepareStatement("DELETE FROM INGREDIENT WHERE ID = ?")){

            statement.setInt(1, id);
            statement.execute();

            LOGGER.info(String.format("Ingredient with ID %d is deleting from DB", id));
        } catch (SQLException e) {
            LOGGER.error("Exception occurred while connection to DB: " + DaoCommons.URL, e);
            throw new RuntimeException(e);
        }
    }

    @Override
    public void update(int id, String newTitle) {
        try (Connection connection = DriverManager.getConnection(DaoCommons.URL, DaoCommons.USER, DaoCommons.PASSWORD);
             PreparedStatement statement = connection.prepareStatement("UPDATE INGREDIENT SET TITLE=? WHERE ID = ?")){

            statement.setString(1, newTitle);
            statement.setInt(2, id);
            statement.execute();

            LOGGER.info(String.format("Ingredient with ID %d is updating from DB", id));
        } catch (SQLException e) {
            LOGGER.error("Exception occurred while connection to DB: " + DaoCommons.URL, e);
            throw new RuntimeException(e);
        }
    }

    @Override
    public String readMetadata() {
        try (Connection connection = DriverManager.getConnection(DaoCommons.URL, DaoCommons.USER, DaoCommons.PASSWORD);
             Statement statement = connection.createStatement()){

            StringBuilder sb = new StringBuilder();

            String sql = "SELECT * FROM INGREDIENT";
            ResultSet resultSet = statement.executeQuery(sql);
            ResultSetMetaData metaData = resultSet.getMetaData();

            int n = metaData.getColumnCount();
            for (int i = 1; i<n+1; i++) {
                sb.append(metaData.getColumnClassName(i));
                sb.append("====" + metaData.getColumnName(i) + "\n");
            }

            return sb.toString();
        } catch (SQLException e) {
            LOGGER.error("Exception occurred while connection to DB: " + DaoCommons.URL, e);
            throw new RuntimeException(e);
        }
    }
}
