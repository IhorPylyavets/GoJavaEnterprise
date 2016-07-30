package com.example;

import org.junit.Test;

import static org.junit.Assert.*;

public class TaskTest {

    @Test
    public void Task_instantiatesWithDescription_String() {
        Task myTask = new Task("Mow the lawn");
        assertEquals("Mow the lawn", myTask.getDescription());
    }

}