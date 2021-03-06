package com.goit.restaurant.model;

import java.sql.Timestamp;

public class DishesPreparation {

    private int id;
    private int dishesId;
    private int employeeId;
    private int orderId;
    private Timestamp date;

    public DishesPreparation() {
    }

    public DishesPreparation(int id, int dishesId, int employeeId, int orderId, Timestamp date) {
        this.id = id;
        this.dishesId = dishesId;
        this.employeeId = employeeId;
        this.orderId = orderId;
        this.date = date;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getDishesId() {
        return dishesId;
    }

    public void setDishesId(int dishesId) {
        this.dishesId = dishesId;
    }

    public int getEmployeeId() {
        return employeeId;
    }

    public void setEmployeeId(int employeeId) {
        this.employeeId = employeeId;
    }

    public int getOrderId() {
        return orderId;
    }

    public void setOrderId(int orderId) {
        this.orderId = orderId;
    }

    public Timestamp getDate() {
        return date;
    }

    public void setDate(Timestamp date) {
        this.date = date;
    }

    @Override
    public String toString() {
        return "DishesPreparation{" +
                "id=" + id +
                ", dishesId=" + dishesId +
                ", employeeId=" + employeeId +
                ", orderId=" + orderId +
                ", date='" + date + '\'' +
                '}';
    }
}
