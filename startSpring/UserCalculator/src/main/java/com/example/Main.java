package com.example;

import com.goit.springproject.arithmetic.Calculator;
import com.goit.springproject.operation.SimpleOperationProvider;

public class Main {
    public static void main(String[] args) {
        SimpleOperationProvider simpleOperationProvider = new SimpleOperationProvider();
        Calculator calculator  = new Calculator(simpleOperationProvider);

        System.out.println(calculator.execute("! 6 + 93.0709 + -8.0987 - ! 3 + 4 - 3"));
        System.out.println(calculator.execute("3 - 98"));
        System.out.println(calculator.execute("! 6"));
        System.out.println(calculator.execute("78 + 87.09"));
        System.out.println(calculator.execute("100.009 - 0.008"));

        System.out.println(calculator.execute("12.03.1990 - 03.09.1989"));
        System.out.println(calculator.execute("12.1990 + 9.1989"));
    }
}
