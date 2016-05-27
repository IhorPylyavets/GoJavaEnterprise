package com.goit.collections;

import com.goit.collections.common.Constants;
import com.goit.collections.list.ArrayListDemo;
import com.goit.collections.list.LinkedListDemo;
import com.goit.collections.set.HashSetDemo;
import com.goit.collections.set.TreeSetDemo;

public class Main {
    public static void main(String[] args) {
        int size = Constants.VOLUME_1000K;

        System.out.println("Tests for size: " + size);

        ArrayListDemo arrayListDemo = new ArrayListDemo();
        System.out.println("Test ArrayList.populate():       " + arrayListDemo.populateExperiment(size) + " nanoseconds");
        System.out.println("Test ArrayList.add():            " + arrayListDemo.addExperiment() + " nanoseconds");
        System.out.println("Test ArrayList.get():            " + arrayListDemo.getExperiment() + " nanoseconds");
        System.out.println("Test ArrayList.remove():         " + arrayListDemo.removeExperiment() + " nanoseconds");
        System.out.println("Test ArrayList.contains():       " + arrayListDemo.containsExperiment() + " nanoseconds");
        System.out.println("Test ArrayList.iteratorAdd():    " + arrayListDemo.iteratorAddExperiment() + " nanoseconds");
        System.out.println("Test ArrayList.iteratorRemove(): " + arrayListDemo.iteratorRemoveExperiment() + " nanoseconds");
        System.out.println();

        LinkedListDemo linkedListDemo = new LinkedListDemo();
        System.out.println("Test LinkedList.populate():       " + linkedListDemo.populateExperiment(size) + " nanoseconds");
        System.out.println("Test LinkedList.add():            " + linkedListDemo.addExperiment() + " nanoseconds");
        System.out.println("Test LinkedList.get():            " + linkedListDemo.getExperiment() + " nanoseconds");
        System.out.println("Test LinkedList.remove():         " + linkedListDemo.removeExperiment() + " nanoseconds");
        System.out.println("Test LinkedList.contains():       " + linkedListDemo.containsExperiment() + " nanoseconds");
        System.out.println("Test LinkedList.iteratorAdd():    " + linkedListDemo.iteratorAddExperiment() + " nanoseconds");
        System.out.println("Test LinkedList.iteratorRemove(): " + linkedListDemo.iteratorRemoveExperiment() + " nanoseconds");
        System.out.println();

        HashSetDemo hashSetDemo = new HashSetDemo();
        System.out.println("Test HashSet.populate(): " + hashSetDemo.populateExperiment(size) + " nanoseconds");
        System.out.println("Test HashSet.add():      " + hashSetDemo.addExperiment() + " nanoseconds");
        System.out.println("Test HashSet.remove():   " + hashSetDemo.removeExperiment() + " nanoseconds");
        System.out.println("Test HashSet.contains(): " + hashSetDemo.containsExperiment() + " nanoseconds");
        System.out.println();

        TreeSetDemo treeSetDemo = new TreeSetDemo();
        System.out.println("Test TreeSet.populate(): " + treeSetDemo.populateExperiment(size) + " nanoseconds");
        System.out.println("Test TreeSet.add():      " + treeSetDemo.addExperiment() + " nanoseconds");
        System.out.println("Test TreeSet.remove():   " + treeSetDemo.removeExperiment() + " nanoseconds");
        System.out.println("Test TreeSet.contains(): " + treeSetDemo.containsExperiment() + " nanoseconds");
    }
}
