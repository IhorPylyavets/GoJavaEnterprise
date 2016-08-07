package com.example.controllers;

import com.example.model.Employee;
import com.example.dao.EmployeeDao;
import com.example.model.Position;
import org.springframework.transaction.annotation.Transactional;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class EmployeeController {

    private EmployeeDao employeeDao;

    @Transactional
    public void createEmployee() {
        Set<Employee> allEmployees = new HashSet<>(employeeDao.findAllEmployee());

        Employee employee = new Employee();
        employee.setId(1L);
        employee.setName("Victor");
        employee.setSurname("Bevz");
        employee.setPosition(Position.WAITER);
        employee.setPhoneNumber("111-22-33");
        employee.setSalary(25000.0F);

        if (!allEmployees.contains(employee)) {
            employeeDao.save(employee);
        }
    }

    @Transactional
    public List<Employee> getAllEmployees() {
        return employeeDao.findAllEmployee();
    }

    @Transactional
    public Employee getEmployeeByName(String name) {
        return employeeDao.findByName(name);
    }

    public void setEmployeeDao(EmployeeDao employeeDao) {
        this.employeeDao = employeeDao;
    }
}
