package com.goit.restaurant.controllers;

import com.goit.restaurant.dao.restaurantintefraces.OrderDao;
import com.goit.restaurant.model.Order;
import org.springframework.transaction.PlatformTransactionManager;
import org.springframework.transaction.annotation.Transactional;

import java.sql.Timestamp;
import java.util.List;

public class OrderController {

    private PlatformTransactionManager txManager;
    private OrderDao orderDao;

    public void setTxManager(PlatformTransactionManager txManager) {
        this.txManager = txManager;
    }

    public void setOrderDao(OrderDao orderDao) {
        this.orderDao = orderDao;
    }

    @Transactional
    public void createOrder(int employeeId, int deskId, Timestamp orderDate) {
        orderDao.createOrder(employeeId, deskId, orderDate);
    }

    @Transactional
    public List<Order> getAllOrder() {
        return orderDao.getAllOrder();
    }

    @Transactional
    public Order findOrderById(int id) {
        return orderDao.findOrderById(id);
    }

    @Transactional
    public void deleteOrder(int id) {
        orderDao.deleteOrder(id);
    }

    @Transactional
    public void updateOrderEmployeeId(int id, int newEmployeeId) {
        orderDao.updateOrderEmployeeId(id, newEmployeeId);
    }

    @Transactional
    public void updateOrderDeskId(int id, int newDeskId) {
        orderDao.updateOrderDeskId(id, newDeskId);
    }

    @Transactional
    public void updateOrderDate(int id, Timestamp newOrderDate) {
        orderDao.updateOrderDate(id, newOrderDate);
    }
}
