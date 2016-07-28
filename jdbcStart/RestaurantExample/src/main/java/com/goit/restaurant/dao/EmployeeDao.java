package com.goit.restaurant.dao;

import com.goit.restaurant.model.Employee;

import java.util.List;

public interface EmployeeDao {
    void createEmployee(String lastName, String firstName, String birthday, String phone, int positionId, float salary);
    Employee loadEmployeeById(int id);
    List<Employee> getAllEmployees();
    void deleteEmployee(int id);
    void updateEmployeeLastName(int id, String newEmployeeLastName);
    void updateEmployeeFirstName(int id, String newEmployeeFirstName);
    void updateEmployeeBirthday(int id, String newEmployeeBirthday);
    void updateEmployeePhone(int id, String newEmployeePhone);
    void updateEmployeePositionId(int id, int newPositionId);
    void updateEmployeeSalary(int id, float newEmployeeSalary);
    //String readEmployeeMetadata();
}
