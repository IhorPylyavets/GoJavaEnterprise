package com.goit.restaurant.dao;

import com.goit.restaurant.model.Employee;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import javax.sql.DataSource;
import java.sql.*;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.List;

public class EmployeeDaoImpl implements EmployeeDao{

    private static final Logger LOGGER = LoggerFactory.getLogger(EmployeeDaoImpl.class);
    private DataSource dataSource;

    @Override
    @Transactional(propagation = Propagation.MANDATORY)
    public Employee createEmployee(String lastName, String firstName, String birthday, String phone, int positionId, float salary) {
        try (Connection connection = dataSource.getConnection();
             PreparedStatement statement =
                     connection.prepareStatement("INSERT INTO EMPLOYEES (LAST_NAME, FIRST_NAME, BIRTHDAY, PHONE, POSITION_ID, SALARY) " +
                             "VALUES (?,?,?,?,?,?) RETURNING ID, LAST_NAME, FIRST_NAME, BIRTHDAY, PHONE, POSITION_ID, SALARY")){

            statement.setString(1, lastName);
            statement.setString(2, firstName);
            statement.setDate(3, stringToDate(birthday));
            statement.setString(4, phone);
            statement.setInt(5, positionId);
            statement.setFloat(6, salary);

            ResultSet resultSet = statement.executeQuery();
            Employee resultEmployee = null;

            if (resultSet.next()) {
                resultEmployee = createEmployeeFromResultSet(resultSet);
            }
            LOGGER.info(String.format("Employee is creating in DB"));

            return resultEmployee;
        } catch (SQLException e) {
            LOGGER.error("Exception occurred while connection to DB: ", e);
            throw new RuntimeException(e);
        }
    }

    @Override
    @Transactional(propagation = Propagation.MANDATORY)
    public Employee loadEmployeeById(int id) {
        try (Connection connection = dataSource.getConnection();
             PreparedStatement statement = connection.prepareStatement("SELECT * FROM EMPLOYEES WHERE ID = ?")){

            statement.setInt(1, id);

            ResultSet resultSet = statement.executeQuery();
            if (resultSet.next()) {
                return createEmployeeFromResultSet(resultSet);
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
    public List<Employee> getAllEmployees() {
        try (Connection connection = dataSource.getConnection();
             Statement statement = connection.createStatement()){

            String sql = "SELECT * FROM EMPLOYEES";
            ResultSet resultSet = statement.executeQuery(sql);
            List<Employee> resultList = new ArrayList<>();

            while (resultSet.next()) {
                Employee employee = createEmployeeFromResultSet(resultSet);
                resultList.add(employee);
            }

            return resultList;
        } catch (SQLException e) {
            LOGGER.error("Exception occurred while connection to DB: ", e);
            throw new RuntimeException(e);
        }
    }

    @Override
    @Transactional(propagation = Propagation.MANDATORY)
    public void deleteEmployee(int id) {
        try (Connection connection = dataSource.getConnection();
             PreparedStatement statement = connection.prepareStatement("DELETE FROM EMPLOYEES WHERE ID = ?")){

            statement.setInt(1, id);
            statement.execute();

            LOGGER.info(String.format("Employee with ID %d is deleting from DB", id));
        } catch (SQLException e) {
            LOGGER.error("Exception occurred while connection to DB: ", e);
            throw new RuntimeException(e);
        }
    }

    @Override
    @Transactional(propagation = Propagation.MANDATORY)
    public String readEmployeeMetadata() {
        try (Connection connection = dataSource.getConnection();
             Statement statement = connection.createStatement()){

            StringBuilder sb = new StringBuilder();

            String sql = "SELECT * FROM EMPLOYEES";
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

    private Employee createEmployeeFromResultSet(ResultSet resultSet) throws SQLException {
        Employee employee = new Employee();
        employee.setId(resultSet.getInt("ID"));
        employee.setLastName(resultSet.getString("LAST_NAME"));
        employee.setFirstName(resultSet.getString("FIRST_NAME"));
        employee.setBirthday(resultSet.getString("BIRTHDAY"));
        employee.setPhone(resultSet.getString("PHONE"));
        employee.setPositionId(resultSet.getInt("POSITION_ID"));
        employee.setSalary(resultSet.getFloat("SALARY"));
        return employee;
    }

    private Date stringToDate(String birthday) {
        SimpleDateFormat sdf1 = new SimpleDateFormat("MM-dd-yyyy");
        java.util.Date date = null;
        try {
            date = sdf1.parse(birthday);
        } catch (ParseException e) {
            throw new IllegalArgumentException("Wrong birthday format");
        }
        return new Date(date.getTime());
    }
}
