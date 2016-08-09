package com.goit.restaurant.dao.hibernate;

import com.goit.restaurant.dao.MenuDao;
import com.goit.restaurant.model.Menu;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.query.Query;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

public class HMenuDao implements MenuDao{

    private SessionFactory sessionFactory;

    @Override
    @Transactional
    public void createMenu(Menu menu) {
        sessionFactory.getCurrentSession().save(menu);
    }

    @Override
    @Transactional
    public Menu findMenuById(int id) {
        Session session = sessionFactory.getCurrentSession();
        Query query = session.createQuery("FROM Menu P WHERE P.id = :id");
        query.setParameter("id", id);
        return (Menu) query.uniqueResult();
    }

    @Override
    @Transactional
    public List<Menu> getAllMenu() {
        return sessionFactory.getCurrentSession().createQuery("select m from Menu m").list();
    }

    @Override
    @Transactional
    public void deleteMenu(int id) {
        Session session = sessionFactory.getCurrentSession();
        Query query = session.createQuery("delete Menu WHERE id = :id");
        query.setParameter("id", id);
        query.executeUpdate();
    }

    @Override
    @Transactional
    public void updateMenuTitle(int id, String newMenuTitle) {
        Session session = sessionFactory.getCurrentSession();
        Query query = session.createQuery("update Menu set menuTitle = :menuTitle where id = :id");
        query.setParameter("menuTitle", newMenuTitle);
        query.setParameter("id", id);
        query.executeUpdate();
    }

    public void setSessionFactory(SessionFactory sessionFactory) {
        this.sessionFactory = sessionFactory;
    }
}
