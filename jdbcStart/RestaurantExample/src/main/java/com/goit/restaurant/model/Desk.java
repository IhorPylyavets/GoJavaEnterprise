package com.goit.restaurant.model;

public class Desk {

    private int id;
    private String number;

    public Desk() {
    }

    public Desk(int id, String number) {
        this.id = id;
        this.number = number;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getNumber() {
        return number;
    }

    public void setNumber(String number) {
        this.number = number;
    }

    @Override
    public String toString() {
        return "Desk{" +
                "id=" + id +
                ", number='" + number + '\'' +
                '}';
    }
}
