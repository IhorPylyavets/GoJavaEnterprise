package com.goit.multithreading.part1.lesson.notebook;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class Runner {

    private static Random random = new Random();

    public static void main(String[] args) {
        List<Author> authors = new ArrayList<>();
        authors.add(new Author("Kobe", 5));
        authors.add(new Author("Dirk Nowitzki", 8));
        authors.add(new Author("Viacheslav Kravtsov", 3));

        new Thread(new Notebook(authors)).start();
    }

    public static void write(List<Author> authors, int countLines) {
        int id = random.nextInt(authors.size());

        Author author = authors.get(id);

        synchronized (author) {
            if (author.getCapacityInkForSingleLine() == 0) {
                System.out.println(String.format("%s: I don't have enough ink", author.getNameAuthor()));
            } else if (author.getCapacityInkForSingleLine() <= countLines) {
                author.makeSameNote(author.getCapacityInkForSingleLine());
                System.out.println(String.format("%s: My ink ran out", author.getNameAuthor()));
                authors.remove(author);
            } else {
                author.makeSameNote(countLines);
            }
        }

    }

    public static class Notebook implements Runnable {

        private List<Author> authors;

        public Notebook(List<Author> authors) {
            this.authors = authors;
        }

        @Override
        public void run() {
            while (true) {
                write(authors, random.nextInt(4));
                if (authors.size() == 0) {
                    break;
                }
            }
        }
    }


    public static class Author{

        private String nameAuthor;
        private int capacityInkForSingleLine;
        private final int maxCapacity;

        public Author(String nameAuthor, int capacityInkForSingleLine) {
            this.nameAuthor = nameAuthor;
            this.capacityInkForSingleLine = capacityInkForSingleLine;
            this.maxCapacity = capacityInkForSingleLine;
        }

        public String getNameAuthor() {
            return nameAuthor;
        }

        public int getCapacityInkForSingleLine() {
            return capacityInkForSingleLine;
        }

        public void makeSameNote(int countLine) {
            for (int i = 0; i < countLine; i++) {
                System.out.println(String.format("%s: it's my single line #%s"
                        , this.getNameAuthor(), this.maxCapacity - this.getCapacityInkForSingleLine() + 1));
                this.capacityInkForSingleLine -= 1;
            }
            System.out.println();
        }
    }

}
