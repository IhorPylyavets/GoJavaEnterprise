package com.goit.springproject.operation.binary;

public interface BinaryOperation<T> {
    public T eval(T a, T b);
}
