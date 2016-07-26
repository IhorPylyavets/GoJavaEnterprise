package com.goit.restaurant;

import com.goit.restaurant.controllers.EmployeeController;
import com.goit.restaurant.controllers.PositionController;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class Main {
    private static final Logger LOGGER = LoggerFactory.getLogger(Main.class);
    private PositionController positionController;
    private EmployeeController employeeController;

    public static void main(String[] args) {
        ApplicationContext context = new ClassPathXmlApplicationContext("application-context.xml");
        Main main = context.getBean(Main.class);
        main.start();
    }

    private void start() {

    }

    public void setPositionController(PositionController positionController) {
        this.positionController = positionController;
    }
    public void setEmployeeController(EmployeeController employeeController) {
        this.employeeController = employeeController;
    }
}
