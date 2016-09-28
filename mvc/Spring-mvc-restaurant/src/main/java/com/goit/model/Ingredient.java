package com.goit.model;

import com.fasterxml.jackson.annotation.JsonIgnore;

import javax.persistence.*;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "INGREDIENTS")
public class Ingredient implements Serializable{

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "ID")
    private Integer id;

    @Column(name = "INGREDIENT_TITLE")
    private String ingredientTitle;

    @ManyToMany(mappedBy = "ingredients", cascade = CascadeType.ALL)
    private List<Dish> dishes = new ArrayList<>();

    public Ingredient() {
    }

    public Ingredient(String ingredientTitle) {
        this.ingredientTitle = ingredientTitle;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getIngredientTitle() {
        return ingredientTitle;
    }

    public void setIngredientTitle(String ingredientTitle) {
        this.ingredientTitle = ingredientTitle;
    }

    public List<Dish> getDishes() {
        return dishes;
    }

    public void setDishes(List<Dish> dishes) {
        this.dishes = dishes;
    }

    @JsonIgnore
    public boolean isNew() {
        return (this.id == null);
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Ingredient that = (Ingredient) o;

        if (ingredientTitle != null ? !ingredientTitle.equals(that.ingredientTitle) : that.ingredientTitle != null)
            return false;
        return dishes != null ? dishes.equals(that.dishes) : that.dishes == null;

    }

    @Override
    public int hashCode() {
        int result = ingredientTitle != null ? ingredientTitle.hashCode() : 0;
        result = 31 * result + (dishes != null ? dishes.hashCode() : 0);
        return result;
    }

    @Override
    public String toString() {
        return "Ingredient{" +
                "id=" + id +
                ", ingredientTitle='" + ingredientTitle + '\'' +
                '}';
    }
}
