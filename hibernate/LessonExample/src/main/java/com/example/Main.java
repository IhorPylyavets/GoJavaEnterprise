package com.example;

import com.example.controllers.DishController;
import com.example.controllers.EmployeeController;
import com.example.controllers.OrderController;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import java.util.ArrayList;
import java.util.List;

public class Main {

    private EmployeeController employeeController;
    private DishController dishController;
    private OrderController orderController;

    public static void main(String[] args) {
        ApplicationContext applicationContext =
                new ClassPathXmlApplicationContext("application-context.xml", "hibernate-context.xml");
        applicationContext.getBean(Main.class).start();
    }

    private void start() {
        employeeController.createEmployee();
        dishController.createDish();

        List<String> dishes1 = new ArrayList<>();
        dishes1.add("Plov");
        dishes1.add("Salad");
        orderController.createOrder("Victor", dishes1, 1);

        List<String> dishes2 = new ArrayList<>();
        dishes2.add("Plov");
        dishes2.add("Potato");
        orderController.createOrder("Victor", dishes2, 2);

        orderController.printAllOrders();
    }

    public void setEmployeeController(EmployeeController employeeController) {
        this.employeeController = employeeController;
    }
    public void setDishController(DishController dishController) {
        this.dishController = dishController;
    }
    public void setOrderController(OrderController orderController) {
        this.orderController = orderController;
    }
}
