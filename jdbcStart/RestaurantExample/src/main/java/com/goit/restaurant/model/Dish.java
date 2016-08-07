package com.goit.restaurant.model;

public class Dish {

    private int id;
    private String dishTitle;
    private int categoryId;
    private float price;
    private float weight;

    public Dish() {
    }

    public Dish(int id, String dishTitle, int categoryId, float price, float weight) {
        this.id = id;
        this.dishTitle = dishTitle;
        this.categoryId = categoryId;
        this.price = price;
        this.weight = weight;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getDishTitle() {
        return dishTitle;
    }

    public void setDishTitle(String dishTitle) {
        this.dishTitle = dishTitle;
    }

    public int getCategoryId() {
        return categoryId;
    }

    public void setCategoryId(int categoryId) {
        this.categoryId = categoryId;
    }

    public float getPrice() {
        return price;
    }

    public void setPrice(float price) {
        this.price = price;
    }

    public float getWeight() {
        return weight;
    }

    public void setWeight(float weight) {
        this.weight = weight;
    }

    @Override
    public String toString() {
        return "Dish{" +
                "id=" + id +
                ", dishTitle='" + dishTitle + '\'' +
                ", categoryId=" + categoryId +
                ", price=" + price +
                ", weight=" + weight +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Dish dish = (Dish) o;

        if (categoryId != dish.categoryId) return false;
        if (Float.compare(dish.price, price) != 0) return false;
        if (Float.compare(dish.weight, weight) != 0) return false;
        return dishTitle != null ? dishTitle.equals(dish.dishTitle) : dish.dishTitle == null;

    }

    @Override
    public int hashCode() {
        int result = dishTitle != null ? dishTitle.hashCode() : 0;
        result = 31 * result + categoryId;
        result = 31 * result + (price != +0.0f ? Float.floatToIntBits(price) : 0);
        result = 31 * result + (weight != +0.0f ? Float.floatToIntBits(weight) : 0);
        return result;
    }
}
