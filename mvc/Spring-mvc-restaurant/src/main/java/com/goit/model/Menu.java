package com.goit.model;

import javax.persistence.*;
import java.io.Serializable;
import java.util.List;

@Entity
@Table(name = "MENUS")
public class Menu implements Serializable{

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "ID")
    private int id;

    @Column(name = "MENU_TITLE")
    private String menuTitle;

    @ManyToMany(fetch = FetchType.EAGER)
    @JoinTable(
            name = "menu_to_dishes",
            joinColumns = @JoinColumn(name = "menuId", referencedColumnName = "id"),
            inverseJoinColumns = @JoinColumn(name = "dishId", referencedColumnName = "id")
    )
    private List<Dish> dishes;

    public Menu() {
    }

    public Menu(String menuTitle, List<Dish> dishes) {
        this.menuTitle = menuTitle;
        this.dishes = dishes;
    }

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

    @Override
    public String toString() {
        return "Menu{" +
                "id=" + id +
                ", menuTitle='" + menuTitle + '\'' +
                ", dishes=" + dishes +
                '}';
    }


    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Menu menu = (Menu) o;

        if (menuTitle != null ? !menuTitle.equals(menu.menuTitle) : menu.menuTitle != null) return false;
        return dishes != null ? dishes.equals(menu.dishes) : menu.dishes == null;

    }

    @Override
    public int hashCode() {
        int result = menuTitle != null ? menuTitle.hashCode() : 0;
        result = 31 * result + (dishes != null ? dishes.hashCode() : 0);
        return result;
    }
}
