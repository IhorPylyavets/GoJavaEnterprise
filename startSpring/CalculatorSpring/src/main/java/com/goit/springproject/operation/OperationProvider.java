package com.goit.springproject.operation;

import java.util.List;

public interface OperationProvider {
    List<Operation> getOperationList();
    void addOperation(Operation operation);
}
