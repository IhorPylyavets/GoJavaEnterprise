package com.goit.dao.hibernate;

import com.goit.dao.DeskDao;
import com.goit.model.Desk;
import com.goit.model.DeskStatus;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.query.Query;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

public class HDeskDao implements DeskDao{

    private SessionFactory sessionFactory;

    public void setSessionFactory(SessionFactory sessionFactory) {
        this.sessionFactory = sessionFactory;
    }

    @Transactional
    public void create(Desk item) {
        sessionFactory.getCurrentSession().saveOrUpdate(item);
    }

    @Transactional
    public Desk findById(int id) {
        Session session = sessionFactory.getCurrentSession();
        Query query = session.createQuery("FROM Desk D WHERE D.id = :id");
        query.setParameter("id", id);
        return (Desk) query.uniqueResult();
    }

    @Transactional
    public Desk findByTitle(String title) {
        Session session = sessionFactory.getCurrentSession();
        Query query = session.createQuery("FROM Desk D WHERE D.deskTitle = :deskTitle");
        query.setParameter("deskTitle", title);
        return (Desk) query.uniqueResult();
    }

    @Transactional
    public List<Desk> getAll() {
        return sessionFactory.getCurrentSession().createQuery("select d from Desk d").list();
    }

    @Transactional
    public void delete(int id) {
        Session session = sessionFactory.getCurrentSession();
        Query query = session.createQuery("delete Desk WHERE id = :id");
        query.setParameter("id", id);
        query.executeUpdate();
    }

    @Transactional
    public void updateTitle(int id, String newTitle) {
        Session session = sessionFactory.getCurrentSession();
        Query query = session.createQuery("update Desk set deskTitle = :deskTitle where id = :id");
        query.setParameter("deskTitle", newTitle);
        query.setParameter("id", id);
        query.executeUpdate();
    }

    @Transactional
    public void updateStatus(int id, DeskStatus deskStatus) {
        Session session = sessionFactory.getCurrentSession();
        Query query = session.createQuery("update Desk set deskStatus = :deskStatus where id = :id");
        query.setParameter("deskStatus", deskStatus);
        query.setParameter("id", id);
        query.executeUpdate();
    }
}
