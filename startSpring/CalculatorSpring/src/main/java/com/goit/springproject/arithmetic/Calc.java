package com.goit.springproject.arithmetic;

import com.goit.springproject.operation.binary.NumberAdd;
import com.goit.springproject.operation.binary.BinaryOperation;
import com.goit.springproject.operation.SubOperation;

import java.util.List;

public class Calc {
    public static String execute(List<String> expressionList) {

        while (expressionList.size() != 1) {
            computeExpression(expressionList);
        }

        return expressionList.get(0);
    }

    private static List<String> computeExpression(List<String> expressionList) {
        BinaryOperation operation;

        double a = Double.parseDouble(expressionList.get(0));
        double b = Double.parseDouble(expressionList.get(2));

        if (expressionList.get(1).equals("+")) {
            operation = new NumberAdd();
            expressionList.set(2, Double.toString((Double) operation.eval(a, b)));
        } else {
            operation = new SubOperation();
            expressionList.set(2, Double.toString((Double) operation.eval(a, b)));
        }

        expressionList.remove(1);
        expressionList.remove(0);

        return expressionList;
    }
}
