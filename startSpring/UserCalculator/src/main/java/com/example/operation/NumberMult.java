package com.example.operation;

import com.goit.springproject.operation.binary.BinaryOperation;

public class NumberMult implements BinaryOperation<Number>{

    private int priority;

    public NumberMult(int priority) {
        this.priority = priority;
    }

    public Number eval(Number a, Number b) {
        return a.doubleValue() * b.doubleValue();
    }

    public int getPriority() {
        return priority;
    }

    public String getOperator() {
        return "*";
    }
}
