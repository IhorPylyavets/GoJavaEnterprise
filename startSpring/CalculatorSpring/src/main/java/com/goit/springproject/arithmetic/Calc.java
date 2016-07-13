package com.goit.springproject.arithmetic;

import com.goit.springproject.operation.SimpleOperationProvider;

import java.util.Arrays;

public class Calc {

    private SimpleOperationProvider simpleOperationProvider;

    public Calc(SimpleOperationProvider simpleOperationProvider) {
        this.simpleOperationProvider = simpleOperationProvider;
    }

    public SimpleOperationProvider getSimpleOperationProvider() {
        return simpleOperationProvider;
    }

    public /*String*/void execute(String expression) {
        Parser parser = new OperationParser(this.simpleOperationProvider);
        String[] expressionArray = parser.parse(expression);

        System.out.println("true expressionArray " + Arrays.toString(expressionArray));

    }



}
