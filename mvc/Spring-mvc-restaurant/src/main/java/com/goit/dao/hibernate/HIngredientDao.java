package com.goit.dao.hibernate;

import com.goit.dao.IngredientDao;
import com.goit.model.Ingredient;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.query.Query;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

public class HIngredientDao implements IngredientDao{

    private SessionFactory sessionFactory;

    public void setSessionFactory(SessionFactory sessionFactory) {
        this.sessionFactory = sessionFactory;
    }

    @Transactional
    public void createIngredient(Ingredient ingredient) {
        sessionFactory.getCurrentSession().persist(ingredient);
    }

    @Transactional
    public Ingredient findIngredientById(int id) {
        Session session = sessionFactory.getCurrentSession();
        Query query = session.createQuery("FROM Ingredient I WHERE I.id = :id");
        query.setParameter("id", id);
        return (Ingredient) query.uniqueResult();
    }

    @Transactional
    public List<Ingredient> getAllIngredient() {
        return sessionFactory.getCurrentSession().createQuery("select i from Ingredient i").list();
    }

    @Transactional
    public void deleteIngredient(int id) {
        Session session = sessionFactory.getCurrentSession();
        Query query = session.createQuery("delete Ingredient WHERE id = :id");
        query.setParameter("id", id);
        query.executeUpdate();
    }

    @Transactional
    public void updateIngredientTitle(int id, String newIngredientTitle) {
        Session session = sessionFactory.getCurrentSession();
        Query query = session.createQuery("update Ingredient set ingredientTitle = :ingredientTitle where id = :id");
        query.setParameter("ingredientTitle", newIngredientTitle);
        query.setParameter("id", id);
        query.executeUpdate();
    }
}
