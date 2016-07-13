package com.goit.springproject;

import com.goit.springproject.arithmetic.Calc;
import com.goit.springproject.operation.SimpleOperationProvider;

public class RunnerTests {
    public static void main(String[] args) {
        SimpleOperationProvider simpleOperationProvider = new SimpleOperationProvider();
        Calc calc  = new Calc(simpleOperationProvider);

        String expressions = "34 + 5 - 6 + -6";
        calc.execute(expressions);
    }
}
