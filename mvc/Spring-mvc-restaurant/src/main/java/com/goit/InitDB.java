package com.goit;

import com.goit.dao.*;
import com.goit.model.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.annotation.PostConstruct;
import java.sql.Date;
import java.sql.Timestamp;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.List;

@Service
public class InitDB {

    @Autowired
    private CategoryDao categoryDao;

    @Autowired
    private PositionDao positionDao;

    @Autowired
    private EmployeeDao employeeDao;

    @Autowired
    private MenuDao menuDao;

    @Autowired
    private IngredientDao ingredientDao;

    @Autowired
    private  WarehouseDao warehouseDao;

    @Autowired
    private DishDao dishDao;

    @Autowired
    private DeskDao deskDao;

    @Autowired
    private OrderDao orderDao;

    @Autowired
    private DishesPreparationDao dishesPreparationDao;

    @PostConstruct
    public void init() {
        positionDao.create(new Position("waiter"));
        positionDao.create(new Position("cook"));
        positionDao.create(new Position("manager"));
        positionDao.create(new Position("hookah"));
        positionDao.create(new Position("security guard"));

        employeeDao.createEmployee(new Employee("Ivanov", "Ivan", stringToDate("1978-06-19"), "1234567890",
                positionDao.findByTitle("waiter"), 20000.0F));
        employeeDao.createEmployee(new Employee("Grot", "Piter", stringToDate("1978-06-19"), "1234567890",
                positionDao.findByTitle("waiter"), 21000.0F));
        employeeDao.createEmployee(new Employee("Petrov", "Piter", stringToDate("1960-05-05"), "9876543210",
                positionDao.findByTitle("cook"), 23000.0F));
        employeeDao.createEmployee(new Employee("Berrens", "Saul", stringToDate("1960-05-05"), "9876543210",
                positionDao.findByTitle("cook"), 23000.0F));
        employeeDao.createEmployee(new Employee("Green", "Alex", stringToDate("1980-05-13"), "09877763310",
                positionDao.findByTitle("manager"), 33000.0F));
        employeeDao.createEmployee(new Employee("Teddy", "BigTeddy", stringToDate("1989-06-19"), "05088221797",
                positionDao.findByTitle("hookah"), 35000.0F));
        employeeDao.createEmployee(new Employee("Petrov", "Vasilii", stringToDate("1976-05-21"), "06777991102",
                positionDao.findByTitle("security guard"), 29000.0F));

        ingredientDao.create(new Ingredient("potato"));
        ingredientDao.create(new Ingredient("fish"));
        ingredientDao.create(new Ingredient("pork"));
        ingredientDao.create(new Ingredient("beef"));
        ingredientDao.create(new Ingredient("eggs"));
        ingredientDao.create(new Ingredient("cheese"));
        ingredientDao.create(new Ingredient("tomatoes"));
        ingredientDao.create(new Ingredient("union"));
        ingredientDao.create(new Ingredient("duck"));
        ingredientDao.create(new Ingredient("apple"));
        ingredientDao.create(new Ingredient("carrot"));
        ingredientDao.create(new Ingredient("sausage"));
        ingredientDao.create(new Ingredient("cucumbers"));
        ingredientDao.create(new Ingredient("olive"));

        categoryDao.create(new Category("meat"));
        categoryDao.create(new Category("fruit"));
        categoryDao.create(new Category("salads"));
        categoryDao.create(new Category("juices"));
        categoryDao.create(new Category("alcohol"));

        warehouseDao.createWarehouse(new Warehouse(ingredientDao.findByTitle("potato"), 400.0F));
        warehouseDao.createWarehouse(new Warehouse(ingredientDao.findByTitle("fish"), 20.0F));
        warehouseDao.createWarehouse(new Warehouse(ingredientDao.findByTitle("pork"), 30.0F));
        warehouseDao.createWarehouse(new Warehouse(ingredientDao.findByTitle("beef"), 47.0F));
        warehouseDao.createWarehouse(new Warehouse(ingredientDao.findByTitle("eggs"), 200.0F));
        warehouseDao.createWarehouse(new Warehouse(ingredientDao.findByTitle("cheese"), 48.0F));
        warehouseDao.createWarehouse(new Warehouse(ingredientDao.findByTitle("tomatoes"), 100.0F));
        warehouseDao.createWarehouse(new Warehouse(ingredientDao.findByTitle("union"), 15.0F));
        warehouseDao.createWarehouse(new Warehouse(ingredientDao.findByTitle("duck"), 42.0F));
        warehouseDao.createWarehouse(new Warehouse(ingredientDao.findByTitle("apple"), 190.0F));
        warehouseDao.createWarehouse(new Warehouse(ingredientDao.findByTitle("carrot"), 200.0F));
        warehouseDao.createWarehouse(new Warehouse(ingredientDao.findByTitle("sausage"), 50.0F));
        warehouseDao.createWarehouse(new Warehouse(ingredientDao.findByTitle("cucumbers"), 45.0F));
        warehouseDao.createWarehouse(new Warehouse(ingredientDao.findByTitle("olive"), 36.0F));

        //dishDao.createDish(new Dish("Chop", categoryDao.findByTitle("meat"), 54.0F, 220.0F));
        //dishDao.createDish(new Dish("Grapes", categoryDao.findByTitle("fruit"), 31.0F, 300.0F));
        List<Ingredient> olivieIngredient = new ArrayList<>();
        olivieIngredient.add(ingredientDao.findByTitle("potato"));
        olivieIngredient.add(ingredientDao.findByTitle("eggs"));
        olivieIngredient.add(ingredientDao.findByTitle("union"));
        olivieIngredient.add(ingredientDao.findByTitle("carrot"));
        olivieIngredient.add(ingredientDao.findByTitle("sausage"));
        dishDao.createDish(new Dish("Olivie", olivieIngredient, categoryDao.findByTitle("salads"), 35.0F, 200.0F));
        //dishDao.createDish(new Dish("Apple juice", categoryDao.findByTitle("juices"), 20.0F, 250.0F));
        //dishDao.createDish(new Dish("Vodka", categoryDao.findByTitle("alcohol"), 50.0F, 500.0F));

        List<Ingredient> duckWithApplesIngredients = new ArrayList<>();
        duckWithApplesIngredients.add(ingredientDao.findByTitle("duck"));
        duckWithApplesIngredients.add(ingredientDao.findByTitle("apple"));
        dishDao.createDish(new Dish("Duck with apples", duckWithApplesIngredients, categoryDao.findByTitle("meat"), 70.0F, 430.0F));

        List<Ingredient> greekSaladIngredients = new ArrayList<>();
        greekSaladIngredients.add(ingredientDao.findByTitle("tomatoes"));
        greekSaladIngredients.add(ingredientDao.findByTitle("cucumbers"));
        greekSaladIngredients.add(ingredientDao.findByTitle("olive"));
        dishDao.createDish(new Dish("Greek salad", greekSaladIngredients, categoryDao.findByTitle("salads"), 30.0F, 180.0F));

        /*List<Dish> dishList = dishDao.getAllDish();
        for (Dish d : dishList) {
            System.out.println(d);
        }*/

        List<Dish> businessDishes = new ArrayList<>();
        businessDishes.add(dishDao.findDishByTitle("Olivie"));
        businessDishes.add(dishDao.findDishByTitle("Duck with apples"));
        menuDao.createMenu(new Menu("Menu Business Lunch", businessDishes));
        List<Dish> buffetDishes = new ArrayList<>();
        buffetDishes.add(dishDao.findDishByTitle("Greek salad"));
        buffetDishes.add(dishDao.findDishByTitle("Duck with apples"));
        menuDao.createMenu(new Menu("Buffet", buffetDishes));
        List<Dish> tableDishes = new ArrayList<>();
        tableDishes.add(dishDao.findDishByTitle("Greek salad"));
        menuDao.createMenu(new Menu("Table d*hote menu", tableDishes));
        List<Dish> carteDishes = new ArrayList<>();
        carteDishes.add(dishDao.findDishByTitle("Duck with apples"));
        menuDao.createMenu(new Menu("Menu a la carte", carteDishes));

        deskDao.create(new Desk("First"));
        deskDao.create(new Desk("Second"));
        deskDao.create(new Desk("Third"));
        deskDao.create(new Desk("Fourth"));
        deskDao.create(new Desk("Fifth"));

        orderDao.createOrder(new Orders(employeeDao.findEmployeeByFullName("Ivanov", "Ivan"),
                deskDao.findByTitle("First"), getTimestampNow()));
        orderDao.createOrder(new Orders(employeeDao.findEmployeeByFullName("Grot", "Piter"),
                deskDao.findByTitle("Fourth"), getTimestampNow()));

        DishesPreparation dishesPreparation1 = new DishesPreparation();
        dishesPreparation1.setDish(dishDao.findDishByTitle("Duck with apples"));
        dishesPreparation1.setCook(employeeDao.findEmployeeByFullName("Petrov", "Piter"));
        dishesPreparation1.setOrderValue(orderDao.findOrderById(1));
        dishesPreparation1.setDatePreparation(getTimestampNow());
        dishesPreparationDao.createDishesPreparation(dishesPreparation1);

        DishesPreparation dishesPreparation2 = new DishesPreparation();
        dishesPreparation2.setDish(dishDao.findDishByTitle("Greek salad"));
        dishesPreparation2.setCook(employeeDao.findEmployeeByFullName("Petrov", "Piter"));
        dishesPreparation2.setOrderValue(orderDao.findOrderById(1));
        dishesPreparation2.setDatePreparation(getTimestampNow());
        dishesPreparationDao.createDishesPreparation(dishesPreparation2);

    }

