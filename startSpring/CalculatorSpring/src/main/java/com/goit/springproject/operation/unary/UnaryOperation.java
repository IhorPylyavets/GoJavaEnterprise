package com.goit.springproject.operation.unary;

import com.goit.springproject.operation.Operation;

public interface UnaryOperation<T> extends Operation {
    public T eval(T a);
}