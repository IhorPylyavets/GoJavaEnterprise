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

    public void await(int countLine) throws InterruptedException {
        synchronized (lock) {
            if (countLine > 0) {
                lock.wait();
            }
        }
    }

    public void makeSameNote(int countLine) throws InterruptedException {
        synchronized (lock) {
            if (countLine > 0) {
                String message = String.format("%s: it's my single line #%s",
                        this.getNameAuthor(), this.maxCapacity - this.getCapacityInkForSingleLine() + 1);
                System.out.println(message);
                countLine -= 1;
                this.capacityInkForSingleLine -= 1;
            }

            if (countLine == 0) {
                lock.notifyAll();
            }
        }
    }
}
