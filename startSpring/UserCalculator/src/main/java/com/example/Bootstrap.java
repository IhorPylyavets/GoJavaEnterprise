package com.example;

import com.example.operation.NumberDiv;
import com.example.operation.NumberMult;
import com.goit.springproject.arithmetic.Calculator;
import com.goit.springproject.arithmetic.Parser;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.stereotype.Component;

import java.io.IOException;
import java.util.Scanner;

@Component
public class Bootstrap {

    private final static String CALCULATOR_HELLO = "Enter expressions use space between values: ";

    private Calculator calculator;

    public static void main(String[] args) throws IOException {
        ApplicationContext applicationContext = new AnnotationConfigApplicationContext(AppConfig.class);
        //ApplicationContext applicationContext = new ClassPathXmlApplicationContext("application-context.xml", "aop-context.xml");
        Bootstrap bootstrap = applicationContext.getBean("bootstrap", Bootstrap.class);

        consoleExecute(bootstrap);
    }

    public static void consoleExecute(Bootstrap bootstrap) {
        boolean isNeedToRun = true;
        System.out.println(Bootstrap.CALCULATOR_HELLO);
        Scanner sc = new Scanner(System.in);

        while (isNeedToRun) {
            try {
                bootstrap.execute(sc.nextLine());
                System.out.println("Would you like to continue? y n");
                Scanner sc2 = new Scanner(System.in);
                if (sc2.nextLine().equals("n")) {
                    isNeedToRun = false;
                } else {
                    System.out.println(Bootstrap.CALCULATOR_HELLO);
                }
            }
            catch (Exception e) {
                throw new RuntimeException(e);
            }
        }
        sc.close();
    }

    public void execute(String expression) {
        System.out.println(calculator.execute(expression));
    }

    @Autowired
    public void setCalculator(Calculator calculator) {
        this.calculator = calculator;

        this.calculator.getSimpleOperationProvider().addOperation(new NumberDiv(2));
        this.calculator.getSimpleOperationProvider().addOperation(new NumberMult(2));
    }
}
