package com.goit.model;

import org.hibernate.annotations.GenericGenerator;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "DISHES")
public class Dish {

    @Id
    @GeneratedValue(generator = "increment")
    @GenericGenerator(name = "increment", strategy = "increment")
    @Column(name = "ID")
    private int id;

    @Column(name = "DISH_TITLE")
    private String dishTitle;

    @ManyToMany()
    @JoinTable(
            name = "DISHES_TO_INGREDIENTS",
            joinColumns = @JoinColumn(name = "DISHES_ID"),
            inverseJoinColumns = @JoinColumn(name = "INGREDIENTS_ID")
    )
    private List<Ingredient> ingredients;

    @ManyToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "CATEGORY_ID")
    private Category category;

    @Column(name = "PRICE")
    private float price;

    @Column(name = "WEIGHT")
    private float weight;

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
        if (ingredients == null) {
            ingredients = new ArrayList<Ingredient>();
        }
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
                //", ingredients=" + ingredients +
                ", category=" + category +
                ", price=" + price +
                ", weight=" + weight +
                '}';
    }
}
