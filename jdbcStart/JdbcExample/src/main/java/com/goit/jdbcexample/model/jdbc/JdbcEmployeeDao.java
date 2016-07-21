package com.goit.jdbcexample.model.jdbc;

import com.goit.jdbcexample.model.Employee;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class JdbcEmployeeDao implements EmployeeDao {

    private static final Logger LOGGER = LoggerFactory.getLogger(JdbcEmployeeDao.class);
    private static final String URL = "jdbc:postgresql://localhost:5432/company";
    private static final String USER = "user";
    private static final String PASSWORD = "12345";

    public JdbcEmployeeDao() {
        loadDriver();
    }

    @Override
    public Employee load(int id) {
        try (Connection connection = DriverManager.getConnection(URL, USER, PASSWORD);
             PreparedStatement statement =
                     connection.prepareStatement("SELECT * FROM EMPLOYEE WHERE ID = ?")){

            statement.setInt(1, id);

            ResultSet resultSet = statement.executeQuery();
            if (resultSet.next()) {
                return createEmployee(resultSet);
            } else {
                throw new RuntimeException("Cannot find Employee with id " + id);
            }
        } catch (SQLException e) {
            LOGGER.error("Exception occurred while connection to DB: " + URL, e);
            throw new RuntimeException(e);
        }
    }

    @Override
    public List<Employee> getAllEmployee() {
        List<Employee> resultList = new ArrayList<>();

        try (Connection connection = DriverManager.getConnection(URL, USER, PASSWORD);
             Statement statement = connection.createStatement()){

            String sql = "SELECT * FROM EMPLOYEE";
            ResultSet resultSet = statement.executeQuery(sql);

            while (resultSet.next()) {
                Employee employee = createEmployee(resultSet);
                resultList.add(employee);
            }
        } catch (SQLException e) {
            LOGGER.error("Exception occurred while connection to DB: " + URL, e);
            throw new RuntimeException(e);
        }

        return resultList;
    }

    private void loadDriver() {
        try {
            LOGGER.info("Loading JDBC driver: org.postgresql.Driver");
            Class.forName("org.postgresql.Driver");
            LOGGER.info("Driver successfully loaded");
        } catch (ClassNotFoundException e) {
            LOGGER.error("Cannot find driver: org.postgresql.Driver");
            throw new RuntimeException(e);
        }
    }

    private Employee createEmployee(ResultSet resultSet) throws SQLException {
        Employee employee = new Employee();
        employee.setId(resultSet.getInt("ID"));
        employee.setName(resultSet.getString("NAME"));
        employee.setAge(resultSet.getInt("AGE"));
        employee.setAddress(resultSet.getString("ADDRESS"));
        employee.setSalary(resultSet.getFloat("SALARY"));
        employee.setJoinDate(resultSet.getString("JOIN_DATE"));
        return employee;
    }

}
