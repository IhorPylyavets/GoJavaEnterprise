package com.goit.collections;

import com.goit.collections.help.Constants;
import com.goit.collections.list.ArrayListDemo;
import com.goit.collections.list.LinkedListDemo;

public class Main {
    public static void main(String[] args) {
        int size = Constants.VOLUME_1000K;

        ArrayListDemo arrayListDemo = new ArrayListDemo();

        System.out.println("Tests for size: " + size);
        System.out.println("Test ArrayList.populate():       " + arrayListDemo.populateExperiment(size) + " nanoseconds");
        System.out.println("Test ArrayList.add():            " + arrayListDemo.addExperiment() + " nanoseconds");
        System.out.println("Test ArrayList.get():            " + arrayListDemo.getExperiment() + " nanoseconds");
        System.out.println("Test ArrayList.remove():         " + arrayListDemo.removeExperiment() + " nanoseconds");
        System.out.println("Test ArrayList.contains():       " + arrayListDemo.containsExperiment() + " nanoseconds");
        System.out.println("Test ArrayList.iteratorAdd():    " + arrayListDemo.iteratorAddExperiment() + " nanoseconds");
        System.out.println("Test ArrayList.iteratorRemove(): " + arrayListDemo.iteratorRemoveExperiment() + " nanoseconds");
        System.out.println();

        LinkedListDemo linkedListDemo = new LinkedListDemo();

        System.out.println("Tests for size: " + size);
        System.out.println("Test LinkedList.populate():       " + linkedListDemo.populateExperiment(size) + " nanoseconds");
        System.out.println("Test LinkedList.add():            " + linkedListDemo.addExperiment() + " nanoseconds");
        System.out.println("Test LinkedList.get():            " + linkedListDemo.getExperiment() + " nanoseconds");
        System.out.println("Test LinkedList.remove():         " + linkedListDemo.removeExperiment() + " nanoseconds");
        System.out.println("Test LinkedList.contains():       " + linkedListDemo.containsExperiment() + " nanoseconds");
        System.out.println("Test LinkedList.iteratorAdd():    " + linkedListDemo.iteratorAddExperiment() + " nanoseconds");
        System.out.println("Test LinkedList.iteratorRemove(): " + linkedListDemo.iteratorRemoveExperiment() + " nanoseconds");

    }
}
