package com.goit.module_3_1;

import com.goit.module_3_1.model.Consumer;

public class Bootstrap {
    public static void main(String[] args) {
        SimpleSemaphore semaphore = new SimpleSemaphore(10);

        new Thread(new Consumer(semaphore, 1)).start();
        new Thread(new Consumer(semaphore, 5)).start();
        new Thread(new Consumer(semaphore, 8)).start();
        new Thread(new Consumer(semaphore, 4)).start();
    }
}
