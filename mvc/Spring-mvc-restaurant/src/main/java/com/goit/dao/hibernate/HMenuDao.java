package com.goit.dao.hibernate;

import com.goit.dao.MenuDao;
import com.goit.model.Dish;
import com.goit.model.Menu;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.query.Query;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.List;

public class HMenuDao implements MenuDao {

    private SessionFactory sessionFactory;

    public void setSessionFactory(SessionFactory sessionFactory) {
        this.sessionFactory = sessionFactory;
    }

    @Override
    @Transactional
    public void createMenu(Menu menu) {
        sessionFactory.getCurrentSession().saveOrUpdate(menu);
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
    public Menu findMenuByTitle(String menuTitle) {
        Session session = sessionFactory.getCurrentSession();
        Query query = session.createQuery("FROM Menu P WHERE P.menuTitle = :menuTitle");
        query.setParameter("menuTitle", menuTitle);
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

    @Override
    @Transactional
    public List<Dish> getAllDishByMenuId(int id) {
        Query query = sessionFactory.getCurrentSession().createQuery(
                "FROM Menu as m LEFT JOIN FETCH m.dishes WHERE d.id =" + id);
        Menu menu = (Menu) query.uniqueResult();

        return new ArrayList<Dish>(menu.getDishesInMenu());
    }

    @Override
    @Transactional
    public void updateMenuDishes(int id, List<Dish> newDishes) {
        // !!! not work

        /*Session session = sessionFactory.getCurrentSession();
        Query query = session.createQuery("update Menu set dishesInMenu = :dishesInMenu where id = :id");
        query.setParameter("dishesInMenu", newDishes);
        query.setParameter("id", id);
        query.executeUpdate();*/
    }

}
