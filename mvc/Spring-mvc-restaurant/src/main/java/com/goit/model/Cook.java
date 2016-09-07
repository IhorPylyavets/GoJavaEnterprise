package com.goit.model;

import org.hibernate.annotations.Fetch;
import org.hibernate.annotations.FetchMode;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
import java.util.List;

@Entity
public class Cook extends Employee{

    @OneToMany(fetch = FetchType.LAZY)
    @JoinColumn(name = "EMPLOYEE_ID")
    @Fetch(FetchMode.JOIN)
    private List<DishesPreparation> dishesPreparationList;

    public List<DishesPreparation> getDishesPreparationList() {
        return dishesPreparationList;
    }

    public void setDishesPreparationList(List<DishesPreparation> dishesPreparationList) {
        this.dishesPreparationList = dishesPreparationList;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("Waiter {\n");
        sb.append(" id = ").append(getId()).append("\n");
        sb.append(" name = ").append(getFirstName()).append("\n");
        sb.append(" surname = ").append(getLastName()).append("\n");
        sb.append(" orders = {\n");

        for (DishesPreparation preparation : dishesPreparationList) {
            sb.append("    ").append(preparation).append("\n" );
        }

        //dishesPreparationList.forEach(order -> sb.append("    ").append(order).append("\n" ));
        sb.append("    }\n");
        sb.append("}\n");

        return sb.toString();
    }

}
