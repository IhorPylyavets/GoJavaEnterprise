package com.goit.springproject.operation.unary;

public class NumberFactorial implements UnaryOperation<Integer> {
    @Override
    public Integer eval(Integer n) {
        if (n == 0) return 1;
        return n * eval(n-1);
    }
}
