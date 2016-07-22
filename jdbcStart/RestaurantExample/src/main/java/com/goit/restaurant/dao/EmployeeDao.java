package com.goit.restaurant.dao;

import com.goit.restaurant.model.Employee;

import java.util.List;

public interface EmployeeDao {
    Employee createEmployee(String lastName, String firstName, String birthday, String phone, int positionId, float salary);
    Employee loadEmployee(int id);
    List<Employee> getAllEmployee();
    void deleteEmployee(int id);
    //void updateEmployee(int id, String newPositionTitle);
    String readMetadata();
}
