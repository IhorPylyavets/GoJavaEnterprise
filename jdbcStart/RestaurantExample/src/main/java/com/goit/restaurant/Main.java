package com.goit.restaurant;

import com.goit.restaurant.controllers.DeskController;
import com.goit.restaurant.controllers.EmployeeController;
import com.goit.restaurant.controllers.PositionController;
import com.goit.restaurant.model.Desk;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class Main {
    private static final Logger LOGGER = LoggerFactory.getLogger(Main.class);
    private PositionController positionController;
    private EmployeeController employeeController;
    private DeskController deskController;

    public static void main(String[] args) {
        ApplicationContext context = new ClassPathXmlApplicationContext("application-context.xml");
        Main main = context.getBean(Main.class);
        main.start();
    }

    private void start() {
        System.out.println(deskController.readDeskMetadata());
        Desk desk = deskController.loadDeskById(1);
        System.out.println(desk);
        deskController.getAllPosition().forEach(System.out::println);

        /*Desk desk1 = deskController.createDesk("Test Desk");
        System.out.println(desk1);*/
        deskController.updateDeskTitle(6, "Tessss ddeesjb");
        desk = deskController.loadDeskById(6);
        System.out.println(desk);

        //deskController.updateDeskStatus(6, Desk.DeskStatus.ORDERED);
        deskController.deleteDesk(6);
        deskController.getAllPosition().forEach(System.out::println);

    }

    public void setPositionController(PositionController positionController) {
        this.positionController = positionController;
    }
    public void setEmployeeController(EmployeeController employeeController) {
        this.employeeController = employeeController;
    }

    public void setDeskController(DeskController deskController) {
        this.deskController = deskController;
    }
}
