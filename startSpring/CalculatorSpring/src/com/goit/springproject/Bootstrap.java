package com.goit.springproject;

import com.goit.springproject.arithmetic.Calc;
import com.goit.springproject.arithmetic.Parser;

import java.util.List;

public class Bootstrap {
    public static void main(String[] args) {
        Parser parser = new Parser();
        String expression = "-109-93.009+8.09987";
        List<String> expressionList = parser.parse(expression);

        System.out.println(expression + "=" + Calc.execute(expressionList));
    }
}
