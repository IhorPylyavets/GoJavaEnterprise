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

    public static class Notebook implements Runnable {

        private List<Author> authors;

        public Notebook(List<Author> authors) {
            this.authors = authors;
        }

        @Override
        public void run() {
            while (true) {
                try {
                    writing(authors, random.nextInt(4));
                    if (authors.size() == 0) {
                        break;
                    }
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        }

        public void writing(List<Author> authors, int countLines) throws InterruptedException {
            int id = random.nextInt(authors.size());

            Author author = authors.get(id);

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

}
