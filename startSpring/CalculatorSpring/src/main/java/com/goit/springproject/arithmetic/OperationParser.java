package com.goit.springproject.arithmetic;

import com.goit.springproject.arithmetic.expression.Element;
import com.goit.springproject.operation.Operation;
import com.goit.springproject.operation.SimpleOperationProvider;

import java.util.*;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

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
    public List<Element> parse(String expression) {
        String[] expressionArray = expression.split(" ");
        expressionValidation(expressionArray);
        //bracketValidation(expressionArray);

        return stringToElementList(expressionArray);
    }

    private void expressionValidation(String[] expressionArray) {
        for (String str : expressionArray) {
            if (!parserOperationSet.contains(str) && !checkExpressionToNumberPattern(str)
                    && !checkExpressionToDatePattern(str)/*&& !isBracket(str)*/) {
                throw new IllegalArgumentException("Your expression include bad operations");
            }
        }
    }

    /*
    private boolean isBracket(String str) {
        return (str.equals("(") || str.equals(")"));
    }

    private void bracketValidation(String[] expressionArray) {
        if (!isCorrectCountBrackets(expressionArray)) {
            throw new IllegalArgumentException("In your expression wrong amount bracket");
        }
        if (!isCorrectSequenceBracket(expressionArray)) {
            throw new IllegalArgumentException("In your expression wrong sequence bracket");
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

    private boolean isCorrectSequenceBracket(String[] expressionArray) {
        int count = 0;

        for (String str : expressionArray) {
            if (str.equals("(")) {
                count += 1;
            }

            if (str.equals(")")) {
                count -= 1;
            }

            if (count < 0) {
                return false;
            }
        }
        return true;
    }
    */

    private List<Element> stringToElementList(String[] expressionArray) {
        List<Element> list = new ArrayList<>();

        for (String expression : expressionArray) {
            Element element = null;

            if (parserOperationSet.contains(expression)) {
                element = new Element(Element.Category.OPERATOR, expression);
                for (Operation operation : this.simpleOperationProvider.getOperationList()) {
                    if (operation.getOperator().equals(expression)) {
                        element.setOperatorPriority(operation.getPriority());
                    }
                }
                list.add(element);
            } else if (checkExpressionToDatePattern(expression)) {
                list.add(new Element(Element.Category.DATE, expression));
            } else  {
                list.add(new Element(Element.Category.NUMBER, expression));
            }
        }

        return list;
    }

    private boolean checkExpressionToDatePattern(String expression) {
        Pattern p = Pattern.compile("^([0-9]{2})\\." + "([0-9]{2})\\." + "([0-9]{4})$");
        Matcher m = p.matcher(expression);
        return m.matches();
    }

    private boolean checkExpressionToNumberPattern(String expression) {
        Pattern p = Pattern.compile("^[-]?[0-9]*\\.?[0-9]*$");
        Matcher m = p.matcher(expression);
        return m.matches();
    }

}
