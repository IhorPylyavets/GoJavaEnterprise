package com.goit.model;

import javax.persistence.*;
import java.io.Serializable;

@Entity
@Table(name = "CATEGORIES")
@Inheritance(strategy = InheritanceType.SINGLE_TABLE)
public class Category implements Serializable{

    @javax.persistence.Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "ID")
    private Integer id;

    @Column(name = "CATEGORY_TITLE")
    private String categoryTitle;

    public Category() {
    }

    public Category(String categoryTitle) {
        this.categoryTitle = categoryTitle;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getCategoryTitle() {
        return categoryTitle;
    }

    public void setCategoryTitle(String categoryTitle) {
        this.categoryTitle = categoryTitle;
    }

    public boolean isNew() {
        return (this.id == null);
    }

    @Override
    public String toString() {
        return "Category{" +
                "id=" + id +
                ", categoryTitle='" + categoryTitle + '\'' +
                '}';
    }
}