package com.goit.multithreading.part1.hw;

public class Consumer implements Runnable{
    Semaphore semaphore;
    int permitsRequired;

    public Consumer(Semaphore semaphore, int permitsRequired) {
        this.semaphore = semaphore;
        this.permitsRequired = permitsRequired;
    }

    @Override
    public void run() {
        try {

            semaphore.acquire(permitsRequired);
            Thread.sleep(1000);
            semaphore.release(permitsRequired);

        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
