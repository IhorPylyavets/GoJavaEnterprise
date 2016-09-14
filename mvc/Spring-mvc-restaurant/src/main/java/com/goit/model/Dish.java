package com.goit.model;

import javax.persistence.*;
import java.io.Serializable;
import java.util.List;

@Entity
@Table(name = "DISHES")
//@Inheritance(strategy = InheritanceType.SINGLE_TABLE)
public class Dish implements Serializable {

    //@javax.persistence.Id
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "ID")
    private int id;

    @Column(name = "DISH_TITLE")
    private String dishTitle;

    @ManyToMany(fetch = FetchType.EAGER)
    @JoinTable(
            name = "dishes_to_ingredients",
            joinColumns = @JoinColumn(name = "dishId", referencedColumnName = "id"),
            inverseJoinColumns = @JoinColumn(name = "ingredientId", referencedColumnName = "id")
    )
    private List<Ingredient> ingredients;

    @ManyToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "CATEGORY_ID")
    private Category category;

    @Column(name = "PRICE")
    private float price;

    @Column(name = "WEIGHT")
    private float weight;

    public Dish() {
    }

    public Dish(String dishTitle, List<Ingredient> ingredients, Category category, float price, float weight) {
        this.dishTitle = dishTitle;
        this.ingredients = ingredients;
        this.category = category;
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

    public List<Ingredient> getIngredients() {
        return ingredients;
    }

    public void setIngredients(List<Ingredient> ingredients) {
        this.ingredients = ingredients;
    }

    public Category getCategory() {
        return category;
    }

    public void setCategory(Category category) {
        this.category = category;
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
                ", ingredients=" + ingredients +
                ", category=" + category +
                ", price=" + price +
                ", weight=" + weight +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Dish dish = (Dish) o;

        if (Float.compare(dish.price, price) != 0) return false;
        if (Float.compare(dish.weight, weight) != 0) return false;
        if (dishTitle != null ? !dishTitle.equals(dish.dishTitle) : dish.dishTitle != null) return false;
        if (ingredients != null ? !ingredients.equals(dish.ingredients) : dish.ingredients != null) return false;
        return category != null ? category.equals(dish.category) : dish.category == null;

    }

    @Override
    public int hashCode() {
        int result = dishTitle != null ? dishTitle.hashCode() : 0;
        result = 31 * result + (ingredients != null ? ingredients.hashCode() : 0);
        result = 31 * result + (category != null ? category.hashCode() : 0);
        result = 31 * result + (price != +0.0f ? Float.floatToIntBits(price) : 0);
        result = 31 * result + (weight != +0.0f ? Float.floatToIntBits(weight) : 0);
        return result;
    }
}
