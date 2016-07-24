package com.goit.restaurant.model;

public class Stock {

    private int id;
    private int ingredientId;
    private int amount;

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
        return "Stock{" +
                "id=" + id +
                ", ingredientId=" + ingredientId +
                ", amount=" + amount +
                '}';
    }

    @Override
    public boolean equals(Object obj) {
        Stock o = (Stock) obj;

        return ((o.getIngredientId() == getIngredientId()) &&
                (o.getAmount() == getAmount()));
    }
}
