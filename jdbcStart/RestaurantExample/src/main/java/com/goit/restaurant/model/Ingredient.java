package com.goit.restaurant.model;

public class Ingredient {

    private int id;
    private String ingredientTitle;

    public Ingredient() {
    }

    public Ingredient(int id, String ingredientTitle) {
        this.id = id;
        this.ingredientTitle = ingredientTitle;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getIngredientTitle() {
        return ingredientTitle;
    }

    public void setIngredientTitle(String ingredientTitle) {
        this.ingredientTitle = ingredientTitle;
    }

    @Override
    public String toString() {
        return "Ingredient{" +
                "id=" + id +
                ", ingredientTitle='" + ingredientTitle + '\'' +
                '}';
    }
}
