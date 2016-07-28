package com.goit.restaurant;

import com.goit.restaurant.controllers.*;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class Main {
    private static final Logger LOGGER = LoggerFactory.getLogger(Main.class);
    private PositionController positionController;
    private EmployeeController employeeController;
    private DeskController deskController;
    private MenuController menuController;
    private IngredientController ingredientController;
    private WarehouseController warehouseController;
    private CategoryController categoryController;

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
    public void setDeskController(DeskController deskController) {
        this.deskController = deskController;
    }
    public void setMenuController(MenuController menuController) {
        this.menuController = menuController;
    }
    public void setIngredientController(IngredientController ingredientController) {
        this.ingredientController = ingredientController;
    }
    public void setWarehouseController(WarehouseController warehouseController) {
        this.warehouseController = warehouseController;
    }
    public void setCategoryController(CategoryController categoryController) {
        this.categoryController = categoryController;
    }
}
