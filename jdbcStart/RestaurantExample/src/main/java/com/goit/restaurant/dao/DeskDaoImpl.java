package com.goit.restaurant.dao;

import com.goit.restaurant.model.Desk;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class DeskDaoImpl implements DeskDao{

    private static final Logger LOGGER = LoggerFactory.getLogger(DeskDaoImpl.class);

    public DeskDaoImpl() {
        DaoCommons.loadDriver();
    }

    @Override
    public Desk createDesk(String deskNumber) {
        try (Connection connection = DriverManager.getConnection(DaoCommons.URL, DaoCommons.USER, DaoCommons.PASSWORD);
             PreparedStatement statement =
                     connection.prepareStatement("INSERT INTO DESK (NUMBER ) VALUES (?) RETURNING ID, NUMBER ")){

            Desk resultDesk = new Desk();

            statement.setString(1, deskNumber);
            ResultSet resultSet = statement.executeQuery();

            if (resultSet.next()) {
                resultDesk.setId(resultSet.getInt(1));
                resultDesk.setNumber(resultSet.getString(2));
            }
            LOGGER.info(String.format("Desk with NUMBER %s is creating in DB", deskNumber));

            return resultDesk;
        } catch (SQLException e) {
            LOGGER.error("Exception occurred while connection to DB: " + DaoCommons.URL, e);
            throw new RuntimeException(e);
        }
    }

    @Override
    public Desk loadDesk(int id) {
        try (Connection connection = DriverManager.getConnection(DaoCommons.URL, DaoCommons.USER, DaoCommons.PASSWORD);
             PreparedStatement statement =
                     connection.prepareStatement("SELECT * FROM DESK WHERE ID = ?")){

            statement.setInt(1, id);

            ResultSet resultSet = statement.executeQuery();
            if (resultSet.next()) {
                return new Desk(resultSet.getInt("ID"), resultSet.getString("NUMBER"));
            } else {
                throw new RuntimeException("Cannot find Desk with ID " + id);
            }
        } catch (SQLException e) {
            LOGGER.error("Exception occurred while connection to DB: " + DaoCommons.URL, e);
            throw new RuntimeException(e);
        }
    }

    @Override
    public List<Desk> getAllDesk() {
        try (Connection connection = DriverManager.getConnection(DaoCommons.URL, DaoCommons.USER, DaoCommons.PASSWORD);
             Statement statement = connection.createStatement()){

            List<Desk> resultList = new ArrayList<>();

            String sql = "SELECT * FROM DESK";
            ResultSet resultSet = statement.executeQuery(sql);

            while (resultSet.next()) {
                resultList.add(new Desk(resultSet.getInt("ID"), resultSet.getString("NUMBER")));
            }

            return resultList;
        } catch (SQLException e) {
            LOGGER.error("Exception occurred while connection to DB: " + DaoCommons.URL, e);
            throw new RuntimeException(e);
        }
    }

    @Override
    public void deleteDesk(int id) {
        try (Connection connection = DriverManager.getConnection(DaoCommons.URL, DaoCommons.USER, DaoCommons.PASSWORD);
             PreparedStatement statement = connection.prepareStatement("DELETE FROM DESK WHERE ID = ?")){

            statement.setInt(1, id);
            statement.execute();

            LOGGER.info(String.format("Desk with ID %d is deleting from DB", id));
        } catch (SQLException e) {
            LOGGER.error("Exception occurred while connection to DB: " + DaoCommons.URL, e);
            throw new RuntimeException(e);
        }
    }

    @Override
    public void updateDesk(int id, String newDeskNumber) {
        try (Connection connection = DriverManager.getConnection(DaoCommons.URL, DaoCommons.USER, DaoCommons.PASSWORD);
             PreparedStatement statement = connection.prepareStatement("UPDATE DESK SET NUMBER=? WHERE ID = ?")){

            statement.setString(1, newDeskNumber);
            statement.setInt(2, id);
            statement.execute();

            LOGGER.info(String.format("Desk with ID %d is updating from DB", id));
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

            String sql = "SELECT * FROM DESK";
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