    public void setPositionDao(PositionDao positionDao) {
        this.positionDao = positionDao;
    }

    public void setEmployeeDao(EmployeeDao employeeDao) {
        this.employeeDao = employeeDao;
    }

    public void setIngredientDao(IngredientDao ingredientDao) {
        this.ingredientDao = ingredientDao;
    }

    public void setCategoryDao(CategoryDao categoryDao) {
        this.categoryDao = categoryDao;
    }

    public void setWarehouseDao(WarehouseDao warehouseDao) {
        this.warehouseDao = warehouseDao;
    }

    public void setDishDao(DishDao dishDao) {
        this.dishDao = dishDao;
    }

    public void setDeskDao(DeskDao deskDao) {
        this.deskDao = deskDao;
    }

    public void setMenuDao(MenuDao menuDao) {
        this.menuDao = menuDao;
    }

    public void setOrderDao(OrderDao orderDao) {
        this.orderDao = orderDao;
    }

    public void setDishesPreparationDao(DishesPreparationDao dishesPreparationDao) {
        this.dishesPreparationDao = dishesPreparationDao;
    }

    private Date stringToDate(String dateInString) {
        SimpleDateFormat sdf1 = new SimpleDateFormat("yyyy-MM-dd");
        try {
            return new Date(sdf1.parse(dateInString).getTime());
        } catch (ParseException e) {
            throw new RuntimeException(e);
        }

    }

    private Timestamp getTimestampNow() {
        java.util.Date date= new java.util.Date();
        return new Timestamp(date.getTime());
    }

}
