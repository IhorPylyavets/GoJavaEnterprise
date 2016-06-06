package com.goit.multithreading.part1.lesson;

import java.util.Random;

public class DeadLock {

    private static Random random = new Random();
    private static Account account1 = new Account(100L, 1);
    private static Account account2 = new Account(200L, 2);

    private static int count = 0;

    public static void main(String[] args) {
        new Thread(new Worker()).start();
        new Thread(new Worker()).start();
    }

    public static void transfer(Account source, Account target, long amount) {
        final Account a1;
        final Account a2;

        if (source.compareTo(target) >= 1) {
            a1 = source;
            a2 = target;
        } else {
            a1 = target;
            a2 = source;
        }

        synchronized (a1) {
            synchronized (a2) {
                if (source.getBalance() >= amount) {
                    source.withdraw(amount);
                    target.put(amount);
                    System.out.println(count + " Transfer: " + amount);
                } else {
                    System.out.println(count + " Not enough money");
                }
                count++;
            }
        }
    }

    public static class Worker implements Runnable {

        @Override
        public void run() {
            while (true) {
                if (random.nextBoolean()) {
                    transfer(account1, account2, random.nextInt(10));
                } else {
                    transfer(account2, account1, random.nextInt(10));
                }
            }
        }
    }

    public static class Account implements Comparable<Account>{

        private long balance;
        private long id;

        public Account(long balance, long id) {
            this.balance = balance;
            this.id = id;
        }

        public long getBalance() {
            return balance;
        }

        public void put(long amount) {
            balance += amount;
        }

        public void withdraw(long amount) {
            balance -= amount;
        }

        @Override
        public int compareTo(Account o) {
            if (id > o.id) {
                return 1;
            } else if (id < o.id) {
                return -1;
            } else {
                return 0;
            }
        }
    }
}
