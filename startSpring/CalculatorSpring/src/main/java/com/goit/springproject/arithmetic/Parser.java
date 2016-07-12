package com.goit.springproject.arithmetic;

import com.goit.springproject.operation.SimpleOperationProvider;

public interface Parser {
    SimpleOperationProvider getSimpleOperationProvider();
    String[] parse(String expression);
}
