package com.goit.dao.hibernate;

import com.goit.dao.WarehouseDao;
import com.goit.model.Warehouse;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.query.Query;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

public class HWarehouseDao implements WarehouseDao{

    private SessionFactory sessionFactory;

    public void setSessionFactory(SessionFactory sessionFactory) {
        this.sessionFactory = sessionFactory;
    }

    @Transactional
    public void createWarehouse(Warehouse warehouse) {
        sessionFactory.getCurrentSession().persist(warehouse);
    }

    @Transactional
    public Warehouse findWarehouseById(int id) {
        Session session = sessionFactory.getCurrentSession();
        Query query = session.createQuery("FROM Warehouse E WHERE E.id = :id");
        query.setParameter("id", id);
        return (Warehouse) query.uniqueResult();
    }

    @Transactional
    public List<Warehouse> getAllWarehouse() {
        return sessionFactory.getCurrentSession().createQuery("select w from Warehouse w").list();
    }

    @Transactional
    public void deleteWarehouse(int id) {
        Session session = sessionFactory.getCurrentSession();
        Query query = session.createQuery("delete Warehouse WHERE id = :id");
        query.setParameter("id", id);
        query.executeUpdate();
    }

    @Transactional
    public void updateWarehouseIngredientId(int id, int newWarehouseIngredientId) {
        Session session = sessionFactory.getCurrentSession();
        Query query = session.createQuery("update Warehouse set ingredientId = :ingredientId where id = :id");
        query.setParameter("ingredientId", newWarehouseIngredientId);
        query.setParameter("id", id);
        query.executeUpdate();
    }

    @Transactional
    public void updateWarehouseAmount(int id, float newWarehouseAmount) {
        Session session = sessionFactory.getCurrentSession();
        Query query = session.createQuery("update Warehouse set amount = :amount where id = :id");
        query.setParameter("amount", newWarehouseAmount);
        query.setParameter("id", id);
        query.executeUpdate();
    }

}
