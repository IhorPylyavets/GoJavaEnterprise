package com.goit.model;

public enum DeskStatus {
    FREE("FREE"),
    ORDERED("ORDERED");

    private final String name;

    private DeskStatus(String s) {
        name = s;
    }

    public boolean equalsName(String otherName) {
        return (otherName == null) ? false : name.equals(otherName);
    }

    public String toString() {
        return this.name;
    }
}
