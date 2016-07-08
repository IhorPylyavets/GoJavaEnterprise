package com.goit.multithreading.part1.hw;

import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

public class SimpleSemaphoreTest {

    private SimpleSemaphore semaphore;

    @Before
    public void initTest() throws Exception {
        semaphore = new SimpleSemaphore(5);
        semaphore.acquire(2);
    }

    @Test
    public void testAcquire() throws Exception {
        semaphore.acquire();
        int expected = 2;
        int actual = semaphore.getAvailablePermits();

        assertEquals(actual, expected);
    }

    @Test
    public void testAcquireWithParameter() throws Exception {
        semaphore.acquire(2);
        int expected = 1;
        int actual = semaphore.getAvailablePermits();

        assertEquals(actual, expected);
    }

    @Test
    public void testAcquireNotEnoughPermits() throws Exception {
        Thread thread = new Thread(new Consumer(semaphore, 4));
        thread.start();
        thread.join(2000);

        assertTrue(thread.isAlive());
    }

    @Test
    public void testRelease() throws Exception {
        semaphore.release(1);
        int expected = 4;
        int actual = semaphore.getAvailablePermits();

        assertEquals(actual, expected);
    }

    @Test
    public void testReleaseOverLimit() throws Exception {
        semaphore.release(6);
        int expected = 5;
        int actual = semaphore.getAvailablePermits();

        assertEquals(actual, expected);
    }
}
