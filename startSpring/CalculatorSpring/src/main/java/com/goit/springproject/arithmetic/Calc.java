package com.goit.springproject.arithmetic;

import com.goit.springproject.arithmetic.expression.Element;
import com.goit.springproject.operation.SimpleOperationProvider;

import java.util.List;

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
        List<Element> expressions = parser.parse(expression);

        for (Element el : expressions) {
            System.out.println(el);
        }

    }



}
