package com.goit.model;

import org.hibernate.annotations.GenericGenerator;

import javax.persistence.*;
import java.sql.Timestamp;

@Entity
@Table(name = "DISHES_PREPARATION")
public class DishesPreparation {

    @Id
    @GeneratedValue(generator = "increment")
    @GenericGenerator(name = "increment", strategy = "increment")
    @Column(name = "ID")
    private int id;

    @ManyToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "DISHES_ID")
    private Dish dish;

    @ManyToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "EMPLOYEE_ID")
    private Employee employee;

    @ManyToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "ORDER_ID")
    private Orders order;

    @Column(name = "ORDER_DATE")
    private Timestamp datePreparation;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public Dish getDish() {
        return dish;
    }

    public void setDish(Dish dish) {
        this.dish = dish;
    }

    public Employee getEmployee() {
        return employee;
    }

    public void setEmployee(Employee employee) {
        this.employee = employee;
    }

    public Orders getOrder() {
        return order;
    }

    public void setOrder(Orders order) {
        this.order = order;
    }

    public Timestamp getDatePreparation() {
        return datePreparation;
    }

    public void setDatePreparation(Timestamp datePreparation) {
        this.datePreparation = datePreparation;
    }

    @Override
    public String toString() {
        return "DishesPreparation{" +
                "id=" + id +
                ", dish=" + dish +
                ", employee=" + employee +
                ", order=" + order +
                ", datePreparation=" + datePreparation +
                '}';
    }
}
