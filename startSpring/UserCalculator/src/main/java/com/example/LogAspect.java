package com.example;

import org.apache.log4j.Logger;
import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.*;
import org.aspectj.lang.reflect.MethodSignature;

@Aspect
public class LogAspect {

    final static Logger logger = Logger.getLogger(LogAspect.class);

    @Before("execution( * com.goit.springproject.arithmetic.Calculator.execute(String)) && args(expressions)")
    public void onBeforeExecute(String expressions) {
        logger.info("Calculator: Expression: " + expressions);
    }

    @AfterReturning(pointcut = "execution(* com.goit.springproject.arithmetic.Calculator.execute(..))",
            returning= "result")
    public void logAfterReturning(JoinPoint joinPoint, Object result) {
        logger.info("Calculator: result: " + result.toString());
    }

    @AfterThrowing(pointcut = "execution(* com.goit.springproject.arithmetic.Calculator.execute(..))",
            throwing= "error")
    public void logAfterThrowing(JoinPoint joinPoint, Throwable error) {
        logger.error("Calculator: ERROR: " + error.toString());
    }

}
