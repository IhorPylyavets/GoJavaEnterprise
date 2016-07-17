package com.goit.springproject;

import com.goit.springproject.arithmetic.Calc;
import com.goit.springproject.operation.SimpleOperationProvider;

public class RunnerTests {
    public static void main(String[] args) {
        SimpleOperationProvider simpleOperationProvider = new SimpleOperationProvider();
        Calc calc  = new Calc(simpleOperationProvider);

        String expressions = "11.09.1998 - 93.0709 + -8.0987";
        calc.execute(expressions);

    }
}
