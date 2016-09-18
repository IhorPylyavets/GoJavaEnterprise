package com.goit.model;

import javax.persistence.*;
import java.io.Serializable;
import java.sql.Timestamp;

@Entity
@Table(name = "ORDERS")
public class Orders implements Serializable {

    /*@Id
    @GeneratedValue(generator = "increment")
    @GenericGenerator(name = "increment", strategy = "increment")
    @Column(name = "ID")*/
    @javax.persistence.Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "ID")
    private int id;

    @ManyToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "WAITER_ID")
    private Employee waiter;

    @ManyToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "DESK_ID")
    private Desk desk;

    @Column(name = "ORDER_DATE")
    private Timestamp orderDate;

    public Orders() {}

    public Orders(Employee waiter, Desk desk, Timestamp orderDate) {
        this.waiter = waiter;
        this.desk = desk;
        this.orderDate = orderDate;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
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

    public Timestamp getOrderDate() {
        return orderDate;
    }

    public void setOrderDate(Timestamp orderDate) {
        this.orderDate = orderDate;
    }

    @Override
    public String toString() {
        return "Order{" +
                "id=" + id +
                ", waiter=" + waiter +
                ", desk=" + desk +
                ", orderDate=" + orderDate +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Orders orders = (Orders) o;

        if (waiter != null ? !waiter.equals(orders.waiter) : orders.waiter != null) return false;
        if (desk != null ? !desk.equals(orders.desk) : orders.desk != null) return false;
        return orderDate != null ? orderDate.equals(orders.orderDate) : orders.orderDate == null;

    }

    @Override
    public int hashCode() {
        int result = waiter != null ? waiter.hashCode() : 0;
        result = 31 * result + (desk != null ? desk.hashCode() : 0);
        result = 31 * result + (orderDate != null ? orderDate.hashCode() : 0);
        return result;
    }
}
