package com.goit.model;

import org.hibernate.annotations.Fetch;
import org.hibernate.annotations.FetchMode;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
import java.util.List;

@Entity
public class Cook extends Employee {

    @OneToMany(fetch = FetchType.EAGER)
    @JoinColumn(name = "cook_id")
    @Fetch(FetchMode.SELECT)
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
        sb.append("Cook {\n");
        sb.append("  ID = {\n").append(getId()).append("\n");
        sb.append("  lastName = {\n").append(getLastName()).append("\n");
        sb.append("  firstName = {\n").append(getFirstName()).append("\n");
        sb.append("  birthday = {\n").append(getBirthday()).append("\n");
        sb.append("  phone = {\n").append(getPhone()).append("\n");
        sb.append("  salary = {\n").append(getSalary()).append("\n");
        dishesPreparationList.forEach(dishesPreparation -> sb.append("    ").append(dishesPreparation).append("\n"));
        sb.append("  }\n");
        sb.append("}\n");
        return sb.toString();
    }

}
