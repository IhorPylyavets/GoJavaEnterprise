package com.goit.module_3_1.model;

import com.goit.module_3_1.Semaphore;

public class Consumer implements Runnable {

    public Semaphore semaphore;
    public int permitsRequired;

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
