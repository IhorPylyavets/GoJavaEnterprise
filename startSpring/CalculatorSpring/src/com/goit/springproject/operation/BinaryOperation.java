package com.goit.springproject.operation;

public interface BinaryOperation<T> {
    public T eval(T a, T b);
}