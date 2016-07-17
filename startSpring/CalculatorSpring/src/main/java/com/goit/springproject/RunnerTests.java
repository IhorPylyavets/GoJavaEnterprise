package com.goit.springproject;

import com.goit.springproject.arithmetic.Calc;
import com.goit.springproject.operation.SimpleOperationProvider;

public class RunnerTests {
    public static void main(String[] args) {
        SimpleOperationProvider simpleOperationProvider = new SimpleOperationProvider();
        Calc calc  = new Calc(simpleOperationProvider);

        String expressions = "! 6 + 93.0709 + -8.0987 - ! 3 + 4 - 3";
        //String expressions = "3 + 4 * 3";
        String res = calc.execute(expressions);
        System.out.println(res);

    }
}
