package com.goit.multithreading.part2.hw;

import java.util.concurrent.Callable;
import java.util.concurrent.Phaser;

public class Task implements Callable<Long>{

    private Phaser phaser;
    private int[] array;

    public Task(Phaser phaser, int[] arraySegment) {
        this.phaser = phaser;
        this.array = arraySegment;
    }

    @Override
    public Long call() throws Exception {
        phaser.register();

        long result = 0L;

        for (int element : array) {
            result += element * element;
        }
        phaser.arriveAndAwaitAdvance();

        try {
            Thread.sleep(100);
        } catch (InterruptedException e) {
            Thread.currentThread().interrupt();
        }

        phaser.arriveAndDeregister();

        return result;
    }
}
