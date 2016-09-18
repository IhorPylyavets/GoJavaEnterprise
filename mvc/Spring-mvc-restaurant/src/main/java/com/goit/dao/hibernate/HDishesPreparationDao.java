package com.goit.dao.hibernate;

import com.goit.dao.DishesPreparationDao;
import com.goit.model.Dish;
import com.goit.model.DishesPreparation;
import com.goit.model.Employee;
import com.goit.model.Orders;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.query.Query;
import org.springframework.transaction.annotation.Transactional;

import java.sql.Timestamp;
import java.util.List;

public class HDishesPreparationDao implements DishesPreparationDao{

    private SessionFactory sessionFactory;

    public void setSessionFactory(SessionFactory sessionFactory) {
        this.sessionFactory = sessionFactory;
    }

    @Transactional
    public void createDishesPreparation(DishesPreparation dishesPreparation) {
        sessionFactory.getCurrentSession().saveOrUpdate(dishesPreparation);
    }

    @Transactional
    public DishesPreparation findDishesPreparationById(int id) {
        DishesPreparation dishesPreparation = sessionFactory.getCurrentSession().get(DishesPreparation.class, id);
        if (dishesPreparation == null)
            throw new RuntimeException("Can't find DishesPreparation by id = " + id);
        return dishesPreparation;
    }

    @Transactional
    public List<DishesPreparation> getAllDishesPreparation() {
        return sessionFactory.getCurrentSession().createQuery("select d from DishesPreparation d").list();
    }

    @Transactional
    public void deleteDishesPreparation(int id) {
        Session session = sessionFactory.getCurrentSession();
        Query query = session.createQuery("delete DishesPreparation WHERE id = :id");
        query.setParameter("id", id);
        query.executeUpdate();
    }

    @Transactional
    public void updateDishesPreparationDish(int id, Dish newDish) {
        Session session = sessionFactory.getCurrentSession();
        Query query = session.createQuery("update DishesPreparation set dish = :dish where id = :id");
        query.setParameter("dish", newDish);
        query.setParameter("id", id);
        query.executeUpdate();
    }

    @Transactional
    public void updateDishesPreparationCook(int id, Employee newCook) {
        Session session = sessionFactory.getCurrentSession();
        Query query = session.createQuery("update DishesPreparation set cook = :cook where id = :id");
        query.setParameter("cook", newCook);
        query.setParameter("id", id);
        query.executeUpdate();
    }

    @Transactional
    public void updateDishesPreparationOrder(int id, Orders newOrder) {
        Session session = sessionFactory.getCurrentSession();
        Query query = session.createQuery("update DishesPreparation set orderValue = :orderValue where id = :id");
        query.setParameter("orderValue", newOrder);
        query.setParameter("id", id);
        query.executeUpdate();
    }

    @Transactional
    public void updateDishesPreparationDate(int id, Timestamp newDate) {
        Session session = sessionFactory.getCurrentSession();
        Query query = session.createQuery("update DishesPreparation set datePreparation = :datePreparation where id = :id");
        query.setParameter("datePreparation", newDate);
        query.setParameter("id", id);
        query.executeUpdate();
    }

}
