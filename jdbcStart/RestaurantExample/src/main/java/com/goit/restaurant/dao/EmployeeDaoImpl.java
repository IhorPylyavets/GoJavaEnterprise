package com.goit.restaurant.dao;

import com.goit.restaurant.model.Employee;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.transaction.annotation.Transactional;

import javax.sql.DataSource;

import java.util.List;

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
    private JdbcTemplate jdbcTemplateObject;

    @Override
    @Transactional
    public void createEmployee(String lastName, String firstName, String birthday,
                               String phone, int positionId, float salary) {

        String sql = "INSERT INTO EMPLOYEES (LAST_NAME, FIRST_NAME, BIRTHDAY, PHONE, POSITION_ID, SALARY)" +
                " VALUES (?,?,?,?,?,?)";
        jdbcTemplateObject.update(sql, lastName, firstName, stringToDate(birthday), phone, positionId, salary);
        LOGGER.info(String.format("Employee with parameters {%s, %s, %s, %s, %s, %s,} creating in DB"
                , lastName, firstName, birthday, phone, positionId, salary));
    }
    // employeeController.createEmployee("lastName", "firstName", "01-03-1972", "phone", 5, 29000.0F);

    @Override
    @Transactional
    public Employee loadEmployeeById(int id) {
        String SQL = "SELECT * FROM EMPLOYEES WHERE ID = ?";
        return jdbcTemplateObject.queryForObject(SQL, new Object[]{id}, new EmployeeMapper());
    }

    @Override
    @Transactional
    public List<Employee> getAllEmployees() {
        String SQL = "SELECT * FROM EMPLOYEES";
        return jdbcTemplateObject.query(SQL, new EmployeeMapper());
    }

    @Override
    @Transactional
    public void deleteEmployee(int id) {
        String SQL = "DELETE FROM EMPLOYEES WHERE ID = ?";
        jdbcTemplateObject.update(SQL, id);
        LOGGER.info(String.format("Employee with %d is deleting from DB", id));
    }

    @Override
    @Transactional
    public void updateEmployeeLastName(int id, String newEmployeeLastName) {
        String SQL = "UPDATE EMPLOYEES SET LAST_NAME = ? WHERE ID = ?";
        jdbcTemplateObject.update(SQL, newEmployeeLastName, id);
        LOGGER.info(String.format("Employee with %d is updating LAST_NAME to '%s' in DB", id, newEmployeeLastName));
    }

    @Override
    @Transactional
    public void updateEmployeeFirstName(int id, String newEmployeeFirstName) {
        String SQL = "UPDATE EMPLOYEES SET FIRST_NAME = ? WHERE ID = ?";
        jdbcTemplateObject.update(SQL, newEmployeeFirstName, id);
        LOGGER.info(String.format("Employee with %d is updating FIRST_NAME to '%s' in DB", id, newEmployeeFirstName));
    }

    @Override
    @Transactional
    public void updateEmployeeBirthday(int id, String newEmployeeBirthday) {
        String SQL = "UPDATE EMPLOYEES SET BIRTHDAY = ? WHERE ID = ?";
        jdbcTemplateObject.update(SQL, stringToDate(newEmployeeBirthday), id);
        LOGGER.info(String.format("Employee with %d is updating BIRTHDAY to '%s' in DB", id, newEmployeeBirthday));
    }

    @Override
    @Transactional
    public void updateEmployeePhone(int id, String newEmployeePhone) {
        String SQL = "UPDATE EMPLOYEES SET PHONE = ? WHERE ID = ?";
        jdbcTemplateObject.update(SQL, newEmployeePhone, id);
        LOGGER.info(String.format("Employee with %d is updating PHONE to '%s' in DB", id, newEmployeePhone));
    }

    @Override
    @Transactional
    public void updateEmployeePositionId(int id, int newPositionId) {
        String SQL = "UPDATE EMPLOYEES SET POSITION_ID = ? WHERE ID = ?";
        jdbcTemplateObject.update(SQL, newPositionId, id);
        LOGGER.info(String.format("Employee with %d is updating POSITION_ID to '%d' in DB", id, newPositionId));
    }

    @Override
    @Transactional
    public void updateEmployeeSalary(int id, float newEmployeeSalary) {
        String SQL = "UPDATE EMPLOYEES SET SALARY = ? WHERE ID = ?";
        jdbcTemplateObject.update(SQL, Float.valueOf(newEmployeeSalary), id);
        LOGGER.info(String.format("Employee with %d is updating SALARY to '%f' in DB", id, newEmployeeSalary));
    }

    public void setDataSource(DataSource dataSource) {
        this.dataSource = dataSource;
        this.jdbcTemplateObject = new JdbcTemplate(dataSource);
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
