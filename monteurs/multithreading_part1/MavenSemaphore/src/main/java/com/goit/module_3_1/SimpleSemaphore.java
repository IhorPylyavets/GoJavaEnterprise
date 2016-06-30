package com.goit.module_3_1;

public class SimpleSemaphore implements Semaphore {

    private int permitsLimit;
    private int permits;
    private final Object lock = new Object();

    public SimpleSemaphore(int permits) {
        this.permits = permits;
        this.permitsLimit = permits;
    }

    @Override
    public void acquire() {
        acquire(1);
    }

    @Override
    public void acquire(int permits) {
        synchronized (lock) {
            while (true) {
                if (this.permits >= permits) {
                    this.permits -= permits;
                    System.out.println("Acquired " + permits + " permits");
                    return;
                } else {
                    System.out.println("Trying to acuire " + permits + " permits. Not enough free permits");
                    try {
                        lock.wait();
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
            }
        }
    }

    @Override
    public void release() {
        release(1);
    }

    @Override
    public void release(int permits) {
        synchronized (lock) {
            this.permits = (this.permits + permits > permitsLimit) ? permitsLimit : this.permits + permits;
            lock.notifyAll();
            System.out.println("Released " + permits + " permits");
        }
    }

    @Override
    public int getAvailablePermits() {
        return permits;
    }
}
