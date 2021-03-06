package com.goit.restaurant.dao.hibernate;

import com.goit.restaurant.dao.EmployeeDao;
import com.goit.restaurant.model.Employee;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.query.Query;
import org.springframework.transaction.annotation.Transactional;

import java.sql.Date;
import java.util.List;


/*CREATE TABLE EMPLOYEES (
        ID SERIAL PRIMARY KEY,
        LAST_NAME TEXT NOT NULL,
        FIRST_NAME TEXT NOT NULL,
        BIRTHDAY TEXT,
        PHONE TEXT,
        POSITION_ID int NOT NULL,
        SALARY real
        );*/
public class HEmployeeDao implements EmployeeDao{

    private SessionFactory sessionFactory;

    @Override
    @Transactional
    public void createEmployee(Employee employee) {
        sessionFactory.getCurrentSession().save(employee);
    }

    @Override
    @Transactional
    public Employee findEmployeeById(int id) {
        Session session = sessionFactory.getCurrentSession();
        Query query = session.createQuery("FROM Employee E WHERE E.id = :id");
        query.setParameter("id", id);
        return (Employee) query.uniqueResult();
    }

    @Override
    @Transactional
    public List<Employee> getAllEmployees() {
        return sessionFactory.getCurrentSession().createQuery("select e from Employee e").list();
    }

    @Override
    @Transactional
    public void deleteEmployee(int id) {
        Session session = sessionFactory.getCurrentSession();
        Query query = session.createQuery("delete Employee WHERE id = :id");
        query.setParameter("id", id);
        query.executeUpdate();
    }

    @Override
    @Transactional
    public void updateEmployeeLastName(int id, String newEmployeeLastName) {
        Session session = sessionFactory.getCurrentSession();
        Query query = session.createQuery("update Employee set lastName = :lastName where id = :id");
        query.setParameter("lastName", newEmployeeLastName);
        query.setParameter("id", id);
        query.executeUpdate();
    }

    @Override
    @Transactional
    public void updateEmployeeFirstName(int id, String newEmployeeFirstName) {
        Session session = sessionFactory.getCurrentSession();
        Query query = session.createQuery("update Employee set firstName = :firstName where id = :id");
        query.setParameter("firstName", newEmployeeFirstName);
        query.setParameter("id", id);
        query.executeUpdate();
    }

    @Override
    @Transactional
    public void updateEmployeeBirthday(int id, Date newEmployeeBirthday) {
        Session session = sessionFactory.getCurrentSession();
        Query query = session.createQuery("update Employee set birthday = :birthday where id = :id");
        query.setParameter("birthday", newEmployeeBirthday);
        query.setParameter("id", id);
        query.executeUpdate();
    }

    @Override
    @Transactional
    public void updateEmployeePhone(int id, String newEmployeePhone) {
        Session session = sessionFactory.getCurrentSession();
        Query query = session.createQuery("update Employee set phone = :phone where id = :id");
        query.setParameter("phone", newEmployeePhone);
        query.setParameter("id", id);
        query.executeUpdate();
    }

    @Override
    @Transactional
    public void updateEmployeePositionId(int id, int newPositionId) {
        Session session = sessionFactory.getCurrentSession();
        Query query = session.createQuery("update Employee set positionId = :positionId where id = :id");
        query.setParameter("positionId", newPositionId);
        query.setParameter("id", id);
        query.executeUpdate();
    }

    @Override
    @Transactional
    public void updateEmployeeSalary(int id, float newEmployeeSalary) {
        Session session = sessionFactory.getCurrentSession();
        Query query = session.createQuery("update Employee set salary = :salary where id = :id");
        query.setParameter("salary", newEmployeeSalary);
        query.setParameter("id", id);
        query.executeUpdate();
    }

    public void setSessionFactory(SessionFactory sessionFactory) {
        this.sessionFactory = sessionFactory;
    }
}
