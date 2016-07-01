package com.goit.springproject.operations;

public interface BinaryOperation<T> {
    public T eval(T a, T b);
}
