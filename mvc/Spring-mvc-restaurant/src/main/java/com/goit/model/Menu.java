package com.goit.model;

import javax.persistence.*;
import java.io.Serializable;
import java.util.List;

@Entity
@Table(name = "MENUS")
public class Menu implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "ID")
    private Integer id;

    @Column(name = "MENU_TITLE")
    private String menuTitle;

    @ManyToMany(fetch = FetchType.EAGER, cascade = CascadeType.ALL)
    @JoinTable(
            name = "menus_to_dishes",
            joinColumns = @JoinColumn(name = "menuId", referencedColumnName = "id"),
            inverseJoinColumns = @JoinColumn(name = "dishId", referencedColumnName = "id")
    )
    private List<Dish> dishesList;

    public Menu() {
    }

    public Menu(String menuTitle, List<Dish> dishesList) {
        this.menuTitle = menuTitle;
        this.dishesList = dishesList;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getMenuTitle() {
        return menuTitle;
    }

    public void setMenuTitle(String menuTitle) {
        this.menuTitle = menuTitle;
    }

    public List<Dish> getDishesList() {
        return dishesList;
    }

    public void setDishesList(List<Dish> dishesList) {
        this.dishesList = dishesList;
    }

    public boolean isNew() {
        return (this.id == null);
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Menu menu = (Menu) o;

        if (menuTitle != null ? !menuTitle.equals(menu.menuTitle) : menu.menuTitle != null) return false;
        return dishesList != null ? dishesList.equals(menu.dishesList) : menu.dishesList == null;

    }

    @Override
    public int hashCode() {
        int result = menuTitle != null ? menuTitle.hashCode() : 0;
        result = 31 * result + (dishesList != null ? dishesList.hashCode() : 0);
        return result;
    }

    @Override
    public String toString() {
        return "Menu{" +
                "id=" + id +
                ", menuTitle='" + menuTitle + '\'' +
                ", dishesList=" + dishesList +
                '}';
    }
}
