package com.goit.springproject.operation;

import java.util.List;

public interface OperationProvider {
    public List<Operation> getOperationList();
    public void addOperation(Operation operation);
}
