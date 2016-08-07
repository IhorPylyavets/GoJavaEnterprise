package com.example.dao;

import com.example.model.Orders;

import java.util.List;

public interface OrderDao {
    void save(Orders orders);
    List<Orders> findAllOrders();
}
