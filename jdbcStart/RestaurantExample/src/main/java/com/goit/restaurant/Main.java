package com.goit.restaurant;

import com.goit.restaurant.controllers.*;
import com.goit.restaurant.model.Employee;
import freemarker.template.Configuration;
import freemarker.template.Template;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import spark.Request;
import spark.Response;
import spark.Route;

import java.io.StringWriter;
import java.util.*;

import static spark.Spark.*;

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

    private static void showAllEmployee(List<Employee> employees) {
        final Configuration configuration = new Configuration();
        configuration.setClassForTemplateLoading(Main.class, "/");

        get("/", new Route() {
            @Override
            public Object handle(Request request, Response response) {
                StringWriter stringWriter = new StringWriter();

                try {
                    Template employeeTemplate = configuration.getTemplate("templates/employee.ftl");
                    Map<String, Object> map = new HashMap<>();
                    List<String> list = new ArrayList<>();
                    for (Employee em : employees) {
                        list.add(em.toString());
                    }
                    map.put("employees", list);
                    employeeTemplate.process(map, stringWriter);

                } catch (Exception e) {
                    halt(500);
                    e.printStackTrace();
                }
                return stringWriter;
            }
        });
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

        //warehouseController.getAllWarehouse().forEach(System.out::println);

        /*employeeController.getAllEmployee().forEach(System.out::println);
        String testLastName = "Test last name";
        String testFirstName = "Test first name";
        java.sql.Date testBirthday = Common.stringToSqlDate("2000-11-23");
        String testPhone = "111 222 345";
        int testPositionId = 1;
        Float testSalary = 23000.0F;

        Employee employee = new Employee();
        employee.setFirstName(testFirstName);
        employee.setLastName(testLastName);
        employee.setBirthday(testBirthday);
        employee.setPhone(testPhone);
        employee.setPositionId(testPositionId);
        employee.setSalary(testSalary);

        employeeController.createEmployee(employee);
        System.out.println(employeeController.findEmployeeById(6));
        employeeController.updateEmployeeLastName(6, "q");
        employeeController.updateEmployeeFirstName(6, "q");
        employeeController.updateEmployeeBirthday(6, Common.stringToSqlDate("1997-10-03"));
        employeeController.updateEmployeePhone(6, "111");
        employeeController.updateEmployeePositionId(6, 2);
        employeeController.updateEmployeeSalary(6, 111.0F);
        System.out.println(employeeController.findEmployeeById(6));
        employeeController.deleteEmployee(6);*/

        showAllEmployee(employeeController.getAllEmployee());
        //.forEach(System.out::println);

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
