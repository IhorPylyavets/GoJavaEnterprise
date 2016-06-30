package com.goit;

import org.springframework.beans.factory.ObjectFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.stereotype.Component;

@Component
public class  Bootstrap {

    private TaskProvider<Integer> taskProvider;
    private ObjectFactory<Executor<Integer>>  executorFactory;

    public static void main(String[] args) {
        ApplicationContext applicationContext = new ClassPathXmlApplicationContext("application-context.xml");
        Bootstrap bootstrap = applicationContext.getBean("bootstrap", Bootstrap.class);

        bootstrap.execute();
        bootstrap.execute();
    }

    public void execute() {
        Executor<Integer> executor = executorFactory.getObject();

        taskProvider.getAllTasks().forEach(executor::addTask);
        executor.execute();
        System.out.println("Valid results");
        executor.getValidResults().forEach(System.out::println);
        System.out.println("Invalid results");
        executor.getInvalidResults().forEach(System.out::println);
    }

    @Autowired
    public void setTaskProvider(TaskProvider<Integer> taskProvider) {
        this.taskProvider = taskProvider;
    }

    @Autowired
    public void setExecutorFactory(ObjectFactory<Executor<Integer>> executorFactory) {
        this.executorFactory = executorFactory;
    }
}