package com.goit.service;

import com.goit.dao.EmployeeDao;
import com.goit.model.Employee;
import com.goit.model.Position;
import org.springframework.transaction.annotation.Transactional;

import java.sql.Date;
import java.util.List;

public class EmployeeService{

    private EmployeeDao employeeDao;

    @Transactional
    public void createEmployee(Employee employee) {
        employeeDao.createEmployee(employee);
    }

    @Transactional
    public List<Employee> findEmployeeByName(String lastName) {
        return employeeDao.findEmployeeByName(lastName);
    }

    @Transactional
    public Employee findEmployeeById(int id) {
        return employeeDao.findEmployeeById(id);
    }

    @Transactional
    public Employee findEmployeeByFullName(String lastName, String firstName) {
        return employeeDao.findEmployeeByFullName(lastName, firstName);
    }

    @Transactional
    public List<Employee> getAllEmployee() {
        return employeeDao.getAllEmployees();
    }

    @Transactional
    public List<Employee> getAllEmployeesByPosition(Position position) {
        return employeeDao.getAllEmployeesByPosition(position);
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
    public void updateEmployeePositionId(int id, Position newPosition) {
        employeeDao.updateEmployeePositionId(id, newPosition);
    }

    @Transactional
    public void updateEmployeeSalary(int id, float newEmployeeSalary) {
        employeeDao.updateEmployeeSalary(id, newEmployeeSalary);
    }

    public void setEmployeeDao(EmployeeDao employeeDao) {
        this.employeeDao = employeeDao;
    }
}
