package com.example.controllers;

import com.example.dao.DishDao;
import com.example.dao.EmployeeDao;
import com.example.dao.OrderDao;
import com.example.model.Dish;
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
