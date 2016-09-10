package com.goit.model;

import javax.persistence.*;
import java.io.Serializable;

@Entity
@Table(name = "MENUS")
@Inheritance(strategy = InheritanceType.SINGLE_TABLE)
public class Menu implements Serializable{

    @javax.persistence.Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "ID")
    private int id;

    @Column(name = "MENU_TITLE")
    private String menuTitle;

    public Menu() {
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
                '}';
    }
}
