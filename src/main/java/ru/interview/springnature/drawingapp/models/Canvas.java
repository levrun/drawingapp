package ru.interview.springnature.drawingapp.models;

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

    public Canvas(Point size) {
        this.size = size;
        array = new Point[size.getX()][size.getY()];
        initialiseEmptyCanvas(size);
    }

    private void initialiseEmptyCanvas(Point size) {
        for(int x = 0; x < size.getX(); x++) {
            for(int y = 0; y < size.getY(); y++) {
                array[x][y] = new Point(x + 1, y + 1);
            }
        }
    }

    public Point[][] getArray() {
        return array;
    }

}
