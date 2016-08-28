package com.example.controllers;

import com.example.dao.DishDao;
import com.example.dao.EmployeeDao;
import com.example.dao.OrderDao;
import com.example.model.Dish;
import com.example.model.DishCategory;
import com.example.model.Orders;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class OrderController {

    private EmployeeDao employeeDao;
    private DishDao dishDao;
    private OrderDao orderDao;

    @Transactional
    public void createOrder(String waiterName, List<String> dishes, int tableNumber) {
        Orders orders = new Orders();
        orders.setWaiter(employeeDao.findByName(waiterName));
        orders.setDishes(createDishes(dishes));
        orders.setTableNumber(tableNumber);
        orders.setOrderDate(new Date());

        orderDao.save(orders);
    }

    @Transactional
    public List<Orders> getAllOrders() {
        return orderDao.findAllOrders();
    }

    @Transactional
    public void printAllOrders() {
        getAllOrders().forEach(System.out::println);
    }

    @Transactional
    public void removeAllOrders() {
        orderDao.removeAll();
    }

    @Transactional
    public void initOrders() {
        List<String> dishes = new ArrayList<>();
        dishes.add("Plov");
        dishes.add("Salad");
        createOrder("John", dishes, 1);

        List<String> dishes1 = new ArrayList<>();
        dishes1.add("Potato");
        dishes1.add("Salad");
        createOrder("John", dishes1, 2);

        List<String> dishes2 = new ArrayList<>();
        dishes2.add("Plov");
        dishes2.add("Potato");
        createOrder("Mary", dishes2, 3);

        orderDao.save(createOrderWithIceCream());
    }

    private Orders createOrderWithIceCream() {
        List<Dish> dishes = new ArrayList<>();

        Dish iceCream = new Dish();
        iceCream.setName("Ice Cream");
        iceCream.setCategory(DishCategory.DESSERT);
        iceCream.setPrice(3.0F);
        iceCream.setWeight(100.0F);
        dishDao.save(iceCream);
        dishes.add(iceCream);

        Orders order = new Orders();
        order.setWaiter(employeeDao.findByName("Mary"));
        order.setDishes(dishes);
        order.setTableNumber(4);
        order.setOrderDate(new Date());

        return order;
    }

    private List<Dish> createDishes(List<String> dishes) {
        List<Dish> result = new ArrayList<>();
        for (String dishName : dishes) {
            result.add(dishDao.findByName(dishName));
        }

        return result;
    }

    public void setEmployeeDao(EmployeeDao employeeDao) {
        this.employeeDao = employeeDao;
    }

    public void setDishDao(DishDao dishDao) {
        this.dishDao = dishDao;
    }

    public void setOrderDao(OrderDao orderDao) {
        this.orderDao = orderDao;
    }

}
