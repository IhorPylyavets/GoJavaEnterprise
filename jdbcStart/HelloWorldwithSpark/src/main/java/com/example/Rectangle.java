package com.example;

public class Rectangle {
    private int mLength;
    private int mWidth;

    public Rectangle(int length, int width) {
        this.mLength = length;
        this.mWidth = width;
    }

    public int getLength() {
        return mLength;
    }

    public int getWidth() {
        return mWidth;
    }

    public boolean isSquare() {
        return mLength == mWidth;
    }
}
