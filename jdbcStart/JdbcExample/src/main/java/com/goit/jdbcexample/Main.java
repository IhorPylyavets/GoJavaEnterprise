package com.goit.jdbcexample;

import com.goit.jdbcexample.model.Employee;
import com.goit.jdbcexample.model.jdbc.JdbcEmployeeDao;
import com.goit.jdbcexample.model.jdbc.EmployeeDao;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class Main {

    private static final Logger LOGGER = LoggerFactory.getLogger(Main.class);

    public static void main(String[] args) {
        EmployeeDao employeeDAO = new JdbcEmployeeDao();
        employeeDAO.getAllEmployee().forEach(System.out::println);

        System.out.println("Employee with id=3");
        Employee employee = employeeDAO.load(3);
        System.out.println(employee);
    }

}
