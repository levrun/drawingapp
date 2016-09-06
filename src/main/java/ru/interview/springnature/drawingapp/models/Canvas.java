package ru.interview.springnature.drawingapp.models;

import java.util.HashSet;
import java.util.Set;

import static ru.interview.springnature.drawingapp.drawing.CanvasPainter.BLANK_POINT;

/**
 * Created by Eraskin Alexei on 03.09.2016.
 */
public class Canvas implements Shape {

    public static final int MIN_LENGTH = 1;
    public static final int MAX_LENGTH = 50;

    public Point getSize() {
        return size;
    }

    private Point size;
    private Point[][] array;
    private Set<Point> pointsSet;

    public Canvas(Point size) {
        this.size = size;
        array = new Point[size.getX()][size.getY()];
        pointsSet = new HashSet<>();
        initialiseEmptyCanvas(size);
    }

    private void initialiseEmptyCanvas(Point size) {
        for(int x = 0; x < size.getX(); x++) {
            for(int y = 0; y < size.getY(); y++) {
                array[x][y] = new Point(x + 1, y + 1);
                pointsSet.add(new Point(x + 1, y + 1));
            }
        }
    }

    public Point[][] getArray() {
        return array;
    }

    public Set<Point> getEmptyPointNeighbors(Point point) {
        Set<Point> set = new HashSet<>();

        if(pointsSet.contains(new Point(point.getX() - 1, point.getY()))) {
            Point left = array[point.getConvertedX() - 1][point.getConvertedY()];
            if(left.getValue() == BLANK_POINT) {
                set.add(left);
            }
        }

        if(pointsSet.contains(new Point(point.getX() + 1, point.getY()))) {
            Point right = array[point.getConvertedX() + 1][point.getConvertedY()];
            if(right.getValue() == BLANK_POINT) {
                set.add(right);
            }
        }

        if(pointsSet.contains(new Point(point.getX(), point.getY() - 1))) {
            Point up = array[point.getConvertedX()][point.getConvertedY() - 1];
            if(up.getValue() == BLANK_POINT) {
                set.add(up);
            }
        }

        if(pointsSet.contains(new Point(point.getX(), point.getY() + 1))) {
            Point down = array[point.getConvertedX()][point.getConvertedY() + 1];
            if(down.getValue() == BLANK_POINT) {
                set.add(down);
            }
        }

        return set;
    }

}
