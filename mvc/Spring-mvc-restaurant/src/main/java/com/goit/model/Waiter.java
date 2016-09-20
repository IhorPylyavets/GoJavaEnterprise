package com.goit.model;

import org.hibernate.annotations.Fetch;
import org.hibernate.annotations.FetchMode;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
import java.util.List;

@Entity
public class Waiter extends Employee {

    /*@OneToMany(fetch = FetchType.LAZY)
    @JoinColumn(name = "EMPLOYEE_ID")
    @Fetch(FetchMode.JOIN)
    private List<Orders> orders;

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
        sb.append(" id = ").append(getId()).append("\n");
        sb.append(" name = ").append(getFirstName()).append("\n");
        sb.append(" surname = ").append(getLastName()).append("\n");
        sb.append(" orders = {\n");

        for (Orders currentOrder : orders) {
            sb.append("    ").append(currentOrder).append("\n" );
        }

        sb.append("    }\n");
        sb.append("}\n");

        return sb.toString();
    }*/
}
