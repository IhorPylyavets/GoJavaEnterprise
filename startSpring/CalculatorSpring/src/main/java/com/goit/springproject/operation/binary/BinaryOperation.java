package com.goit.springproject.operation.binary;

import com.goit.springproject.operation.Operation;

public interface BinaryOperation<T> extends Operation {
    public T eval(T a, T b);
}
