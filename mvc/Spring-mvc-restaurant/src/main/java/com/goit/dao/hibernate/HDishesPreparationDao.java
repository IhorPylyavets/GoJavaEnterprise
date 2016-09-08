/*
package com.goit.dao.hibernate;

import com.goit.dao.DishesPreparationDao;
import com.goit.model.Dish;
import com.goit.model.DishesPreparation;
import com.goit.model.Employee;
import com.goit.model.Orders;
import org.hibernate.SessionFactory;
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

    }

    @Transactional
    public DishesPreparation findDishesPreparationById(int id) {
        return null;
    }

    @Transactional
    public List<DishesPreparation> getAllDishesPreparation() {
        return sessionFactory.getCurrentSession().createQuery("select d from DishesPreparation d").list();
    }

    @Transactional
    public void deleteDishesPreparation(int id) {

    }

    @Transactional
    public void updateDishesPreparationDish(int id, Dish newDish) {

    }

    @Transactional
    public void updateDishesPreparationCook(int id, Employee newCook) {

    }

    @Transactional
    public void updateDishesPreparationOrder(int id, Orders newOrder) {

    }

    @Transactional
    public void updateDishesPreparationDate(int id, Timestamp newDate) {

    }

}
*/
