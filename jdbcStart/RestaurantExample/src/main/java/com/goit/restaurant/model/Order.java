package com.goit.restaurant.model;

import java.sql.Timestamp;

public class Order {

    private int id;
    private int employeeId;
    private int deskId;
    private Timestamp orderDate;

    public Order() {
    }

    public Order(int id, int employeeId, int deskId, Timestamp orderDate) {
        this.id = id;
        this.employeeId = employeeId;
        this.deskId = deskId;
        this.orderDate = orderDate;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getEmployeeId() {
        return employeeId;
    }

    public void setEmployeeId(int employeeId) {
        this.employeeId = employeeId;
    }

    public int getDeskId() {
        return deskId;
    }

    public void setDeskId(int deskId) {
        this.deskId = deskId;
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
                ", employeeId=" + employeeId +
                ", deskId=" + deskId +
                ", orderDate=" + orderDate +
                '}';
    }
}
