package ru.interview.springnature.drawingapp.drawing;

import ru.interview.springnature.drawingapp.exceptions.IllegalParametersException;
import ru.interview.springnature.drawingapp.models.Canvas;
import ru.interview.springnature.drawingapp.models.Line;
import ru.interview.springnature.drawingapp.models.Point;
import ru.interview.springnature.drawingapp.models.Rectangle;

import java.util.Set;

/**
 * Created by Eraskin Alexei on 03.09.2016.
 */
public abstract class CanvasPainter {

    protected Canvas canvas;

    public static final char BLANK_POINT = ' ';
    public static final char X_POINT = 'x';

    public abstract void showCanvas() throws IllegalParametersException;

    public Canvas getCanvas() {
        return canvas;
    }

    public void setCanvas(Canvas canvas) {
        this.canvas = canvas;
    }

    public void drawRectangle(Rectangle rectangle) throws IllegalParametersException {
        Line upperHorizontalLine = new Line(new Point(rectangle.getStart().getX(), rectangle.getStart().getY()),
                new Point(rectangle.getEnd().getX(), rectangle.getStart().getY()));
        drawLine(upperHorizontalLine);

        Line bottomHorizontalLine = new Line(new Point(rectangle.getStart().getX(), rectangle.getEnd().getY()),
                new Point(rectangle.getEnd().getX(), rectangle.getEnd().getY()));
        drawLine(bottomHorizontalLine);

        Line leftVerticalLine = new Line(new Point(rectangle.getStart().getX(), rectangle.getStart().getY()),
                new Point(rectangle.getStart().getX(), rectangle.getEnd().getY()));
        drawLine(leftVerticalLine);

        Line rightVerticalLine = new Line(new Point(rectangle.getEnd().getX(), rectangle.getStart().getY()),
                new Point(rectangle.getEnd().getX(), rectangle.getEnd().getY()));
        drawLine(rightVerticalLine);
    }

    private Set<Point> getAllEmptyNeighbors(Point point, char colorCode) {

        Set<Point> neighbors = canvas.getEmptyPointNeighbors(point);

        if(!neighbors.isEmpty()) {
            for(Point p : neighbors) {
                p.setValue(colorCode);
                getAllEmptyNeighbors(p, colorCode);
            }
        }

        return neighbors;
    }

    public void bucketFill(Point point, char colorCode) throws IllegalParametersException {
        Point startPoint = canvas.getArray()[point.getX()][point.getY()];
        getAllEmptyNeighbors(startPoint, colorCode);
    }

    public void drawLine(Line line) throws IllegalParametersException {
        Point[][] array = canvas.getArray();

        if(line.isHorizontal()) {
            for(int i = line.getStart().getX() - 1; i < line.getStart().getX() - 1 + line.getLength(); i++) {
                Point point = array[i][line.getStart().getY() - 1];
                point.setValue(X_POINT);
            }
        } else {
            for(int i = line.getStart().getY() - 1; i < line.getStart().getY() - 1 + line.getLength(); i++) {
                Point point = array[line.getStart().getX() - 1][i];
                point.setValue(X_POINT);
            }
        }

    }
}
