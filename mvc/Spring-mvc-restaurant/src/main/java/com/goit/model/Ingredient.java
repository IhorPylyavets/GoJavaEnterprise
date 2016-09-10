package com.goit.model;

import javax.persistence.*;
import java.io.Serializable;
import java.util.List;

@Entity
@Table(name = "INGREDIENTS")
@Inheritance(strategy = InheritanceType.SINGLE_TABLE)
public class Ingredient implements Serializable{

    @javax.persistence.Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "ID")
    private int id;

    @Column(name = "INGREDIENT_TITLE")
    private String ingredientTitle;

    /*@ManyToMany(mappedBy="ingredients")
    private List<Dish> dishes;*/
    @ManyToMany(mappedBy = "ingredients", cascade = CascadeType.ALL)
    private List<Dish> ingredients;

    public Ingredient() {
    }

    public Ingredient(String ingredientTitle) {
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

   /* public List<Dish> getDishes() {
        if (dishes == null) {
            dishes = new ArrayList<Dish>();
        }
        return dishes;
    }

    public void setDishes(List<Dish> dishes) {
        this.dishes = dishes;
    }*/

    @Override
    public String toString() {
        return "Ingredient{" +
                "id=" + id +
                ", ingredientTitle='" + ingredientTitle + '\'' +
                //", dishes=" + dishes +
                '}';
    }

}
