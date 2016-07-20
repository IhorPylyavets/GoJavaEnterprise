package com.goit;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.*;

import java.util.List;

@Aspect
public class LogAspect {

    //@Around("execution( * Executor.execute())") // method execute()
    /*@Around("execution( * Executor.*(..))") // all methods
    public Object onExecute(ProceedingJoinPoint pjp) throws Throwable {
        System.out.println("LogAspect. Before execution of: " + pjp.getSignature().getName());
        Object result = pjp.proceed();
        System.out.println("LogAspect. After execution of:  " + pjp.getSignature().getName());
        return result;
    }*/

    /*@Before("execution( * Executor.addTask(Task)) && args(task))")
    public void onExecute(Task task) throws Throwable {
     System.out.println(task.toString());
    }*/

    /*@AfterReturning(pointcut = "execution( * Executor.getValidResults()))",
                    returning = "result")
    public void onExecute(List result) throws Throwable {
        System.out.println("After Returning. Result: " + result.toString());
    }*/

    @Around("execution( * Executor.addTask(Task)) && args(task)")
    public void onExecute(ProceedingJoinPoint pjp, Task task) throws Throwable {
        ((Executor<Integer>)pjp.getTarget()).addTask(task, (t) -> t > 0);
    }

}
