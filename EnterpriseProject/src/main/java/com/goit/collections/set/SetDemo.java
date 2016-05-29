package com.goit.collections.set;

import com.goit.collections.common.Avarage;
import com.goit.collections.common.Constants;

import java.util.Set;

public abstract class SetDemo<T extends Set> implements SetExperiment {
    private Set set;

    public SetDemo(Set<Integer> set) {
        this.set = set;
    }

    @Override
    public long addExperiment() {
        long[] timesArray = new long[Constants.COUNT_EXPERIMENT];

        for (int i = 0; i < Constants.COUNT_EXPERIMENT; i++) {
            long startTime = System.nanoTime();
            this.set.add(((int)(Math.random() * Constants.VOLUME_1000K)));
            long endTime = System.nanoTime();
            timesArray[i] = endTime - startTime;
        }

        return Avarage.getAverageTime(timesArray);
    }

    @Override
    public long removeExperiment() {
        long[] timesArray = new long[Constants.COUNT_EXPERIMENT];

        for (int i = 0; i < Constants.COUNT_EXPERIMENT; i++) {
            long startTime = System.nanoTime();
            boolean isremoved = this.set.remove(this.set.size() - 1 - i);
            long endTime = System.nanoTime();
            timesArray[i] = endTime - startTime;
        }

        return Avarage.getAverageTime(timesArray);
    }

    @Override
    public long containsExperiment() {
        long[] timesArray = new long[Constants.COUNT_EXPERIMENT];

        for (int i = 0; i < Constants.COUNT_EXPERIMENT; i++) {
            long startTime = System.nanoTime();
            boolean exist = this.set.contains(((int)(Math.random() * Constants.VOLUME_1000K)));
            long endTime = System.nanoTime();
            timesArray[i] = endTime - startTime;
        }

        return Avarage.getAverageTime(timesArray);
    }

    @Override
    public long populateExperiment(int setSize) {
        long[] timesArray = new long[setSize];

        for (int i = 0; i < setSize; i++) {
            long startTime = System.nanoTime();
            this.set.add(((int)(Math.random() * Constants.RANGE)));
            long endTime = System.nanoTime();
            timesArray[i] = endTime - startTime;
        }

        return Avarage.getAverageTime(timesArray);
    }
}
