package com.goit.springproject.operation;

public class AddOperation implements BinaryOperation<Double> {

    @Override
    public Double eval(Double a, Double b) {
        return a + b;
    }

}