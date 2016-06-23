package com.goit.enterprise.generics;

import org.junit.Test;

import static org.junit.Assert.*;

public class SerialExecutorTest {

    @org.junit.Test
    public void testExecuteWithoutValidator() throws Exception {
        SerialExecutor<Integer> executor = new SerialExecutor<Integer>();
        executor.addTask(new AddTask(1, 2));
        executor.execute();

        assertEquals("wrong valid result size", executor.getValidResults().size(), 1);
        assertEquals("wrong invalid result size", executor.getInvalidResults().size(), 0);
        assertEquals("Wrong execution result", executor.getValidResults().get(0), Integer.valueOf(3));
    }

    @Test
    public void testExecuteWithValidator() throws Exception {
        SerialExecutor<Integer> executor = new SerialExecutor<>();
        executor.addTask(new AddTask(1, -2), result -> result > 0);
        executor.execute();

        assertEquals("wrong valid result size", executor.getValidResults().size(), 0);
        assertEquals("wrong invalid result size", executor.getInvalidResults().size(), 1);
        assertEquals("Wrong execution result", executor.getInvalidResults().get(0), Integer.valueOf(-1));
    }

    @Test
    public void testExecutor() throws Exception {
        SerialExecutor<Integer> executor = new SerialExecutor<>();
        executor.addTask(new AddTask(1, -2));
        executor.addTask(new AddTask(1, 2), result -> result > 0);
        executor.addTask(new AddTask(1, -2), result -> result > 0);
        executor.addTask(new AddTask(Integer.MAX_VALUE, 1), result -> result > 0);

        executor.execute();

        assertEquals("wrong valid result size", executor.getValidResults().size(), 2);
        assertEquals("wrong invalid result size", executor.getInvalidResults().size(), 2);

        assertEquals("Wrong execution result", executor.getValidResults().get(0), Integer.valueOf(-1));
        assertEquals("Wrong execution result", executor.getValidResults().get(1), Integer.valueOf(3));

        assertEquals("Wrong execution result", executor.getInvalidResults().get(0), Integer.valueOf(-1));
        assertEquals("Wrong execution result", executor.getInvalidResults().get(1), Integer.valueOf(Integer.MIN_VALUE));

    }

}