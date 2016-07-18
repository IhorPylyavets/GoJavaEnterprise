package com.goit.springproject.arithmetic;

import com.goit.springproject.arithmetic.expression.Element;
import com.goit.springproject.operation.SimpleOperationProvider;
import com.goit.springproject.operation.binary.BinaryOperation;
import com.goit.springproject.operation.unary.UnaryOperation;

import java.util.List;

public class Calculator {

    private SimpleOperationProvider simpleOperationProvider;

    public Calculator(SimpleOperationProvider simpleOperationProvider) {
        this.simpleOperationProvider = simpleOperationProvider;
    }

    public SimpleOperationProvider getSimpleOperationProvider() {
        return simpleOperationProvider;
    }

    public String execute(String expression) {
        Parser parser = new OperationParser(this.simpleOperationProvider);
        List<Element> expressionList = parser.parse(expression);

        if (isExistDateOperation(expressionList)) {
            executeDateOperations(expressionList);
        } else {
            executeUnaryOperations(expressionList);
            executeBinaryOperations(expressionList, 2);
            executeBinaryOperations(expressionList, 1);
        }

        return makeStringResult(expression, expressionList.get(0).getValue());
    }

    private void executeUnaryOperations(List<Element> expressionList) {
        for (int i = 0; i < expressionList.size(); i++) {
            if (expressionList.get(i).getOperatorPriority() == 3) {
                UnaryOperation unaryOperation = (UnaryOperation) simpleOperationProvider
                        .getOperationByOperator(expressionList.get(i).getValue());

                int value = Integer.parseInt(expressionList.get(i+1).getValue());

                String operationResult = String.valueOf(unaryOperation.eval(value));

                expressionList.set(i, new Element(Element.Category.NUMBER, operationResult));
                expressionList.remove(i+1);

            }
        }
    }

    private void executeBinaryOperations(List<Element> expressionList, int operationPriority) {
        while ((isExistCurrentPriority(expressionList, operationPriority ))) {
            for (int i = 1; i < expressionList.size(); i++) {
                if (expressionList.get(i).getOperatorPriority() == operationPriority) {
                    BinaryOperation binaryOperation = (BinaryOperation) simpleOperationProvider
                            .getOperationByOperator(expressionList.get(i).getValue());

                    double valueFirst = Double.parseDouble(expressionList.get(i - 1).getValue());
                    double valueSecond = Double.parseDouble(expressionList.get(i + 1).getValue());

                    String operationResult = String.valueOf(binaryOperation.eval(valueFirst, valueSecond));

                    expressionList.set(i - 1, new Element(Element.Category.NUMBER, operationResult));
                    expressionList.remove(i);
                    expressionList.remove(i);
                }
            }
        }
    }

    private boolean isExistCurrentPriority(List<Element> expressionList, int operationPriority) {
        for (Element element : expressionList) {
            if (element.getOperatorPriority() == operationPriority) {
                return true;
            }
        }
        return false;
    }

    private boolean isExistDateOperation(List<Element> expressionList) {
        for (Element element : expressionList) {
            if (element.getCategory().equals(Element.Category.DATE)) {
                return true;
            }
        }
        return false;
    }

    private void executeDateOperations(List<Element> expressionList) {

    }

    private String makeStringResult(String expression, String result) {
        return String.format("%s = %s", expression, result);
    }

}
