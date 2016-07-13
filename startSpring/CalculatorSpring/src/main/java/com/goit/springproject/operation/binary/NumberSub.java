package com.goit.springproject.operation.binary;

public class NumberSub implements BinaryOperation<Number> {

    private int priority;

    public NumberSub(int priority) {
        this.priority = priority;
    }

    @Override
    public int getPriority() {
        return priority;
    }

    @Override
    public Number eval(Number a, Number b) {
        return a.doubleValue() - b.doubleValue();
    }

    @Override
    public String getOperator() {
        return "-";
    }

}