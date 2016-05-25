package com.goit.collections;

import java.util.ArrayList;
import java.util.Arrays;

public class ArrayListDemo {
    private static int VOLUME_10K   = 10000;
    private static int VOLUME_100K  = 100000;
    private static int VOLUME_1000K = 1000000;
    private static int COUNT_OPERATIONS = 100;

    public static void main(String[] args) {
        long[] averageAddTimes = getArrayTimeResultArrayListAdd();

        System.out.println("Test ArrayList.add(): " + Arrays.toString(averageAddTimes));
    }

    private static long[] getArrayTimeResultArrayListAdd() {
        long[] averageTimes = new long[3];

        long[] array10k = new long[COUNT_OPERATIONS];
        long[] array100k = new long[COUNT_OPERATIONS];
        long[] array1000k = new long[COUNT_OPERATIONS];

        for (int i = 0; i < COUNT_OPERATIONS; i++) {
            array10k[i] = addElementToArrayList(VOLUME_10K);
        }
        averageTimes[0] = getAverageTime(array10k);

        for (int i = 0; i < COUNT_OPERATIONS; i++) {
            array100k[i] = addElementToArrayList(VOLUME_100K);
        }
        averageTimes[1] = getAverageTime(array100k);

        for (int i = 0; i < COUNT_OPERATIONS; i++) {
            array1000k[i] = addElementToArrayList(VOLUME_1000K);
        }
        averageTimes[2] = getAverageTime(array1000k);

        return averageTimes;
    }

    private static long addElementToArrayList(int count) {
        long startTime = System.nanoTime();
        ArrayList<Integer> list = new ArrayList<>();
        for (int i = 0; i < count; i++) {
            list.add(i);
        }
        long endTime = System.nanoTime();
        return endTime - startTime;
    }

    private static long getAverageTime(long[] timeArray) {
        long resultTime = 0;

        for (long tempTime : timeArray) {
            resultTime += tempTime;
        }

        return  resultTime/timeArray.length;
    }
}
