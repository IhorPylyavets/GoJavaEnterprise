package com.goit.restaurant.dao;

import com.goit.restaurant.model.Warehouse;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class WarehouseDaoImpl implements WarehouseDao {

    private static final Logger LOGGER = LoggerFactory.getLogger(WarehouseDaoImpl.class);

    public WarehouseDaoImpl() {
        DaoCommons.loadDriver();
    }

    @Override
    public Warehouse create(int ingredientId, int amount) {
        try (Connection connection = DriverManager.getConnection(DaoCommons.URL, DaoCommons.USER, DaoCommons.PASSWORD);
             PreparedStatement statement =
                     connection.prepareStatement("INSERT INTO WAREHOUSE (INGREDIENT_ID, AMOUNT) " +
                             "VALUES (?,?) RETURNING ID, INGREDIENT_ID, AMOUNT")){

            statement.setInt(1, ingredientId);
            statement.setInt(2, amount);
            ResultSet resultSet = statement.executeQuery();

            Warehouse resultWarehouse = null;

            if (resultSet.next()) {
                resultWarehouse = createWarehouseFromResultSet(resultSet);
            }
            LOGGER.info(String.format("Warehouse is creating in DB"));

            return resultWarehouse;
        } catch (SQLException e) {
            LOGGER.error("Exception occurred while connection to DB: " + DaoCommons.URL, e);
            throw new RuntimeException(e);
        }
    }

    @Override
    public Warehouse load(int id) {
        try (Connection connection = DriverManager.getConnection(DaoCommons.URL, DaoCommons.USER, DaoCommons.PASSWORD);
             PreparedStatement statement = connection.prepareStatement("SELECT * FROM WAREHOUSE WHERE ID = ?")){

            statement.setInt(1, id);

            ResultSet resultSet = statement.executeQuery();
            if (resultSet.next()) {
                return createWarehouseFromResultSet(resultSet);
            } else {
                throw new RuntimeException("Cannot find Warehouse with id " + id);
            }
        } catch (SQLException e) {
            LOGGER.error("Exception occurred while connection to DB: " + DaoCommons.URL, e);
            throw new RuntimeException(e);
        }
    }

    @Override
    public List<Warehouse> getAll() {
        try (Connection connection = DriverManager.getConnection(DaoCommons.URL, DaoCommons.USER, DaoCommons.PASSWORD);
             Statement statement = connection.createStatement()){

            String sql = "SELECT * FROM WAREHOUSE";
            ResultSet resultSet = statement.executeQuery(sql);
            List<Warehouse> resultList = new ArrayList<>();

            while (resultSet.next()) {
                Warehouse warehouse = createWarehouseFromResultSet(resultSet);
                resultList.add(warehouse);
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
             PreparedStatement statement = connection.prepareStatement("DELETE FROM WAREHOUSE WHERE ID = ?")){

            statement.setInt(1, id);
            statement.execute();

            LOGGER.info(String.format("Warehouse with ID %d is deleting from DB", id));
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

            String sql = "SELECT * FROM WAREHOUSE";
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

    private Warehouse createWarehouseFromResultSet(ResultSet resultSet) throws SQLException {
        Warehouse warehouse = new Warehouse();
        warehouse.setId(resultSet.getInt("ID"));
        warehouse.setIngredientId(resultSet.getInt("INGREDIENT_ID"));
        warehouse.setAmount(resultSet.getInt("AMOUNT"));
        return warehouse;
    }
}
