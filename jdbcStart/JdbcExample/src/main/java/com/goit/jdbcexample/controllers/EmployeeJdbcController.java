package com.goit.jdbcexample.controllers;

import com.goit.jdbcexample.model.Employee;
import com.goit.jdbcexample.model.jdbc.EmployeeDao;
import org.springframework.transaction.PlatformTransactionManager;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import java.util.Date;
import java.util.List;

public class EmployeeJdbcController {
    private PlatformTransactionManager txManager;
    private EmployeeDao employeeDao;

    public void setTxManager(PlatformTransactionManager txManager) {
        this.txManager = txManager;
    }

    public void setEmployeeDao(EmployeeDao employeeDao) {
        this.employeeDao = employeeDao;
    }

    @Transactional
    public List<Employee> getAllEmployee() {
        return employeeDao.getAllEmployee();
    }

    @Transactional
    public Employee load(int id) {
        return employeeDao.load(id);
    }

    @Transactional
    public void createEmployee() {
        Employee employee = new Employee();
        employee.setId(16);
        employee.setName("Name test");
        employee.setAge(24);
        employee.setAddress("Kiev3");
        employee.setSalary(26000.F);
        employee.setJoinDate(new Date());

        employeeDao.createEmployee(employee);
    }
}
