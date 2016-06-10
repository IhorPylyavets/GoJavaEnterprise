package com.goit.multithreading.part1.hw;

public class SingleSemaphore implements Semaphore{

    private final int maxPermits;
    private int permits;
    //private final Object lock = new Object();

    public SingleSemaphore(int permits) {
        this.permits = permits;
        this.maxPermits = permits;
    }

    @Override
    public void acquire() throws InterruptedException {
        synchronized (this) {
            if (this.permits > 0) {
                this.permits -= 1;
            } else {
                this.wait();
            }
        }
    }

    @Override
    public void acquire(int permits) throws InterruptedException {
        if (permits < 0 ) {
            throw new IllegalArgumentException();
        }

        synchronized (this) {
            if (this.permits - permits > 0) {
                this.permits -= permits;
            } else {
                if (this.permits > 0) {
                    this.notify();
                }
                this.wait();
            }
        }
    }

    @Override
    public void release() {
        synchronized (this) {
            if (this.permits < this.maxPermits) {
                this.permits += 1;
            }
            this.notify();
        }
    }

    @Override
    public void release(int permits) {
        if (permits < 0 ) {
            throw new IllegalArgumentException();
        }

        synchronized (this) {
            if (this.permits + permits <= maxPermits) {
                this.permits += permits;
            }
            this.notify();
        }
    }

    @Override
    public int getAvailablePermits() {
        synchronized (this) {
            return this.permits;
        }
    }

}