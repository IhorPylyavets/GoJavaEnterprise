package com.goit.restaurant.model;

public class Menu {

    private int id;
    private String menuTitle;

    public Menu() {
    }

    public Menu(int id, String menuTitle) {
        this.id = id;
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
