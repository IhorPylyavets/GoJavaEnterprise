package com.goit.springproject;

import com.goit.springproject.arithmetic.Calc;
import com.goit.springproject.arithmetic.Parser;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class Bootstrap {
    public static void main(String[] args) {
        ApplicationContext applicationContext = new AnnotationConfigApplicationContext(AppConfig.class);
        Bootstrap bootstrap = applicationContext.getBean("bootstrap", Bootstrap.class);

        bootstrap.execute();
    }

    public void execute() {
        Parser parser = new Parser();
        String expression = "-109.0998-93.009+8.09987";
        List<String> expressionList = parser.parse(expression);

        System.out.println(expression + "=" + Calc.execute(expressionList));
    }
}