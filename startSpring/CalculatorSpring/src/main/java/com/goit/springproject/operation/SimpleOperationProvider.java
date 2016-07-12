package com.goit.springproject.operation;

import java.util.ArrayList;
import java.util.List;

public class SimpleOperationProvider implements OperationProvider{

    private List<Operation> operationList = new ArrayList<>();

    @Override
    public List<Operation> getOperationList() {
        return operationList;
    }

    @Override
    public void addOperation(Operation operation) {
        operationList.add(operation);
    }

}
