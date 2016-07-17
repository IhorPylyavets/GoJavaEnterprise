package com.goit.springproject;

import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.stereotype.Component;

@Component
public class Bootstrap {
    public static void main(String[] args) {
        ApplicationContext applicationContext = new AnnotationConfigApplicationContext(AppConfig.class);
        Bootstrap bootstrap = applicationContext.getBean("bootstrap", Bootstrap.class);

        bootstrap.execute();
    }

    public void execute() {}
}