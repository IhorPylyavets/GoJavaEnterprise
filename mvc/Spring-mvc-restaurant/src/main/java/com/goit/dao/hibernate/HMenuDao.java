package com.goit.dao.hibernate;

import com.goit.dao.MenuDao;
import com.goit.model.Menu;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.query.Query;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

public class HMenuDao implements MenuDao{

    private SessionFactory sessionFactory;

    public void setSessionFactory(SessionFactory sessionFactory) {
        this.sessionFactory = sessionFactory;
    }

    @Transactional
    public void createMenu(Menu menu) {
        sessionFactory.getCurrentSession().persist(menu);
    }

    @Transactional
    public Menu findMenuById(int id) {
        Session session = sessionFactory.getCurrentSession();
        Query query = session.createQuery("FROM Menu P WHERE P.id = :id");
        query.setParameter("id", id);
        return (Menu) query.uniqueResult();
    }

    @Transactional
    public List<Menu> getAllMenu() {
        return sessionFactory.getCurrentSession().createQuery("select m from Menu m").list();
    }

    @Transactional
    public void deleteMenu(int id) {
        Session session = sessionFactory.getCurrentSession();
        Query query = session.createQuery("delete Menu WHERE id = :id");
        query.setParameter("id", id);
        query.executeUpdate();
    }

    @Transactional
    public void updateMenuTitle(int id, String newMenuTitle) {
        Session session = sessionFactory.getCurrentSession();
        Query query = session.createQuery("update Menu set menuTitle = :menuTitle where id = :id");
        query.setParameter("menuTitle", newMenuTitle);
        query.setParameter("id", id);
        query.executeUpdate();
    }
}
