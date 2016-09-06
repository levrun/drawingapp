package ru.interview.springnature.drawingapp.models;

import static ru.interview.springnature.drawingapp.drawing.CanvasPainter.BLANK_POINT;

/**
 * Created by Eraskin Alexei on 03.09.2016.
 */
public class Point implements Shape {

    private int x;
    private int y;
    private char value;

    public Point(int x, int y) {
        this.x = x;
        this.y = y;
        this.value = BLANK_POINT;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Point point = (Point) o;

        if (getX() != point.getX()) return false;
        if (getY() != point.getY()) return false;
        return getValue() == point.getValue();

    }

    @Override
    public int hashCode() {
        int result = getX();
        result = 31 * result + getY();
        result = 31 * result + getValue();
        return result;
    }


    public int getX() {
        return x;
    }

    public int getConvertedX() {
        return x - 1;
    }

    public void setX(int x) {
        this.x = x;
    }

    public int getY() {
        return y;
    }

    public int getConvertedY() {
        return y - 1;
    }

    public void setY(int y) {
        this.y = y;
    }

    public char getValue() {
        return value;
    }

    public void setValue(char value) {
        this.value = value;
    }
}
