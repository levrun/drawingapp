package ru.interview.springnature.drawingapp.drawing;

import ru.interview.springnature.drawingapp.exceptions.IllegalParametersException;
import ru.interview.springnature.drawingapp.models.Line;
import ru.interview.springnature.drawingapp.models.Point;
import ru.interview.springnature.drawingapp.models.Rectangle;

import java.util.Set;

/**
 * Created by Eraskin Alexei on 03.09.2016.
 */
public class ConsoleCanvasPainter extends CanvasPainter {


    @Override
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

    @Override
    public void bucketFill(Point point, char colorCode) throws IllegalParametersException {
        Point startPoint = canvas.getArray()[point.getX()][point.getY()];
        getAllEmptyNeighbors(startPoint, colorCode);
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

    @Override
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

    @Override
    public void showCanvas() {

        Point[][] array = canvas.getArray();
        int sizeX = canvas.getSize().getX();
        int sizeY = canvas.getSize().getY();

        printHorizontalLine(sizeX);

        for(int y = 0; y <  sizeY; y++) {
            for(int x = 0; x < sizeX; x++) {
                if(x == 0) {
                    System.out.print("|");
                }

                Point point = array[x][y];
                if(point.getValue() == BLANK_POINT) {
                    System.out.print(BLANK_POINT);
                } else if(point.getValue() == X_POINT) {
                    System.out.print(X_POINT);
                } else {
                    System.out.print(point.getValue());
                }

                if(x == sizeX - 1) {
                    System.out.print("|");
                }
            }
            System.out.println();
        }

        printHorizontalLine(sizeX);

    }

    private void printHorizontalLine(int lineLength) {
        for(int i = 0; i < lineLength + 2; i++) {
            System.out.print("-");
        }
        System.out.println();
    }
}
