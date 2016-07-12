package com.goit.springproject.arithmetic;

import com.goit.springproject.operation.Operation;
import com.goit.springproject.operation.SimpleOperationProvider;

import java.util.*;

public class OperationParser implements Parser {

    private SimpleOperationProvider simpleOperationProvider;
    private Set<String> parserOperationSet = new HashSet<>();

    public OperationParser(SimpleOperationProvider simpleOperationProvider) {
        this.simpleOperationProvider = simpleOperationProvider;

        for (Operation operation : this.simpleOperationProvider.getOperationList()) {
            parserOperationSet.add(operation.getOperator());
        }
    }

    @Override
    public SimpleOperationProvider getSimpleOperationProvider() {
        return simpleOperationProvider;
    }

    @Override
    public String[] parse(String expression) {
        String[] expressionArray = expression.split(" ");
        expressionValidation(expressionArray);
        bracketValidation(expressionArray);
        return expressionArray;
    }

    private void expressionValidation(String[] expressionArray) {
        for (String str : expressionArray) {
            if (!parserOperationSet.contains(str) || !isNumber(str) || !isBracket(str)) {
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

    private boolean isBracket(String str) {
        return (str.equals("(") || str.equals(")"));
    }

    private void bracketValidation(String[] expressionArray) {
        if (!isCorrectCountBrackets(expressionArray)) {
            throw new IllegalArgumentException("In your expression wrong amount bracket");
        }
    }

    private boolean isCorrectCountBrackets(String[] expressionArray) {
        int countBracket = 0;

        for (String str : expressionArray) {
            if (str.equals("(")) {
                countBracket += 1;
            }

            if (str.equals(")")) {
                countBracket -= 1;
            }
        }

        if (countBracket != 0) {
            return false;
        }
        return true;
    }

}
