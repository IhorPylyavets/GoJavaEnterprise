package com.goit.generics;

/*

1 Переписать интерфейс Task так что бы он был типизирован по результату (значению возращаемуому методом getResult()).
2 Переписать интерфейс Validator так что бы он был типизирован по принемаемому значению isValid(Object result);
3 Переписать интерфейс Executor так чтоб он был типизирован в соответсвии с типизацией Task и Validator
4 Импелементирвать интерфейс Executor
5 Написать к нему тесты.

*/


public class Runner {
    public static void main(String[] args) {
        Executor<Number> numberExecutor = new ExecutorImpl();

        numberExecutor.addTask(new IntegerTask(3));
        numberExecutor.addTask(new IntegerTask(24));
        numberExecutor.addTask(new IntegerTask(90));
        numberExecutor.addTask(new IntegerTask(-13));
        numberExecutor.addTask(new IntegerTask(34));

        numberExecutor.addTask(new LongTask(-323L), new NumberValidator());
        numberExecutor.addTask(new LongTask(34L), new NumberValidator());
        numberExecutor.addTask(new LongTask(10L), new NumberValidator());

        numberExecutor.execute();

        System.out.println("Valid results:");
        for (Number number : numberExecutor.getValidResults()) {
            System.out.println(number);
        }
        System.out.println("Invalid results:");
        for (Number number : numberExecutor.getInvalidResults()) {
            System.out.println(number);
        }
    }
}
