package com.goit.dao;

import java.util.List;

public interface SimpleDao<T> {
    void create(T item);
    T findById(int id);
    T findByTitle(String title);
    List<T> getAll();
    void delete(int id);
    void updateTitle(int id, String newTitle);
}
