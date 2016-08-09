package com.goit.restaurant.dao.jdbc.mappers;

import com.goit.restaurant.model.Employee;
import org.springframework.jdbc.core.RowMapper;

import java.sql.ResultSet;
import java.sql.SQLException;

public class EmployeeMapper implements RowMapper<Employee>{
    @Override
    public Employee mapRow(ResultSet resultSet, int i) throws SQLException {
        Employee employee = new Employee();
        employee.setId(resultSet.getInt("ID"));
        employee.setLastName(resultSet.getString("LAST_NAME"));
        employee.setFirstName(resultSet.getString("FIRST_NAME"));
        employee.setBirthday(resultSet.getDate("BIRTHDAY"));
        employee.setPhone(resultSet.getString("PHONE"));
        employee.setPositionId(resultSet.getInt("POSITION_ID"));
        employee.setSalary(resultSet.getFloat("SALARY"));
        return employee;
    }
}
