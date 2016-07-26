package com.goit.restaurant.controllers;

import com.goit.restaurant.dao.EmployeeDao;
import com.goit.restaurant.model.Employee;
import org.springframework.transaction.PlatformTransactionManager;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

public class EmployeeController {
    private PlatformTransactionManager txManager;
    private EmployeeDao employeeDao;

    public void setTxManager(PlatformTransactionManager txManager) {
        this.txManager = txManager;
    }

    public void setEmployeeDao(EmployeeDao employeeDao) {
        this.employeeDao = employeeDao;
    }

    @Transactional(propagation = Propagation.REQUIRED)
    public Employee createEmployee(String lastName, String firstName, String birthday, String phone, int positionId, float salary) {
        return employeeDao.createEmployee(lastName, firstName, birthday, phone, positionId, salary);
    }

    @Transactional(propagation = Propagation.REQUIRED)
    public Employee loadEmployeeById(int id) {
        return employeeDao.loadEmployeeById(id);
    }

    @Transactional(propagation = Propagation.REQUIRED)
    public List<Employee> getAllEmployee() {
        return employeeDao.getAllEmployees();
    }

    @Transactional(propagation = Propagation.REQUIRED)
    public void deleteEmployee(int id) {
        employeeDao.deleteEmployee(id);
    }

    @Transactional(propagation = Propagation.REQUIRED)
    public String readEmployeeMetadata() {
        return employeeDao.readEmployeeMetadata();
    }
}
