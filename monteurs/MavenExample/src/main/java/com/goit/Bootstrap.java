package com.goit;

public class Bootstrap {

    public static void main(String[] args) {
        SerialExecutor<Integer> executor = new SerialExecutor<>();
        executor.addTask(new AddTask(1, -2));
        executor.addTask(new AddTask(1, 2), result -> result > 0);
        executor.addTask(new AddTask(1, -2), result -> result > 0);
        executor.addTask(new AddTask(Integer.MAX_VALUE, 1), result -> result > 0);

        executor.execute();

        System.out.println("Valid results");
        executor.getValidResults().forEach(System.out::println);
        System.out.println("Invalid results");
        executor.getInvalidResults().forEach(System.out::println);
    }

}
