package com.example.dao.hibernate;

import com.example.dao.OrderDao;
import com.example.model.Orders;
import org.hibernate.SessionFactory;

import java.util.List;

public class HOrderDao implements OrderDao {

    private SessionFactory sessionFactory;

    @Override
    public void save(Orders orders) {
        sessionFactory.getCurrentSession().save(orders);
    }

    @Override
    public List<Orders> findAllOrders() {
        return sessionFactory.getCurrentSession().createQuery("select o from Orders o").list();
    }

    public void setSessionFactory(SessionFactory sessionFactory) {
        this.sessionFactory = sessionFactory;
    }
}
