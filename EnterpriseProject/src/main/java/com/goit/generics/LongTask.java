package com.goit.generics;

public class LongTask implements Task<Long>{

    private Long result;
    private Long value;

    public LongTask(Long value) {
        this.value = value;
    }

    @Override
    public void execute() {
        this.result = this.value + 6;
    }

    @Override
    public Long getResult() {
        return this.result;
    }
}
