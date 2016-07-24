package com.goit.restaurant.dao;

import com.goit.restaurant.model.Stock;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class StockDaoImpl implements StockDao{

    private static final Logger LOGGER = LoggerFactory.getLogger(StockDaoImpl.class);

    public StockDaoImpl() {
        DaoCommons.loadDriver();
    }

    @Override
    public Stock create(int ingredientId, int amount) {
        try (Connection connection = DriverManager.getConnection(DaoCommons.URL, DaoCommons.USER, DaoCommons.PASSWORD);
             PreparedStatement statement =
                     connection.prepareStatement("INSERT INTO STOCK (INGREDIENT_ID, AMOUNT) " +
                             "VALUES (?,?) RETURNING ID, INGREDIENT_ID, AMOUNT")){

            statement.setInt(1, ingredientId);
            statement.setInt(2, amount);
            ResultSet resultSet = statement.executeQuery();

            Stock resultStock = null;

            if (resultSet.next()) {
                resultStock = createStockFromResultSet(resultSet);
            }
            LOGGER.info(String.format("Stock is creating in DB"));

            return resultStock;
        } catch (SQLException e) {
            LOGGER.error("Exception occurred while connection to DB: " + DaoCommons.URL, e);
            throw new RuntimeException(e);
        }
    }

    @Override
    public Stock load(int id) {
        try (Connection connection = DriverManager.getConnection(DaoCommons.URL, DaoCommons.USER, DaoCommons.PASSWORD);
             PreparedStatement statement = connection.prepareStatement("SELECT * FROM STOCK WHERE ID = ?")){

            statement.setInt(1, id);

            ResultSet resultSet = statement.executeQuery();
            if (resultSet.next()) {
                return createStockFromResultSet(resultSet);
            } else {
                throw new RuntimeException("Cannot find Stock with id " + id);
            }
        } catch (SQLException e) {
            LOGGER.error("Exception occurred while connection to DB: " + DaoCommons.URL, e);
            throw new RuntimeException(e);
        }
    }

    @Override
    public List<Stock> getAll() {
        try (Connection connection = DriverManager.getConnection(DaoCommons.URL, DaoCommons.USER, DaoCommons.PASSWORD);
             Statement statement = connection.createStatement()){

            String sql = "SELECT * FROM STOCK";
            ResultSet resultSet = statement.executeQuery(sql);
            List<Stock> resultList = new ArrayList<>();

            while (resultSet.next()) {
                Stock stock = createStockFromResultSet(resultSet);
                resultList.add(stock);
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
             PreparedStatement statement = connection.prepareStatement("DELETE FROM STOCK WHERE ID = ?")){

            statement.setInt(1, id);
            statement.execute();

            LOGGER.info(String.format("Stock with ID %d is deleting from DB", id));
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

            String sql = "SELECT * FROM STOCK";
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

    private Stock createStockFromResultSet(ResultSet resultSet) throws SQLException {
        Stock stock = new Stock();
        stock.setId(resultSet.getInt("ID"));
        stock.setIngredientId(resultSet.getInt("INGREDIENT_ID"));
        stock.setAmount(resultSet.getInt("AMOUNT"));
        return stock;
    }
}
