package com.goit.jdbcexample;

import com.goit.jdbcexample.controllers.EmployeeController;
import com.goit.jdbcexample.controllers.EmployeeJdbcController;
import com.goit.jdbcexample.model.Employee;
import com.goit.jdbcexample.model.jdbc.JdbcEmployeeDao;
import com.goit.jdbcexample.model.jdbc.EmployeeDao;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class Main {

    private static final Logger LOGGER = LoggerFactory.getLogger(Main.class);

    //private EmployeeController employeeController;
    private EmployeeJdbcController employeeJdbcController;

    public static void main(String[] args) {
        //ApplicationContext context = new ClassPathXmlApplicationContext("application-context.xml");
        ApplicationContext context = new ClassPathXmlApplicationContext("application-context-jdbc-template.xml");
        Main main = context.getBean(Main.class);
        main.start();
    }

    private void start() {
        //employeeJdbcController.createEmployee();
        employeeJdbcController.getAllEmployee().forEach(System.out::println);
        System.out.println(employeeJdbcController.load(1));
    }

    public void setEmployeeController(EmployeeJdbcController employeeJdbcController) {
        this.employeeJdbcController = employeeJdbcController;
    }
}
