package com.goit.dao.hibernate;

import com.goit.dao.CategoryDao;
import com.goit.model.Category;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.query.Query;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

public class HCategoryDao implements CategoryDao{

    private SessionFactory sessionFactory;

    public void setSessionFactory(SessionFactory sessionFactory) {
        this.sessionFactory = sessionFactory;
    }

    @Transactional
    public void createCategory(Category category) {
        sessionFactory.getCurrentSession().save(category);
    }

    @Transactional
    public Category findCategoryById(int id) {
        Session session = sessionFactory.getCurrentSession();
        Query query = session.createQuery("FROM Category C WHERE C.id = :id");
        query.setParameter("id", id);
        return (Category) query.uniqueResult();
    }

    @Transactional
    public List<Category> getAllCategory() {
        return sessionFactory.getCurrentSession().createQuery("select c from Category c").list();
    }

    @Transactional
    public void deleteCategory(int id) {
        Session session = sessionFactory.getCurrentSession();
        Query query = session.createQuery("delete Category WHERE id = :id");
        query.setParameter("id", id);
        query.executeUpdate();
    }

    @Transactional
    public void updateCategoryTitle(int id, String newCategoryTitle) {
        Session session = sessionFactory.getCurrentSession();
        Query query = session.createQuery("update Category set categoryTitle = :categoryTitle where id = :id");
        query.setParameter("categoryTitle", newCategoryTitle);
        query.setParameter("id", id);
        query.executeUpdate();
    }
}
