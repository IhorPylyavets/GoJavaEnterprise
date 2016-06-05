package com.goit.generics;

import java.util.ArrayList;
import java.util.List;

public class ExecutorImpl implements Executor<Number> {

    List<Task> tasks = new ArrayList<>();
    List<Number> validTasks = new ArrayList<>();
    List<Number> invalidTasks = new ArrayList<>();

    boolean isExecute = false;

    @Override
    public void addTask(Task<? extends Number> task) {
        if (task.getResult() != null) {
            throw new RuntimeException();
        } else {
            this.tasks.add(task);
            task.execute();
            this.validTasks.add(task.getResult());
        }
    }

    @Override
    public void addTask(Task<? extends Number> task, Validator<? super Number> validator) {
        if (task.getResult() != null) {
            throw new RuntimeException();
        } else {
            this.tasks.add(task);
            task.execute();
            if (validator.isValid(task.getResult())) {
                this.validTasks.add(task.getResult());
            } else {
                this.invalidTasks.add(task.getResult());
            }
        }
    }

    @Override
    public void execute() {
        for (Task<Number> task : this.tasks) {
            task.execute();
        }
        this.isExecute = true;
    }

    @Override
    public List<Number> getValidResults() {
        if (!this.isExecute) {
            throw new RuntimeException();
        }
        return this.validTasks;
    }

    @Override
    public List<Number> getInvalidResults() {
        if (!this.isExecute) {
            throw new RuntimeException();
        }
        return this.invalidTasks;
    }
}
