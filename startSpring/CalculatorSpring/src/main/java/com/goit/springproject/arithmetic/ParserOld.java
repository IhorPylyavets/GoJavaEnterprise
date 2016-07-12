package com.goit.springproject.arithmetic;

import java.util.ArrayList;
import java.util.List;

public class ParserOld {
    public List<String> parse(String expression) {
        char[] chars = expression.toCharArray();
        simpleExpressionValidation(chars);

        return parseCharsExpressionToList(chars);
    }

    private void simpleExpressionValidation(char[] chars) {
        for (char c : chars) {
            if (!(isDigit(c) || isSign(c))) {
                throw new IllegalArgumentException("Your expression include bad symbols");
            }
        }
    }

    private boolean isDigit(char c) {
        return "0123456789.".indexOf(c) != -1;
    }

    private boolean isSign(char c) {
        return "+-*/^".indexOf(c) != -1;
    }

    private boolean isSignMinus(char c) {
        return "-".indexOf(c) != -1;
    }

    private List<String> parseCharsExpressionToList(char[] chars) {
        List<String> list = new ArrayList<>();

        String number = "";
        int i = 0;
        if (isSignMinus(chars[0])) {
            number += "-";
            i += 1;
        }

        for (; i < chars.length; i++) {
            if (isDigit(chars[i])) {
                number += chars[i];
            } else {
                if (number.length() != 0) {
                    list.add(number);
                    number = "";
                }
                list.add(String.valueOf(chars[i]));
            }
        }
        if (number.length() != 0) {
            list.add(number);
        }

        return list;
    }
}
