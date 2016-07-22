package com.goit.restaurant.dao;

import com.goit.restaurant.model.Position;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class PositionDaoImpl implements PositionDao {

    private static final Logger LOGGER = LoggerFactory.getLogger(PositionDaoImpl.class);

    public PositionDaoImpl() {
        DaoCommons.loadDriver();
    }

    public Position createPosition(String positionTitle) {
        Position resultPosition = new Position();
        try (Connection connection = DriverManager.getConnection(DaoCommons.URL, DaoCommons.USER, DaoCommons.PASSWORD);
             PreparedStatement statement =
                     connection.prepareStatement("INSERT INTO POSITION (TITLE) VALUES (?) RETURNING ID, TITLE")){

            statement.setString(1, positionTitle);
            ResultSet resultSet = statement.executeQuery();

            if (resultSet.next()) {
                resultPosition.setId(resultSet.getInt(1));
                resultPosition.setTitle(resultSet.getString(2));
            }
            LOGGER.info(String.format("Position with TITLE %s is creating in DB", positionTitle));
        } catch (SQLException e) {
            LOGGER.error("Exception occurred while connection to DB: " + DaoCommons.URL, e);
            throw new RuntimeException(e);
        }
        return resultPosition;
    }

    public Position loadPosition(int id) {
        try (Connection connection = DriverManager.getConnection(DaoCommons.URL, DaoCommons.USER, DaoCommons.PASSWORD);
             PreparedStatement statement =
                     connection.prepareStatement("SELECT * FROM POSITION WHERE ID = ?")){

            statement.setInt(1, id);

            ResultSet resultSet = statement.executeQuery();
            if (resultSet.next()) {
                return new Position(resultSet.getInt("ID"), resultSet.getString("TITLE"));
            } else {
                throw new RuntimeException("Cannot find Position with ID " + id);
            }
        } catch (SQLException e) {
            LOGGER.error("Exception occurred while connection to DB: " + DaoCommons.URL, e);
            throw new RuntimeException(e);
        }
    }

    public List<Position> getAllPosition() {
        List<Position> resultList = new ArrayList<>();

        try (Connection connection = DriverManager.getConnection(DaoCommons.URL, DaoCommons.USER, DaoCommons.PASSWORD);
             Statement statement = connection.createStatement()){

            String sql = "SELECT * FROM POSITION";
            ResultSet resultSet = statement.executeQuery(sql);

            while (resultSet.next()) {
                resultList.add(new Position(resultSet.getInt("ID"), resultSet.getString("TITLE")));
            }
        } catch (SQLException e) {
            LOGGER.error("Exception occurred while connection to DB: " + DaoCommons.URL, e);
            throw new RuntimeException(e);
        }

        return resultList;
    }

    public void deletePosition(int id) {
        try (Connection connection = DriverManager.getConnection(DaoCommons.URL, DaoCommons.USER, DaoCommons.PASSWORD);
             PreparedStatement statement = connection.prepareStatement("DELETE FROM POSITION WHERE ID = ?")){

            statement.setInt(1, id);
            statement.execute();

            LOGGER.info(String.format("Position with ID %d is deleting from DB", id));
        } catch (SQLException e) {
            LOGGER.error("Exception occurred while connection to DB: " + DaoCommons.URL, e);
            throw new RuntimeException(e);
        }
    }

    public void updatePosition(int id, String newPositionTitle) {
        try (Connection connection = DriverManager.getConnection(DaoCommons.URL, DaoCommons.USER, DaoCommons.PASSWORD);
             PreparedStatement statement = connection.prepareStatement("UPDATE POSITION SET TITLE=? WHERE ID = ?")){

            statement.setString(1, newPositionTitle);
            statement.setInt(2, id);
            statement.execute();

            LOGGER.info(String.format("Position with ID %d is updating from DB", id));
        } catch (SQLException e) {
            LOGGER.error("Exception occurred while connection to DB: " + DaoCommons.URL, e);
            throw new RuntimeException(e);
        }
    }

    @Override
    public String readMetadata() {
        StringBuilder sb = new StringBuilder();

        try (Connection connection = DriverManager.getConnection(DaoCommons.URL, DaoCommons.USER, DaoCommons.PASSWORD);
             Statement statement = connection.createStatement()){

            String sql = "SELECT * FROM POSITION";
            ResultSet resultSet = statement.executeQuery(sql);
            ResultSetMetaData metaData = resultSet.getMetaData();

            int n = metaData.getColumnCount();
            for (int i = 1; i<n+1; i++) {
                sb.append(metaData.getColumnClassName(i));
                sb.append("====" + metaData.getColumnName(i) + "\n");
            }

        } catch (SQLException e) {
            LOGGER.error("Exception occurred while connection to DB: " + DaoCommons.URL, e);
            throw new RuntimeException(e);
        }

        return sb.toString();
    }

}
