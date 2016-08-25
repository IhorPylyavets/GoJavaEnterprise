package com.goit.dao.hibernate;

import com.goit.dao.OrderDao;
import com.goit.model.Desk;
import com.goit.model.Employee;
import com.goit.model.Orders;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.query.Query;
import org.springframework.transaction.annotation.Transactional;

import java.sql.Timestamp;
import java.util.List;

public class HOrderDao implements OrderDao{

    private SessionFactory sessionFactory;

    public void setSessionFactory(SessionFactory sessionFactory) {
        this.sessionFactory = sessionFactory;
    }

    @Transactional
    public void createOrder(Orders order) {
        sessionFactory.getCurrentSession().saveOrUpdate(order);
    }

    @Transactional
    public Orders findOrderById(int id) {
        Session session = sessionFactory.getCurrentSession();
        Query query = session.createQuery("FROM Orders O WHERE O.id = :id");
        query.setParameter("id", id);
        return (Orders) query.uniqueResult();
    }

    @Transactional
    public List<Orders> getAllOrders() {
        return sessionFactory.getCurrentSession().createQuery("select o from Orders o").list();
    }

    @Transactional
    public void deleteOrder(int id) {
        Session session = sessionFactory.getCurrentSession();
        Query query = session.createQuery("delete Orders WHERE id = :id");
        query.setParameter("id", id);
        query.executeUpdate();
    }

    @Transactional
    public void updateOrderWaiterId(int id, Employee newWaiter) {
        Session session = sessionFactory.getCurrentSession();
        Query query = session.createQuery("update Orders set employee = :employee where id = :id");
        query.setParameter("employee", newWaiter);
        query.setParameter("id", id);
        query.executeUpdate();
    }

    @Transactional
    public void updateOrderDeskId(int id, Desk newDesk) {
        Session session = sessionFactory.getCurrentSession();
        Query query = session.createQuery("update Orders set desk = :desk where id = :id");
        query.setParameter("desk", newDesk);
        query.setParameter("id", id);
        query.executeUpdate();
    }

    @Transactional
    public void updateOrderDate(int id, Timestamp newOrderDate) {
        Session session = sessionFactory.getCurrentSession();
        Query query = session.createQuery("update Orders set orderDate = :orderDate where id = :id");
        query.setParameter("orderDate", newOrderDate);
        query.setParameter("id", id);
        query.executeUpdate();
    }

}
