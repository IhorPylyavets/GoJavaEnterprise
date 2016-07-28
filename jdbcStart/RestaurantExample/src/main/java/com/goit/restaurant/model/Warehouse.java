package com.goit.restaurant.model;

public class Warehouse {

    private int id;
    private int ingredientId;
    private int amount;

    public Warehouse() {
    }

    public Warehouse(int id, int ingredientId, int amount) {
        this.id = id;
        this.ingredientId = ingredientId;
        this.amount = amount;
    }

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

    public int getAmount() {
        return amount;
    }

    public void setAmount(int amount) {
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
