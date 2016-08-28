package com.example.dao.hibernate;

import com.example.model.Employee;
import com.example.dao.EmployeeDao;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.query.Query;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

public class HEmployeeDao implements EmployeeDao {

    private SessionFactory sessionFactory;

    @Override
    @Transactional
    public void save( Employee employee) {
        sessionFactory.getCurrentSession().save(employee);
    }

    @Override
    public Employee getEmployeeById(Long id) {
        /*Session session = sessionFactory.getCurrentSession();
        Query query = session.createQuery("FROM Employee  C WHERE C.id = :id");
        query.setParameter("id", id);
        return (Employee) query.uniqueResult();*/
        return sessionFactory.getCurrentSession().load(Employee.class, id);
    }

    @Override
    public List<Employee> findAllEmployee() {
        return sessionFactory.getCurrentSession().createQuery("select e from Employee e").list();
    }

    @Override
    public Employee findByName(String name) {
        Session session = sessionFactory.getCurrentSession();
        Query query = session.createQuery("select e from Employee e where e.name like :name");
        query.setParameter("name", name);
        return (Employee) query.uniqueResult();
    }

    @Override
    public void remove(Employee employee) {
        sessionFactory.getCurrentSession().delete(employee );
    }

    @Override
    public void removeAll() {
        sessionFactory.getCurrentSession().createQuery("delete from Employee").executeUpdate();
    }

    public void setSessionFactory(SessionFactory sessionFactory) {
        this.sessionFactory = sessionFactory;
    }

}
