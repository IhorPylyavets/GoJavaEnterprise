package com.goit.dao;

import com.goit.model.Desk;
import com.goit.model.Dish;
import com.goit.model.Employee;
import com.goit.model.Orders;

import java.sql.Date;
import java.util.List;

public interface OrderDao {

    void createOrder(Orders order);

    Orders findOrderById(int id);

    List<Orders> getAllOrders();

    void deleteOrder(int id);

    void updateOrderWaiterId(int id, Employee newWaiter);

    void updateOrderDeskId(int id, Desk newDesk);

    void updateOrderDate(int id, Date newOrderDate);

    /*List<Dish> getAllDishByOrderId(int id);

    void updateOrderDishes(int id, List<Dish> newDishes);*/
}
