package com.goit.multithreading.part2.hw;

import org.junit.Test;

import static org.junit.Assert.*;

public class SimpleSquareSumTest {

    SimpleSquareSum squareSum = new SimpleSquareSum();

    @Test(expected = IllegalArgumentException.class)
    public void testValidateValues() {
        int[] values = new int[] {};
        int numberOfThreads = 7;
        long actual = squareSum.getSquareSum(values, numberOfThreads);
    }

    @Test(expected = IllegalArgumentException.class)
    public void testValidateThreadsCount() {
        int[] values = new int[] {1, 2, 3, 4};
        int numberOfThreads = -7;
        long actual = squareSum.getSquareSum(values, numberOfThreads);
    }

    @Test
    public void testGetSquareSum_v1() {
        int[] values = new int[] {1, 2, 3, 4, 5, 6, 7, 8};
        int numberOfThreads = 4;
        long actual = squareSum.getSquareSum(values, numberOfThreads);

        assertEquals(204, actual);
    }

}