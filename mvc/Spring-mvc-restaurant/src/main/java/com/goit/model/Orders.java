package com.goit.model;

import javax.persistence.*;
import java.io.Serializable;
import java.sql.Timestamp;

@Entity
@Table(name = "ORDERS")
public class Orders implements Serializable {

    @javax.persistence.Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "ID")
    private Integer id;

    @ManyToOne
    @JoinColumn(name = "WAITER_ID")
    private Waiter waiter;

    @ManyToOne
    @JoinColumn(name = "DESK_ID")
    private Desk desk;

    @Column(name = "ORDER_DATE")
    private Timestamp orderDate;

    public Orders() {}

    public Orders(Waiter waiter, Desk desk, Timestamp orderDate) {
        this.waiter = waiter;
        this.desk = desk;
        this.orderDate = orderDate;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Waiter getWaiter() {
        return waiter;
    }

    public void setWaiter(Waiter waiter) {
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

    public boolean isNew() {
        return (this.id == null);
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

}
