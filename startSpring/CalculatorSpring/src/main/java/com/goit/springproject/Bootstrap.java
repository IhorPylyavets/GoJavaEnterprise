package com.goit.springproject;

import com.goit.springproject.arithmetic.CalcOld;
import com.goit.springproject.arithmetic.ParserOld;
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
        ParserOld parser = new ParserOld();
        String expression = "-109.0998-93.009+8.09987";
        List<String> expressionList = parser.parse(expression);

        System.out.println(expression + "=" + CalcOld.execute(expressionList));
    }
}