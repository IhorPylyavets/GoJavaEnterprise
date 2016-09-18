package com.goit.model;

import javax.persistence.*;
import java.io.Serializable;
import java.sql.Timestamp;

@Entity
@Table(name = "DISHES_PREPARATION")
public class DishesPreparation implements Serializable{

    /*@Id
    @GeneratedValue(generator = "increment")
    @GenericGenerator(name = "increment", strategy = "increment")
    @Column(name = "ID")*/
    @javax.persistence.Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "ID")
    private int id;

    @ManyToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "DISHES_ID")
    private Dish dish;

    @ManyToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "EMPLOYEE_ID")
    private Employee cook;

    @ManyToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "ORDER_ID")
    private Orders orderValue;

    @Column(name = "ORDER_DATE")
    private Timestamp datePreparation;

    public DishesPreparation() {}

    public DishesPreparation(Dish dish, Employee cook, Orders orderValue, Timestamp datePreparation) {
        this.dish = dish;
        this.cook = cook;
        this.orderValue = orderValue;
        this.datePreparation = datePreparation;
    }

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

    public Employee getCook() {
        return cook;
    }

    public void setCook(Employee cook) {
        this.cook = cook;
    }

    public Orders getOrderValue() {
        return orderValue;
    }

    public void setOrderValue(Orders orderValue) {
        this.orderValue = orderValue;
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
                ", cook=" + cook +
                ", order=" + orderValue +
                ", datePreparation=" + datePreparation +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        DishesPreparation that = (DishesPreparation) o;

        if (dish != null ? !dish.equals(that.dish) : that.dish != null) return false;
        if (cook != null ? !cook.equals(that.cook) : that.cook != null) return false;
        if (orderValue != null ? !orderValue.equals(that.orderValue) : that.orderValue != null) return false;
        return datePreparation != null ? datePreparation.equals(that.datePreparation) : that.datePreparation == null;

    }

    @Override
    public int hashCode() {
        int result = dish != null ? dish.hashCode() : 0;
        result = 31 * result + (cook != null ? cook.hashCode() : 0);
        result = 31 * result + (orderValue != null ? orderValue.hashCode() : 0);
        result = 31 * result + (datePreparation != null ? datePreparation.hashCode() : 0);
        return result;
    }
}
