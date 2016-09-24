package com.goit.dao.hibernate;

import com.goit.dao.EmployeeDao;
import com.goit.model.Employee;
import com.goit.model.Position;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.transaction.annotation.Transactional;

import javax.persistence.criteria.*;
import java.sql.Date;
import java.util.List;

public class HEmployeeDao implements EmployeeDao {

    private static final String ID = "id";
    private static final String POSITION = "position";
    private static final String LAST_NAME = "lastName";
    private static final String FIRST_NAME = "firstName";
    private static final String BIRTHDAY = "birthday";
    private static final String PHONE = "phone";
    private static final String SALARY = "salary";

    private SessionFactory sessionFactory;

    @Transactional
    public void createEmployee(Employee employee) {
        sessionFactory.getCurrentSession().saveOrUpdate(employee);
    }

    @Transactional
    public Employee findEmployeeById(int id) {
        Session session = sessionFactory.getCurrentSession();
        CriteriaBuilder criteriaBuilder = session.getCriteriaBuilder();
        CriteriaQuery<Employee> criteriaQuery = criteriaBuilder.createQuery(Employee.class);
        Root<Employee> employeeRoot = criteriaQuery.from(Employee.class);
        Predicate condition = criteriaBuilder.equal(employeeRoot.get(ID), id);
        criteriaQuery.where(condition);
        return (Employee) session.createQuery(criteriaQuery).getSingleResult();
        /*Session session = sessionFactory.getCurrentSession();
        Query query = session.createQuery("FROM Employee E WHERE E.id = :id");
        query.setParameter("id", id);
        return (Employee) query.uniqueResult();*/
        /*Employee employee = sessionFactory.getCurrentSession().get(Employee.class, id);
        if (employee == null)
            throw new RuntimeException("Can't find Employee by id = " + id);
        return employee;*/
    }

    @Transactional
    public List<Employee> findEmployeeByName(String lastName) {
        Session session = sessionFactory.getCurrentSession();
        CriteriaBuilder criteriaBuilder = session.getCriteriaBuilder();
        CriteriaQuery<Employee> criteriaQuery = criteriaBuilder.createQuery(Employee.class);
        Root<Employee> employeeRoot = criteriaQuery.from(Employee.class);
        Predicate condition = criteriaBuilder.equal(employeeRoot.get(LAST_NAME), lastName);
        criteriaQuery.where(condition);
        return session.createQuery(criteriaQuery).getResultList();
    }

    @Transactional
    public Employee findEmployeeByFullName(String lastName, String firstName) {
        Session session = sessionFactory.getCurrentSession();
        CriteriaBuilder criteriaBuilder = session.getCriteriaBuilder();
        CriteriaQuery<Employee> criteriaQuery = criteriaBuilder.createQuery(Employee.class);
        Root<Employee> employeeRoot = criteriaQuery.from(Employee.class);
        Predicate conditionLastName = criteriaBuilder.equal(employeeRoot.get(LAST_NAME), lastName);
        Predicate conditionFirstName = criteriaBuilder.equal(employeeRoot.get(FIRST_NAME), firstName);
        Predicate mainCondition = criteriaBuilder.and(conditionLastName, conditionFirstName);
        criteriaQuery.where(mainCondition);
        return (Employee) session.createQuery(criteriaQuery).getSingleResult();
        /*Session session = sessionFactory.getCurrentSession();
        Query query = session.createQuery("select e from Employee e WHERE e.lastName = :lastName AND e.firstName = :firstName");
        query.setParameter("lastName", lastName);
        query.setParameter("firstName", firstName);
        return (Employee) query.uniqueResult();*/
    }

    @Transactional
    public List<Employee> getAllEmployees() {
        Session session = sessionFactory.getCurrentSession();
        CriteriaBuilder criteriaBuilder = session.getCriteriaBuilder();
        CriteriaQuery<Employee> criteriaQuery = criteriaBuilder.createQuery(Employee.class);
        Root<Employee> employeeRoot = criteriaQuery.from(Employee.class);
        criteriaQuery.select(employeeRoot);
        return session.createQuery(criteriaQuery).getResultList();
        //return sessionFactory.getCurrentSession().createQuery("select e from Employee e").list();
    }

    @Transactional
    public List<Employee> getAllEmployeesByPosition(Position position) {
        Session session = sessionFactory.getCurrentSession();
        CriteriaBuilder criteriaBuilder = session.getCriteriaBuilder();
        CriteriaQuery<Employee> criteriaQuery = criteriaBuilder.createQuery(Employee.class);
        Root<Employee> employeeRoot = criteriaQuery.from(Employee.class);
        Predicate condition = criteriaBuilder.equal(employeeRoot.get(POSITION), position);
        criteriaQuery.where(condition);
        return session.createQuery(criteriaQuery).getResultList();
        /*return sessionFactory.getCurrentSession()
                .createQuery("select e from Employee e WHERE e.position = :position")
                .setParameter("position", position)
                .list();*/
    }

