package com.goit.springproject.arithmetic;

import com.goit.springproject.arithmetic.expression.Element;
import com.goit.springproject.operation.SimpleOperationProvider;

import java.util.List;

public interface Parser {
    SimpleOperationProvider getSimpleOperationProvider();
    List<Element> parse(String expression);
}
