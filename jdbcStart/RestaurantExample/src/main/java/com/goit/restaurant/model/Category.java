package com.goit.restaurant.model;

public class Category {

    private int id;
    private String categoryTitle;

    public Category() {
    }

    public Category(int id, String categoryTitle) {
        this.id = id;
        this.categoryTitle = categoryTitle;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getCategoryTitle() {
        return categoryTitle;
    }

    public void setCategoryTitle(String categoryTitle) {
        this.categoryTitle = categoryTitle;
    }

    @Override
    public String toString() {
        return "Category{" +
                "id=" + id +
                ", categoryTitle='" + categoryTitle + '\'' +
                '}';
    }
}
