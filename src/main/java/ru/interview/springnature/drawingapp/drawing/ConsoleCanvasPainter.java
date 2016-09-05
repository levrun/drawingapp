package ru.interview.springnature.drawingapp.drawing;

import ru.interview.springnature.drawingapp.exceptions.IllegalParametersException;
import ru.interview.springnature.drawingapp.models.Line;
import ru.interview.springnature.drawingapp.models.Point;

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
                    System.out.print(" ");
                } else if(point.getValue() == X_POINT) {
                    System.out.print("x");
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
