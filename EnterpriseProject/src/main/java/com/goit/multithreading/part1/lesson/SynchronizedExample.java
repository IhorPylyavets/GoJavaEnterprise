package com.goit.multithreading.part1.lesson;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class SynchronizedExample {

    private int counter;
    private final Object lock = new Object();

    public static void main(String[] args) throws InterruptedException {
        new SynchronizedExample().test();
    }

    /*
    public int increment() {
        synchronized (this) {
            return counter++;
        }
    }

    or

    public synchronized int increment() {
        return counter++;
    }
    */
    
    public int increment() {
        synchronized (lock) {
            return counter++;
        }
    }

    /* if static variable
    public static synchronized int increment() {
        return counter++;
    }

    or

    public static int increment() {
        synchronized (SynchronizedExample.class) {
            return counter++;
        }
    }*/

    public void test() throws InterruptedException {
        List<Aggregator> aggregators = new ArrayList<>();

        for (int i = 0; i < 10; i++) {
            Aggregator aggregator = new Aggregator();
            aggregators.add(aggregator);

            new Thread(aggregator).start();
        }

        Thread.sleep(100);

        boolean isValid = true;
        Set<Integer> integerSet = new HashSet<>();

        for (Aggregator aggregator : aggregators) {
            for (Integer anInt : aggregator.ints) {
                if (!integerSet.add(anInt)) {
                    System.out.println("Error, duplicate found: " + anInt);
                    isValid = false;
                }
            }
        }

        if (isValid) {
            System.out.println("No duplicates");
        }
    }

    public class Aggregator implements Runnable{

        List<Integer> ints = new ArrayList<>();

        @Override
        public void run() {
            for (int i = 0; i < 1000; i++) {
                ints.add(increment());
            }
        }
    }
}
