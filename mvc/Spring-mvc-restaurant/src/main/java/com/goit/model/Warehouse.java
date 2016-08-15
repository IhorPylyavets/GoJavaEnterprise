package com.goit.model;

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

    @ManyToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "INGREDIENT_ID")
    private Ingredient ingredient;

    @Column(name = "AMOUNT")
    private float amount;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public Ingredient getIngredient() {
        return ingredient;
    }

    public void setIngredient(Ingredient ingredient) {
        this.ingredient = ingredient;
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
                ", ingredient=" + ingredient +
                ", amount=" + amount +
                '}';
    }
}
