package com.goit.restaurant.dao;

import com.goit.restaurant.model.Desk;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import javax.sql.DataSource;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class DeskDaoImpl implements DeskDao{

    private static final Logger LOGGER = LoggerFactory.getLogger(EmployeeDaoImpl.class);
    private DataSource dataSource;

    @Override
    @Transactional(propagation = Propagation.MANDATORY)
    public Desk createDesk(String deskTitle) {
        try (Connection connection = dataSource.getConnection();
              PreparedStatement statement =
                      connection.prepareStatement("INSERT INTO DESKS (DESK_TITLE) " +
                              "VALUES (?) RETURNING ID, DESK_TITLE, STATUS_OF_DESK")){

            Desk resultDesk = new Desk();

            statement.setString(1, deskTitle);
            //statement.setString(2, Desk.DeskStatus.FREE.toString());
            ResultSet resultSet = statement.executeQuery();

            if (resultSet.next()) {
                resultDesk.setId(resultSet.getInt(1));
                resultDesk.setDeskTitle(resultSet.getString(2));
                resultDesk.setDeskStatus(Desk.DeskStatus.valueOf(resultSet.getString(3)));
            }
            LOGGER.info(String.format("Desk with NUMBER %s is creating in DB", deskTitle));

            return resultDesk;
        } catch (SQLException e) {
            LOGGER.error("Exception occurred while connection to DB: ", e);
            throw new RuntimeException(e);
        }
    }

    @Override
    @Transactional(propagation = Propagation.MANDATORY)
    public Desk loadDeskById(int id) {
        try (Connection connection = dataSource.getConnection();
             PreparedStatement statement =
                     connection.prepareStatement("SELECT * FROM DESKS WHERE ID = ?")){

            statement.setInt(1, id);

            ResultSet resultSet = statement.executeQuery();
            if (resultSet.next()) {
                return new Desk(resultSet.getInt("ID"), resultSet.getString("DESK_TITLE"),
                        Desk.DeskStatus.valueOf(resultSet.getString("STATUS_OF_DESK")));
            } else {
                throw new RuntimeException("Cannot find Desk with ID " + id);
            }
        } catch (SQLException e) {
            LOGGER.error("Exception occurred while connection to DB: ", e);
            throw new RuntimeException(e);
        }
    }

    @Override
    @Transactional(propagation = Propagation.MANDATORY)
    public List<Desk> getAllDesks() {
        try (Connection connection = dataSource.getConnection();
             Statement statement = connection.createStatement()){

            List<Desk> resultList = new ArrayList<>();

            String sql = "SELECT * FROM DESKS";
            ResultSet resultSet = statement.executeQuery(sql);

            while (resultSet.next()) {
                resultList.add(new Desk(resultSet.getInt("ID"), resultSet.getString("DESK_TITLE"),
                        Desk.DeskStatus.valueOf(resultSet.getString("STATUS_OF_DESK"))));
            }

            return resultList;
        } catch (SQLException e) {
            LOGGER.error("Exception occurred while connection to DB: ", e);
            throw new RuntimeException(e);
        }
    }

    @Override
    @Transactional(propagation = Propagation.MANDATORY)
    public void deleteDesk(int id) {
        try (Connection connection = dataSource.getConnection();
             PreparedStatement statement = connection.prepareStatement("DELETE FROM DESKS WHERE ID = ?")){

            statement.setInt(1, id);
            statement.execute();

            LOGGER.info(String.format("Desk with ID %d is deleting from DB", id));
        } catch (SQLException e) {
            LOGGER.error("Exception occurred while connection to DB: ", e);
            throw new RuntimeException(e);
        }
    }

    @Override
    @Transactional(propagation = Propagation.MANDATORY)
    public void updateDeskTitle(int id, String newDeskTitle) {
        try (Connection connection = dataSource.getConnection();
             PreparedStatement statement = connection.prepareStatement("UPDATE DESKS SET DESK_TITLE=? WHERE ID = ?")){

            statement.setString(1, newDeskTitle);
            statement.setInt(2, id);
            statement.execute();

            LOGGER.info(String.format("Desk with ID %d is updating from DB", id));
        } catch (SQLException e) {
            LOGGER.error("Exception occurred while connection to DB: ", e);
            throw new RuntimeException(e);
        }
    }

    /*@Override
    public void updateDeskStatus(int id, Desk.DeskStatus deskStatus) {
        try (Connection connection = dataSource.getConnection();
             PreparedStatement statement = connection.prepareStatement("UPDATE DESKS SET STATUS_OF_DESK=? WHERE ID = ?")){

            statement.setString(1, deskStatus.toString());
            statement.setInt(2, id);
            statement.execute();

            LOGGER.info(String.format("Desk with ID %d is updating from DB", id));
        } catch (SQLException e) {
            LOGGER.error("Exception occurred while connection to DB: ", e);
            throw new RuntimeException(e);
        }
    }*/

    @Override
    @Transactional(propagation = Propagation.MANDATORY)
    public String readDeskMetadata() {
        try (Connection connection = dataSource.getConnection();
             Statement statement = connection.createStatement()){

            StringBuilder sb = new StringBuilder();

            String sql = "SELECT * FROM DESKS";
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
