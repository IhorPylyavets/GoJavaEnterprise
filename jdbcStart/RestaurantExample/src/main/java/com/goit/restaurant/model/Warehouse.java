package com.goit.restaurant.model;

import org.hibernate.annotations.GenericGenerator;

import javax.persistence.*;

@Entity
@Table(name = "WAREHOUSE")
public class Warehouse {

    @Id
    @GeneratedValue(generator = "increment")
    @GenericGenerator(name = "increment", strategy = "increment")
    @Column(name = "ID")
    private int id;

    //@OneToMany
    @JoinColumn(name = "INGREDIENT_ID")
    private int ingredientId;

    @Column(name = "AMOUNT")
    private float amount;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getIngredientId() {
        return ingredientId;
    }

    public void setIngredientId(int ingredientId) {
        this.ingredientId = ingredientId;
    }

    public float getAmount() {
        return amount;
    }

    public void setAmount(float amount) {
        this.amount = amount;
    }

    @Override
    public String toString() {
        return "Warehouse{" +
                "id=" + id +
                ", ingredientId=" + ingredientId +
                ", amount=" + amount +
                '}';
    }
}
