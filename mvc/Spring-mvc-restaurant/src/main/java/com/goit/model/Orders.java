package com.goit.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import org.hibernate.annotations.Fetch;
import org.hibernate.annotations.FetchMode;

import javax.persistence.*;
import java.io.Serializable;
import java.sql.Date;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "ORDERS")
public class Orders implements Serializable {

    @javax.persistence.Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "ID")
    private Integer id;

    @ManyToOne
    @JoinColumn(name ="waiter_id")
    private Employee waiter;

    @ManyToOne
    @JoinColumn(name = "DESK_ID")
    private Desk desk;

    @Column(name = "ORDER_DATE")
    private Date orderDate;

    @ManyToMany(fetch = FetchType.EAGER)
    @Fetch(value = FetchMode.SUBSELECT)
    @JoinTable(
            name = "orders_to_dishes",
            joinColumns = @JoinColumn(name = "orderId", referencedColumnName = "id"),
            inverseJoinColumns = @JoinColumn(name = "dishId", referencedColumnName = "id")
    )
    private List<Dish> dishesInOrder = new ArrayList<>();

    public Orders() {}

    public Orders(Employee waiter, Desk desk, Date orderDate, List<Dish> dishesInOrder) {
        this.waiter = waiter;
        this.desk = desk;
        this.orderDate = orderDate;
        this.dishesInOrder = dishesInOrder;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Employee getWaiter() {
        return waiter;
    }

    public void setWaiter(Employee waiter) {
        this.waiter = waiter;
    }

    public Desk getDesk() {
        return desk;
    }

    public void setDesk(Desk desk) {
        this.desk = desk;
    }

    public Date getOrderDate() {
        return orderDate;
    }

    public void setOrderDate(Date orderDate) {
        this.orderDate = orderDate;
    }

    public List<Dish> getDishesInOrder() {
        return dishesInOrder;
    }

    public void setDishesInOrder(List<Dish> dishesInOrder) {
        this.dishesInOrder = dishesInOrder;
    }

    @JsonIgnore
    public boolean isNew() {
        return (this.id == null);
    }

    @Override
    public String toString() {
        return "Orders{" +
                "id=" + id +
                ", waiter=" + waiter +
                ", desk=" + desk +
                ", orderDate=" + orderDate +
                ", dishesInOrder=" + dishesInOrder +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Orders orders = (Orders) o;

        if (waiter != null ? !waiter.equals(orders.waiter) : orders.waiter != null) return false;
        if (desk != null ? !desk.equals(orders.desk) : orders.desk != null) return false;
        if (orderDate != null ? !orderDate.equals(orders.orderDate) : orders.orderDate != null) return false;
        return dishesInOrder != null ? dishesInOrder.equals(orders.dishesInOrder) : orders.dishesInOrder == null;

    }

    @Override
    public int hashCode() {
        int result = waiter != null ? waiter.hashCode() : 0;
        result = 31 * result + (desk != null ? desk.hashCode() : 0);
        result = 31 * result + (orderDate != null ? orderDate.hashCode() : 0);
        result = 31 * result + (dishesInOrder != null ? dishesInOrder.hashCode() : 0);
        return result;
    }
}
