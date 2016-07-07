package com.goit.multithreading.part2.hw;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.*;

public class SimpleSquareSum implements SquareSum {

    private int[] elements;

    public int[] getElements() {
        return elements;
    }

    @Override
    public long getSquareSum(int[] values, int numberOfThreads) {
        final Phaser phaser = new Phaser();

        validateArrayLength(values.length);
        validateThreadsCount(numberOfThreads);

        findNElements(values.length, numberOfThreads);
        List<Callable<Long>> callableList = fromCallableTasks(values, numberOfThreads, phaser);

        ExecutorService executor = Executors.newFixedThreadPool(numberOfThreads);
        List<Future<Long>> segmentResults;
        long overallResult = 0L;
        try {
            segmentResults = executor.invokeAll(callableList);
            for (Future<Long> segmentResult : segmentResults) {
                overallResult += segmentResult.get();
            }
        }
        catch (InterruptedException e) {
            segmentResults = null;
            executor.shutdownNow();
            Thread.currentThread().interrupt();
        }
        catch (ExecutionException e) {
            segmentResults = null;
            executor.shutdownNow();
            Thread.currentThread().interrupt();
        }
        executor.shutdown();
        return overallResult;
    }

    private List<Callable<Long>> fromCallableTasks(int[] values, int numberOfThreads, Phaser phaser) {
        List<Callable<Long>> callableList = new ArrayList<>();
        int startPosition = 0;

        for (int i = 0; i < numberOfThreads; i++) {
            int[] arraySegment = new int[elements[i]];
            System.arraycopy(values, startPosition, arraySegment, 0, elements[i]);
            callableList.add(new Task(phaser, arraySegment));
            startPosition += elements[i];
        }

        return callableList;
    }

    private void validateArrayLength(int length) {
        if (length == 0) {
            throw new IllegalArgumentException("Array without elements !");
        }
    }

    private void validateThreadsCount(int numberOfThreads) {
        if (numberOfThreads <= 0) {
            throw new IllegalArgumentException("Negative threads count !");
        }
    }

    private void findNElements(int length, int numberOfThreads) {
        elements = new int[numberOfThreads];
        int quotient = length / numberOfThreads;
        int modulo = length % numberOfThreads;
        for (int i = 0; i < numberOfThreads; i++) {
            if (i < modulo) {
                elements[i] = quotient + 1;
            } else {
                elements[i] = quotient;
            }
        }
    }
}
