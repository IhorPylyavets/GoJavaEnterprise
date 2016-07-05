package com.goit.springproject.operation.unary;

public interface UnaryOperation<T> {
    T eval(T a);
}