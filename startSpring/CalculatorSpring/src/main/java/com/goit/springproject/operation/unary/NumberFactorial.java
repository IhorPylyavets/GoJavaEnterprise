package com.goit.springproject.operation.unary;

public class NumberFactorial implements UnaryOperation<Integer> {

    private int priority;

    public NumberFactorial(int priority) {
        this.priority = priority;
    }

    @Override
    public Integer eval(Integer n) {
        if (n == 0) return 1;
        return n * eval(n-1);
    }

    @Override
    public int getPriority() {
        return priority;
    }

    @Override
    public String getOperator() {
        return "!";
    }
}

