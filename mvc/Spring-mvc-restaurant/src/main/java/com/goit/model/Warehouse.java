package com.goit.model;

import javax.persistence.*;
import java.io.Serializable;

@Entity
@Table(name = "WAREHOUSE")
@Inheritance(strategy = InheritanceType.SINGLE_TABLE)
public class Warehouse implements Serializable{

    @javax.persistence.Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "ID")
    private Integer id;

    @ManyToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "INGREDIENT_ID")
    private Ingredient ingredient;

    @Column(name = "AMOUNT")
    private float amount;

    public Warehouse() {
    }

    public Warehouse(Ingredient ingredient, float amount) {
        this.ingredient = ingredient;
        this.amount = amount;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
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

    public boolean isNew() {
        return (this.id == null);
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
