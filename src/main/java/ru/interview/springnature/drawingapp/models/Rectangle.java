package ru.interview.springnature.drawingapp.models;

/**
 * Created by Eraskin Alexei on 03.09.2016.
 */
public class Rectangle implements Shape {

    private Point start;
    private Point end;

    public Rectangle(Point start, Point end) {
        this.start = start;
        this.end = end;
    }

    public Point getStart() {
        return start;
    }

    public void setStart(Point start) {
        this.start = start;
    }

    public Point getEnd() {
        return end;
    }

    public void setEnd(Point end) {
        this.end = end;
    }

}
