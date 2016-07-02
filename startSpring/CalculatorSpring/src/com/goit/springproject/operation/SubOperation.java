package com.goit.springproject.operation;

public class SubOperation implements BinaryOperation<Double> {

    @Override
    public Double eval(Double a, Double b) {
        return a - b;
    }

}
