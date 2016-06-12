package com.goit.multithreading.part1.lesson.notebook;

public class Author {

    private String nameAuthor;
    private int capacityInkForSingleLine;
    private final int maxCapacity;

    private final Object lock = new Object();

    public Author(String nameAuthor, int capacityInkForSingleLine) {
        this.nameAuthor = nameAuthor;
        this.capacityInkForSingleLine = capacityInkForSingleLine;
        this.maxCapacity = capacityInkForSingleLine;
    }

    public String getNameAuthor() {
        return nameAuthor;
    }

    public int getCapacityInkForSingleLine() {
        synchronized (lock) {
            return capacityInkForSingleLine;
        }
    }

    public void makeSameNote(int countLine) {
        synchronized (lock) {
            for (int i = 0; i < countLine; i++) {
                String message = String.format("%s: it's my single line #%s",
                        this.getNameAuthor(), this.maxCapacity - this.getCapacityInkForSingleLine() + 1);
                System.out.println(message);
                this.capacityInkForSingleLine -= 1;
            }
        }
    }
}
