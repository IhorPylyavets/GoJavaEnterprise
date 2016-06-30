package com.goit.multithreading.part1.hw;

public class Runner {

    public static void main(String[] args) {
        SimpleSemaphore semaphore = new SimpleSemaphore(10);

        new Thread(new Consumer(semaphore, 1)).start();
        new Thread(new Consumer(semaphore, 5)).start();
        new Thread(new Consumer(semaphore, 8)).start();
        new Thread(new Consumer(semaphore, 4)).start();
    }

}
