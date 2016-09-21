/*
package com.goit.dao.hibernate;


import com.goit.dao.PositionDao;
import com.goit.dao.WaiterDao;
import com.goit.model.Employee;
import com.goit.model.Waiter;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.transaction.annotation.Transactional;

import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Predicate;
import javax.persistence.criteria.Root;
import java.util.List;

public class HWaiterDao extends HEmployeeDao implements WaiterDao {

    private static final String POSITION = "position";
    private static final String WAITER_TITLE = "waiter";

    private SessionFactory sessionFactory;
    private PositionDao positionDao;

    @Transactional
    public Waiter findEmployeeById(int id) {
        Session session = sessionFactory.getCurrentSession();
        CriteriaBuilder criteriaBuilder = session.getCriteriaBuilder();
        CriteriaQuery<Waiter> criteriaQuery = criteriaBuilder.createQuery(Waiter.class);
        Root<Waiter> employeeRoot = criteriaQuery.from(Waiter.class);
        Predicate condition = criteriaBuilder.equal(employeeRoot.get("id"), id);
        criteriaQuery.where(condition);
        return session.createQuery(criteriaQuery).getSingleResult();
    }

    @Transactional
    public List<Waiter> getAllWaiters() {
        Session session = sessionFactory.getCurrentSession();
        CriteriaBuilder criteriaBuilder = session.getCriteriaBuilder();
        CriteriaQuery<Employee> criteriaQuery = criteriaBuilder.createQuery(Employee.class);
        Root<Employee> employeeRoot = criteriaQuery.from(Employee.class);
        Predicate condition = criteriaBuilder.equal(employeeRoot.get(POSITION), positionDao.findByTitle(WAITER_TITLE));
        criteriaQuery.where(condition);
        return session.createQuery(criteriaQuery).getResultList();
    }

    public void setSessionFactory(SessionFactory sessionFactory) {
        this.sessionFactory = sessionFactory;
    }

    public void setPositionDao(PositionDao positionDao) {
        this.positionDao = positionDao;
    }

}
*/
