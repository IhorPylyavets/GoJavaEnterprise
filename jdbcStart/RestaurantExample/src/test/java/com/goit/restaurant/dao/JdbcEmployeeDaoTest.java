package com.goit.restaurant.dao;

import com.goit.restaurant.Common;
import com.goit.restaurant.controllers.EmployeeController;
import com.goit.restaurant.model.Employee;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.annotation.Rollback;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

import static org.junit.Assert.assertEquals;

@ContextConfiguration(locations = "classpath:application-context-test.xml")
@RunWith(SpringJUnit4ClassRunner.class)
public class JdbcEmployeeDaoTest {

    @Autowired
    private EmployeeController employeeController;

    @Test
    @Transactional
    @Rollback(true)
    public void testCreateDeleteDishesEmployee() throws Exception {
        List<Employee> employeeList = employeeController.getAllEmployee();

        String testLastName = "Test last name";
        String testFirstName = "Test first name";
        java.sql.Date testBirthday = Common.stringToSqlDate("2000-11-23");
        String testPhone = "111 222 345";
        int testPositionId = 1;
        Float testSalary = 23000.0F;
        employeeController.createEmployee(testLastName, testFirstName, testBirthday, testPhone, testPositionId, testSalary);

        List<Employee> employeeListCurrent = employeeController.getAllEmployee();
        assertEquals(employeeList.size(), employeeListCurrent.size()-1);
        assertEquals(employeeListCurrent.get(employeeListCurrent.size()-1).getLastName(), testLastName);
        assertEquals(employeeListCurrent.get(employeeListCurrent.size()-1).getFirstName(), testFirstName);
        assertEquals(employeeListCurrent.get(employeeListCurrent.size()-1).getBirthday(), testBirthday);
        assertEquals(employeeListCurrent.get(employeeListCurrent.size()-1).getPhone(), testPhone);
        assertEquals(employeeListCurrent.get(employeeListCurrent.size()-1).getPositionId(), testPositionId);
        assertEquals(employeeListCurrent.get(employeeListCurrent.size()-1).getSalary(), testSalary, 0.01);

        employeeController.deleteEmployee(employeeListCurrent.get(employeeListCurrent.size()-1).getId());
        employeeListCurrent = employeeController.getAllEmployee();
        assertEquals(employeeList.size(), employeeListCurrent.size());
    }

    @Test
    @Transactional
    @Rollback(true)
    public void testFindEmployeeById() throws Exception {
        String testLastName = "Test last name";
        String testFirstName = "Test first name";
        java.sql.Date testBirthday = Common.stringToSqlDate("2000-11-23");
        String testPhone = "111 222 345";
        int testPositionId = 1;
        Float testSalary = 23000.0F;
        employeeController.createEmployee(testLastName, testFirstName, testBirthday, testPhone, testPositionId, testSalary);

        List<Employee> employeeList = employeeController.getAllEmployee();
        Employee employee = employeeController.findEmployeeById(employeeList.get(employeeList.size()-1).getId());
        assertEquals(employee.getLastName(), testLastName);
        assertEquals(employee.getFirstName(), testFirstName);
        assertEquals(employee.getBirthday(), testBirthday);
        assertEquals(employee.getPhone(), testPhone);
        assertEquals(employee.getPositionId(), testPositionId);
        assertEquals(employee.getSalary(), testSalary, 0.01);
    }

    @Test
    @Transactional
    @Rollback(true)
    public void testUpdateEmployee() throws Exception {
        String testLastName = "Test last name";
        String testFirstName = "Test first name";
        java.sql.Date testBirthday = Common.stringToSqlDate("2000-11-23");
        String testPhone = "111 222 345";
        int testPositionId = 1;
        Float testSalary = 23000.0F;
        employeeController.createEmployee(testLastName, testFirstName, testBirthday, testPhone, testPositionId, testSalary);

        List<Employee> employeeList = employeeController.getAllEmployee();
        String testUpdateLastName = "Test Update last name";
        String testUpdateFirstName = "Test Update first name";
        java.sql.Date testUpdateBirthday = Common.stringToSqlDate("1993-12-21");
        String testUpdatePhone = "131 252 385";
        int testUpdatePositionId = 2;
        Float testUpdateSalary = 24500.7F;

        employeeController.updateEmployeeLastName(employeeList.get(employeeList.size()-1).getId(), testUpdateLastName);
        employeeController.updateEmployeeFirstName(employeeList.get(employeeList.size()-1).getId(), testUpdateFirstName);
        employeeController.updateEmployeeBirthday(employeeList.get(employeeList.size()-1).getId(), testUpdateBirthday);
        employeeController.updateEmployeePhone(employeeList.get(employeeList.size()-1).getId(), testUpdatePhone);
        employeeController.updateEmployeePositionId(employeeList.get(employeeList.size()-1).getId(), testUpdatePositionId);
        employeeController.updateEmployeeSalary(employeeList.get(employeeList.size()-1).getId(), testUpdateSalary);

        Employee employee = employeeController.findEmployeeById(employeeList.get(employeeList.size()-1).getId());
        assertEquals(employee.getLastName(), testUpdateLastName);
        assertEquals(employee.getFirstName(), testUpdateFirstName);
        assertEquals(employee.getBirthday(), testUpdateBirthday);
        assertEquals(employee.getPhone(), testUpdatePhone);
        assertEquals(employee.getPositionId(), testUpdatePositionId);
        assertEquals(employee.getSalary(), testUpdateSalary, 0.01);
    }

}