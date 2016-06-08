package com.goit.multithreading.part1.lesson.cart;

public class Cart {
    private static int weight = 0;

    public static void addWeight(){
        weight--;
    }

    public static void reduceWeight(){
        weight++;
    }

    public static int getWeight(){
        return weight;
    }
}
