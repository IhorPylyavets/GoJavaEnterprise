package com.goit.collections;

public class Main {
    public static void main(String[] args) {
        int size = Constants.VOLUME_1000K;
        
        ArrayListDemo arrayListDemo = new ArrayListDemo();

        System.out.println("Tests for size: " + size);
        System.out.println("Test ArrayList.populate(): " + arrayListDemo.populateExperiment(size) + " nanoseconds");
        System.out.println("Test ArrayList.add(): " + arrayListDemo.addExperiment() + " nanoseconds");
        System.out.println("Test ArrayList.get(): " + arrayListDemo.getExperiment() + " nanoseconds");
        System.out.println("Test ArrayList.remove(): " + arrayListDemo.removeExperiment() + " nanoseconds");
        System.out.println("Test ArrayList.contains(): " + arrayListDemo.containsExperiment() + " nanoseconds");
        System.out.println("Test ArrayList.iteratorAdd(): " + arrayListDemo.iteratorAddExperiment() + " nanoseconds");
        System.out.println("Test ArrayList.iteratorRemove(): " + arrayListDemo.iteratorRemoveExperiment() + " nanoseconds");

    }
}
