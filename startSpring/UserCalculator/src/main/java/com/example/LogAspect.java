package com.example;

import org.apache.log4j.Logger;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;

@Aspect
public class LogAspect {

    final static Logger logger = Logger.getLogger(LogAspect.class);

    /*@Around("execution( * com.goit.springproject.arithmetic.Calculator.execute(String))")
    public Object onExecute(ProceedingJoinPoint pjp) throws Throwable {
        System.out.println("LogAspect. Before execution of: " + pjp.getSignature().getName());
        Object result = pjp.proceed();
        System.out.println("LogAspect. After execution of:  " + pjp.getSignature().getName());
        return result;
    }*/

    @Before("execution( * com.goit.springproject.arithmetic.Calculator.execute(String)) && args(expressions)")
    public void onExecute(String expressions) {
        logger.info("Calculator: Expression: " + expressions);
    }
}
