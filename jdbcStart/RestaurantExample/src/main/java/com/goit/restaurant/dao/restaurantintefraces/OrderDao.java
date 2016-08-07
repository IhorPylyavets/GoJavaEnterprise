package com.goit.restaurant.dao.restaurantintefraces;

import com.goit.restaurant.model.Order;

import java.sql.Timestamp;
import java.util.List;

public interface OrderDao {
    void createOrder(int employeeId, int deskId, Timestamp orderDate);
    Order findOrderById(int id);
    List<Order> getAllOrder();
    void deleteOrder(int id);
    void updateOrderEmployeeId(int id, int employeeId);
    void updateOrderDeskId(int id, int deskId);
    void updateOrderDate(int id, Timestamp orderDate);
}
