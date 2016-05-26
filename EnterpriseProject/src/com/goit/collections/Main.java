package com.goit.collections;

public class Main {
    public static void main(String[] args) {
        ArrayListDemo arrayListDemo = new ArrayListDemo();
        System.out.println("Test ArrayList.populate(): " + arrayListDemo.populateExperiment(Constants.VOLUME_1000K) + " nanoseconds");
        System.out.println("Test ArrayList.add(): " + arrayListDemo.addExperiment() + " nanoseconds");
        System.out.println("Test ArrayList.get(): " + arrayListDemo.getExperiment() + " nanoseconds");
        System.out.println("Test ArrayList.remove(): " + arrayListDemo.removeExperiment() + " nanoseconds");
        System.out.println("Test ArrayList.contains(): " + arrayListDemo.containsExperiment() + " nanoseconds");

    }
}
