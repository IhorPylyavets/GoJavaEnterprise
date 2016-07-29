package com.goit.restaurant.dao.restaurantintefraces;

import com.goit.restaurant.model.Order;

import java.util.List;

public interface OrderDao {
    void createOrder(int employeeId, int deskId, String orderDate);
    Order loadOrderById(int id);
    List<Order> getAllOrder();
    void deleteOrder(int id);
    void updateOrderEmployeeId(int id, int employeeId);
    void updateOrderDeskId(int id, int deskId);
    void updateOrderDate(int id, String orderDate);
}
