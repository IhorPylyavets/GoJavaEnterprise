package com.goit.restaurant.model;

public class Position {

    private int id;
    private String positionTitle;

    public Position() {
    }

    public Position(int id, String positionTitle) {
        this.id = id;
        this.positionTitle = positionTitle;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getPositionTitle() {
        return positionTitle;
    }

    public void setPositionTitle(String positionTitle) {
        this.positionTitle = positionTitle;
    }

    @Override
    public String toString() {
        return "Position{" +
                "id=" + id +
                ", positionTitle='" + positionTitle + '\'' +
                '}';
    }
}
