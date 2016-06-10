package com.goit.multithreading.part1.hw;

public class Runner {

    public static void main(String[] args) {
        Semaphore semaphore = new SingleSemaphore(10);
        Semaphore semaphore2 = new SingleSemaphore(5);

        synchronized (semaphore) {
            int permits = semaphore.getAvailablePermits();
            semaphore.release(10 - permits);
        }

        synchronized (semaphore2) {
            int permits2 = semaphore2.getAvailablePermits();
            semaphore2.release(10 - permits2);
        }

    }

}
