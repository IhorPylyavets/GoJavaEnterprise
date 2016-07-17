package com.goit.springproject.arithmetic;

import com.goit.springproject.arithmetic.expression.Element;
import com.goit.springproject.operation.Operation;
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
        List<Element> expressionList = parser.parse(expression);

        for (Element el : expressionList) {
            System.out.println(el);
        }

        for (int i = 0; i < expressionList.size(); i++) {
            if (expressionList.get(i).getOperatorPriority() == 3) {
                Operation op = simpleOperationProvider.getOperationByOperator(expressionList.get(i).getValue());
            }
        }

    }



}
