package com.goit.model;

import javax.persistence.*;
import java.io.Serializable;

@Entity
@Table(name = "MENUS")
@Inheritance(strategy = InheritanceType.SINGLE_TABLE)
public class Menu implements Serializable{

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "ID")
    private int id;

    @Column(name = "MENU_TITLE")
    private String menuTitle;

    /*@ManyToMany(fetch = FetchType.EAGER)
    @JoinTable(
            name = "menu_to_dishes",
            joinColumns = @JoinColumn(name = "menuId", referencedColumnName = "id"),
            inverseJoinColumns = @JoinColumn(name = "dishId", referencedColumnName = "id")
    )
    private List<Dish> dishes;*/

    public Menu() {
    }

    /*public Menu(String menuTitle, List<Dish> dishes) {
        this.menuTitle = menuTitle;
        this.dishes = dishes;
    }*/

    public Menu(String menuTitle) {
        this.menuTitle = menuTitle;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getMenuTitle() {
        return menuTitle;
    }

    public void setMenuTitle(String menuTitle) {
        this.menuTitle = menuTitle;
    }

    /*public List<Dish> getDishes() {
        return dishes;
    }

    public void setDishes(List<Dish> dishes) {
        this.dishes = dishes;
    }*/

    @Override
    public String toString() {
        return "Menu{" +
                "id=" + id +
                ", menuTitle='" + menuTitle + /*'\'' +
                ", dishes=" + dishes +*/
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Menu menu = (Menu) o;

        return menuTitle != null ? menuTitle.equals(menu.menuTitle) : menu.menuTitle == null;

    }

    @Override
    public int hashCode() {
        return menuTitle != null ? menuTitle.hashCode() : 0;
    }
}
