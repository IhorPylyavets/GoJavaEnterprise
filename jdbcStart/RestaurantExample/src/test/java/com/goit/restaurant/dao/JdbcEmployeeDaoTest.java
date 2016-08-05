package com.goit.restaurant.dao;

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
    public void testEmployee() throws Exception {
        List<Employee> employeeList = employeeController.getAllEmployee();

        String testLastName = "Test last name";
        String testFirstName = "Test first name";
        String dateBirthday = "2000-11-23";
        java.sql.Date testBirthday = java.sql.Date.valueOf(dateBirthday);
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


        Employee employee = employeeController.findEmployeeById(employeeListCurrent.get(employeeListCurrent.size()-1).getId());
        System.out.println(employee);

        String testUpdateLastName = "Update Test last name";
        employeeController.updateEmployeeLastName(employeeListCurrent.get(employeeListCurrent.size()-1).getId(), testUpdateLastName);

        String testUpdateFirstName = "Update Test first name";
        employeeController.updateEmployeeFirstName(employeeListCurrent.get(employeeListCurrent.size()-1).getId(), testUpdateFirstName);

        String dateUpdateBirthday = "2007-10-22";
        java.sql.Date testUpdateBirthday = java.sql.Date.valueOf(dateUpdateBirthday);
        employeeController.updateEmployeeBirthday(employeeListCurrent.get(employeeListCurrent.size()-1).getId(), testUpdateBirthday);

        String testUpdatePhone = "888 999 431";
        employeeController.updateEmployeePhone(employeeListCurrent.get(employeeListCurrent.size()-1).getId(), testUpdatePhone);

        int testUpdatePositionId = 2;
        employeeController.updateEmployeePositionId(employeeListCurrent.get(employeeListCurrent.size()-1).getId(), testUpdatePositionId);

        float testUpdateSalary = 20000.0F;
        employeeController.updateEmployeeSalary(employeeListCurrent.get(employeeListCurrent.size()-1).getId(), testUpdateSalary);

        employeeListCurrent = employeeController.getAllEmployee();
        assertEquals(employeeListCurrent.get(employeeListCurrent.size()-1).getLastName(), testUpdateLastName);
        assertEquals(employeeListCurrent.get(employeeListCurrent.size()-1).getFirstName(), testUpdateFirstName);
        assertEquals(employeeListCurrent.get(employeeListCurrent.size()-1).getBirthday(), testUpdateBirthday);
        assertEquals(employeeListCurrent.get(employeeListCurrent.size()-1).getPhone(), testUpdatePhone);
        assertEquals(employeeListCurrent.get(employeeListCurrent.size()-1).getPositionId(), testUpdatePositionId);
        assertEquals(employeeListCurrent.get(employeeListCurrent.size()-1).getSalary(), testUpdateSalary, 0.01);

        employeeController.deleteEmployee(employeeListCurrent.size()-1);
        employeeListCurrent = employeeController.getAllEmployee();
        assertEquals(employeeListCurrent.size(), employeeList.size());
    }

}