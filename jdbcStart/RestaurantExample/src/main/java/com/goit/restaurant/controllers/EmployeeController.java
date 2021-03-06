package com.goit.restaurant.controllers;

import com.goit.restaurant.dao.EmployeeDao;
import com.goit.restaurant.model.Employee;
import org.springframework.transaction.PlatformTransactionManager;
import org.springframework.transaction.annotation.Transactional;

import java.sql.Date;
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

    @Transactional
    public void createEmployee(Employee employee) {
        employeeDao.createEmployee(employee);
    }

    @Transactional
    public Employee findEmployeeById(int id) {
        return employeeDao.findEmployeeById(id);
    }

    @Transactional
    public List<Employee> getAllEmployee() {
        return employeeDao.getAllEmployees();
    }

    @Transactional
    public void deleteEmployee(int id) {
        employeeDao.deleteEmployee(id);
    }

    @Transactional
    public void updateEmployeeLastName(int id, String newEmployeeLastName) {
        employeeDao.updateEmployeeLastName(id, newEmployeeLastName);
    }

    @Transactional
    public void updateEmployeeFirstName(int id, String newEmployeeFirstName) {
        employeeDao.updateEmployeeFirstName(id, newEmployeeFirstName);
    }

    @Transactional
    public void updateEmployeeBirthday(int id, Date newEmployeeBirthday) {
        employeeDao.updateEmployeeBirthday(id, newEmployeeBirthday);
    }

    @Transactional
    public void updateEmployeePhone(int id, String newEmployeePhone) {
        employeeDao.updateEmployeePhone(id, newEmployeePhone);
    }

    @Transactional
    public void updateEmployeePositionId(int id, int newPositionId) {
        employeeDao.updateEmployeePositionId(id, newPositionId);
    }

    @Transactional
    public void updateEmployeeSalary(int id, float newEmployeeSalary) {
        employeeDao.updateEmployeeSalary(id, newEmployeeSalary);
    }

    /*@Transactional
    public String readEmployeeMetadata() {
        return employeeDao.readEmployeeMetadata();
    }*/
}
