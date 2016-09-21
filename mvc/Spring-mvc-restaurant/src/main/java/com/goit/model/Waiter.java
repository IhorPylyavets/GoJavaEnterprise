package com.goit.model;

import org.hibernate.annotations.Fetch;
import org.hibernate.annotations.FetchMode;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.OneToMany;
import java.sql.Date;
import java.util.ArrayList;
import java.util.List;

@Entity
public class Waiter extends Employee {

    @OneToMany(mappedBy = "waiter", fetch = FetchType.EAGER)
    @Fetch(FetchMode.SELECT)
    private List<Orders> orders = new ArrayList<>();

    public Waiter() {}

    public Waiter(String lastName, String firstName, Date birthday, String phone, Position position, float salary, List<Orders> orders) {
        super(lastName, firstName, birthday, phone, position, salary);
        this.orders = orders;
    }

    public List<Orders> getOrders() {
        return orders;
    }

    public void setOrders(List<Orders> orders) {
        this.orders = orders;
    }



    @Override
    public String toString() {
        return "Waiter{" +
                "id= " + getId() +
                "lastName= " + getLastName() +
                "firstName= " + getFirstName() +
                "orders=" + orders +
                '}';
    }

    /*@Override
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
