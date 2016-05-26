package com.goit.collections;

import java.util.ArrayList;

public class ArrayListDemo implements ListExperiment{
    private ArrayList arrayList;

    public ArrayListDemo() {
        arrayList = new ArrayList();
    }

    @Override
    public long addExperiment() {
        long[] timesArray = new long[Constants.COUNT_EXPERIMENT];

        for (int i = 0; i < Constants.COUNT_EXPERIMENT; i++) {
            long startTime = System.nanoTime();
            this.arrayList.add(((int)(Math.random() * Constants.VOLUME_1000K)));
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
            int value = (int) this.arrayList.get(this.arrayList.size() - 1 - i);
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
            int value = (int) this.arrayList.remove(this.arrayList.size() - 1 - i);
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
            boolean value = this.arrayList.contains(((int)(Math.random() * Constants.VOLUME_1000K)));
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
            this.arrayList.add(((int)(Math.random() * Constants.RANGE)));
            long endTime = System.nanoTime();
            timesArray[i] = endTime - startTime;
        }

        return getAverageTime(timesArray);
    }

    @Override
    public long iteratorAddExperiment() {
        return 0;
    }

    @Override
    public long iteratorRemoveExperiment() {
        return 0;
    }

    private long getAverageTime(long[] timesArray) {
        long resultTime = 0;

        for (long tempTime : timesArray) {
            resultTime += tempTime;
        }

        return  resultTime/timesArray.length;
    }
}