    @Transactional
    public void deleteEmployee(int id) {
        Session session = sessionFactory.getCurrentSession();
        CriteriaBuilder criteriaBuilder = session.getCriteriaBuilder();
        CriteriaDelete<Employee> delete = criteriaBuilder.createCriteriaDelete(Employee.class);
        Root employeeRoot = delete.from(Employee.class);
        delete.where(criteriaBuilder.equal(employeeRoot.get(ID), id));
        session.createQuery(delete).executeUpdate();
        /*Session session = sessionFactory.getCurrentSession();
        Query query = session.createQuery("delete Employee WHERE id = :id");
        query.setParameter("id", id);
        query.executeUpdate();*/
    }

    @Transactional
    public void updateEmployeeLastName(int id, String newEmployeeLastName) {
        updateEmployeeFieldById(id, LAST_NAME, newEmployeeLastName);
        /*Session session = sessionFactory.getCurrentSession();
        Query query = session.createQuery("update Employee set lastName = :lastName where id = :id");
        query.setParameter("lastName", newEmployeeLastName);
        query.setParameter("id", id);
        query.executeUpdate();*/
    }

    @Transactional
    public void updateEmployeeFirstName(int id, String newEmployeeFirstName) {
        updateEmployeeFieldById(id, FIRST_NAME, newEmployeeFirstName);
        /*Session session = sessionFactory.getCurrentSession();
        Query query = session.createQuery("update Employee set firstName = :firstName where id = :id");
        query.setParameter("firstName", newEmployeeFirstName);
        query.setParameter("id", id);
        query.executeUpdate();*/
    }

    @Transactional
    public void updateEmployeeBirthday(int id, Date newEmployeeBirthday) {
        Session session = sessionFactory.getCurrentSession();
        CriteriaBuilder criteriaBuilder = session.getCriteriaBuilder();
        CriteriaUpdate<Employee> updateBirthday = criteriaBuilder.createCriteriaUpdate(Employee.class);
        Root employeeRoot = updateBirthday.from(Employee.class);
        Predicate condition = criteriaBuilder.equal(employeeRoot.get(ID), id);
        updateBirthday.set(BIRTHDAY, newEmployeeBirthday);
        updateBirthday.where(condition);
        session.createQuery(updateBirthday).executeUpdate();
        /*Session session = sessionFactory.getCurrentSession();
        Query query = session.createQuery("update Employee set birthday = :birthday where id = :id");
        query.setParameter("birthday", newEmployeeBirthday);
        query.setParameter("id", id);
        query.executeUpdate();*/
    }

    @Transactional
    public void updateEmployeePhone(int id, String newEmployeePhone) {
        updateEmployeeFieldById(id, PHONE, newEmployeePhone);
        /*Session session = sessionFactory.getCurrentSession();
        Query query = session.createQuery("update Employee set phone = :phone where id = :id");
        query.setParameter("phone", newEmployeePhone);
        query.setParameter("id", id);
        query.executeUpdate();*/
    }

    @Transactional
    public void updateEmployeePositionId(int id, Position newPosition) {
        Session session = sessionFactory.getCurrentSession();
        CriteriaBuilder criteriaBuilder = session.getCriteriaBuilder();
        CriteriaUpdate<Employee> updatePosition = criteriaBuilder.createCriteriaUpdate(Employee.class);
        Root employeeRoot = updatePosition.from(Employee.class);
        Predicate condition = criteriaBuilder.equal(employeeRoot.get(ID), id);
        updatePosition.set(POSITION, newPosition);
        updatePosition.where(condition);
        session.createQuery(updatePosition).executeUpdate();

        /*Session session = sessionFactory.getCurrentSession();
        Query query = session.createQuery("update Employee set position = :position where id = :id");
        query.setParameter("position", newPosition);
        query.setParameter("id", id);
        query.executeUpdate();*/
    }

    @Transactional
    public void updateEmployeeSalary(int id, float newEmployeeSalary) {
        Session session = sessionFactory.getCurrentSession();
        CriteriaBuilder criteriaBuilder = session.getCriteriaBuilder();
        CriteriaUpdate<Employee> updateSalary = criteriaBuilder.createCriteriaUpdate(Employee.class);
        Root employeeRoot = updateSalary.from(Employee.class);
        Predicate condition = criteriaBuilder.equal(employeeRoot.get(ID), id);
        updateSalary.set(SALARY, newEmployeeSalary);
        updateSalary.where(condition);
        session.createQuery(updateSalary).executeUpdate();
        /*Session session = sessionFactory.getCurrentSession();
        Query query = session.createQuery("update Employee set salary = :salary where id = :id");
        query.setParameter("salary", newEmployeeSalary);
        query.setParameter("id", id);
        query.executeUpdate();*/
    }

    public void setSessionFactory(SessionFactory sessionFactory) {
        this.sessionFactory = sessionFactory;
    }

    private void updateEmployeeFieldById(int id, String fieldTitle, String newValue) {
        Session session = sessionFactory.getCurrentSession();
        CriteriaBuilder criteriaBuilder = session.getCriteriaBuilder();
        CriteriaUpdate<Employee> update = criteriaBuilder.createCriteriaUpdate(Employee.class);
        Root employeeRoot = update.from(Employee.class);
        Predicate condition = criteriaBuilder.equal(employeeRoot.get(ID), id);
        update.set(fieldTitle, newValue);
        update.where(condition);
        session.createQuery(update).executeUpdate();
    }

}
