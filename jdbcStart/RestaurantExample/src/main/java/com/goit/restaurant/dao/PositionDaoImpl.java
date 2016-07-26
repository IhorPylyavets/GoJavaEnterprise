package com.goit.restaurant.dao;

import com.goit.restaurant.model.Position;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import javax.sql.DataSource;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class PositionDaoImpl implements PositionDao{

    private DataSource dataSource;
    private static final Logger LOGGER = LoggerFactory.getLogger(PositionDaoImpl.class);

    @Override
    @Transactional(propagation = Propagation.MANDATORY)
    public Position createPosition(String positionTitle) {
        try (Connection connection = dataSource.getConnection();
             PreparedStatement statement =
                     connection.prepareStatement("INSERT INTO POSITIONS (POSITION_TITLE) VALUES (?) RETURNING ID, POSITION_TITLE")){

            Position resultPositions = new Position();

            statement.setString(1, positionTitle);
            ResultSet resultSet = statement.executeQuery();

            if (resultSet.next()) {
                resultPositions.setId(resultSet.getInt(1));
                resultPositions.setPositionTitle(resultSet.getString(2));
            }
            LOGGER.info(String.format("Position with TITLE %s is creating in DB", positionTitle));

            return resultPositions;
        } catch (SQLException e) {
            LOGGER.error("Exception occurred while connection to DB: ", e);
            throw new RuntimeException(e);
        }
    }

    @Override
    @Transactional(propagation = Propagation.MANDATORY)
    public Position loadPositionById(int id) {
        try (Connection connection = dataSource.getConnection();
             PreparedStatement statement =
                     connection.prepareStatement("SELECT * FROM POSITIONS WHERE ID = ?")){

            statement.setInt(1, id);
            ResultSet resultSet = statement.executeQuery();
            if (resultSet.next()) {
                return new Position(resultSet.getInt("ID"), resultSet.getString("POSITION_TITLE"));
            } else {
                throw new RuntimeException("Cannot find Employee with id " + id);
            }
        } catch (SQLException e) {
            LOGGER.error("Exception occurred while connection to DB: ", e);
            throw new RuntimeException(e);
        }
    }

    @Override
    @Transactional(propagation = Propagation.MANDATORY)
    public List<Position> getAllPosition() {
        try (Connection connection = dataSource.getConnection();
             Statement statement = connection.createStatement()){

            List<Position> resultList = new ArrayList<>();

            String sql = "SELECT * FROM POSITIONS";
            ResultSet resultSet = statement.executeQuery(sql);

            while (resultSet.next()) {
                resultList.add(new Position(resultSet.getInt("ID"), resultSet.getString("POSITION_TITLE")));
            }

            return resultList;
        } catch (SQLException e) {
            LOGGER.error("Exception occurred while connection to DB: ", e);
            throw new RuntimeException(e);
        }
    }

    @Override
    @Transactional(propagation = Propagation.MANDATORY)
    public void deletePosition(int id) {
        try (Connection connection = dataSource.getConnection();
             PreparedStatement statement = connection.prepareStatement("DELETE FROM POSITIONS WHERE ID = ?")){

            statement.setInt(1, id);
            statement.execute();

            LOGGER.info(String.format("Position with ID %d is deleting from DB", id));
        } catch (SQLException e) {
            LOGGER.error("Exception occurred while connection to DB: ", e);
            throw new RuntimeException(e);
        }
    }

    @Override
    @Transactional(propagation = Propagation.MANDATORY)
    public void updatePosition(int id, String newTitle) {
        try (Connection connection = dataSource.getConnection();
             PreparedStatement statement = connection.prepareStatement("UPDATE POSITIONS SET POSITION_TITLE=? WHERE ID = ?")){

            statement.setString(1, newTitle);
            statement.setInt(2, id);
            statement.execute();

            LOGGER.info(String.format("Position with ID %d is updating from DB", id));
        } catch (SQLException e) {
            LOGGER.error("Exception occurred while connection to DB: ", e);
            throw new RuntimeException(e);
        }
    }

    @Override
    @Transactional(propagation = Propagation.MANDATORY)
    public String readPositionMetadata() {
        try (Connection connection = dataSource.getConnection();
             Statement statement = connection.createStatement()){

            StringBuilder sb = new StringBuilder();

            String sql = "SELECT * FROM POSITIONS";
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
