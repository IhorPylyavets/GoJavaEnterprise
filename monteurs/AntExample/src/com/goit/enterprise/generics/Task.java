package com.goit.enterprise.generics;

public interface Task<T> {

    void execute();
    T getResult();

}