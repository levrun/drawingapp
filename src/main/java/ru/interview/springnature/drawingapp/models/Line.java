package ru.interview.springnature.drawingapp.models;

import ru.interview.springnature.drawingapp.exceptions.IllegalParametersException;

/**
 * Created by Eraskin Alexei on 03.09.2016.
 */
public class Line implements Shape {

    private Point start;
    private Point end;

    public Line(Point start, Point end) {
        this.start = start;
        this.end = end;
    }

    public boolean isHorizontal() throws IllegalParametersException {
        if(start.getX() == end.getX()) {
            return false;
        } else if(start.getY() == end.getY()){
            return true;
        } else {
            throw new IllegalParametersException();
        }
    }

    public boolean isVertical() throws IllegalParametersException {
        return !isHorizontal();
    }

    public int getLength() throws IllegalParametersException {
        if(isHorizontal()) {
            return end.getX() - start.getX() + 1;
        } else {
            return end.getY() - start.getY() + 1;
        }
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
