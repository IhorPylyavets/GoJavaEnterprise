package com.goit.model;

import org.hibernate.annotations.GenericGenerator;

import javax.persistence.*;
import java.util.List;

@Entity
@Table(name = "INGREDIENTS")
public class Ingredient {

    @Id
    @GeneratedValue(generator = "increment")
    @GenericGenerator(name = "increment", strategy = "increment")
    @Column(name = "ID")
    private int id;

    @Column(name = "INGREDIENT_TITLE")
    private String ingredientTitle;

    /*@ManyToMany(mappedBy="ingredients")
    private List<Dish> dishes;*/
    @ManyToMany(mappedBy = "ingredients", cascade = CascadeType.ALL)
    private List<Dish> ingredients;

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
