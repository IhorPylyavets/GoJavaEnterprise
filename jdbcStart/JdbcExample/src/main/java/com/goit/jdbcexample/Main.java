package com.goit.jdbcexample;

import com.goit.jdbcexample.controllers.EmployeeController;
import com.goit.jdbcexample.model.Employee;
import com.goit.jdbcexample.model.jdbc.JdbcEmployeeDao;
import com.goit.jdbcexample.model.jdbc.EmployeeDao;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class Main {

    private static final Logger LOGGER = LoggerFactory.getLogger(Main.class);

    private EmployeeController employeeController;

    public static void main(String[] args) {
        ApplicationContext context = new ClassPathXmlApplicationContext("application-context.xml");
        Main main = context.getBean(Main.class);
        main.start();
    }

    private void start() {
        //employeeController.getAllEmployee().forEach(System.out::println);
        System.out.println(employeeController.getEmployeeById(1));
    }

    public void setEmployeeController(EmployeeController employeeController) {
        this.employeeController = employeeController;
    }
}
