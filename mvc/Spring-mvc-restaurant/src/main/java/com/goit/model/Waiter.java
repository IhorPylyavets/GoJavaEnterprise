package com.goit.model;

import org.hibernate.annotations.Fetch;
import org.hibernate.annotations.FetchMode;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
import java.sql.Date;
import java.util.ArrayList;
import java.util.List;

@Entity
public class Waiter extends Employee {

    @OneToMany(fetch = FetchType.EAGER)
    @JoinColumn(name = "waiter_id")
    @Fetch(FetchMode.SELECT)
    private List<Orders> orders = new ArrayList<>();

    public List<Orders> getOrders() {
        return orders;
    }

    public void setOrders(List<Orders> orders) {
        this.orders = orders;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("Waiter {\n");
        sb.append("  ID = {\n").append(getId()).append("\n");
        sb.append("  lastName = {\n").append(getLastName()).append("\n");
        sb.append("  firstName = {\n").append(getFirstName()).append("\n");
        sb.append("  birthday = {\n").append(getBirthday()).append("\n");
        sb.append("  phone = {\n").append(getPhone()).append("\n");
        sb.append("  salary = {\n").append(getSalary()).append("\n");
        orders.forEach(order -> sb.append("    ").append(order).append("\n"));
        sb.append("  }\n");
        sb.append("}\n");
        return sb.toString();
    }
}
