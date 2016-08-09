package com.goit.restaurant.dao.hibernate;

import com.goit.restaurant.dao.WarehouseDao;
import com.goit.restaurant.model.Warehouse;
import org.hibernate.SessionFactory;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

public class HWarehouseDao implements WarehouseDao{

    private SessionFactory sessionFactory;

    @Override
    @Transactional
    public void createWarehouse(Warehouse warehouse) {
        sessionFactory.getCurrentSession().save(warehouse);
    }

    @Override
    @Transactional
    public Warehouse findWarehouseById(int id) {
        return null;
    }

    @Override
    @Transactional
    public List<Warehouse> getAllWarehouse() {
        return sessionFactory.getCurrentSession().createQuery("select w from Warehouse w").list();
    }

    @Override
    @Transactional
    public void deleteWarehouse(int id) {

    }

    @Override
    @Transactional
    public void updateWarehouseIngredientId(int id, int newWarehouseIngredientId) {

    }

    @Override
    @Transactional
    public void updateWarehouseAmount(int id, float newWarehouseAmount) {

    }

    public void setSessionFactory(SessionFactory sessionFactory) {
        this.sessionFactory = sessionFactory;
    }
}
