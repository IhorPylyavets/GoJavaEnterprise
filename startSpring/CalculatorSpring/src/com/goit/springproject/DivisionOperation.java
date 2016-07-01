package com.goit.springproject;

import com.goit.springproject.operations.BinaryOperation;

public class DivisionOperation implements BinaryOperation<Double> {

    @Override
    public Double eval(Double a, Double b) {
        return a / b;
    }
}
