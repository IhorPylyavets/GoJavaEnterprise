package com.goit.springproject.operation.binary;

public class NumberSub implements BinaryOperation<Number> {

    @Override
    public Number eval(Number a, Number b) {
        return a.doubleValue() - b.doubleValue();
    }

    @Override
    public char getOperator() {
        return '-';
    }

}