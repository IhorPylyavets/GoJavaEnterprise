package com.goit.jdbcexample.model.jdbc;

import com.goit.jdbcexample.model.Employee;

import java.util.List;

public interface EmployeeDao {
    Employee load(int id);
    List<Employee> getAllEmployee();
}
