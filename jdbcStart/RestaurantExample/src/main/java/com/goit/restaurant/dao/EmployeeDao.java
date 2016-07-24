package com.goit.restaurant.dao;

import com.goit.restaurant.model.Employee;

import java.util.List;

public interface EmployeeDao {
    Employee create(String lastName, String firstName, String birthday, String phone, int positionId, float salary);
    Employee load(int id);
    List<Employee> getAll();
    void delete(int id);
    //void updateEmployee(int id, String newPositionTitle);
    String readMetadata();
}