package com.goit.restaurant.dao.hibernate;

import com.goit.restaurant.dao.PositionDao;
import com.goit.restaurant.model.Position;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.query.Query;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

public class HPositionDao implements PositionDao{

    private SessionFactory sessionFactory;

    @Override
    @Transactional
    public void createPosition(Position position) {
        sessionFactory.getCurrentSession().save(position);
    }

    @Override
    @Transactional
    public Position findPositionById(int id) {
        Session session = sessionFactory.getCurrentSession();
        Query query = session.createQuery("FROM Position P WHERE P.id = :id");
        query.setParameter("id", id);
        return (Position) query.uniqueResult();

    }

    @Override
    @Transactional
    public List<Position> getAllPosition() {
        return sessionFactory.getCurrentSession().createQuery("select p from Position p").list();
    }

    @Override
    @Transactional
    public void deletePosition(int id) {
        Session session = sessionFactory.getCurrentSession();
        Query query = session.createQuery("delete Position WHERE id = :id");
        query.setParameter("id", id);
        query.executeUpdate();

    }

    @Override
    @Transactional
    public void updatePositionTitle(int id, String newTitle) {
        Session session = sessionFactory.getCurrentSession();
        Query query = session.createQuery("update Position set positionTitle = :positionTitle where id = :id");
        query.setParameter("positionTitle", newTitle);
        query.setParameter("id", id);
        query.executeUpdate();
    }

    public void setSessionFactory(SessionFactory sessionFactory) {
        this.sessionFactory = sessionFactory;
    }
}
