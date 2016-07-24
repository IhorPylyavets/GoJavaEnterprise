package com.goit.restaurant.dao;

import com.goit.restaurant.model.Employee;
import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.assertTrue;

public class EmployeeDaoImplTest {

    private EmployeeDao employeeDao;

    @Before
    public void init() {
        employeeDao = new EmployeeDaoImpl();
    }

    @Test
    public void testCreateEmployee() throws Exception {
        String lastName = "lastName";
        String firstName = "firstName";
        String birthday = "7-06-2013";
        String phone = "22334455";
        int positionId = 1;
        float salary = 20000;

        Employee createEmployee = employeeDao.create(lastName, firstName, birthday, phone, positionId, salary);
        Employee employee = employeeDao.load(createEmployee.getId());
        assertTrue(createEmployee.equals(employee));

        employeeDao.delete(createEmployee.getId());
    }

    @Test(expected = RuntimeException.class)
    public void testDeleteEmployee() throws Exception {
        String lastName = "lastName";
        String firstName = "firstName";
        String birthday = "7-06-2013";
        String phone = "22334455";
        int positionId = 1;
        float salary = 20000;

        Employee createEmployee = employeeDao.create(lastName, firstName, birthday, phone, positionId, salary);
        employeeDao.delete(createEmployee.getId());
        Employee pos = employeeDao.load(createEmployee.getId());
    }

    @Test
    public void testReadMetaData() throws Exception {
        String metaData = employeeDao.readMetadata();
        System.out.println(metaData);
    }
}