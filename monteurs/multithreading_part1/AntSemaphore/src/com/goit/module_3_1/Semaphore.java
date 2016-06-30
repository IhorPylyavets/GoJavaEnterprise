package com.goit.module_3_1;

public interface Semaphore {
    public void acquire();
    public void acquire(int permits);
    public void release();
    public void release(int permits);
    public int getAvailablePermits();

}
