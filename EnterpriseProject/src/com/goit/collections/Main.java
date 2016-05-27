package com.goit.collections;

import com.goit.collections.common.Constants;
import com.goit.collections.common.FileWriterDemo;
import com.goit.collections.list.ArrayListDemo;
import com.goit.collections.list.LinkedListDemo;
import com.goit.collections.set.HashSetDemo;
import com.goit.collections.set.TreeSetDemo;

import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException {
        int size = Constants.VOLUME_1000K;

        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("Tests for size: " + size + "\r\n");
        stringBuilder.append("\r\n");

        ArrayListDemo arrayListDemo = new ArrayListDemo();
        stringBuilder.append("Test ArrayList.populate():       " + arrayListDemo.populateExperiment(size) + " nanoseconds" + "\r\n");
        stringBuilder.append("Test ArrayList.add():            " + arrayListDemo.addExperiment() + " nanoseconds" + "\r\n");
        stringBuilder.append("Test ArrayList.get():            " + arrayListDemo.getExperiment() + " nanoseconds" + "\r\n");
        stringBuilder.append("Test ArrayList.remove():         " + arrayListDemo.removeExperiment() + " nanoseconds" + "\r\n");
        stringBuilder.append("Test ArrayList.contains():       " + arrayListDemo.containsExperiment() + " nanoseconds" + "\r\n");
        stringBuilder.append("Test ArrayList.iteratorAdd():    " + arrayListDemo.iteratorAddExperiment() + " nanoseconds" + "\r\n");
        stringBuilder.append("Test ArrayList.iteratorRemove(): " + arrayListDemo.iteratorRemoveExperiment() + " nanoseconds"+ "\r\n");
        stringBuilder.append("\r\n");

        LinkedListDemo linkedListDemo = new LinkedListDemo();
        stringBuilder.append("Test LinkedList.populate():       " + linkedListDemo.populateExperiment(size) + " nanoseconds" + "\r\n");
        stringBuilder.append("Test LinkedList.add():            " + linkedListDemo.addExperiment() + " nanoseconds" + "\r\n");
        stringBuilder.append("Test LinkedList.get():            " + linkedListDemo.getExperiment() + " nanoseconds" + "\r\n");
        stringBuilder.append("Test LinkedList.remove():         " + linkedListDemo.removeExperiment() + " nanoseconds" + "\r\n");
        stringBuilder.append("Test LinkedList.contains():       " + linkedListDemo.containsExperiment() + " nanoseconds" + "\r\n");
        stringBuilder.append("Test LinkedList.iteratorAdd():    " + linkedListDemo.iteratorAddExperiment() + " nanoseconds" + "\r\n");
        stringBuilder.append("Test LinkedList.iteratorRemove(): " + linkedListDemo.iteratorRemoveExperiment() + " nanoseconds" + "\r\n");
        stringBuilder.append("\r\n");

        HashSetDemo hashSetDemo = new HashSetDemo();
        stringBuilder.append("Test HashSet.populate(): " + hashSetDemo.populateExperiment(size) + " nanoseconds" + "\r\n");
        stringBuilder.append("Test HashSet.add():      " + hashSetDemo.addExperiment() + " nanoseconds" + "\r\n");
        stringBuilder.append("Test HashSet.remove():   " + hashSetDemo.removeExperiment() + " nanoseconds" + "\r\n");
        stringBuilder.append("Test HashSet.contains(): " + hashSetDemo.containsExperiment() + " nanoseconds" + "\r\n");
        stringBuilder.append("\r\n");

        TreeSetDemo treeSetDemo = new TreeSetDemo();
        stringBuilder.append("Test TreeSet.populate(): " + treeSetDemo.populateExperiment(size) + " nanoseconds" + "\r\n");
        stringBuilder.append("Test TreeSet.add():      " + treeSetDemo.addExperiment() + " nanoseconds" + "\r\n");
        stringBuilder.append("Test TreeSet.remove():   " + treeSetDemo.removeExperiment() + " nanoseconds" + "\r\n");
        stringBuilder.append("Test TreeSet.contains(): " + treeSetDemo.containsExperiment() + " nanoseconds" + "\r\n");

        FileWriterDemo fileWriterDemo = new FileWriterDemo();
        fileWriterDemo.writeDataToFile(size + ".txt", stringBuilder.toString());

        System.out.println("Read experiment results in txt file");
    }
}
