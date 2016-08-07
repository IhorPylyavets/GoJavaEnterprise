package com.example.dao;

import com.example.model.Employee;

import java.util.List;

public interface EmployeeDao {
    void save(Employee employee);
    Employee getEmployeeById();
    List<Employee> findAllEmployee();
    Employee findByName(String name);
    void remove(Employee employee);
}
