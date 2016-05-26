package com.goit.collections.list;

import com.goit.collections.help.Constants;

import java.util.List;
import java.util.ListIterator;

public abstract class ListDemo<T extends List> implements ListExperiment {
    private List list;

    public ListDemo(List<Integer> list) {
        this.list = list;
    }

    @Override
    public long addExperiment() {
        long[] timesArray = new long[Constants.COUNT_EXPERIMENT];

        for (int i = 0; i < Constants.COUNT_EXPERIMENT; i++) {
            long startTime = System.nanoTime();
            this.list.add(((int)(Math.random() * Constants.VOLUME_1000K)));
            long endTime = System.nanoTime();
            timesArray[i] = endTime - startTime;
        }

        return getAverageTime(timesArray);
    }

    @Override
    public long getExperiment() {
        long[] timesArray = new long[Constants.COUNT_EXPERIMENT];

        for (int i = 0; i < Constants.COUNT_EXPERIMENT; i++) {
            long startTime = System.nanoTime();
            int value = (int) this.list.get(this.list.size() - 1 - i);
            long endTime = System.nanoTime();
            timesArray[i] = endTime - startTime;
        }

        return getAverageTime(timesArray);
    }

    @Override
    public long removeExperiment() {
        long[] timesArray = new long[Constants.COUNT_EXPERIMENT];

        for (int i = 0; i < Constants.COUNT_EXPERIMENT; i++) {
            long startTime = System.nanoTime();
            int value = (int) this.list.remove(this.list.size() - 1 - i);
            long endTime = System.nanoTime();
            timesArray[i] = endTime - startTime;
        }

        return getAverageTime(timesArray);
    }

    @Override
    public long containsExperiment() {
        long[] timesArray = new long[Constants.COUNT_EXPERIMENT];

        for (int i = 0; i < Constants.COUNT_EXPERIMENT; i++) {
            long startTime = System.nanoTime();
            boolean value = this.list.contains(((int)(Math.random() * Constants.VOLUME_1000K)));
            long endTime = System.nanoTime();
            timesArray[i] = endTime - startTime;
        }

        return getAverageTime(timesArray);
    }

    @Override
    public long populateExperiment(int arraySize) {
        long[] timesArray = new long[arraySize];

        for (int i = 0; i < arraySize; i++) {
            long startTime = System.nanoTime();
            this.list.add(((int)(Math.random() * Constants.RANGE)));
            long endTime = System.nanoTime();
            timesArray[i] = endTime - startTime;
        }

        return getAverageTime(timesArray);
    }

    @Override
    public long iteratorAddExperiment() {
        long[] timesArray = new long[Constants.COUNT_EXPERIMENT];
        ListIterator<Integer> iterator = this.list.listIterator();

        for (int i = 0; i < Constants.COUNT_EXPERIMENT; i++) {
            long startTime = System.nanoTime();
            iterator.add(0);
            long endTime = System.nanoTime();
            timesArray[i] = endTime - startTime;
        }

        return getAverageTime(timesArray);
    }

    @Override
    public long iteratorRemoveExperiment() {
        long[] timesArray = new long[Constants.COUNT_EXPERIMENT];
        ListIterator<Integer> iterator = this.list.listIterator();

        for (int i = 0; i < Constants.COUNT_EXPERIMENT; i++) {
            long startTime = System.nanoTime();
            iterator.next();
            iterator.remove();
            long endTime = System.nanoTime();
            timesArray[i] = endTime - startTime;
        }

        return getAverageTime(timesArray);
    }

    private long getAverageTime(long[] timesArray) {
        long resultTime = 0;

        for (long tempTime : timesArray) {
            resultTime += tempTime;
        }

        return  resultTime/timesArray.length;
    }
}
