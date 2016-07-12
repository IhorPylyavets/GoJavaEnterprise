package com.goit.springproject.operation.binary;

public class NumberAdd implements BinaryOperation<Number> {

    @Override
    public int getPriority() {
        return 1;
    }

    @Override
    public Number eval(Number a, Number b) {
        return a.doubleValue() + b.doubleValue();
    }

    @Override
    public String getOperator() {
        return "+";
    }

}