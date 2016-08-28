package com.example.controllers;

import com.example.dao.EmployeeDao;
import com.example.model.Employee;
import com.example.model.Position;
import com.example.model.Waiter;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

public class EmployeeController {

    private EmployeeDao employeeDao;

    @Transactional
    public void initEmployee() {
        Waiter john = new Waiter();
        john.setName("John");
        john.setSurname("Smith");
        john.setPhoneNumber("111-111-111");
        john.setPosition(Position.WAITER);
        john.setSalary(25000.0F);
        employeeDao.save(john);

        Waiter mary = new Waiter();
        mary.setName("Mary");
        mary.setSurname("Qwerty");
        mary.setPhoneNumber("222-333-666");
        mary.setPosition(Position.WAITER);
        mary.setSalary(24000.0F);
        employeeDao.save(mary);
    }

    @Transactional
    public List<Employee> getAllEmployees() {
        return employeeDao.findAllEmployee();
    }

    @Transactional
    public Employee getEmployeeByName(String name) {
        return employeeDao.findByName(name);
    }

    @Transactional
    public void removeAllEmployee() {
        employeeDao.removeAll();
    }

    @Transactional
    public void printEmployeesToConsole(Long id) {
        System.out.println(employeeDao.getEmployeeById(id));
        System.out.println(employeeDao.getEmployeeById(id));
    }

    public void setEmployeeDao(EmployeeDao employeeDao) {
        this.employeeDao = employeeDao;
    }
}
