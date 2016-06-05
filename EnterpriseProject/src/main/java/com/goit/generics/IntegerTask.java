package com.goit.generics;

public class IntegerTask implements Task<Integer>{

    private Integer result;
    private Integer value;

    public IntegerTask(Integer value) {
        this.value = value;
    }

    @Override
    public void execute() {
        this.result = this.value - 89;
    }

    @Override
    public Integer getResult() {
        return this.result;
    }
}
