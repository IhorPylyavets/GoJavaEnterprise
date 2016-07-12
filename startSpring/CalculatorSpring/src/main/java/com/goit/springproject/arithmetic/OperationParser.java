package com.goit.springproject.arithmetic;

import com.goit.springproject.operation.Operation;
import com.goit.springproject.operation.SimpleOperationProvider;

import java.util.*;

public class OperationParser {

    private SimpleOperationProvider simpleOperationProvider;
    private Set<String> parserOperationSet = new HashSet<>();

    public OperationParser(SimpleOperationProvider simpleOperationProvider) {
        this.simpleOperationProvider = simpleOperationProvider;

        for (Operation operation : this.simpleOperationProvider.getOperationList()) {
            parserOperationSet.add(operation.getOperator());
        }
    }

    public String[] parse(String expression) {
        String[] expressionArray = expression.split(" ");

        expressionValidation(expressionArray);

        return expressionArray;
    }

    private void expressionValidation(String[] expressionArray) {
        for (String str : expressionArray) {
            if (!parserOperationSet.contains(str) || !isNumber(str)) {
                throw new IllegalArgumentException("Your expression include bad operations");
            }
        }
    }

    private boolean isNumber(String str) {
        if (str.substring(0, 1).equals("-")) {
            str = str.substring(1);
        }

        char[] chars = str.toCharArray();
        for (char c : chars) {
            if (!isDigit(c)) {
                return false;
            }
        }

        return true;
    }

    private boolean isDigit(char c) {
        return "0123456789.".indexOf(c) != -1;
    }

}
