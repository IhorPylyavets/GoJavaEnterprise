package com.goit.dao;

import com.goit.model.Employee;

import java.sql.Date;
import java.util.List;

public interface EmployeeDao {
    void createEmployee(Employee employee);
    Employee findEmployeeById(int id);
    List<Employee> getAllEmployees();
    void deleteEmployee(int id);
    void updateEmployeeLastName(int id, String newEmployeeLastName);
    void updateEmployeeFirstName(int id, String newEmployeeFirstName);
    void updateEmployeeBirthday(int id, Date newEmployeeBirthday);
    void updateEmployeePhone(int id, String newEmployeePhone);
    void updateEmployeePositionId(int id, int newPositionId);
    void updateEmployeeSalary(int id, float newEmployeeSalary);
}
