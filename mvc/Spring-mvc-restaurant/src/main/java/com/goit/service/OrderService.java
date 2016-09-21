package com.goit.service;

import com.goit.dao.OrderDao;
import com.goit.model.Desk;
import com.goit.model.Employee;
import com.goit.model.Orders;
import org.springframework.transaction.annotation.Transactional;

import java.sql.Date;
import java.util.List;

public class OrderService {

    private OrderDao orderDao;

    public void setOrderDao(OrderDao orderDao) {
        this.orderDao = orderDao;
    }

    @Transactional
    public void createOrder(Orders order) {
        orderDao.createOrder(order);
    }

    @Transactional
    public Orders findOrderById(int id) {
        return orderDao.findOrderById(id);
    }

    @Transactional
    public List<Orders> getAllOrders() {
        return orderDao.getAllOrders();
    }

    @Transactional
    public void deleteOrder(int id) {
        orderDao.deleteOrder(id);
    }

    @Transactional
    public void updateOrderWaiterId(int id, Employee newWaiter) {
        orderDao.updateOrderWaiterId(id, newWaiter);
    }

    @Transactional
    public void updateOrderDeskId(int id, Desk newDesk) {
        orderDao.updateOrderDeskId(id, newDesk);
    }

    @Transactional
    public void updateOrderDate(int id, Date newOrderDate) {
        orderDao.updateOrderDate(id, newOrderDate);
    }
}
