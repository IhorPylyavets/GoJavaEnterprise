package com.goit.springproject.operation;

import com.goit.springproject.operation.binary.NumberAdd;
import com.goit.springproject.operation.binary.NumberSub;
import com.goit.springproject.operation.unary.NumberFactorial;

import java.util.ArrayList;
import java.util.List;

public class SimpleOperationProvider implements OperationProvider{

    private List<Operation> operationList;

    public SimpleOperationProvider() {
        this.operationList = new ArrayList<>();

        addOperation(new NumberAdd(1));
        addOperation(new NumberSub(1));
        addOperation(new NumberFactorial(3));
    }

    @Override
    public List<Operation> getOperationList() {
        return operationList;
    }

    @Override
    public void addOperation(Operation operation) {
        operationList.add(operation);
    }

}
