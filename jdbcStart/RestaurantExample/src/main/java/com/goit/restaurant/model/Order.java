package com.goit.restaurant.model;

import java.util.Date;

public class Order {

    private int id;
    private int employeeId;
    private int deskId;
    private String orderDate;

    public Order() {
    }

    public Order(int id, int employeeId, int deskId, String orderDate) {
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

    public String getOrderDate() {
        return orderDate;
    }

    public void setOrderDate(String orderDate) {
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
