package com.example;

import org.aspectj.lang.ProceedingJoinPoint;

public class LogAspect {

    public Object onExecute(ProceedingJoinPoint pjp) throws Throwable {
        System.out.println("LogAspect. Before execution of: " + pjp.getSignature().getName());
        Object result = pjp.proceed();
        System.out.println("LogAspect. After execution of:  " + pjp.getSignature().getName());
        return result;
    }
}
