package com.goit;

import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;
import java.util.ArrayList;
import java.util.List;

@Component
public class IntegerTaskProvider implements TaskProvider<Integer> {

    private List<Task<Integer>> tasks = new ArrayList<>();

    @PostConstruct
    public void init() {
        tasks.add(new AddTask(1, -2));
        tasks.add(new AddTask(1, 2));
        tasks.add(new AddTask(1, -2));
        tasks.add(new AddTask(Integer.MAX_VALUE, 1));
    }

    @Override
    public List<Task<Integer>> getAllTasks() {
        return tasks;
    }
}
