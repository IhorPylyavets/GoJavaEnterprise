package com.goit;

import com.goit.dao.*;
import com.goit.model.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.annotation.PostConstruct;
import java.sql.Date;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;

@Service
public class InitDB {

    @Autowired
    private PositionDao positionDao;

    @Autowired
    private EmployeeDao employeeDao;

    @Autowired
    private IngredientDao ingredientDao;

    @Autowired
    private MenuDao menuDao;

    @Autowired
    private CategoryDao categoryDao;

    @Autowired
    private  WarehouseDao warehouseDao;

    @Autowired
    private DishDao dishDao;

    @Autowired
    private DeskDao deskDao;

    @PostConstruct
    public void init() {
        positionDao.create(new Position("waiter"));
        positionDao.create(new Position("cook"));
        positionDao.create(new Position("manager"));
        positionDao.create(new Position("hookah"));
        positionDao.create(new Position("security guard"));

        employeeDao.createEmployee(new Employee("Ivanov", "Ivan", stringToDate("1978-06-19"), "1234567890",
                positionDao.findByTitle("waiter"), 20000.0F));
        employeeDao.createEmployee(new Employee("Petrov", "Piter", stringToDate("1960-05-05"), "9876543210",
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

        menuDao.create(new Menu("Menu Business Lunch"));
        menuDao.create(new Menu("Buffet"));
        menuDao.create(new Menu("Table d*hote menu"));
        menuDao.create(new Menu("Menu a la carte"));

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

        //dishDao.createDish(new Dish("Chop", categoryDao.findByTitle("meat"), 54.0F, 220.0F));
        //dishDao.createDish(new Dish("Grapes", categoryDao.findByTitle("fruit"), 31.0F, 300.0F));
        ArrayList<Ingredient> olivieIngredient = new ArrayList<>();
        olivieIngredient.add(ingredientDao.findByTitle("potato"));
        olivieIngredient.add(ingredientDao.findByTitle("eggs"));
        olivieIngredient.add(ingredientDao.findByTitle("union"));
        dishDao.createDish(new Dish("Olivie", olivieIngredient, categoryDao.findByTitle("salads"), 35.0F, 200.0F));
        //dishDao.createDish(new Dish("Apple juice", categoryDao.findByTitle("juices"), 20.0F, 250.0F));
        //dishDao.createDish(new Dish("Vodka", categoryDao.findByTitle("alcohol"), 50.0F, 500.0F));

        ArrayList<Ingredient> duckWithApplesIngredients = new ArrayList<>();
        duckWithApplesIngredients.add(ingredientDao.findByTitle("duck"));
        duckWithApplesIngredients.add(ingredientDao.findByTitle("apple"));
        dishDao.createDish(new Dish("Duck with apples", duckWithApplesIngredients, categoryDao.findByTitle("meat"), 70.0F, 430.0F));

        deskDao.create(new Desk("First"));
        deskDao.create(new Desk("Second"));
        deskDao.create(new Desk("Third"));
        deskDao.create(new Desk("Fourth"));
        deskDao.create(new Desk("Fifth"));

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

    public void setMenuDao(MenuDao menuDao) {
        this.menuDao = menuDao;
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

    private Date stringToDate(String dateInString) {
        SimpleDateFormat sdf1 = new SimpleDateFormat("yyyy-MM-dd");
        try {
            return new Date(sdf1.parse(dateInString).getTime());
        } catch (ParseException e) {
            throw new RuntimeException(e);
        }

    }

}
