package com.goit.restaurant;

import com.goit.restaurant.controllers.*;
import com.goit.restaurant.model.Category;
import com.goit.restaurant.model.Ingredient;
import com.goit.restaurant.model.Menu;
import com.goit.restaurant.model.Position;
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
    private OrderController orderController;
    private DishesPreparationController dishesPreparationController;
    private DishController dishController;

    public static void main(String[] args) {
        ApplicationContext context =
                new ClassPathXmlApplicationContext("application-context.xml", "hibernate-context.xml");
        Main main = context.getBean(Main.class);
        main.start();
    }

    private void start() {
        /*Position position = new Position();
        position.setPositionTitle("Test H Position");
        positionController.createPosition(position);
*/

        //positionController.updatePositionTitle(6, "Qwerwetqwer");
        //positionController.deletePosition(6);

        //positionController.getAllPosition().forEach(System.out::println);
        //System.out.println(positionController.findPositionById(2));

        /*menuController.getAllMenu().forEach(System.out::println);
        Menu menu = new Menu();
        menu.setMenuTitle("qweee");
        menuController.createMenu(menu);

        menuController.updateMenuTitle(5, "qqqqqqqqqqqqqqqqqqqqqqqqqqqq");
        System.out.println(menuController.findMenuById(5));
        menuController.deleteMenu(5);
        menuController.getAllMenu().forEach(System.out::println);*/

//        ingredientController.getAllIngredient().forEach(System.out::println);
//        Ingredient ingredient = new Ingredient();
//        ingredient.setIngredientTitle("qqqqqqqq");
//        ingredientController.createIngredient(ingredient);
//        System.out.println(ingredientController.findIngredientById(11));

        /*ingredientController.updateIngredientTitle(11, "aaaaaaaaaaa");
        System.out.println(ingredientController.findIngredientById(11));
        ingredientController.deleteIngredient(11);
        ingredientController.getAllIngredient().forEach(System.out::println);*/

        /*categoryController.getAllCategories().forEach(System.out::println);
        Category category = new Category();
        category.setCategoryTitle("zzzzzzzzzzzz");
        categoryController.createCategory(category);
        System.out.println(categoryController.findCategoryById(6));
        categoryController.updateCategoryTitle(6, "xxxxxxxxxxx");
        System.out.println(categoryController.findCategoryById(6));
        categoryController.deleteCategory(6);
        categoryController.getAllCategories().forEach(System.out::println);*/

        warehouseController.getAllWarehouse().forEach(System.out::println);

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
    public void setOrderController(OrderController orderController) {
        this.orderController = orderController;
    }
    public void setDishesPreparationController(DishesPreparationController dishesPreparationController) {
        this.dishesPreparationController = dishesPreparationController;
    }
    public void setDishController(DishController dishController) {
        this.dishController = dishController;
    }
}
