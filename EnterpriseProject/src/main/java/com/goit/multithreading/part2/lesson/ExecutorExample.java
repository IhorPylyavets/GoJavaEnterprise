package com.goit.multithreading.part2.lesson;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Random;
import java.util.concurrent.*;
import java.util.stream.IntStream;

public class ExecutorExample {

    public static void main(String[] args) throws ExecutionException, InterruptedException {
        new ExecutorExample().testScheduledAtFixedRate();
    }

    public void testExecute() {
        Executor executor = Executors.newSingleThreadExecutor();
        System.out.println(Thread.currentThread().getName() + " submits tasks");
        try {
            executor.execute(new Runnable() {
                @Override
                public void run() {
                    throw new RuntimeException("Exception");
                    //System.out.println(Thread.currentThread().getName() + "Async task started");
                }
            });
        } catch (Exception e) {
            System.out.println("Ignore exception");
        }
    }

    public void testSubmit() throws ExecutionException, InterruptedException {
        ExecutorService executorService = Executors.newSingleThreadExecutor();
        Future<String> f = executorService.submit(new Callable<String>() {
            @Override
            public String call() throws Exception {
                Thread.sleep(1000);
                return "task executed";
            }
        });
        System.out.println("Waiting for result");
        System.out.println("result: " + f.get());

        executorService.shutdown();
    }

    public void testExeptions() throws ExecutionException, InterruptedException {
        ExecutorService executorService = Executors.newSingleThreadExecutor();
        Future<String> f = executorService.submit(new Callable<String>() {
            @Override
            public String call() throws Exception {
                throw new RuntimeException("Exeptions happened");
            }
        });
        System.out.println("Waiting for result");
        Thread.sleep(1000);
        try {
            System.out.println("result: " + f.get());
        } catch (ExecutionException e) {
            System.out.println("Exeption occured");
        }

        executorService.shutdown();
    }

    public void testInvokeAny() throws ExecutionException, InterruptedException {
        List<Callable<String>> callables = new ArrayList<>();
        Random random = new Random();
        IntStream.range(0, 3).forEach(i -> callables.add(() -> {
            Thread.sleep(random.nextInt(1000));
            return String.valueOf(i);
        }));

        ExecutorService executorService = Executors.newSingleThreadExecutor();
        String result = executorService.invokeAny(callables);

        System.out.println(result);
        executorService.shutdown();
    }

    public void testInvokeAll() throws ExecutionException, InterruptedException {
        List<Callable<String>> callables = new ArrayList<>();
        Random random = new Random();
        IntStream.range(0, 3).forEach(i -> callables.add(() -> {
            Thread.sleep(random.nextInt(1000));
            return String.valueOf(i);
        }));

        ExecutorService executorService = Executors.newSingleThreadExecutor();
        List<Future<String>> result = executorService.invokeAll(callables);

        for (Future f : result) {
            System.out.println(f.get());
        }

        executorService.shutdown();
    }

    public void testScheduled() {
        ScheduledExecutorService executorService = Executors.newSingleThreadScheduledExecutor();
        System.out.println("Task scheduled " + new Date());
        executorService.schedule(new Runnable() {
            @Override
            public void run() {
                System.out.println("task executed " + new Date());
            }
        }, 1, TimeUnit.SECONDS);
    }

    public void testScheduledAtFixedRate() throws InterruptedException {
        ScheduledExecutorService executorService = Executors.newSingleThreadScheduledExecutor();
        System.out.println("Task scheduled " + new Date());
        executorService.scheduleAtFixedRate(new Runnable() {
            @Override
            public void run() {
                System.out.println("Task executed " + new Date());
            }
        }, 1, 1, TimeUnit.SECONDS);

        Thread.sleep(10000);

        executorService.shutdown();
    }

}
