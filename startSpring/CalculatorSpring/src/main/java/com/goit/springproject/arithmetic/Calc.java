package com.goit.springproject.arithmetic;

import com.goit.springproject.operation.SimpleOperationProvider;

public class Calc {

    private SimpleOperationProvider simpleOperationProvider;

    public Calc(SimpleOperationProvider simpleOperationProvider) {
        this.simpleOperationProvider = simpleOperationProvider;
    }

    public /*String*/void execute(String expression) {
        Parser parser = new OperationParser(this.simpleOperationProvider);
        String[] expressions = parser.parse(expression);

    }

    public SimpleOperationProvider getSimpleOperationProvider() {
        return simpleOperationProvider;
    }

}
