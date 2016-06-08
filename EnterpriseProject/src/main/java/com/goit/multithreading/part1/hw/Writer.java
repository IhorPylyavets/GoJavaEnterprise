package com.goit.multithreading.part1.hw;

public class Writer {

    private String nameAuthor;
    private int capacityInkForSingleLine;

    public Writer(String nameAuthor, int capacityInkForSingleLine) {
        this.nameAuthor = nameAuthor;
        this.capacityInkForSingleLine = capacityInkForSingleLine;
    }

    public String getNameAuthor() {
        return nameAuthor;
    }

    public int getCapacityInkForSingleLine() {
        return capacityInkForSingleLine;
    }

    public void write(int countLine) {
        for (int i = 0; i < countLine; i++) {
            System.out.println(String.format("%s: it's my single line", this.getNameAuthor()));
            this.capacityInkForSingleLine -= 1;
        }
    }
}
