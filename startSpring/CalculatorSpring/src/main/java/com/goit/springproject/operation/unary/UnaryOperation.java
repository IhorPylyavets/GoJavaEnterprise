package com.goit.springproject.operation.unary;

public interface UnaryOperation<T> {
    public T eval(T a);
    public char getOperator();
}