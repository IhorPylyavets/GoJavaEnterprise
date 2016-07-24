package com.goit.restaurant.dao;

import java.util.List;

public interface SimpleDao<T> {
    T create(String title);
    T load(int id);
    List<T> getAll();
    void delete(int id);
    void update(int id, String newTitle);
    String readMetadata();
}
