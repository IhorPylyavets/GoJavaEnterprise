package com.goit.collections.common;

public class Avarage {
    public static long getAverageTime(long[] timesArray) {
        long resultTime = 0;

        for (long tempTime : timesArray) {
            resultTime += tempTime;
        }

        return  resultTime/timesArray.length;
    }
}
