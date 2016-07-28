package com.goit.jdbcexample.model.jdbc;

import com.goit.jdbcexample.model.Employee;
import org.springframework.jdbc.core.RowMapper;

import java.sql.ResultSet;
import java.sql.SQLException;

public class EmployeeMapper implements RowMapper<Employee>{
    @Override
    public Employee mapRow(ResultSet resultSet, int i) throws SQLException {
        return new Employee(resultSet.getInt("ID"), resultSet.getString("NAME"),
                resultSet.getInt("AGE"), resultSet.getString("ADDRESS"), resultSet.getFloat("SALARY"),
                resultSet.getDate("JOIN_DATE"));
    }
}
