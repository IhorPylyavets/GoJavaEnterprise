package com.goit.generics;

public class NumberValidator implements Validator<Number> {
    public NumberValidator() {
    }

    @Override
    public boolean isValid(Number result) {
        return result.longValue() > 0;
    }
}
