package com.goit.model;

import com.fasterxml.jackson.annotation.JsonIgnore;

import javax.persistence.*;
import java.io.Serializable;
import java.sql.Date;

@Entity
@Table(name = "DISHES_PREPARATION")
public class DishesPreparation implements Serializable{

    @javax.persistence.Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "ID")
    private Integer id;

    @ManyToOne
    @JoinColumn(name ="cook_id")
    private Employee cook;

    @ManyToOne
    @JoinColumn(name = "dish_id")
    private Dish dish;

    @ManyToOne
    @JoinColumn(name = "order_id")
    private Orders order;

    @Column(name = "ORDER_DATE")
    private Date datePreparation;

    public DishesPreparation() {}

    public DishesPreparation(Employee cook, Dish dish, Orders order, Date datePreparation) {
        this.cook = cook;
        this.dish = dish;
        this.order = order;
        this.datePreparation = datePreparation;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Employee getCook() {
        return cook;
    }

    public void setCook(Employee cook) {
        this.cook = cook;
    }

    public Dish getDish() {
        return dish;
    }

    public void setDish(Dish dish) {
        this.dish = dish;
    }

    public Orders getOrder() {
        return order;
    }

    public void setOrder(Orders order) {
        this.order = order;
    }

    public Date getDatePreparation() {
        return datePreparation;
    }

    public void setDatePreparation(Date datePreparation) {
        this.datePreparation = datePreparation;
    }

    @JsonIgnore
    public boolean isNew() {
        return (this.id == null);
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        DishesPreparation that = (DishesPreparation) o;

        if (cook != null ? !cook.equals(that.cook) : that.cook != null) return false;
        if (dish != null ? !dish.equals(that.dish) : that.dish != null) return false;
        if (order != null ? !order.equals(that.order) : that.order != null) return false;
        return datePreparation != null ? datePreparation.equals(that.datePreparation) : that.datePreparation == null;

    }

    @Override
    public int hashCode() {
        int result = cook != null ? cook.hashCode() : 0;
        result = 31 * result + (dish != null ? dish.hashCode() : 0);
        result = 31 * result + (order != null ? order.hashCode() : 0);
        result = 31 * result + (datePreparation != null ? datePreparation.hashCode() : 0);
        return result;
    }

    @Override
    public String toString() {
        return "DishesPreparation{" +
                "id=" + id +
                ", cook=" + cook +
                ", dish=" + dish +
                ", order=" + order +
                ", datePreparation=" + datePreparation +
                '}';
    }
}
